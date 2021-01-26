package com.qualitystream.tutorial;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Mercury {
    
	private WebDriver driver;
	By resgisterLinkLocator = By.linkText("REGISTER");
	By registerPageLocator = By.xpath("//img[@src='/images/masts/mast_register.gif']");
	By email = By.id("email");
	By Password = By.xpath("//input[@name='password']");
	By ConfirPasswordlocator = By.name("confirmPassword");
	By registerBtnLocator = By.name("register");
	
	By userLocator = By.name("userName");
	By userpassword = By.name("password");
	By signInBtnLocator = By.name("login");
	
	By homePage = By.xpath("//tr//tr//tr//tr[1]//td[1]//img[1]");
	@Before
	public void setUp() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chormedriver/chromedriver.exe");
		
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://newtours.demoaut.com/");
	}

	@After
	public void tearDown() throws Exception {
	//	driver.quit();
	}
	
	@Test
	public void ResgiterUser() throws InterruptedException {
		driver.findElement(resgisterLinkLocator).click();
		Thread.sleep(4000);
		if(driver.findElement(registerPageLocator).isDisplayed()) {
			driver.findElement(email).sendKeys("qualityadmin");
			driver.findElement(Password).sendKeys("pass1");
			Thread.sleep(2000);
			driver.findElement(ConfirPasswordlocator).sendKeys("pass1");
			driver.findElement(registerBtnLocator).click();
		}
		else {
			System.out.print("Pagina no found");
		}
		
		List<WebElement> fonts = driver.findElements(By.tagName("font"));
		assertEquals("Note: Your user name is qualityadmin.", fonts.get(5).getText());
		
	}
   
	
	@Test
	public void sigIn() throws InterruptedException {
		if(driver.findElement(userLocator).isDisplayed()) {
			Thread.sleep(2000);
			driver.findElement(userLocator).sendKeys("qualityadmin");
			driver.findElement(userpassword).sendKeys("pass1");
			driver.findElement(signInBtnLocator).click();
			Thread.sleep(4000);
			assertTrue(driver.findElement(homePage).isDisplayed());
			System.out.println("Test Passed");
		}
		else
			System.out.println("Username no present");
		
	}
  
}
