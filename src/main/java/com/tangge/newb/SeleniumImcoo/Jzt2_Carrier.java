package com.tangge.newb.SeleniumImcoo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/**
 *承运商报价 
 */
public class Jzt2_Carrier {
	static WebDriver driver;
	static Select select;
	static  WebElement element;
	static Actions action;
	
	public void ShareFunction(){
		System.setProperty("webdriver.chrome.driver", "D:\\chromedowlond\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://118.190.115.95:8086/jzt2_web/login.jsp");		
		driver.manage().window().maximize();
	}
	
	//投标中心
	public void BdCenter(){
		select = new Select(driver.findElement(By.name("userType")));
		select.selectByVisibleText("承运商");
		
		driver.findElement(By.name("username")).sendKeys("15349873898");
		driver.findElement(By.name("password")).sendKeys("123456");
		
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.className("btn")).click();//登录
		driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[2]/div[1]/div/ul[1]/li/a")).click();//投标中心
		driver.switchTo().frame("iframe");
		driver.findElement(By.name("search_like_totalOrder.projectName")).sendKeys("测试物品脚本444");//项目名称
		driver.findElement(By.id("search")).click();//搜索
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div[3]/div/table/tbody/tr[2]/td[7]/a")).click();
		driver.switchTo().frame("layui-layer-iframe1"); //layui-layer-iframe1
		driver.findElement(By.id("bid")).click();//详情页面报价按钮  
		//driver.switchTo().parentFrame();
		driver.switchTo().frame("layui-layer-iframe1");
		
		//税率百分比
		driver.findElement(By.id("taxRate")).sendKeys("2");
		
		//车长
		select = new Select(driver.findElement(By.name("carLength")));
		select.selectByVisibleText("12.5米");
		
		//车型
		select = new Select(driver.findElement(By.name("carType")));
		select.selectByVisibleText("高低板");
		
		driver.findElement(By.name("carMoney")).sendKeys("6300");
		
		driver.findElement(By.xpath("//*[@id=\"save\"]")).click();
		
		driver.switchTo().parentFrame();
		 
		 
		driver.findElement(By.className("layui-layer-ico")).click();
		
	}
	
    public static void main( String[] args ) {
    	Jzt2_Carrier bd = new Jzt2_Carrier();
    	bd.ShareFunction();
    	bd.BdCenter();
    	
    	
    	
    	
    }
}
