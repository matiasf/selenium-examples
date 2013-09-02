package com.vectorns.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WatirExamplesPage {
	
	@FindBy(className = "entry-title")
	protected WebElement title;
	
	public WatirExamplesPage(final WebDriver drv) {
		PageFactory.initElements(drv, this);
	}
	
	public boolean isOnExamplePage() {
		return title.getText().equals("Examples");
	}

}