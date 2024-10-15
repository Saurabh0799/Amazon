package capability;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Capability {
	WebDriver driver;
	public WebDriver Capability()
	{
		try {
			ChromeOptions opt = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			opt.addArguments("no-sandbox");
			//opt.addArguments("headless");
			opt.addArguments("window-size=1920,1080");
			driver = new ChromeDriver(opt);
		}
		catch(Exception e){}	
		return driver;
	}

}
