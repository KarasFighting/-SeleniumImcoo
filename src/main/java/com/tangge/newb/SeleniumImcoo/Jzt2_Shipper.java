package com.tangge.newb.SeleniumImcoo;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Date;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class Jzt2_Shipper {	
	static WebDriver driver;
	static Select select;
	static  WebElement element;
	static Actions action;
	
	/**
	 *货主发布运单
	 */
	public void Login() throws Exception {
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
	 
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Jzt2_Shipper jspe =new Jzt2_Shipper();
		jspe.Login();
				
		
		//运单管理
		driver.findElement(By.className("nav-label")).click();
		Thread.sleep(2000);
		
		//发布货源
		driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[1]/ul/li[1]/a")).click();
		Thread.sleep(1000);
		
        driver.switchTo().frame("iframe");//iframe切换
		
		/*
		 * 基本信息
		 * 
		 */
        //项目名称
        driver.findElement(By.xpath("//*[@id=\"J_Form\"]/div[1]/div[1]/div[2]/table/tbody/tr[1]/td[2]/input")).sendKeys("测试物品脚本444");
		Thread.sleep(1000);
				
		//货主单号
		driver.findElement(By.xpath("//*[@id=\"J_Form\"]/div[1]/div[1]/div[2]/table/tbody/tr[1]/td[4]/input")).sendKeys(DateFormatUtils.format(new Date(), "yyyyMMddHHmmss"));
		
		
		//运输模式
	    select = new Select(driver.findElement(By.name("transportMode")));
	    select.selectByVisibleText("整车");
	    
	    
	    //预期运费
	    driver.findElement(By.name("expectedLoadMoney")).sendKeys("6300");
	    
	    
	    //发布类型
	    select = new Select(driver.findElement(By.name("issueType")));
	    select.selectByVisibleText("网上招标");
	    
       
         //投标截止日期【移除readonly的属性】
	    String js = "document.getElementById('bidValidTime').removeAttribute('readonly')";
	    ((JavascriptExecutor)driver).executeScript(js);//将driver强制转换为JavascriptExecutor类型
	    driver.findElement(By.id("bidValidTime")).sendKeys("2018-12-29 15:32:00");
	    
	    
	    /*
		 * 发货人信息
		 * 
		 */
	    driver.findElement(By.xpath("//*[@id=\"chooseSenderAddress\"]/a/i")).click();//发货单位输入框的logo标签
	    driver.switchTo().frame("layui-layer-iframe1");//iframe切换
	    driver.findElement(By.xpath("//*[@id=\"b8e5fffa-f79c-11e8-bb03-00163e04a258\"]")).click();//选择发货单位信息
	    driver.findElement(By.id("btnOK")).click();
	    
	    driver.switchTo().parentFrame();
	    
	    //发货日期
	    String str = "document.getElementById('sendDate').removeAttribute('readonly')";
	    ((JavascriptExecutor)driver).executeScript(str);//将driver强制转换为JavascriptExecutor类型
	    driver.findElement(By.xpath("//*[@id=\"sendDate\"]")).sendKeys("2018-12-31");
	    
	    //发货时间
	    select = new Select(driver.findElement(By.id("sendTimeHour")));
		select.selectByVisibleText("08:00-10:00");
		
		/*
		 * 货物信息
		 * 
		 */
		//货物名称
		driver.findElement(By.name("loadName")).sendKeys("斜对面公司有个妹子不错");
		driver.findElement(By.name("singleSize")).sendKeys("20*10*5");
		
		select = new Select(driver.findElement(By.name("packageType")));
		select.selectByVisibleText("木箱");//包装形式
		
		//总吨量
		driver.findElement(By.name("loadWeight")).sendKeys("50");
		
		//总体积
		driver.findElement(By.name("loadVolume")).sendKeys("200");
		
		//件数
		driver.findElement(By.name("loadCount")).sendKeys("2000");
		
		//货物清单
		StringSelection sel = new StringSelection("C:\\Users\\Administrator\\Desktop\\CIVIC.jpg");//指定图片的路径
		
		driver.findElement(By.xpath("//*[@id=\"selectAttachment\"]")).click();//【点击上传附件】
		
		//把图片文件路径复制到剪贴板
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel,null);
		
		// 新建一个Robot类的对象
		 Robot robot = new Robot();
		 Thread.sleep(1000);
		         
		 // 按下回车
		 robot.keyPress(KeyEvent.VK_ENTER);
		    
		 // 释放回车
		 robot.keyRelease(KeyEvent.VK_ENTER);
		    
		 // 按下 CTRL+V
		 robot.keyPress(KeyEvent.VK_CONTROL);
		 robot.keyPress(KeyEvent.VK_V);
		    
		 // 释放 CTRL+V
		 robot.keyRelease(KeyEvent.VK_CONTROL);
		 robot.keyRelease(KeyEvent.VK_V);
		 Thread.sleep(1000);
		 
		 // 点击回车 Enter
		 robot.keyPress(KeyEvent.VK_ENTER);
		 robot.keyRelease(KeyEvent.VK_ENTER);
		 
		 //上传货物照片
		 driver.findElement(By.xpath("//*[@id=\"selectImage\"]")).click();
		 Thread.sleep(3000);
		//Java 的Runtime 模块的getruntime.exec()方法可以调用exe 程序并执行
		 Runtime exe = Runtime.getRuntime();
		 String strup = "F:\\Image\\upFile.exe";
		 exe.exec(strup);
		 Thread.sleep(2000);
		 
		 /*
			 * 收货人信息
			 * 
			 */
		//发货单位
		 driver.findElement(By.xpath("//*[@id=\"receiverOrderAddress\"]/tbody/tr[1]/td[2]/div/input")).sendKeys("安徽稳石网络科技有限公司");
		 
		//联系人
		 driver.findElement(By.xpath("//*[@id=\"receiverOrderAddress\"]/tbody/tr[1]/td[4]/input")).sendKeys("汤老板");
		 
		//联系电话
		 driver.findElement(By.xpath("//*[@id=\"receiverOrderAddress\"]/tbody/tr[1]/td[6]/input")).sendKeys("15349873898");
		 
		//收货地
		 driver.findElement(By.xpath("//*[@id=\"receiverOrderAddress\"]/tbody/tr[2]/td[2]/div/span")).click();
		 
		 //driver.switchTo().parentFrame();
		 
		 action = new Actions(driver);		 
		 WebElement province = driver.findElement(By.xpath("//*[@id=\"receiverOrderAddress\"]/tbody/tr[2]/td[2]/div/div/div/div[2]/div[1]/dl[1]/dd/a[1]"));
		 action.click(province).perform();
		 
		 action = new Actions(driver);		 
		 WebElement city = driver.findElement(By.xpath("//*[@id=\"receiverOrderAddress\"]/tbody/tr[2]/td[2]/div/div/div/div[2]/div[2]/dl/dd/a[13]"));
		 action.click(city).perform();
		 
		 action = new Actions(driver);		 
		 WebElement district = driver.findElement(By.xpath("//*[@id=\"receiverOrderAddress\"]/tbody/tr[2]/td[2]/div/div/div/div[2]/div[3]/dl/dd/a[1]"));
		 action.click(district).perform();
		 
		//详细地址
		 driver.findElement(By.name("receiveDetailAddress")).sendKeys("东城花园1206");
		 
		//收货日期
		 String verTime = "document.getElementsByName('receiverTime')[0].removeAttribute('readonly')";//重点：name不唯一，需要加索引标注
		 ((JavascriptExecutor)driver).executeScript(verTime);//将driver强制转换为JavascriptExecutor类型
		 driver.findElement(By.xpath("//*[@id=\"receiverOrderAddress\"]/tbody/tr[3]/td[2]/div/input")).sendKeys("2019-12-31");
		 
		 /*
			 * 车辆信息
			 * 
			 */
		 select = new Select(driver.findElement(By.name("carLength")));
		 select.selectByVisibleText("12.5米");//车长		 
		 select = new Select(driver.findElement(By.name("carType")));
		 select.selectByVisibleText("高低板");//车型
		 
		 /*
			 * 服务信息
			 * 
			 */
		 select = new Select(driver.findElement(By.name("signatureRequirements")));
		 select.selectByVisibleText("签字");//签收单要求
		 
		 //是否需要发票
		 driver.findElement(By.xpath("//*[@id=\"J_Form\"]/div[1]/div[6]/div[2]/table/tbody/tr[2]/td[2]/label[1]/input")).click();//是
		 
		 //发票类型
		 select = new Select(driver.findElement(By.name("invoiceType")));
		 select.selectByVisibleText("专用发票");
		 
		 //发票抬头公司
		 driver.findElement(By.name("invoiceCompanyTitle")).sendKeys("锤子科技");
		 
		 //税号
		 driver.findElement(By.name("invoiceCompanyTaxNo")).sendKeys(DateFormatUtils.format(new Date(), "yyyyMMddHHmm"));
		 
		 //地址
		 driver.findElement(By.name("invoiceAddress")).sendKeys("北京市东城区大爷摆摊卖烧烤");
		 
		 //电话
		 driver.findElement(By.name("invoicePhone")).sendKeys("13771716039");
		 
		 //开户银行
		 driver.findElement(By.name("invoiceBank")).sendKeys("齐鲁银行");
		 
		 //银行账户
		 driver.findElement(By.name("invoiceBankNo")).sendKeys("6223795315003442558");
		 
		 //是否投保
		 driver.findElement(By.xpath("//*[@id=\"J_Form\"]/div[1]/div[6]/div[2]/table/tbody/tr[5]/td[2]/label[1]/input")).click();
		 
		 //投保金额
		 driver.findElement(By.name("insuranceMoney")).sendKeys("666");
		 
		 //备注
		 driver.findElement(By.name("remarks")).sendKeys("自动化测试备注信息");
		 
		 //发布
		 driver.findElement(By.id("release")).click();
		 
		 driver.navigate().refresh();//刷新页面
		 
		 //action.sendKeys(Keys.F5);
		 
	}
	
	
	
	
	
	

}
