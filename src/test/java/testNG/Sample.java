package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sample {

	@DataProvider
	public Object[][] getData() {
		Object[][] a=new Object[3][2];
		a[0][0]="qwerty";
		a[0][1]="qewrtyui";
		
		a[1][0]="12345678";
		a[1][1]="1345678";
		
		a[2][0]="wetr565898g#@$#%";
		a[2][1]="567hgd8978*&^%%";
		return a;
	}
	
	
	@Test(dataProvider = "getData")
	public void tc1(String user,String pass) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.facebook.com/");
	driver.findElement(By.id("email")).sendKeys(user);
	driver.findElement(By.name("pass")).sendKeys(pass);
	driver.findElement(By.name("login")).click();
	
	
	}
}
