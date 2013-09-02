package com.vectorns.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenQAPage {
	
	final private WebDriver drv;
	
	@FindBy(css = "ul li a")
	protected List<WebElement> linksProjects;
	
	public OpenQAPage(final WebDriver drv) {
		this.drv = drv;
		PageFactory.initElements(drv, this);
	}
	
	public WatirHomePage clickOnWatir() {
		linksProjects.get(1).click();
		return new WatirHomePage(drv);
	}

}
