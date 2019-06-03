package com.tangge.newb.SeleniumImcoo;

import java.util.Date;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

/**
 *
  承运商发布子运单
 * */
public class Carrier_ChildrenBid {
	
	public static void main(String[] args) throws Exception{
		currency cy = new currency();
		cy.Carrier_Login();
		
		Carrier_ChildrenBid cb = new Carrier_ChildrenBid();
		cb.ReleaseBid(cy);
	}
	
	
	public void ReleaseBid(currency cy) throws Exception {
		cy.getDriver().findElement(By.className("nav-label")).click();
		Thread.sleep(2000);
		cy.getDriver().findElement(By.linkText("运单处理")).click();
		cy.getDriver().switchTo().frame("iframe");
		cy.getDriver().findElement(By.xpath("/html/body/div[2]/ul/li[2]/a")).click();
		cy.getDriver().findElement(By.className("form-control")).sendKeys("测试物品脚本444");
		cy.getDriver().findElement(By.id("search")).click();
		Thread.sleep(2000);
		cy.getDriver().findElement(By.linkText("发布子运单")).click();
		cy.getDriver().switchTo().frame("layui-layer-iframe1");
		
		Select sel = new Select(cy.getDriver().findElement(By.name("carLength")));
		Thread.sleep(2000);
		sel.selectByIndex(9);
		
		Select sct = new Select(cy.getDriver().findElement(By.name("carType")));
		Thread.sleep(2000);
		sct.selectByVisibleText("高低板");
		Thread.sleep(2000);
		
		cy.getDriver().findElement(By.name("expectedLoadMoney")).sendKeys("6300");
		Thread.sleep(2000);
		cy.getDriver().findElement(By.name("customizeOrderNo")).sendKeys(DateFormatUtils.format(new Date(), "yyyyMMddHHmmss"));
		
		Select sec = new Select(cy.getDriver().findElement(By.name("issueType")));
		Thread.sleep(2000);
		sec.selectByVisibleText("网上招标");
		
		 String js = "document.getElementsByName('bidValidTime')[0].removeAttribute('readonly')";
		 ((JavascriptExecutor)cy.getDriver()).executeScript(js);
		 cy.getDriver().findElement(By.name("bidValidTime")).sendKeys("2019-12-31 16:16:16");
		
		 cy.getDriver().findElement(By.name("remarks")).sendKeys("这是测试脚本的备注模板，谢谢！！！");
		 Thread.sleep(2000);
		 cy.getDriver().findElement(By.cssSelector("#save")).click();
		
		 cy.getDriver().findElement(By.id("layui-layer1")).click();
		 
		 //cy.getDriver().navigate().refresh();
		 
		 cy.getAction().sendKeys(Keys.F5);
		 
		
	}
	
	

}
