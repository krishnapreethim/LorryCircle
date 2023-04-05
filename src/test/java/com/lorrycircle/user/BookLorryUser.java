package com.lorrycircle.user;

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

import io.github.bonigarcia.wdm.WebDriverManager;

public class BookLorryUser {
	static Properties pr;
	static WebDriver driver;
	public static void main(String[] args) throws IOException, Exception  {
		//calling the data from properties file
		File file = new File("D:\\LorryCirclewebdriver\\src\\test\\resources\\Properties\\config.propertie");
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

		// Click on Login button
		driver.findElement(By.xpath("//button[text()=' Login ']")).click();

		// Enter User Phone number
		String app_phone = pr.getProperty("phonenumber");
		WebElement phone = driver.findElement(By.id("userLogin"));
		phone.sendKeys(app_phone);
		driver.findElement(By.xpath("//span[text()='Send OTP']")).click();

		// Find the OTP textbox
		WebElement otpTextbox = driver.findElement(By.id("otp"));

		// Get the value of the textbox
		String otpValue = otpTextbox.getAttribute("value");
		System.out.println(otpValue);


		String expectedOtpValue = "123456";
		//assertEquals(expectedOtpValue, otpValue);


		// print the OTP value to the console
		System.out.println("OTP value is: " + expectedOtpValue);
		driver.findElement(By.xpath("(//span[@class='mat-button-wrapper'])[1]")).click();
		String opened_url =driver.getCurrentUrl();
		System.out.println("URL of the application:: "+opened_url);
		String page_title =driver.getTitle();
		System.out.println("Title of the page ::"+page_title);
		Thread.sleep(3000);
		
		// Verify Click on Book Lorry
		WebElement BL = driver.findElement(By.xpath("//*[@class='align-self-center flex pointer bold'][text()=' Book Lorry ']"));
		BL.click();
		String booklorry = driver.getCurrentUrl();
		System.out.println("URL of the application:: "+booklorry);
		String pt = driver.getTitle();
		System.out.println("Title of the page ::"+pt);
		Thread.sleep(3000);
		
		// Verify Back to Dashboard button
		WebElement backtodashboard = driver.findElement(By.xpath("//*[@class='mat-button-wrapper'][text()=' Back to Dashboard ']"));
		backtodashboard.click();
		String B_dashboard = driver.getCurrentUrl();
		System.out.println("URL of the application:: "+B_dashboard);
		String DB = driver.getTitle();
		System.out.println("Title of the page ::"+DB);
		Thread.sleep(2000);
		//driver.close();
	}

}
