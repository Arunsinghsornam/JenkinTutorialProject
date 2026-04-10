package org.libglobal;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {


	    protected  WebDriver driver;

	    public  WebDriver LaunchEdgeBrowser() {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			return driver;

		}

	    public static class ZoomUtility {
		    public static void zoomOut(WebDriver driver, double zoomLevel) {
		        JavascriptExecutor js = (JavascriptExecutor) driver;
		        js.executeScript("document.body.style.zoom='" + zoomLevel + "'");
		    }
		}


	    public  WebDriver LaunchFirefoxBrowser() {
	    	WebDriverManager.firefoxdriver().setup();
	    	driver = new FirefoxDriver();
	    	 return driver;

		}

	    public WebDriver LaunchChromeBrowser() {

	        ChromeOptions options = new ChromeOptions();

	        options.addArguments("--headless=new");
	        options.addArguments("--disable-gpu");
	        options.addArguments("--window-size=1920,1080");

	        options.addArguments("force-device-scale-factor=0.9");
	        options.addArguments("high-dpi-support=0.9");

	       
	        WebDriverManager.chromedriver().clearDriverCache().setup();

	        driver = new ChromeDriver(options);

	        return driver;
	    }

		public void waitUntilLoadingScreenDisappears() {
	    	try {
	    		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loadingScreen")));
	    	} catch (Exception e) {
	    		System.out.println("⏳ Loading screen did not disappear in time.");
	    	}
	    }

		public  void elementWait() {
			Timeouts implicitlyWait =  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		}
		public  void maximizeWindow() {
			driver.manage().window().maximize();
		}
		public  void openAppUrl(String url) {
			driver.get(url);


		}
		public  String getUrl() {
			return driver.getCurrentUrl();

		}
		public  void closeBrowser() {
			driver.close();

		}
		public  void quitBrowser() {
			driver.quit();

		}
		public  void manageElement() {
			driver.manage();

		}
		public  void switchToElement() {
			driver.switchTo();

		}
		public  String windowHandel() {
			String handle = driver.getWindowHandle();
			return handle;

		}
		public  Set<String> windowHandles() {
			Set<String> handles = driver.getWindowHandles();
			return handles;

		}
		public  Navigation elementNavigate(String url) {
			Navigation navigation = driver.navigate();
			return navigation;

		}
		public  void openCurrentUrl() {
			 driver.getCurrentUrl();

			}


		//WebElement interface methods:

		public  void enterValue(WebElement e, String Data) {
			e.sendKeys(Data);


		}
		public  void elementClick(WebElement e) {
			e.click();
			}
		public  String elementGetText(WebElement e,String Data) {
			String text = e.getText();
			return text;


		}
		public  String elementGetAttribute(WebElement e,String Data) {
			String attribute = e.getAttribute(Data);
			return attribute;

		}
		public  boolean elementIsDisplayed(WebElement e) {
			boolean displayed = e.isDisplayed();
			return displayed;


		}
		public  boolean elementIsEnable(WebElement e) {
			boolean enabled = e.isEnabled();
			return enabled;


		}
		public  boolean elementIsSelected(WebElement e) {
			boolean selected = e.isSelected();
			return selected;
		}


		//Navigation interface methods:

		public  void pageForward() {
			driver.navigate().forward();

		}
		public  void pageBack() {
			driver.navigate().back();

		}
		public  void pageRefresh() {
			driver.navigate().refresh();

		}
		public  void pageTo(String url) {
			driver.navigate().to(url);

		}

		//Action class methods:

		public  void moveToElement() {
			Actions ac = new Actions(driver);
			ac.moveToElement(null).perform();

		}
		public  void contextClick() {
			Actions ac = new Actions(driver);
			ac.contextClick().perform();


		}
		public  void doubleClick() {
			Actions ac = new Actions(driver);
			ac.doubleClick().perform();

		}
		public  void dragAndDrop(WebElement source,WebElement target) {
			Actions ac = new Actions(driver);
			ac.dragAndDrop(source, target);

		}
		public  void perform() {
			Actions ac = new Actions(driver);
			ac.perform();

		}
		public  void keyUp(String data) {
			Actions ac = new Actions(driver);
			ac.keyUp(data).perform();

		}
		public  void keyDown(String data) {
			Actions ac = new Actions(driver);
			ac.keyDown(data).perform();

		}

		//Select class methods:

		public  void selectByIndex(WebElement e,int index) {
			Select s = new Select(e);
			s.selectByIndex(index);
			}

		public  void selectByValue(WebElement e,String Data) {
			Select s = new Select(e);
			s.selectByValue(Data);
			}

		public  void selectByVisibleText(WebElement e,String Data) {
			Select s = new Select(e);
			s.selectByVisibleText(Data);

		}
		public  void deselectAll(WebElement e) {
			Select s = new Select(e);
			s.deselectAll();

		}

		public  void deselectByIndex(WebElement e,int index) {
			Select s = new Select(e);
			s.deselectByIndex(index);

		}
		public  void deselectByValue(WebElement e,String Data) {
			Select s = new Select(e);
			s.deselectByValue(Data);

		}
		public  void deselectByVisibleText(WebElement e,String Data) {
			Select s = new Select(e);
			s.deselectByVisibleText(Data);

		}
		public  boolean elementIsMultiple(WebElement e) {
			Select s = new Select(e);
			boolean multiple = s.isMultiple();
			return multiple;
			}

		public  List<WebElement> getOptions(WebElement e) {
			Select s = new Select(e);
			List<WebElement> options = s.getOptions();
			return options;



		}
		public  List<WebElement> getAllSelectedOptions(WebElement e) {
			Select s = new Select(e);
			List<WebElement> list = s.getAllSelectedOptions();
			return list;


		}
		public  WebElement waitUntilElementClickable(WebElement element) {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(100));
			return wait.until(ExpectedConditions.elementToBeClickable(element));
          }
		public WebElement waitUntilElementVisible(By locator) {
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		    return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		}

		public  WebElement getFirstSelectedOption(WebElement e) {
			Select s = new Select(e);
			WebElement firstSelectedOption = s.getFirstSelectedOption();
			return firstSelectedOption;

		}
		//Alert Interface methods:

		public  Alert switchToAlert() {
			Alert al = driver.switchTo().alert();
			return al;
			}
		public  Alert acceptAlert() {
			Alert al = driver.switchTo().alert();
			al.accept();
			return al;

		}
		public  Alert denyAlert() {
			Alert al = driver.switchTo().alert();
			al.dismiss();
			return al;


		}
		public  Alert sendValueAlert(String Data) {
			Alert al = driver.switchTo().alert();
			al.sendKeys(Data);
			return al;

		}

		public  String alertGetText(String text) {
			Alert al = driver.switchTo().alert();
			String text1 = al.getText();
			return text1;


		}
		//Frames:

		public  WebDriver switchToFrameStringId(String text) {
			   WebDriver frame = driver.switchTo().frame(text);
			   return frame;
		}
		public  WebDriver switchToFrameInt(int index) {
			WebDriver frame = driver.switchTo().frame(0);
			return frame;
			}
		public  WebDriver switchToFrameWebElement(WebElement e) {
			WebDriver frame = driver.switchTo().frame(e);
			return frame;
	  }
		public  WebDriver switchToParentFrame() {
			WebDriver parentFrame = driver.switchTo().parentFrame();
			return parentFrame;
		}
		public  void screenShot() throws IOException {
			TakesScreenshot ts = (TakesScreenshot)driver;
			File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
			String ss = "Screenshots" +new Random().nextInt(1000);

			FileHandler.copy(screenshotAs, new File("C:\\Users\\Dell\\Desktop\\ss\\'"+ss+"'.png"));
			}
		public  void employeeOrganizationSelect(WebDriver driver,String...Value ) {
			List<WebElement> employeeOrganization = driver.findElements(By.xpath("//ul[@id='select2-emp_orgid-results']"));
			if(!Value[0].equalsIgnoreCase("all")) {
				for (WebElement list : employeeOrganization) {
					String text = list.getText();
					System.out.println(text);
					for (String val : Value) {
						if(text.equals(val)) {
							list.click();
							break;
						}
					}

				}
			}
		}
		}










