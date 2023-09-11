package MainProject;

import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

/*
1. Web sitesinin alt veya yan menüsünde "Kurslar" veya "Courses" gibi bir bölüm bulunmalıdır.
2. "Kurslar" bölümü, mevcut tüm kursların bir listesini göstermelidir.
3. Her bir kursun adına tıkladığımda, ilgili kurs sayfasına yönlendirilmeliyim.
4. Kurs sayfasında her kursun kısa bir açıklaması görünmelidir.
5. Bu erişim yöntemi, kullanıcıların derslere veya kurs içeriğine hızlıca erişimini sağlamalıdır.
 */
public class US_04_Faruk extends BaseDriver {

    @Test
    public void US_04_coursesTest(){
        driver.get("https://techno.study/tr");

        List<WebElement> kurslar = driver.findElements(By.xpath("//div[@field='descr']//li[@style='color: rgb(0, 0, 0);']"));
        Assert.assertTrue("Kurslar menüsünde tüm kurslar görünmüyor",kurslar.size()==4);
        for (WebElement e : kurslar){
            System.out.println(e.getText());
        }

        WebElement sdetKursu = driver.findElement(By.xpath("//div[@field='descr']//a[text()='SDET Yazılım Test Mühendisi']"));
        sdetKursu.click();
        wait.until(ExpectedConditions.textToBe(By.xpath("//div[text()='Yazılım Test Mühendisi']"),"Yazılım Test Mühendisi"));
        WebElement sdetAciklama=driver.findElement(By.xpath("//div[text()='Yazılım Test Mühendisi']"));
        System.out.println("sdetAciklama = " + sdetAciklama.getText().toLowerCase());
        Assert.assertTrue("hatalı kurs içeriği",sdetAciklama.getText().toLowerCase().contains("test"));

        WebElement android = driver.findElement(By.xpath("//div[@field='descr']//a[text()='Android uygulama geliştirme']"));
        android.click();
        wait.until(ExpectedConditions.textToBe(By.xpath("//strong[text()='Android uygulama geliştirme']"),"Android uygulama geliştirme"));
        WebElement androidAciklama=driver.findElement(By.xpath("//strong[text()='Android uygulama geliştirme']"));
        System.out.println("androidAciklama = " + androidAciklama.getText().toLowerCase());
        Assert.assertTrue("hatalı kurs içeriği",androidAciklama.getText().toLowerCase().contains("android"));

        WebElement veriBilimi = driver.findElement(By.xpath("//div[@field='descr']//a[text()='Veri bilimi']"));
        veriBilimi.click();
        wait.until(ExpectedConditions.textToBe(By.xpath("//div[text()='Veri Bilimi Bootcamp']"),"Veri Bilimi Bootcamp"));
        WebElement veriBilimiAciklama=driver.findElement(By.xpath("//div[text()='Veri Bilimi Bootcamp']"));
        System.out.println("veriBilimiAciklama = " + veriBilimiAciklama.getText().toLowerCase());
        Assert.assertTrue("hatalı kurs içeriği",veriBilimiAciklama.getText().toLowerCase().contains("veri"));


        BekleVeKapat();
    }
}
