package MainProject;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public class MainClass extends BaseDriver {
    @Test

    public void US_01_Test() {
        driver.navigate().to("https://techno.study/tr");
        MyFunc.Wait(2);

        WebElement dropdown = driver.findElement(By.xpath("//div[@class='t228__centerside t228__menualign_left']//a[text()='Kurslar']"));

        Assert.assertTrue("Dropdown menu gozukmuyor", dropdown.isDisplayed());


        dropdown.click();

        List<WebElement> menu = driver.findElements(By.className("t966__menu-item-text"));

        for (WebElement e : menu) {

            Assert.assertTrue("Dropdown menu secenekleri eksik", e.isDisplayed());


        }
        MyFunc.Wait(2);


        WebElement sdet = driver.findElement(By.xpath("//div[text()='SDET Yazılım Test Mühendisi']"));
        sdet.click();
        wait.until(ExpectedConditions.urlToBe("https://techno.study/tr/sdet"));
        Assert.assertTrue("ilgili kurs sayfasina yonlendirilmedi", driver.getCurrentUrl().equals("https://techno.study/tr/sdet"));
        MyFunc.Wait(2);

        driver.navigate().back();
        MyFunc.Wait(2);

        WebElement dropdown2 = driver.findElement(By.xpath("//div[@class='t228__centerside t228__menualign_left']//a[text()='Kurslar']"));
        dropdown2.click();


        MyFunc.Wait(2);
        WebElement android = driver.findElement(By.xpath("//div[text()='Android uygulama geliştirme']"));
        android.click();
        wait.until(ExpectedConditions.urlToBe("https://techno.study/tr/androidapp"));
        Assert.assertTrue("ilgili kurs sayfasina yonlendirilmedi", driver.getCurrentUrl().equals("https://techno.study/tr/androidapp"));
        MyFunc.Wait(2);

        driver.navigate().back();

        MyFunc.Wait(2);

        WebElement dropdown3 = driver.findElement(By.xpath("//div[@class='t228__centerside t228__menualign_left']//a[text()='Kurslar']"));
        dropdown3.click();

        WebElement veriBilimi = driver.findElement(By.xpath("//div[text()='Veri bilimi']"));
        veriBilimi.click();

        wait.until(ExpectedConditions.urlToBe("https://techno.study/tr/data"));

        Assert.assertTrue("ilgili kurs sayfasina yonlendirilmedi", driver.getCurrentUrl().equals("https://techno.study/tr/data"));
        MyFunc.Wait(2);

        driver.navigate().back();

        MyFunc.Wait(2);

        WebElement dropdown4 = driver.findElement(By.xpath("//div[@class='t228__centerside t228__menualign_left']//a[text()='Kurslar']"));
        dropdown4.click();


        WebElement jobCenter = driver.findElement(By.xpath("//div[text()='Job Center & Arbeitsamt']"));
        jobCenter.click();

        wait.until(ExpectedConditions.urlToBe("https://techno.study/jobcenter"));
        Assert.assertTrue("ilgili kurs sayfasina yonlendirilmedi", driver.getCurrentUrl().equals("https://techno.study/jobcenter"));
        MyFunc.Wait(2);

        driver.navigate().back();

        MyFunc.Wait(2);

        WebElement dropdown5 = driver.findElement(By.xpath("//div[@class='t228__centerside t228__menualign_left']//a[text()='Kurslar']"));
        dropdown5.click();

        WebElement masterProgram = driver.findElement(By.xpath("(//div[@class='t966__menu-item-title t-name'])[5]"));

        masterProgram.click();

        wait.until(ExpectedConditions.urlToBe("https://techno.study/masters"));
        Assert.assertTrue("ilgili kurs sayfasina yonlendirilmedi", driver.getCurrentUrl().equals("https://techno.study/masters"));
        MyFunc.Wait(2);

        driver.navigate().back();

        MyFunc.Wait(2);


        BekleVeKapat();
    }

    @Test
    public void US_02_loginTest() {
        driver.get("https://techno.study/tr");

        WebElement campusLogin = driver.findElement(By.linkText("Campus Login"));
        Assert.assertTrue("Login seçeneği görünmüyor", campusLogin.getText().toLowerCase().contains("login"));
        campusLogin.click();

        WebElement girisYap = driver.findElement(By.xpath("//span[@class='mdc-button__label']"));
        Assert.assertTrue("Giriş yap seçeneği bulunmuyor", girisYap.isDisplayed());

        BekleVeKapat();
    }

    @Test
    public void kursBasvuruTesti() {

        String country = "Andorra";
        String kurs = "SDET Türkçe"; // Menü: SDET Türkçe, Veri Bilimi, Job Center & Arbeitsamt, Veri Analitiği
        String survey = "Youtube"; // Menü: Youtube, Instagram, Facebook, LinkedIn, Mezundan, Arkadaş vasıtası ile, Website, Başka

        driver.get("https://techno.study/tr");
        MyFunc.Wait(2);

        WebElement basvurBtn = driver.findElement(By.linkText("BAŞVUR"));
        basvurBtn.click();

        WebElement adSoyad = driver.findElement(By.name("name"));
        adSoyad.sendKeys("Test Ihsu");
        MyFunc.Wait(2);

        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("test_usma@gmail.com");
        MyFunc.Wait(2);

        WebElement countryInput = driver.findElement(By.xpath("//span[@class='t-input-phonemask__select-triangle']"));
        countryInput.click();
        MyFunc.Wait(2);

        WebElement areaCode = driver.findElement(By.xpath("//div[@class='t-input-phonemask__options-name' and text()='" + country + "']"));
        areaCode.click();
        MyFunc.Wait(2);

        WebElement telefon = driver.findElement(By.name("tildaspec-phone-part[]"));
        telefon.sendKeys("999 999");
        MyFunc.Wait(2);

        WebElement ulke = driver.findElement(By.xpath("//select[@name='country']/option[@value='" + country + "']"));
        ulke.click();
        MyFunc.Wait(2);

        WebElement kursSecimi = driver.findElement(By.xpath("//select[@name='course']/option[@value='" + kurs + "']"));
        kursSecimi.click();
        MyFunc.Wait(2);

        WebElement biziNerdenDuydunuz = driver.findElement(By.xpath("//select[@name='survey']/option[@value='" + survey + "']"));
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

    @Test
    public void US_04_coursesTest() {
        driver.get("https://techno.study/tr");
        List<WebElement> kurslar = driver.findElements(By.xpath("//div[@field='descr']//li[@style='color: rgb(0, 0, 0);']"));
        Assert.assertTrue("Kurslar menüsünde tüm kurslar görünmüyor", kurslar.size() == 4);
        for (WebElement e : kurslar) {
            System.out.println(e.getText());
        }
        WebElement sdetKursu = driver.findElement(By.xpath("//div[@field='descr']//a[text()='SDET Yazılım Test Mühendisi']"));
        sdetKursu.click();
        wait.until(ExpectedConditions.textToBe(By.xpath("//div[text()='Yazılım Test Mühendisi']"), "Yazılım Test Mühendisi"));
        WebElement sdetAciklama = driver.findElement(By.xpath("//div[text()='Yazılım Test Mühendisi']"));
        System.out.println("sdetAciklama = " + sdetAciklama.getText().toLowerCase());
        Assert.assertTrue("hatalı kurs içeriği", sdetAciklama.getText().toLowerCase().contains("test"));

        WebElement android = driver.findElement(By.xpath("//div[@field='descr']//a[text()='Android uygulama geliştirme']"));
        android.click();
        wait.until(ExpectedConditions.textToBe(By.xpath("//strong[text()='Android uygulama geliştirme']"), "Android uygulama geliştirme"));
        WebElement androidAciklama = driver.findElement(By.xpath("//strong[text()='Android uygulama geliştirme']"));
        System.out.println("androidAciklama = " + androidAciklama.getText().toLowerCase());
        Assert.assertTrue("hatalı kurs içeriği", androidAciklama.getText().toLowerCase().contains("android"));

        WebElement veriBilimi = driver.findElement(By.xpath("//div[@field='descr']//a[text()='Veri bilimi']"));
        veriBilimi.click();
        wait.until(ExpectedConditions.textToBe(By.xpath("//div[text()='Veri Bilimi Bootcamp']"), "Veri Bilimi Bootcamp"));
        WebElement veriBilimiAciklama = driver.findElement(By.xpath("//div[text()='Veri Bilimi Bootcamp']"));
        System.out.println("veriBilimiAciklama = " + veriBilimiAciklama.getText().toLowerCase());
        Assert.assertTrue("hatalı kurs içeriği", veriBilimiAciklama.getText().toLowerCase().contains("veri"));

        BekleVeKapat();
    }

    @Test
    public void sosyalMedyaErisimTesti() {
        driver.get("https://techno.study/tr");
        MyFunc.Wait(2);

        List<WebElement> linkler = driver.findElements(By.xpath("//div[@class='t-sociallinks']//a[@target='_blank']"));
        for (WebElement e : linkler) {
            MyFunc.Wait(2);
            e.click();

        }
        Set<String> windowsIdler = driver.getWindowHandles();
        for (String id : windowsIdler) {
            driver.switchTo().window(id);
            System.out.println("title= " + driver.getTitle() + " -url= " + driver.getCurrentUrl());
            Assert.assertTrue("URL 'techno' yazısını içermiyor", driver.getCurrentUrl().toLowerCase().contains("techno"));
        }

        BekleVeKapat();
    }

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

    @Test
    public void US_07_logoTest() throws AWTException, IOException, InterruptedException {
        driver.navigate().to("https://techno.study/tr");

        List<WebElement> detayliBilgiler = driver.findElements(By.xpath("//a[text()='Detaylı bilgi']"));
        Assert.assertTrue("Her kurs için detaylı bilgi butonu yok", detayliBilgiler.size() == 3);

        WebElement sdetBilgi = driver.findElement(By.xpath("(//a[text()='Detaylı bilgi'])[2]"));
        sdetBilgi.click();

        wait.until(ExpectedConditions.urlToBe("https://techno.study/tr/sdet"));
        Assert.assertTrue("Hatalı kurs sayfasına yönlendirildi", driver.getCurrentUrl().contains("sdet"));

        driver.navigate().back();

        WebElement androidBilgi = driver.findElement(By.xpath("(//a[text()='Detaylı bilgi'])[3]"));
        androidBilgi.click();
        wait.until(ExpectedConditions.urlToBe("https://techno.study/tr/androidapp"));
        Assert.assertTrue("Hatalı kurs sayfasına yönlendirildi", driver.getCurrentUrl().contains("android"));

        driver.navigate().back();

        WebElement dataBilgi = driver.findElement(By.xpath("(//a[text()='Detaylı bilgi'])[1]"));
        dataBilgi.click();
        wait.until(ExpectedConditions.urlToBe("https://techno.study/tr/data"));
        Assert.assertTrue("Hatalı kurs sayfasına yönlendirildi", driver.getCurrentUrl().contains("data"));

        BekleVeKapat();
    }

    @Test
    public void us_08_kullanimSartlari() throws IOException {
        /*. "Bize Ulaşın" formunda "Şartları okudum ve kabul ettim" seçeneği bulunmalıdır.
             Bu seçeneği tıkladığımda, "Kullanım Şartları" sayfasına yönlendirilmelidir.
            "Kullanım Şartları" sayfası, kullanıcıların şartları okuyup anlamaları için uygun bir şekilde düzenlenmiş olmalıdır.. */
        driver.get("https://techno.study/tr/");

        WebElement sartlar = driver.findElement(By.xpath("//span[@style='color: rgb(83, 231, 190);']"));
        MyFunc.Wait(3);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", sartlar);        // elemente kadar kaydırdım sayfayı

        Assert.assertTrue("beklenen yazı yok", sartlar.getText().contains("Şartlar"));

        String urlAnasayfa = driver.getCurrentUrl();

        sartlar.click();   //aşağı indi, tıkladı

        String tiklamaSonrasiURL = driver.getCurrentUrl();
        //System.out.println(urlAnasayfa+"  "+tiklamaSonrasiURL);  kendıme kontrol ıcın urllerı yazdırdım

        TakesScreenshot ts = (TakesScreenshot) driver;
        File hafizadakiHali = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(hafizadakiHali, new File("ekranGoruntuleri\\screenshot_cansu.png"));

        Assert.assertNotEquals("url değişmedi yeni sayfa açılmadı", tiklamaSonrasiURL, urlAnasayfa);   // eguals olunca test pass ama ben notEquals olmasını beklıyorum ama url ler esıt oldugu ıcın hata verıyor cnku tıklayıncz url degısmedı


        BekleVeKapat();
    }

}
