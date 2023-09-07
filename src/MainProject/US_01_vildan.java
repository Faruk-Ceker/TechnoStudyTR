package MainProject;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

/*AC01_Dropdown_Menu-
        1. Anasayfanın üst kısmında, "Kurslar" veya "Courses" gibi bir başlık altında bir dropdown menü görülmelidir.
        2. Dropdown menüyü tıkladığımda, mevcut tüm kursların bir listesi açılmalıdır.
        3. Her kursun adı görünmelidir.
        4. İstediğim bir kursa tıkladığımda, ilgili kurs sayfasına yönlendirilmeliyim.
        5. Dropdown menü, kullanıcıların kurslara daha hızlı ve kolay erişimini sağlayarak kullanıcı deneyimini iyileştirmelidir.*/

public class US_01_vildan extends BaseDriver {
    @Test

    public void Test(){
        driver.navigate().to("https://techno.study/tr");
        MyFunc.Wait(2);

        WebElement dropdown=driver.findElement(By.xpath("//div[@class='t228__centerside t228__menualign_left']//a[text()='Kurslar']"));

        Assert.assertTrue("Dropdown menu gozukmuyor",dropdown.isDisplayed());


      dropdown.click();

        List<WebElement> menu=driver.findElements(By.className("t966__menu-item-text"));

        for(WebElement e : menu){

            Assert.assertTrue("Dropdown menu secenekleri eksik",e.isDisplayed());


        }
        MyFunc.Wait(2);


        WebElement sdet=driver.findElement(By.xpath("//div[text()='SDET Yazılım Test Mühendisi']"));
        sdet.click();
        wait.until(ExpectedConditions.urlToBe("https://techno.study/tr/sdet"));
        Assert.assertTrue("ilgili kurs sayfasina yonlendirilmedi",driver.getCurrentUrl().equals("https://techno.study/tr/sdet"));
        MyFunc.Wait(2);

       driver.navigate().back();
       MyFunc.Wait(2);

        WebElement dropdown2=driver.findElement(By.xpath("//div[@class='t228__centerside t228__menualign_left']//a[text()='Kurslar']"));
        dropdown2.click();


        MyFunc.Wait(2);
        WebElement android=driver.findElement(By.xpath("//div[text()='Android uygulama geliştirme']"));
        android.click();
        wait.until(ExpectedConditions.urlToBe("https://techno.study/tr/androidapp"));
        Assert.assertTrue("ilgili kurs sayfasina yonlendirilmedi",driver.getCurrentUrl().equals("https://techno.study/tr/androidapp"));
        MyFunc.Wait(2);

        driver.navigate().back();

        MyFunc.Wait(2);

        WebElement dropdown3=driver.findElement(By.xpath("//div[@class='t228__centerside t228__menualign_left']//a[text()='Kurslar']"));
        dropdown3.click();

        WebElement veriBilimi=driver.findElement(By.xpath("//div[text()='Veri bilimi']"));
        veriBilimi.click();

        wait.until(ExpectedConditions.urlToBe("https://techno.study/tr/data"));

        Assert.assertTrue("ilgili kurs sayfasina yonlendirilmedi",driver.getCurrentUrl().equals("https://techno.study/tr/data"));
        MyFunc.Wait(2);

        driver.navigate().back();

        MyFunc.Wait(2);

        WebElement dropdown4=driver.findElement(By.xpath("//div[@class='t228__centerside t228__menualign_left']//a[text()='Kurslar']"));
        dropdown4.click();


        WebElement jobCenter=driver.findElement(By.xpath("//div[text()='Job Center & Arbeitsamt']"));
        jobCenter.click();

        wait.until(ExpectedConditions.urlToBe("https://techno.study/jobcenter"));
        Assert.assertTrue("ilgili kurs sayfasina yonlendirilmedi",driver.getCurrentUrl().equals("https://techno.study/jobcenter"));
        MyFunc.Wait(2);

        driver.navigate().back();

        MyFunc.Wait(2);

        WebElement dropdown5=driver.findElement(By.xpath("//div[@class='t228__centerside t228__menualign_left']//a[text()='Kurslar']"));
        dropdown5.click();

        WebElement masterProgram=driver.findElement(By.xpath("(//div[@class='t966__menu-item-title t-name'])[5]"));

        masterProgram.click();

        wait.until(ExpectedConditions.urlToBe("https://techno.study/masters"));
        Assert.assertTrue("ilgili kurs sayfasina yonlendirilmedi",driver.getCurrentUrl().equals("https://techno.study/masters"));
        MyFunc.Wait(2);

        driver.navigate().back();

        MyFunc.Wait(2);



        BekleVeKapat();
    }

}
