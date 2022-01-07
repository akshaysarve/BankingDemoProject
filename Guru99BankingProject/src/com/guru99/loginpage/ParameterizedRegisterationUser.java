package com.guru99.loginpage;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ParameterizedRegisterationUser {


	public static void main(String[] args) throws IOException {
		
		// Parameterized all the Input values
		 String url= "http://demo.guru99.com/V4/";
		String expSectionTitle= "Guru99 Bank";



		// Parameterized all the WebElement path
		String loginSectionLocator="//h2[contains(text(), 'Guru99 Bank')]";
		String userNameLocator="uid";
		String passwrdLocator="password";
		String loginBtnLocator="btnLogin";
		String visibleText="//td[contains(text(), 'Manger Id : mngr376214')]";

		// Set system properties for Chrome Browser
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\sarve\\eclipse-workspace\\Guru99BankingProject\\firefoxdriver\\geckodriver.exe");

		// Creating instance of Chrome Browser
		WebDriver driver=new FirefoxDriver();

		// Launch the application
		driver.get(url);

		// Maximize the application
		driver.manage().window().maximize();

		// Implicit Wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Login Section Heading
		WebElement loginSection=driver.findElement(By.xpath(loginSectionLocator));

		// To verify the login section heading is displayed or not
		if(loginSection.isDisplayed()) {
			System.out.println("Login Section Heading is Displayed");
		}
		else {
			System.out.println("Login Section Heading is Not Displayed");
		}

		// Validating the title text
		String actSectionTitleText= loginSection.getText();
		String expSectionTitleText= expSectionTitle;

		if(actSectionTitleText.equals(expSectionTitleText)) {
			System.out.println("The Actual Title is " + actSectionTitleText);
			System.out.println("The Actual and Expected Title are Same");
		}
		else {
			System.out.println("The Actual and Expected Title are Same");	
			System.out.println("The Expected Title is " + expSectionTitleText);

		}

		// Username
		WebElement userName=driver.findElement(By.name(userNameLocator));

		// To verify the User Name is displayed or not
		if(userName.isDisplayed()) {
			System.out.println("User Name is Displayed");
		}
		else
		{
			System.out.println("User Name is not Displayed");
		}

		// To verify the User Name is enabled or not
		if(userName.isEnabled()) {
			System.out.println("User Name is Enabled");
			// To Enter the User Name
			userName.sendKeys("mngr376214");
		}
		else 
		{
			System.out.println("User Name is Not Enabled");
		}

		// Password
		WebElement passWrd=driver.findElement(By.name(passwrdLocator));

		// To verify the Password is displayed or not
		if(passWrd.isDisplayed()) {
			System.out.println("Password is Displayed");
		}
		else
		{
			System.out.println("Password is not Displayed");
		}

		// To verify the Password is enabled or not
		if(passWrd.isEnabled()) {
			System.out.println("Password is Enabled");
			// To Enter the Password
			passWrd.sendKeys("garanYn");
		}
		else 
		{
			System.out.println("Password is Not Enabled");
		}

		// Login Button
		WebElement loginBtn=driver.findElement(By.name(loginBtnLocator));

		// To verify the Login Button is displayed or not
		if(loginBtn.isDisplayed()) {
			System.out.println("Login Button is Displayed");
		}
		else
		{
			System.out.println("Login Button is not Displayed");
		}

		// To verify the Password is enabled or not
		if(loginBtn.isEnabled()) {
			System.out.println("Login Button is Enabled");
			// Click on Login
			loginBtn.click();
			System.out.println("Login is sucessful");
		}
		else 
		{
			System.out.println("Login Button is Not Enabled");
		}

		// To get the visible massage
		driver.findElement(By.xpath(visibleText)).getText();
		System.out.println(driver.findElement(By.xpath(visibleText)).getText());
		
		// Screenshot
		
	File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src, new File("C:\\Users\\sarve\\Downloads\\screenshot.png"));
	
	

		// Close the application
		driver.close();

	}



}

