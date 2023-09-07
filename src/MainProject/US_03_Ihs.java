package MainProject;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class US_03_Ihs extends BaseDriver {

    @Test
    public void kursBasvuruTesti (){

        String country="Andorra";
        String kurs="SDET Türkçe"; // Menü: SDET Türkçe, Veri Bilimi, Job Center & Arbeitsamt, Veri Analitiği
        String survey="Youtube"; // Menü: Youtube, Instagram, Facebook, LinkedIn, Mezundan, Arkadaş vasıtası ile, Website, Başka

        driver.get("https://techno.study/tr");
        MyFunc.Wait(2);

        WebElement basvurBtn=driver.findElement(By.linkText("BAŞVUR"));
        basvurBtn.click();

        WebElement adSoyad = driver.findElement(By.name("name"));
        adSoyad.sendKeys("Test Ihsu");
        MyFunc.Wait(2);

        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("test_usma@gmail.com");
        MyFunc.Wait(2);

        WebElement countryInput=driver.findElement(By.xpath("//span[@class='t-input-phonemask__select-triangle']"));
        countryInput.click();
        MyFunc.Wait(2);

       WebElement areaCode = driver.findElement(By.xpath("//div[@class='t-input-phonemask__options-name' and text()='"+country+"']"));
       areaCode.click();
        MyFunc.Wait(2);

        WebElement telefon = driver.findElement(By.name("tildaspec-phone-part[]"));
        telefon.sendKeys("999 999");
        MyFunc.Wait(2);

        WebElement ulke = driver.findElement(By.xpath("//select[@name='country']/option[@value='"+ country +"']"));
        ulke.click();
        MyFunc.Wait(2);

        WebElement kursSecimi = driver.findElement(By.xpath("//select[@name='course']/option[@value='"+ kurs +"']"));
        kursSecimi.click();
        MyFunc.Wait(2);

       WebElement biziNerdenDuydunuz = driver.findElement(By.xpath("//select[@name='survey']/option[@value='"+ survey +"']"));
       biziNerdenDuydunuz.click();
        MyFunc.Wait(2);

       WebElement sartKabulu = driver.findElement(By.xpath("//div[@class='t-checkbox__indicator']"));
       sartKabulu.click();
        MyFunc.Wait(2);

       WebElement gonderBtn = driver.findElement(By.xpath("//button[@type='submit']"));
       gonderBtn.click();
        MyFunc.Wait(2);

        WebElement basvuruKabulMsj = driver.findElement(By.id("tildaformsuccesspopuptext"));
        String actualText = basvuruKabulMsj.getText();
        System.out.println("Başvuru kabul mesajı = " + basvuruKabulMsj.getText());
        MyFunc.Wait(2);

        String expectedText = "Başvurunuz alınmıştır.";
        Assert.assertTrue("Alınan mesaj beklenen ile aynı değil", actualText.contains(expectedText));


        BekleVeKapat();

    }

}
