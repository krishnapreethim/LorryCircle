package com.lorrycircle.Home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser 
{

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();// this syntax is interacting with browser
		
		WebDriver driver = new ChromeDriver();
		
		//In real time we are taking driver as a reference
		
		// Above two lines of syntax is used to lauch a specific browser
		
		// 95% applications are tested in chromebrowser
		
		driver.manage().window().maximize();
		
		driver.get("https://github.com/");
		
		String opened_url =driver.getCurrentUrl();
		
		System.out.println("URL of the application:: "+opened_url);
		
		String page_title =driver.getTitle();
		
		System.out.println("Title of the page ::"+page_title);
		
		driver.close();

	}

}
