package com.vectorns.pageobjects;

import static org.openqa.selenium.By.*;

import org.apache.commons.collections.CollectionUtils;
import org.openqa.selenium.WebDriver;

public class SeleniumWikiPage {
	
	final private WebDriver drv;
	
	public SeleniumWikiPage(final WebDriver drv) {
		this.drv = drv;
	}
	
	public Boolean isOnSeleniumWikiPage() {
		return CollectionUtils.isNotEmpty(drv.findElements(cssSelector("span[itemprop = \"name\"]")));
	}

}
