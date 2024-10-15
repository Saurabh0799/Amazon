package test;

import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {

	WebDriver driver;
	String Url="https://www.amazon.in/";
	public Login(WebDriver driver) throws InterruptedException
	{
		this.driver=driver;
		driver.get(Url);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Enter text to search
		WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='twotabsearchtextbox']")));
		searchBox.sendKeys("xkfdlskjflkjasdlkjaslkj", Keys.ENTER);

		// Wait for search results to load
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'results for')]")));

		try {
			// Clear text from search bar
			WebElement searchBoxClear = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='twotabsearchtextbox']")));
			searchBoxClear.clear();


			// Wait again for the search box to be clickable after the refresh
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='twotabsearchtextbox']")));
		} catch (Exception e) {
			System.out.println("Not able to clear the search box or refresh: " + e.getMessage());
		}

		//search a laptop
		// Enter text to search
		WebElement searc = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='twotabsearchtextbox']")));
		searc.sendKeys("Laptop", Keys.ENTER);
		Thread.sleep(2000);


		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1350)", "");
		//        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
		Thread.sleep(2000);

		try {
			//click on searched laptot at index 4
			driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[6]/div/div/span/div/div/div/div[2]/div/div/div[1]/h2/a/span")).click();
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("window.scrollBy(0,500)", "");
		}catch (Exception e) {
			System.out.println("Not able to scrolls");
		}

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		String originalWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		for (String windowHandle : allWindows) {
			if (!windowHandle.equals(originalWindow)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}

		// Wait for the search box to be visible
		WebElement searchBox1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"productTitle\"]")));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,350)", "");
		//Thread.sleep(2000);

		//click on add to cart 
		driver.findElement(By.xpath("/html/body/div[2]/div/div[5]/div[3]/div[1]/div[4]/div/div[1]/div/div[1]/div/div/div[2]/div/div[2]/div/form/div/div/div[38]/div[1]/span/span/span/input")).click();
		Thread.sleep(5000);
		//click on cancel mark
		try {
			driver.findElement(By.xpath("//*[@id=\"attach-close_sideSheet-link\"]")).click();
		}catch (Exception e) {
			driver.findElement(By.xpath("//*[@id=\"attach-sidesheet-view-cart-button\"]/span/input")).click();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			Thread.sleep(2000);
		}
		Thread.sleep(5000);

		//		try {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -500);");
		Thread.sleep(2000);
		//			//click on cart to view added value
		driver.findElement(By.xpath("//*[@id=\"nav-cart\"]")).click();
		Thread.sleep(2000);

		try {
			driver.findElement(By.xpath("//*[@id=\"sc-active-6931ec8d-25af-48f7-af1e-56113ce4dbac\"]/div[4]/div/div[2]/div[1]/span[2]")).click();
			Thread.sleep(2000);
		}catch (Exception e) {
			driver.findElement(By.xpath("//input[@type='submit' and @value='Delete']")).click();
			System.out.println("Catch block");
			Thread.sleep(2000);
		}

		searc = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='twotabsearchtextbox']")));
		searc.sendKeys("Laptop", Keys.ENTER);
		Thread.sleep(2000);


		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)", "");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"a-autoid-1-announce\"]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"a-autoid-2-announce\"]")).click();
		Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -1000);");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"nav-cart\"]")).click();


	}
}
