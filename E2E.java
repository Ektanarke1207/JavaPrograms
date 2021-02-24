import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class E2E {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("http://demo.automationtesting.in/Register.html");

		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[1]/div[1]/input")).sendKeys("Ekta");
		driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[1]/div[2]/input")).sendKeys("Narke");
		driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[2]/div/textarea"))
				.sendKeys("Suncity road Vishwas garden Anandnagar Pune:411051");
		driver.findElement(By.cssSelector("input.ng-valid-email")).sendKeys("Ektanarke4195@gmail.com");
		driver.findElement(By.cssSelector("input.ng-valid-pattern")).sendKeys("8888412793");

//********************************radio button*********************************//
		int a = driver.findElements(By.xpath("//input[@name='radiooptions']")).size();

		for (int i = 1; i <= a; i++) {
			driver.findElements(By.xpath("//input[@name='radiooptions']")).get(1).click();
		}

//**********************CheckBox*****************************//
		driver.findElement(By.id("checkbox2")).click();

//********************multiple select dynamic dropdown**********************//

		driver.findElement(By.id("msdd")).click();
		List<WebElement> LangPicker = driver.findElements(By.className("ui-corner-all"));
		int count = driver.findElements(By.className("ui-corner-all")).size();

		for (int i = 0; i < count; i++) {
			String text = driver.findElements(By.className("ui-corner-all")).get(i).getText();
			if (text.equalsIgnoreCase("English")) {
				driver.findElements(By.className("ui-corner-all")).get(i).click();

			}

			if (text.equalsIgnoreCase("French")) {
				driver.findElements(By.className("ui-corner-all")).get(i).click();
				break;
			}
		}
//**************************ScrollDown***************************************//
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");

//**********************For Side tab/click*************************************//
		driver.findElement(By.cssSelector("div.form-group:nth-child(8) > label:nth-child(1)")).click();

//*******************Select one option from dropdown*******************************//
		WebElement mySelectElm = driver.findElement(By.id("Skills"));
		Select mySelect = new Select(mySelectElm);
		mySelect.selectByVisibleText("CSS");

		Thread.sleep(2000L);

//**************************Select one option from dropdown***************************//
		//************* with different way********************//
		driver.findElement(By.id("countries")).click();
		driver.findElement(By.cssSelector("#countries > option:nth-child(106)")).click();

//******************************For Side tab/click***************************************//
		driver.findElement(By.cssSelector("div.form-group:nth-child(9) > label:nth-child(1)")).click();

//********************************AutoSuggest dropdown***************************************//
		driver.findElement(By.cssSelector(".select2-selection")).click();
		driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys("ind");
		driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys(Keys.ENTER);

//***************Calendar YEAR/MONTH/DAY *****************************************//
		
		WebElement year = driver.findElement(By.id("yearbox"));
		Select se1 = new Select(year);
		se1.selectByVisibleText("1995");
		
		WebElement month = driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[11]/div[2]/select"));
		Select se2 = new Select(month);
		se2.selectByVisibleText("January");
		
		WebElement day = driver.findElement(By.xpath("//*[@id=\"daybox\"]"));
		Select se3 = new Select(day);
		se3.selectByVisibleText("4");
		
//************Password********************************///
		driver.findElement(By.xpath("//*[@id=\"firstpassword\"]")).sendKeys("EKta_1234");
		driver.findElement(By.id("secondpassword")).sendKeys("EKta_1234");
	
//******************Scroll Up**************************************//		
		js.executeScript("window.scrollBy(0,-500)");
		
//*******************Upload File**************************************//
		WebElement upload = driver.findElement(By.xpath("//input[@type='file']"));
		upload.sendKeys("D://SDLC//SDLC Images/Adapting the Latest Market Trends img 2.jpg");;

//**************************ScrollDown***************************************//
				js.executeScript("window.scrollBy(0,500)");	
				
//***********************Click Submit Button**********************//
		driver.findElement(By.id("submitbtn")).click();
		
	}

}
