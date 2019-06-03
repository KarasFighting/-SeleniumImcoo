package com.tangge.newb.SeleniumImcoo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

public class Shipper_Click_Event {
	
	public static void main(String[] args) throws Exception {
		
		currency cy = new currency();
		cy.Shipper_Login();
		
		Shipper_Click_Event sce = new Shipper_Click_Event();	
		sce.Click_Event(cy);
	}
	
	/**
	 * 随机事件的点击
	 * @throws Exception
	 * */
	public void Click_Event(currency cy) throws Exception{
		
		cy.getDriver().findElement(By.xpath("//*[@id=\"side-menu\"]/li[2]/a/span[1]")).click();//开票管理
		Thread.sleep(2000);
		cy.getDriver().findElement(By.xpath("//*[@id=\"side-menu\"]/li[2]/ul/li[1]/a")).click();//应付账单
		cy.getDriver().switchTo().frame("iframe");
		
		cy.getDriver().findElement(By.className("form-control")).sendKeys("9F55500000001421");
		
		Thread.sleep(2000);
		//选择一下日期
	    String js = "document.getElementsByName('search_gtedate_record.createDate').removeAttribute('readonly')";
	    ((JavascriptExecutor)cy.getDriver()).executeScript(js);
	    cy.getDriver().findElement(By.id("bidValidTime")).sendKeys("2018-12-01");
		cy.getDriver().findElement(By.id("search")).click();//搜索
		Thread.sleep(2000);
		cy.getDriver().findElement(By.linkText("9F55500000001421")).click();//运单详情
		
		cy.getDriver().switchTo().frame("layui-layer-iframe1");
		//下拉滚动条到底部
		String str = "document.body.scrollTop=500";
		((JavascriptExecutor)cy.getDriver()).executeScript(str);
		
		cy.getDriver().findElement(By.xpath("/html/body/div[2]/div/div[3]/div[2]/table/tbody/tr[3]/td[2]/div[1]/ul/li[1]/img")).click();
		cy.getDriver().switchTo().defaultContent();
		Thread.sleep(2000);
		//cy.getDriver().findElement(By.xpath("//*[@id=\"layui-layer1\"]/span[1]")).click();//关闭运单详情.
		
		cy.getDriver().findElement(By.xpath("/html/body/div[3]/div[4]")).click();
		
		cy.getDriver().findElement(By.className("layui-layer-setwin")).click();
		cy.getAction().sendKeys(Keys.F5);
		
		cy.getDriver().findElement(By.xpath("//*[@id=\"side-menu\"]/li[2]/ul/li[2]/a")).click();//开票列表
		
		cy.getDriver().findElement(By.name("search_like_orderNo")).sendKeys("9F55500000001179");
		cy.getDriver().findElement(By.id("search")).click();//搜索
		
		
        cy.getDriver().findElement(By.xpath("/html/body/div[3]/div/div[3]/div[3]/div/table/tbody/tr[2]/td[4]/a")).click();
		
        
	}
	

}
