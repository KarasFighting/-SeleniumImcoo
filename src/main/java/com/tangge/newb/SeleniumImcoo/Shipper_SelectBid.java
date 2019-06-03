package com.tangge.newb.SeleniumImcoo;

import org.openqa.selenium.By;


/**
 *货主选标
 */
public class Shipper_SelectBid {
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub	
		Jzt2_Shipper js = new Jzt2_Shipper();
		js.Login();
		
		Shipper_SelectBid ssb = new Shipper_SelectBid();
		ssb.Select_Bid(js);
			
	}
	
	
	
	@SuppressWarnings("static-access")//告诉编译器忽略指定的警告，不用在编译完成后出现警告信息。
	public void Select_Bid(Jzt2_Shipper js) {
		//运单管理
		js.driver.findElement(By.className("nav-label")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//运单处理 
		js.driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[1]/ul/li[2]/a")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		js.driver.switchTo().frame("iframe");
		
		js.driver.findElement(By.name("search_like_projectName")).sendKeys("测试物品脚本444");//根据项目名称搜索
		js.driver.findElement(By.id("search")).click();//搜索
		
		js.driver.findElement(By.xpath("/html/body/div[4]/div/div[3]/div[3]/div/table/tbody/tr[2]/td[4]/a[2]")).click();
		js.driver.switchTo().frame("layui-layer-iframe1");
		
		js.driver.findElement(By.className("op-choose")).click();//选中
		js.driver.findElement(By.className("layui-layer-btn0")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		js.driver.switchTo().frame("J_Form");
		js.driver.findElement(By.id("btnOK")).click();
	}

}
