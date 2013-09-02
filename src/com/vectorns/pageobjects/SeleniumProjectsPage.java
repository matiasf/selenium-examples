package com.vectorns.pageobjects;

import static org.openqa.selenium.By.linkText;

import org.apache.commons.collections.CollectionUtils;
import org.openqa.selenium.WebDriver;

public class SeleniumProjectsPage extends AbstractSeleniumHeaderAndFooter {

	final private WebDriver drv;
	
	@Override
	protected WebDriver getDriver() {
		return drv;
	}
	
	public SeleniumProjectsPage(final WebDriver drv) {
		this.drv = drv;
	}
	
	public SeleniumProjectsPage open() {
		drv.get("http://docs.seleniumhq.org/projects/");
		return this;
	}
	
	public Boolean isSeleniumIDEOnProject() {
		return CollectionUtils.isNotEmpty(drv.findElements(linkText("Selenium IDE")));
	}
	
	public Boolean isSeleniumRCOnProject() {
		return CollectionUtils.isNotEmpty(drv.findElements(linkText("Selenium Remote Control")));
	}
	
	public Boolean isSeleniumWDOnProject() {
		return CollectionUtils.isNotEmpty(drv.findElements(linkText("Selenium WebDriver")));
	}
	
	public Boolean isSeleniumGridOnProject() {
		return CollectionUtils.isNotEmpty(drv.findElements(linkText("Selenium Grid")));
	}	
	
}
