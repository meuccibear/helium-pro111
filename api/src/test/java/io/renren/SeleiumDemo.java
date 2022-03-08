package io.renren;

import io.renren.common.gitUtils.appium.Web;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import java.net.MalformedURLException;

public class SeleiumDemo {

    Web web;

    @Before
    public void before() throws MalformedURLException {
        web = new Web().build();
    }

    @Test
    public void asd() {
        String hexIndex = "85410a43fffffff";

        web.open(String.format("https://app.hotspotty.net/hexes/%s/transmit-scale/dashboard", hexIndex));
        web.until(By.xpath("//*[@id=\"default-page-container\"]/article/div[3]/section[1]/dl/div[1]/div/dd/div[1]"), 5).outText();
        web.until(By.xpath("//*[@id=\"default-page-container\"]/article/div[3]/section[1]/dl/div[1]/div/dd/div[2]"), 5).outText();
        web.sleep(100);
        web.until(By.xpath("//*[@id=\"default-page-container\"]/div/div[2]/canvas"), 5).move(500, 200);

        web.sleep(4 * 60 * 1000);
    }

    @After
    public void after() throws MalformedURLException {
        web.quit();
    }
}
