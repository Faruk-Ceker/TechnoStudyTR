package MainProject;

import Utility.BaseDriver;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;

/*
"Kendi Kursunu Seç" bölümünde her kursun altında "Detaylı Bilgi" veya "More Info" gibi bir buton veya bağlantı görünmelidir.

"Detaylı Bilgi" butonuna tıkladığımda, ilgili kursun ayrıntılı bilgi ve içeriklerinin bulunduğu kurs sayfasına yönlendirilmelidir.

İçeriklerin bulunduğu kursa sayfasında Techno Study logosu olmalıdır
 */
public class US_07_Faruk extends BaseDriver {

    @Test
    public void US_07_logoTest () throws AWTException, IOException, InterruptedException {
        driver.navigate().to("https://techno.study/tr");

        String anaSayfailkURL = driver.getCurrentUrl();
        List<WebElement> detayliBilgiler = driver.findElements(By.xpath("//a[text()='Detaylı bilgi']"));
        Assert.assertTrue("Her kurs için detaylı bilgi butonu yok",detayliBilgiler.size()==3);

        WebElement sdetBilgi = driver.findElement(By.xpath("(//a[text()='Detaylı bilgi'])[2]"));
        sdetBilgi.click();
        wait.until(ExpectedConditions.urlToBe("https://techno.study/tr/sdet"));
        Assert.assertTrue("Hatalı kurs sayfasına yönlendirildi",driver.getCurrentUrl().contains("sdet"));


        driver.navigate().back();


        WebElement androidBilgi = driver.findElement(By.xpath("(//a[text()='Detaylı bilgi'])[3]"));
        androidBilgi.click();
        wait.until(ExpectedConditions.urlToBe("https://techno.study/tr/androidapp"));
        Assert.assertTrue("Hatalı kurs sayfasına yönlendirildi",driver.getCurrentUrl().contains("android"));


        driver.navigate().back();



        WebElement dataBilgi = driver.findElement(By.xpath("(//a[text()='Detaylı bilgi'])[1]"));
        dataBilgi.click();
        wait.until(ExpectedConditions.urlToBe("https://techno.study/tr/data"));
        Assert.assertTrue("Hatalı kurs sayfasına yönlendirildi",driver.getCurrentUrl().contains("data"));

        BekleVeKapat();
    }
}
