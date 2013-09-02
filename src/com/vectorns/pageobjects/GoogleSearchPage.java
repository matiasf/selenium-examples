package com.vectorns.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage {

	final private WebDriver drv;
	
	@FindBy(css = ".gs-title.gsc-table-cell-thumbnail.gsc-thumbnail-left .gs-title")
	protected List<WebElement> googleLinks;
	
	public GoogleSearchPage(final WebDriver drv) {
		this.drv = drv;
		PageFactory.initElements(drv, this);
	}
	
	public SeleniumWikiPage clickOnGoogleResult(final int position) {
		googleLinks.get(0).click();
		return new SeleniumWikiPage(drv);
	}
	
}
