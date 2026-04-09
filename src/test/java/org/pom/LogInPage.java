package org.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {
	
	private WebDriver driver;
	
	
	@FindBy(xpath ="//a[text()='Login']")
	private WebElement loginButton;
	
	
	@FindBy(name ="q")
	private WebElement searchBar;
	



	public WebElement getLoginButton() {
		return loginButton;
	}


	public WebElement getSearchBar() {
		return searchBar;
	}


	public LogInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

}
