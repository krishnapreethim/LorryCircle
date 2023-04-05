package com.lorrycircle.Home;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BookLorry {
	static Properties pr;
	static WebDriver driver;
	public static void main(String[] args) throws Exception {
		//calling the data from properties file
		File file = new File("D:\\NewSelenium\\LorryCircle\\LorryCirclewebdriver\\src\\test\\resources\\Properties\\config.propertie");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		pr = new Properties();
		pr.load(reader);

		// Launch Browser and wait time
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


		// Calling url from propertie file
		String application_url = pr.getProperty("url");
		driver.get(application_url);
		
		// Valadite the Source field 
		WebElement suggestionBox = driver.findElement(By.xpath("(//input[@id='mat-input-0'])[1]"));
		suggestionBox.sendKeys("Hyderabad");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[text()='Hyderabad, Telangana, India']")));
		WebElement suggestion = driver.findElement(By.xpath("//span[text()='Hyderabad, Telangana, India']"));
		suggestion.click();
		
		// Valadite the Destination field
		WebElement destination=driver.findElement(By.xpath("(//input[@id='mat-input-1'])[1]"));
		destination.sendKeys("Bangalore");
		WebDriverWait waits = new WebDriverWait(driver, 10);
		waits.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[text()='Bangalore, Karnataka, India']")));
		WebElement suggestions = driver.findElement(By.xpath("//span[text()='Bangalore, Karnataka, India']"));
		suggestions.click();
		
		// Valadite the Select Vehicle Type dropdown
		WebElement vehiclelist = driver.findElement(By.xpath("//*[@id=\"mat-select-value-1\"]/span"));
		vehiclelist.click();
		WebElement list = driver.findElement(By.xpath("//*[@id=\"mat-option-8\"]/span"));
		
		String text = list.getText();
		list.click();
		System.out.println(text);
	    
		// Click on Find Trucks  
		driver.findElement(By.xpath("//span[text()=' Find Trucks ']")).click();
		Thread.sleep(2000);
		//driver.close();
		
		
	
	}
}




