package com.lorrycircle.signup;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class signup {
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
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


		// Calling url from propertie file
		String application_url = pr.getProperty("url");
		driver.get(application_url);


		// Click on Sign UP button 
		driver.findElement(By.xpath("//button[text()=' Sign Up ']")).click();
		driver.findElement(By.xpath("//*[text()='English']")).click();


		// Give Username and phone number from properties file 
		String app_username = pr.getProperty("username");
		String app_phone = pr.getProperty("phonenumber");
		WebElement UNtext=driver.findElement(By.id("name"));
		UNtext.sendKeys(app_username);
		WebElement PNtext = driver.findElement(By.xpath("//input[@id='mat-input-3']"));
		PNtext.sendKeys(app_phone);

		// Click on CheckBox and accept the terms and conditions 
		driver.findElement(By.xpath("//span[@class='mat-checkbox-inner-container']")).click();
		driver.findElement(By.xpath("//span[text()=' ACCEPT ']")).click();

		// Click on Register button 
		driver.findElement(By.xpath("//span[text()='Register']")).click();

		// Find the OTP textbox
		WebElement otpTextbox = driver.findElement(By.id("otpCode"));

		// Get the value of the textbox
		String otpValue = otpTextbox.getAttribute("value");
		System.out.println(otpValue);


		String expectedOtpValue = "123456";
		//assertEquals(expectedOtpValue, otpValue);


		// print the OTP value to the console
		System.out.println("OTP value is: " + expectedOtpValue);
		
		WebElement element = driver.findElement(By.xpath("//*[text()=' Verify Code']"));
		if (element.isEnabled()) {
		    element.click();
		}

		/*WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=' Verify Code']")));
		element.click();*/


		//driver.findElement(By.xpath("//*[text()=' Verify Code']")).click();
		driver.findElement(By.xpath("//span[@class='mat-button-wrapper'][text()='OK ']")).click();
	
	// Close the browser
         driver.close();

	}
	

}

