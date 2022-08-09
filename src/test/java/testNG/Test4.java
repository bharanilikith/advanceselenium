package testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test4 {
	@Test
	public void tc1() {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.facebook.com/");
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
	driver.findElement(By.id("email")).sendKeys("admin");
	driver.findElement(By.name("pass")).sendKeys("manager");
	driver.findElement(By.linkText("Forgotten password?")).click();
	System.out.println(driver.getTitle());
	System.out.println(driver.getCurrentUrl());
	driver.close();
}
}