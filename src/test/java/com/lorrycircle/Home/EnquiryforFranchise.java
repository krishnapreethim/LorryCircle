package com.lorrycircle.Home;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EnquiryforFranchise {
	static Properties pr;
	WebDriver driver;
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

		// click on Enquiry for Franchise button
		WebElement enquiry =driver.findElement(By.xpath("//label[@class='flex p-2']"));
		enquiry.click();
		String actualTitle = enquiry.getText();
		System.out.println(actualTitle);

		WebElement emailTextBox = driver.findElement(By.xpath("//input[@type='text'][@id='mat-input-2']"));
		emailTextBox.sendKeys("krishna@gmail.com");

		// Verify that the email textbox is working
		String emailText = emailTextBox.getAttribute("value");
		if (emailText.equals("krishna@gmail.com"))
		{
			System.out.println("Email textbox is working");
		} 
		else 
		{
			System.out.println("Email textbox is not working");
		}

		//Wait commaind 
		Thread.sleep(2000);

		// Verify the phone number 
		WebElement phone =  driver.findElement(By.id("mobileNo"));
		phone.sendKeys("9908829826");

		// Verify that the phone textbox is working
		String phonetext = phone.getAttribute("value");
		if (phonetext.equals("9908829826"))
		{
			System.out.println("Phone textbox is working");
		}
		else
		{
			System.out.println("Phone textbox is not working");
		}
		//Wait commaind 
		Thread.sleep(2000);
		// Verify the Name text field
		WebElement name = driver.findElement(By.xpath("//input[@id='mat-input-4']"));
		name.sendKeys("Krishna");

		// Verify that the Name textbox is wroking
		String nametext = name.getAttribute("value");

		if (nametext.equals("Krishna"))
		{
			System.out.println("name textbox is working");
		}
		else
		{
			System.out.println("name textbox is not working");
		}
		// Verify that the Organization Name text field 
		WebElement Org = driver.findElement(By.xpath("(//input[@id='mat-input-5'])[1]"));       
		Org.sendKeys("LorryCircle");

		// Verify that the Name textbox is wroking
		String orgtext = name.getAttribute("value");

		if (orgtext.equals("LorryCircle"))
		{
			System.out.println("Organization textbox is working");
		}
		

		// Verify the dropdown of What is the Location (State & District) of interest to Operate Franchise ?
		WebElement Dropdown=driver.findElement(By.id("mat-select-value-3"));
		Dropdown.click();

		/*Select statelist=new Select(Dropdown);
		List<WebElement> states=statelist.getOptions();
		//Note: Above states reference store all the values from dropdown
		for(WebElement state:states) {
			System.out.println(state.getText());

		}*/
		WebElement list = driver.findElement(By.xpath("//span[text()='Goa']"));

		String text = list.getText();
		list.click();
		System.out.println(text);
		Thread.sleep(2000);

		// Verify the dropdown of District list
		WebElement district=driver.findElement(By.xpath("//span[text()='District']"));
		district.click();
		Thread.sleep(5000);
		WebElement ldistricts=driver.findElement(By.tagName("mat-option"));
		String textdistricts = ldistricts.getText();
		ldistricts.click();
		System.out.println(textdistricts);

		// Verify If you found right opportunity, how soon could you start? dropdown
		WebElement DD=driver.findElement(By.xpath("//div[@id='mat-select-value-7']//span"));
		DD.click();
		WebElement selectotion = driver.findElement(By.xpath("//*[text()='6 Months']"));
		String selecttext = selectotion.getText();
		selectotion.click();
		System.out.println(selecttext);
		//Thread.sleep(2000);
		
		//Verify Experience in Same or Related Trade? dropdown
		WebElement trade_DD = driver.findElement(By.xpath("(//div)[392]"));
		trade_DD.click();
		Thread.sleep(2000);
		WebElement trade_text = driver.findElement(By.xpath("//span[@class='mat-option-text'][text()='More than 2 Year']"));
		String select_trade = trade_text.getText();
		trade_text.click();
		System.out.println(select_trade);
		
		// Verify Liquid Capital text
		WebElement text1 = driver.findElement(By.xpath("(//input[@id='mat-input-6'])[1]"));
		text1.sendKeys("cash balances");
		
		String Liquid_text = text1.getAttribute("data-placeholder");
		System.out.println(Liquid_text);

		if (Liquid_text.equals("cash balances"))
		{
			System.out.println("Liquid Capital textbox is working");
		}
		else
		{
			System.out.println("Liquid Capital textbox is not working");
		}
		
		
		// Verify Best Time to Contact text box
		WebElement timetext = driver.findElement(By.xpath("(//input[@id='mat-input-7'])[1]"));
		timetext.sendKeys("11.00 AM");
		String time_text = timetext.getAttribute("data-placeholder");
		System.out.println(time_text);
		
		// Verify Referrer's Name text box
		WebElement name_text = driver.findElement(By.xpath("(//input[@id='mat-input-8'])[1]"));
		name_text.sendKeys("preethi");
		String referrer_text = name_text.getAttribute("data-placeholder");
		System.out.println(referrer_text);
		
		// Verify Referrer's Phone/Email text box
		WebElement refcontact = driver.findElement(By.xpath("(//input[@formcontrolname='refContact'])[1]"));
		refcontact.sendKeys("9908829826");
		String ref_phone = refcontact.getAttribute("data-placeholder");
		System.out.println(ref_phone);
		
		// Verify Is there any other information you want to share with us? text field
		WebElement info_test = driver.findElement(By.xpath("(//textarea[@formcontrolname='otherInfo'])[1]"));
		info_test.sendKeys("Thank you for sharing the information you already provided. Before we conclude, I wanted to check with you if there is any other information that you would like to share with us. We value your insights and opinions and want to ensure that we have a complete understanding of your perspective. If there's anything else you'd like to add, please do not hesitate to let us know.\r\n"
				+ "\r\n"
				+ "Thank you for your time and cooperation.\r\n"
				+ "\r\n"
				+ "Best regards,\r\n"
				+ "\r\n"
				+ "[Your Name]");
		String info = info_test.getAttribute("data-placeholder");
		System.out.println(info);
		
		// Verify submit button
		WebElement button = driver.findElement(By.xpath("//span[text()='Submit ']"));
		button.click();
		
		
		
		Thread.sleep(2000);
		// Close the browser
		driver.close();
	}

}




