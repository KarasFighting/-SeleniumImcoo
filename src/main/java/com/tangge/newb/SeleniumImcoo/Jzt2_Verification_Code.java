package com.tangge.newb.SeleniumImcoo;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.Select;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;


public class Jzt2_Verification_Code{
    static WebDriver driver;
    static Select select;
    static WebElement webElement;
    
    public static void main(String[] args) throws Exception {
    	Jzt2_Verification_Code take = new Jzt2_Verification_Code();
    	
    	take.Driver();
    	
    	take.takeScreenshot(driver);
    	
    	int x = 0;
		int y = 0;
		int width = 0;
		int heigth = 0;
		take.createElementImage(driver, webElement, x, y, width, heigth);
		
		String path = null;
		take.getVerificationCode(path);
    	
	}
    
    public  void Driver() throws InterruptedException {
    	System.setProperty("webdriver.chrome.driver", "D:\\chromedowlond\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://118.190.115.95:8086/jzt2_web/login.jsp");
		Thread.sleep(2000);
		//driver.manage().window().maximize(); 
    }
    
    public void loginScript() {
    	// TODO Auto-generated method stub
    			select = new Select(driver.findElement(By.name("userType")));
    			select.selectByVisibleText("货主");
    			
                 //select = new Select(driver.findElement(By.name("userType")));
                 //select.selectByValue("1"); //下拉列表中，通过选项的value属性的值，选择选项
    			
    			//select = new Select(driver.findElement(By.name("userType")));
    			//select.selectByIndex(2); //下拉列表中，通过选项的位置，选择选项
    			
    			driver.findElement(By.name("username")).sendKeys("15349873898");
    			driver.findElement(By.name("password")).sendKeys("123456");
    			
    			
    	
    }
	
	
   // 1.将验证码页面截图保存
    public byte[] takeScreenshot(WebDriver driver) throws IOException {
    		byte[] screenshot = null;
    		screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);//得到截图
    		return screenshot;
    	}

    //2.得到的图片是整个屏幕的截图，我们可以处理一下，对图片进行截取，只保留验证码那一部分    	
    public BufferedImage createElementImage(WebDriver driver,WebElement webElement, int x, int y, int width, int heigth)//开始裁剪的位置和截图的宽和高
    		throws IOException {
    		Dimension size = webElement.getSize();
    		BufferedImage originalImage = ImageIO.read(new ByteArrayInputStream(takeScreenshot(driver)));
    		BufferedImage croppedImage = originalImage.getSubimage(x, y,size.getWidth() + width, size.getHeight() + heigth);//进行裁剪
    		return croppedImage;
    	}

   // 3.tesseract读取图片，获得验证码，默认是英文，如果要使用中文包，加上instance.setLanguage("chi_sim"); 
		private String getVerificationCode(String path) {
    		File imageFile = new File(path);
    		try {
    			imageFile.createNewFile();
    		} catch (IOException e1) {
    			e1.printStackTrace();
    		}
    		WebElement element = driver.findElement(By.xpath("//*[@id=\"kaptcha\"]"));
    		try {
    			BufferedImage image = createElementImage(driver, element, 687, 362,
    					54, 18);//得到裁剪的图片
    			ImageIO.write(image, "png", imageFile);//进行保存
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    		ITesseract instance = new Tesseract();//调用Tesseract
    		URL url = ClassLoader.getSystemResource("tessdata");//获得Tesseract的文字库
    		String tesspath = url.getPath().substring(1);
    		instance.setDatapath(tesspath);//进行读取，默认是英文，如果要使用中文包，加上instance.setLanguage("chi_sim"); 
    		String result = null;
    		try {
    			result = instance.doOCR(imageFile);
    		} catch (TesseractException e1) {
    			e1.printStackTrace();
    		}
    		result = result.replaceAll("[^a-z^A-Z^0-9]", "");//替换大小写及数字
    		return result;
    	}

    

}












