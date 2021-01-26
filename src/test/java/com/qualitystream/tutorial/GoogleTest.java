package com.qualitystream.tutorial;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class GoogleTest {
	
	private WebDriver driver;
	
	@Before
	public void setUp() {
	System.setProperty("webdriver.chrome.driver", "C://chromedriver_win32/chromedriver.exe");
	
		driver= new ChromeDriver();
		driver.manage().window().maximize();
	//	driver.get("http://live.demoguru99.com/");

		driver.get("https://www.google.es/");
	}
	@Test
	public void testGooglePage() throws InterruptedException {
		WebElement searchbox = driver.findElement(By.name("q"));
		searchbox.clear();
		searchbox.sendKeys("Barquisimeto");
		searchbox.sendKeys(Keys.ENTER);
		//searchbox.submit();
		Thread.sleep(3000);
		driver.findElement(By.className("LC20lb MMgsKf")).click();
		Thread.sleep(3000);
	   assertEquals("Barquisimeto - Wikipedia, la enciclopedia libre - Google Saerch", driver.getTitle());
        System.out.println("Test Passed");
	}
	
	@After
	public void CerrarGooglePage() {
		driver.quit();
	}
	
	
}
