package MainProject;

import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/*
Anasayfanın üst kısmında, "Campus Girişi" veya "Log in to Campus" gibi bir seçenek bulunmalıdır.

"Campus Girişi" seçeneğini tıkladığımda, beni Campus platformunun giriş sayfasına yönlendirmelidir.

Campus'e giriş yapılmasına gerek yoktur (Şifre güvenliği açısından)
 */
public class US_02_Faruk extends BaseDriver {

    @Test
    public void US_02_loginTest(){
        driver.get("https://techno.study/tr");

        WebElement campusLogin=driver.findElement(By.linkText("Campus Login"));
        Assert.assertTrue("Login seçeneği görünmüyor",campusLogin.getText().toLowerCase().contains("login"));
        campusLogin.click();

        WebElement girisYap = driver.findElement(By.xpath("//span[@class='mdc-button__label']"));
        Assert.assertTrue("Giriş yap seçeneği bulunmuyor", girisYap.isDisplayed());

        BekleVeKapat();
    }
}
