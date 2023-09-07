package MainProject;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.nio.charset.Charset;

public class US_05_Ihs extends BaseDriver {

    @Test
    public void sosyalMedyaErisimTesti (){


        driver.get("https://techno.study/tr");
        MyFunc.Wait(2);

        WebElement tecStudyTrFB = driver.findElement(By.xpath("//li[@class='t-sociallinks__item t-sociallinks__item_facebook']"));
        tecStudyTrFB.click();
        String x=driver.getCurrentUrl();
        MyFunc.Wait(5);
        System.out.println("x = " + x);


        //switchToNewTab();
        //wait.until(ExpectedConditions.urlContains("facebook"));
        Assert.assertTrue("Current URL doesn't contain 'facebook'",  x.contains("facebook"));
        closeTab();

        WebElement tecStudyTrIns = driver.findElement(By.xpath("//li[@class='t-sociallinks__item t-sociallinks__item_instagram']"));
        tecStudyTrIns.click();

        switchToNewTab();
        Assert.assertTrue("Current URL doesn't contain 'instagram'",  driver.getCurrentUrl().contains("instagram"));
        closeTab();

        WebElement tecStudyTrYB = driver.findElement(By.xpath("//li[@class='t-sociallinks__item t-sociallinks__item_youtube']"));
        tecStudyTrYB.click();

        switchToNewTab();
        Assert.assertTrue("Current URL doesn't contain 'youtube'", driver.getCurrentUrl().contains("youtube"));
        closeTab();

        WebElement tecStudyTrLin = driver.findElement(By.xpath("//li[@class='t-sociallinks__item t-sociallinks__item_linkedin']"));
        tecStudyTrLin.click();

        switchToNewTab();
        Assert.assertTrue("Current URL doesn't contain 'linkedin'",  driver.getCurrentUrl().contains("linkedin"));
        closeTab();

        BekleVeKapat();

    }

    private void closeTab() {
    }

    private void switchToNewTab() {
    }

}
