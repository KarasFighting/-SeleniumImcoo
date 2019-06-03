package com.tangge.newb.SeleniumImcoo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LoginBy {
	public WebDriver driver;
	public void InitDriver() {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedowlond\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.imooc.com/");
		driver.manage().window().maximize();
	}
	
	public void loginScript() throws Exception {
	    
		driver.findElement(By.id("js-signin-btn")).click();
		Thread.sleep(2000);
		WebElement user = driver.findElement(By.name("email"));
		user.isDisplayed();
		WebElement password = driver.findElement(By.name("password"));
		password.isDisplayed();
		Thread.sleep(2000);
			
		//loginButton.isDisplayed();
		user.sendKeys("15349873898");
		password.sendKeys("woaizly202266");		
		Thread.sleep(2000);
		WebElement loginButton = driver.findElement(By.className("moco-btn"));	
		loginButton.click();
		
		WebElement header = driver.findElement(By.id("header-avator"));
		header.isDisplayed();	
		
		/*selemium鼠标悬停
		 * Actions actions = new Actions(driver);
		   actions.moveToElement(webElement).clickAndHold().perform();
		   or
		   actions.clickAndHold(webElement).perform();
		*/
		
		Actions actions = new Actions(driver);
		actions.moveToElement(header).perform();	
		
		String userInfo = driver.findElement(By.className("name")).getText();
		if(userInfo.equals("秋水Karsa")) {
			System.out.println("登录成功");
			
		}else {
			System.out.println("登录失败");
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		LoginBy login = new LoginBy();
		login.InitDriver();
		login.loginScript();
	}

}
