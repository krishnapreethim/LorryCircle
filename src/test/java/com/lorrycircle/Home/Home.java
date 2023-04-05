package com.lorrycircle.Home;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Home {
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
		
		// Find all links on the page
		List<WebElement> links = driver.findElements(By.tagName("a"));

		// Print the href attribute of each link
		for (WebElement link : links) {
		    System.out.println(link.getAttribute("href"));
		}
		driver.close();

		// Close the browser
		//driver.close();
		






		
		
		
		
		
		
		
	}


}
