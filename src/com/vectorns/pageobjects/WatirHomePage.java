package com.vectorns.pageobjects;

import static org.openqa.selenium.By.*;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WatirHomePage {
	
	final private WebDriver drv;
	
	@FindBy(css = "#menu-main-menu li")
	protected List<WebElement> titles;
	
	public WatirHomePage(final WebDriver drv) {
		this.drv = drv;
		PageFactory.initElements(drv, this);
	}
	
	public WatirExamplesPage clickOnExamplePage() {
		new Actions(drv).moveToElement(titles.get(2)).
			moveToElement(drv.findElement(cssSelector("#menu-item-530 a"))).click().build().perform();
		return new WatirExamplesPage(drv);
	}

}
