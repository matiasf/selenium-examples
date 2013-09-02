package com.vectorns.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumHomePage extends AbstractSeleniumHeaderAndFooter {
	
	final private WebDriver drv;
	
	@FindBy(css = "#mainContent h2")
	protected WebElement whatIsTitle;
	
	@Override
	protected WebDriver getDriver() {
		return drv;
	}
	
	public SeleniumHomePage(final WebDriver drv) {
		this.drv = drv;
	}
	
	public SeleniumHomePage open() {
		drv.get("http://docs.seleniumhq.org/");
		PageFactory.initElements(drv, this);
		return this;
	}
	
	public Boolean isWhatIsSeleniumLabelPresent() {
		return whatIsTitle.getText().equals("What is Selenium?");
	}

}
