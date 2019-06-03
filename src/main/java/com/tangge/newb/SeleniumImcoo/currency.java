package com.tangge.newb.SeleniumImcoo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class currency {
	private WebDriver driver;
	private Select select;
	private  WebElement element;
	private Actions action;	
	private String url = "http://118.190.115.95:8086/jzt2_web/login.jsp";
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public WebDriver getDriver() {
		return driver;
	}
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	public Select getSelect() {
		return select;
	}
	public void setSelect(Select select) {
		this.select = select;
	}
	public WebElement getElement() {
		return element;
	}
	public void setElement(WebElement element) {
		this.element = element;
	}
	public Actions getAction() {
		return action;
	}
	public void setAction(Actions action) {
		this.action = action;
	}
	
	public void Shipper_Login() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedowlond\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://118.190.115.95:8086/jzt2_web/login.jsp");
		Thread.sleep(3000);
		driver.manage().window().maximize();
		
		select = new Select(driver.findElement(By.name("userType")));
		select.selectByVisibleText("货主");
		
		driver.findElement(By.name("username")).sendKeys("15349873898");
		driver.findElement(By.name("password")).sendKeys("123456");
		
		Thread.sleep(7000);//预留等待时间输入验证码
		
		driver.findElement(By.className("btn")).click();//登录
		
	}
	
	public void Carrier_Login() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedowlond\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://118.190.115.95:8086/jzt2_web/login.jsp");
		Thread.sleep(3000);
		driver.manage().window().maximize();
		
		select = new Select(driver.findElement(By.name("userType")));
		select.selectByVisibleText("承运商");
		
		driver.findElement(By.name("username")).sendKeys("15349873898");
		driver.findElement(By.name("password")).sendKeys("123456");
		
		Thread.sleep(7000);//预留等待时间输入验证码
		
		driver.findElement(By.className("btn")).click();//登录
		
	}
	
	/**
	 *登录脚本重构element封装
	 * @param args
	 * @return
	 * @return 
	 * @throws Exception
	 */
	public WebElement element(By by) {
		WebElement ele = driver.findElement(by);
		return ele;
	}
	
}
