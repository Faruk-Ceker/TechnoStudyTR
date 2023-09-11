package MainProject;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class US_06_vildan extends BaseDriver {
    @Test

    public void US_06_Test() {


        driver.navigate().to("https://techno.study/tr");
        MyFunc.Wait(1);

        List<WebElement> listOfCourses = driver.findElements(By.cssSelector("[role='menuitem']"));
        Actions aksiyonlar = new Actions(driver);
        WebElement coursesMenu1 = driver.findElement(By.xpath("//a[@class='t-menu__link-item t966__tm-link']"));
        Action aksiyon = aksiyonlar.moveToElement(coursesMenu1).build();


        for (WebElement e : listOfCourses) {
            aksiyon.perform();
            MyFunc.Wait(1);

            e.click();

            MyFunc.Wait(1);


            try {
                WebElement tchSttdyIcon = driver.findElement(By.cssSelector("a[class='t228__imgwrapper']>:nth-child(1)"));

                Assert.assertTrue("Ilgili sayfada technoStudy logosu gozukmedi", tchSttdyIcon.isDisplayed()); // Dropdown menude Job centera tiklayinca logo gozukmuyor.

                Assert.assertTrue("Ilgili sayfada technoStudy logosu etkin degil", tchSttdyIcon.isEnabled());

            } catch (Exception ex) {

                System.out.println("ex.getMessage() = " + ex.getMessage());
            }
            MyFunc.Wait(2);

            driver.navigate().back();
        }

        try {
        WebElement logoBtn = driver.findElement(By.cssSelector("[class='t228__imglogo ']"));
        logoBtn.click();
        MyFunc.Wait(2);

            WebElement title = driver.findElement(By.cssSelector("head > title"));
            Assert.assertTrue("Ana Sayfaya yonlendirilmedi", title.getText().contains("Sıfırdan başlayarak\n" +
                    "6 ayda IT uzmanı olun.")); //Logoya tiklayinca ingilizce anasayfaya yonlendiriliyor.
            MyFunc.Wait(2);
        } catch (Exception err) {
            System.out.println("err = " + err);

        }

        BekleVeKapat();
    }
}


