package com.vectorns.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

abstract public class AbstractSeleniumHeaderAndFooter {
	
	@FindBy(id = "q")
	protected WebElement queryField;
	
	@FindBy(id = "submit")
	protected WebElement goButton;
	
	@FindBy(id = "footerLogo")
	protected WebElement footerLogo;
	
	@FindBy(css = "#menu_projects a")
	protected WebElement projectTab;
	
	protected abstract WebDriver getDriver();

	public GoogleSearchPage searchOnSeleniumPage(final String textToSearch){
		final WebDriver drv = getDriver();
		queryField.sendKeys(textToSearch);
		goButton.click();
		return new GoogleSearchPage(drv);
	}
	
	public OpenQAPage pressOnOpenQALogo() {
		footerLogo.click();;
		return new OpenQAPage(getDriver());
	}
	
	public SeleniumProjectsPage pressOnProjectsTab() {
		projectTab.click();
		return new SeleniumProjectsPage(getDriver());
	}

}
