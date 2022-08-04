package actions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test0 {
	@Test
	public void demo() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://www.dhtmlgoodies.com/submitted-scripts/i-google-like-drag-drop/");
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
	WebElement block1 = driver.findElement(By.xpath("//h1[text()='Block 1']"));
	WebElement block4 = driver.findElement(By.xpath("//h1[text()='Block 4']"));
	Thread.sleep(5000);
	
	Actions a=new Actions(driver);
	a.clickAndHold(block1).moveToElement(block4).release().perform();
	
	}

}
