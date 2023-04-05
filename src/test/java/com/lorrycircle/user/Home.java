package com.lorrycircle.user;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Home {
	static Properties pr;
	static WebDriver driver;
	public static void main(String[] args) throws Exception {
		//calling the data from properties file
		File file = new File("D:\\LorryCirclewebdriver\\src\\test\\resources\\Properties\\config.propertie");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		pr = new Properties();
		pr.load(reader);

		// Launch Browser and wait time
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//	driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


		// Calling URL from properties file
		String application_url = pr.getProperty("url");
		driver.get(application_url);

		// Click on Login button
		driver.findElement(By.xpath("//button[text()=' Login ']")).click();

		// Enter User Phone number
		String app_phone = pr.getProperty("phonenumber");
		WebElement phone = driver.findElement(By.id("userLogin"));
		phone.sendKeys(app_phone);
		driver.findElement(By.xpath("//span[text()='Send OTP']")).click();

		// Find the OTP text box
		WebElement otpTextbox = driver.findElement(By.id("otp"));

		// Get the value of the text box
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

		// Validate the Source field 
		WebElement suggestionBox = driver.findElement(By.xpath("//input[@id='mat-input-4']"));
		suggestionBox.sendKeys("Hyderabad");   

		// Create a JavascriptExecutor instance
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Execute a JavaScript code that highlights the text box by adding a border
		js.executeScript("arguments[0].style.border='3px solid red'", suggestionBox);

		//Select drop down value	from suggestionBox
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[text()='Hyderabad, Telangana, India']")));
		WebElement suggestion = driver.findElement(By.xpath("//span[text()='Hyderabad, Telangana, India']"));
		suggestion.click();
		Thread.sleep(2000);

		// Validate the Destination field 
		WebElement destinationBox = driver.findElement(By.xpath("//input[@data-placeholder='Destination...']"));
		destinationBox.sendKeys("Bangalore");  

		// Create a JavascriptExecutor instance
		JavascriptExecutor js2 = (JavascriptExecutor) driver;

		// Execute a JavaScript code that highlights the text box by adding a border
		js2.executeScript("arguments[0].style.border='3px solid red'", destinationBox);

		//Select drop down value	from destinationBox
		WebDriverWait waits = new WebDriverWait(driver, 10);
		waits.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[text()='Bangalore, Karnataka, India']")));
		WebElement suggestions2 = driver.findElement(By.xpath("//span[text()='Bangalore, Karnataka, India']"));
		suggestions2.click();

		//Select drop down value from find the truck

		WebElement element = driver.findElement(By.xpath("//*[@placeholer='Select Vehicle Type']/div/div/span"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

		// Find the Vehicle type
		WebElement element1=driver.findElement(By.xpath("//input[@placeholder='Suche'][@aria-label='dropdown search']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element1);

		//Select drop down value from Vehicle type
		WebElement vehicleselect = driver.findElement(By.xpath("//*[@class='mat-option-text'][text()=' 2 MT - Closed Body 14 Ft']"));

		Actions actions = new Actions(driver);
		actions.moveToElement(vehicleselect).click().perform();

		// Find the date picker element
		WebElement datepicker = driver.findElement(By.xpath("(//button[@aria-label='Open calendar'])[1]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", datepicker);


		//WebElement datePicker = driver.findElement(By.xpath("(//button[@aria-label='Open calendar'])[1]"));
		// Create a JavascriptExecutor instance
		JavascriptExecutor js3 = (JavascriptExecutor) driver;

		// Execute a JavaScript code that highlights the text box by adding a border
		js3.executeScript("arguments[0].style.border='3px solid yellow'", datepicker);


		WebElement dateField = driver.findElement(By.xpath("//td[@role='gridcell'][div][3]"));

		// replace with your desired date format
		dateField.sendKeys("10/4/2023");
		dateField.click();

		// Create a JavascriptExecutor instance
		JavascriptExecutor js4 = (JavascriptExecutor) driver;

		// Execute a JavaScript code that highlights the text box by adding a border
		js4.executeScript("arguments[0].style.border='3px solid yellow'", dateField);

		// Click on Apply Button
		driver.findElement(By.xpath("//*[text()='Apply']")).click();

		// Find the element to hover over
		//	WebElement elementToHover = driver.findElement(By.xpath(""));
		WebElement element_1 = driver.findElement(By.xpath("//*[@style='transform: rotateZ(-180deg);'][text()=' 6 ']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element_1);

		WebElement element_2 = driver.findElement(By.xpath("//*[@style='transform: rotateZ(-354deg);']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element_2);

		WebElement element_3 = driver.findElement(By.xpath("//*[text()='Ok']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element_3);




		// Find the Get Quote
		WebElement getquote = driver.findElement(By.xpath("//*[@class='mat-button-wrapper'][text()=' Get Quote ']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", getquote);
		Thread.sleep(2000);


		// get page title of get quote
		WebElement gettitle=driver.findElement(By.xpath("//*[@class='bold fs-16 ng-star-inserted'][text()='Load Posting']"));
		String title = gettitle.getText();
		System.out.println(title);

		//Click on Material Type
		WebElement materialtype = driver.findElement(By.xpath("//*[@formcontrolname='goodsType']"));
		Thread.sleep(1000);//.click();
		materialtype.click();

		// Create a JavascriptExecutor instance
		JavascriptExecutor jsmt = (JavascriptExecutor) driver;

		// Execute a JavaScript code that highlights the text box by adding a border
		jsmt.executeScript("arguments[0].style.border='3px solid red'", materialtype);
		Thread.sleep(1000);

		// Select Material type from drop down
		WebElement element4 = driver.findElement(By.xpath("//*[text()='Non Hazardous Chemicals']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element4);


		// Select Package Type
		WebElement packagetype=driver.findElement(By.id("packageType"));
		packagetype.click();

		// Select Package Type drop down
		WebElement packagedropdown=driver.findElement(By.xpath("//*[text()='Vegetable ']"));
		packagedropdown.click();

		//Verify  the text box of Qty (in MT) quantity
		WebElement textbox=driver.findElement(By.id("quantity"));
		textbox.sendKeys("100");

		// Execute a JavaScript code that highlights the text box by adding a border
		JavascriptExecutor js6 = (JavascriptExecutor) driver;
		js6.executeScript("arguments[0].style.border='3px solid red'", textbox);

		//Verify the Expected Price text box
		WebElement Eprice=driver.findElement(By.xpath("//*[@formcontrolname='expectedPrice']"));
		Eprice.clear();
		Eprice.sendKeys("5000");
		// Execute a JavaScript code that highlights the text box by adding a border
		JavascriptExecutor js7 = (JavascriptExecutor) driver;
		js7.executeScript("arguments[0].style.border='3px solid red'", Eprice);
		Thread.sleep(1000);

		//Verify the comment text box
		WebElement commentstext=driver.findElement(By.id("comments"));
		commentstext.sendKeys("jsdhfkhkahsjkhfahsdjfhashkhfhdlJHj"
				+ "sjdFLHSJDlfhKSJHDfjhsdkjhfhjHSLKJHF");

		// Execute a JavaScript code that highlights the textbox by adding a border
		JavascriptExecutor js8 = (JavascriptExecutor) driver;
		js8.executeScript("arguments[0].style.border='3px solid red'", commentstext);

		// Verify functionality Get quote button
		WebElement button=driver.findElement(By.xpath("//button[@color='warn']/span[text()=' Get Quote ']"));
		button.click();
		Thread.sleep(5000);

		// Verify the title of Confirmation page
		WebElement conformtitle=driver.findElement(By.xpath("//*[text()=' Confirmation ']"));
		String conform = conformtitle.getText();
		System.out.println(conform);

		// Verify the text of Confirmation  
		WebElement confirmtext=driver.findElement(By.xpath("//*[text()=' Are You Sure?']"));
		String context = confirmtext.getText();
		System.out.println(context);
		// Execute a JavaScript code that highlights the textbox by adding a border
		JavascriptExecutor js9 = (JavascriptExecutor) driver;
		js9.executeScript("arguments[0].style.border='3px solid red'", confirmtext);

		// Verify the text2 of Confirmation
		WebElement confirmtext1 = driver.findElement(By.xpath("//*[text()='Want to Post Load?']"));
		String context1 = confirmtext1.getText();
		System.out.println(context1);
		// Execute a JavaScript code that highlights the text box by adding a border
		JavascriptExecutor jscon = (JavascriptExecutor) driver;
		jscon.executeScript("arguments[0].style.border='3px solid red'", confirmtext1);

		// Verify button of Confirmation Yes, Proceed
		WebElement confiButton = driver.findElement(By.xpath("//*[@class='mat-button-wrapper'][text()='Yes, Proceed ']"));
		confiButton.click();
		if (confiButton.equals(confiButton)) 
		{
			System.out.println("confiButton");
		} 
		else 
		{
			WebElement cancelbutton = driver.findElement(By.xpath("//*[@class='mat-button-wrapper'][text()=' No, Cancel ']"));
			cancelbutton.click();
			System.out.println("cancelbutton");
		}

		// Verify  Quote Requested  text
		WebElement QR = driver.findElement(By.className("col-md-12 bold cust-dialog-ttl"));
		String Q_R = QR.getText();
		System.out.println(Q_R);

		// 
		//*[@class='mat-button-wrapper'][text()=' OK ']

		//*[@class='mat-button-wrapper'][text()='Yes, Proceed ']
		//*[text()=' Confirmation ']
		//driver.close();





	}

}
