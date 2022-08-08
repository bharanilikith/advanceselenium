package dataDriven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test2 {
	@Test
	public void tc2() throws SQLException {
//Step:1 Register to the database
	Driver driverrf=new Driver();
	DriverManager.registerDriver(driverrf);
	
	//Step:2 Connect to database
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wasm4","root","root");
	
	//step:3 create sql query statement
	Statement statement = con.createStatement();
	String query="select * from logindetails";
	
	//Step:4 execute query
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.facebook.com/");
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
	ResultSet result = statement.executeQuery(query);
	while(result.next()) {
		System.out.println(result.getString(1));
		System.out.println(result.getString(2));
		driver.findElement(By.id("email")).sendKeys(result.getString(1));
		driver.findElement(By.name("pass")).sendKeys(result.getString(2));
		
	}
	
	
	
	
	//step:5 close the connection
	con.close();
	
	}

}
