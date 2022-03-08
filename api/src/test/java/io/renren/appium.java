package io.renren;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @program: starsharks
 * @ClassName appium
 * @description:
 * @author: Mr.Lv
 * @email: lvzhuozhuang@foxmail.com
 * @create: 2022-03-04 11:09
 * @Version 1.0
 **/
public class appium {


    public static void main(String[] args) throws MalformedURLException {
        WebDriver driver = new RemoteWebDriver(
                new URL("http://localhost:4444/wd/hub"),
                DesiredCapabilities.chrome());
        driver.get("https://www.cnblogs.acom/xyztank/articles/12686855.html");
    }
}
