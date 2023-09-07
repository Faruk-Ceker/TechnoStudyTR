package MainProject;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class US_05_Ihs extends BaseDriver {

    @Test
    public void sosyalMedyaErisimTesti (){

       driver.get("https://techno.study/tr");
       MyFunc.Wait(2);

        List<WebElement> linkler = driver.findElements(By.xpath("//div[@class='t-sociallinks']//a[@target='_blank']"));
        for (WebElement e : linkler){
            MyFunc.Wait(2);
            e.click();

        }
        Set<String> windowsIdler = driver.getWindowHandles();
        for (String id : windowsIdler) {
            driver.switchTo().window(id);
            System.out.println("title= "+driver.getTitle()+" -url= "+driver.getCurrentUrl());
            Assert.assertTrue("URL 'techno' yazısını içermiyor" ,  driver.getCurrentUrl().toLowerCase().contains("techno"));

        }

        BekleVeKapat();
    }

  }
