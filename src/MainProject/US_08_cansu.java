package MainProject;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

public class US_08_cansu extends BaseDriver {

    @Test
    public void us_08_kullanimSartlari() throws IOException {
        /*. "Bize Ulaşın" formunda "Şartları okudum ve kabul ettim" seçeneği bulunmalıdır.
             Bu seçeneği tıkladığımda, "Kullanım Şartları" sayfasına yönlendirilmelidir.
            "Kullanım Şartları" sayfası, kullanıcıların şartları okuyup anlamaları için uygun bir şekilde düzenlenmiş olmalıdır.. */
        driver.get("https://techno.study/tr/");

        WebElement sartlar= driver.findElement(By.xpath("//span[@style='color: rgb(83, 231, 190);']"));
        MyFunc.Wait(3);

        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",sartlar);        // elemente kadar kaydırdım sayfayı

        Assert.assertTrue("beklenen yazı yok",sartlar.getText().contains("Şartlar"));

        String urlAnasayfa= driver.getCurrentUrl();

        sartlar.click();   //aşağı indi, tıkladı

        String tiklamaSonrasiURL= driver.getCurrentUrl();
        //System.out.println(urlAnasayfa+"  "+tiklamaSonrasiURL);  kendıme kontrol ıcın urllerı yazdırdım

        TakesScreenshot ts=(TakesScreenshot) driver;
        File hafizadakiHali= ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(hafizadakiHali, new File("ekranGoruntuleri\\screenshot_cansu.png"));

        Assert.assertNotEquals("url değişmedi yeni sayfa açılmadı",tiklamaSonrasiURL,urlAnasayfa);   // eguals olunca test pass ama ben notEquals olmasını beklıyorum ama url ler esıt oldugu ıcın hata verıyor cnku tıklayıncz url degısmedı


        BekleVeKapat();
    }




}
