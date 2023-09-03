package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriver {
    public static WebDriver driver;
    public static WebDriverWait wait;


    static // boyle yaparsak metodu direk çalıştırır ilk basta
            //bunun sartı extends olması ve başta yer alması
   // public static void DriverBaslat ()
    {

        //selenium chrome güncel versiyon uyarısını kaldırmak için
        Logger logger = Logger.getLogger(""); // output yapılan tüm logları al
        logger.setLevel(Level.SEVERE); // sadece errorları gosterir


        driver = new ChromeDriver(); //jendkinste sen head olmadan yeni hafızada calıs diyecez
        driver.manage().window().maximize(); //tam ekran yapar
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public static void BekleVeKapat (){
        MyFunc.Wait(3);
        driver.quit();
    }

}
//  Java hızlı - Web sitesi yavaş
// java elemanı bulmaya çalışıyor, ama web sitesi hala yuklenıyor. site yüklenmeden java bulamadım dıyor bıtırıyor,
// Web elementı bulmaya calıstıgında (FindElement/s)
//  çözüm 1 : biraz süre vereceğiz (20s)

//  Thread.sleep(); -> javayı direkt verilen süre kadar durdurur. kac sanıye verırsen o kadar durdurur programı. Osebeple bu işimize yaramıyor. Bize buldugu zaman cıksın yanı mesela 20 sn verdık 10. sanıyede java buldun cık, 20 sn beklemesın ısterız
//         bıde bu Thread.sleep ıyı kod degıldır mulakatta bundan bahsetme mesela.
//  bunun yerıne driver.manage yapıp bunu MyFunc a atıcam oradan cagırıyorum her seferınde yazmayayım dıye

//driverBaslat();   // extend aldık BaseDriverdan ondan cagırdık boyle
// driverBaslat(); ı yazmama gerek kalmadı neden?
// çünkü bu kodu her zaman mainde ilk başta çalışıyorsa o zaman sen bunu fınksıyon kullnamadan dırekt calıstırabılırsın dıyor java
//BaseDriver da önceden yaptıgımız   public static void driverBaslat()ı  --> static{ yaptık ve yukarıda buradan maınden sonra bır sey yazmadık
// zaten extends yaptıgımız ıcın BaseDriver dan bılıyor java maınden sonra bunu calıstıracagını