package org.pom;
import java.util.Set;

import org.libglobal.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class TestClass extends BaseClass{
	
	@Test
	private void flipKart() throws Throwable {
		driver =  LaunchChromeBrowser();
		openAppUrl("https://www.flipkart.in/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@role='button']")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("q")).sendKeys("Iphone",Keys.ENTER);
		driver.findElement(By.xpath("//div[text()='Apple iPhone 16 Pro Max (Natural Titanium, 256 GB)']")).click();
		String parentWindow = driver.getWindowHandle();
		Set<String> allWindow = driver.getWindowHandles();
		
		for (String eachWindow : allWindow) {
			if(!parentWindow.equals(eachWindow)) {
				driver.switchTo().window(eachWindow);
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[text()='Buy now']")).click();
				System.out.println("Arun singh");
			}
			
		}

	}

}
