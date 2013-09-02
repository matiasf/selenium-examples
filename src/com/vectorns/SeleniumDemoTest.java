package com.vectorns;

import static com.vectorns.utils.SeleniumUtils.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.vectorns.pageobjects.GoogleSearchPage;
import com.vectorns.pageobjects.SeleniumHomePage;
import com.vectorns.pageobjects.SeleniumProjectsPage;
import com.vectorns.pageobjects.SeleniumWikiPage;
import com.vectorns.pageobjects.WatirExamplesPage;

public class SeleniumDemoTest {
	
	@BeforeClass
	public static void configureDriverOnTest() {
		configureDriver();
	}
	
	// Go to the home page of Selenium and the if the label 'What is Selenium' is present.
	@Test
	public void testOpenHomePage() {
		final SeleniumHomePage homePage = new SeleniumHomePage(getDrv());
		assertTrue("Is the label \"What is Selenium\" present", homePage.open().isWhatIsSeleniumLabelPresent()); 
	}
	
	// Go to the project page and check if exist the four Selenium projects.
	@Test
	public void testCheckIfAllTheSeleniumProjectsExist() {
		final SeleniumHomePage homePage = new SeleniumHomePage(getDrv());
		final SeleniumProjectsPage projectPage = homePage.open().pressOnProjectsTab();
		assertTrue("Selenium IDE project still exists", projectPage.isSeleniumIDEOnProject());
		assertTrue("Selenium RC project still exists", projectPage.isSeleniumRCOnProject());
		assertTrue("Selenium WD project still exists", projectPage.isSeleniumWDOnProject());
		assertTrue("Selenium Grid project still exists", projectPage.isSeleniumGridOnProject());
	}
	
	// Enter a query on the search box and get the first result which must go to wiki page
	@Test
	public void testSearchBox() {
		final SeleniumHomePage homePage = new SeleniumHomePage(getDrv());
		final GoogleSearchPage googlePage = homePage.open().searchOnSeleniumPage("JavaScript");
		final SeleniumWikiPage wikiPage = googlePage.clickOnGoogleResult(0);
		assertTrue("Is on the selenium wiki page", wikiPage.isOnSeleniumWikiPage());
	}
	
	// Go to OpenQA page and check something with Watir, using a pop-up menu
	@Test
	public void testWatirAnotherOption() {
		final SeleniumHomePage homePage = new SeleniumHomePage(getDrv());
		final WatirExamplesPage examplePage = homePage.open().pressOnOpenQALogo().clickOnWatir().clickOnExamplePage();
		assertTrue("Is on example page", examplePage.isOnExamplePage());
	}
	
	// After each test, remove all the cookies generated
	@After
	public void cleanCookies() {
		getDrv().manage().deleteAllCookies();
	}
	
	@AfterClass
	public static void closeDriver() {
		getDrv().quit();
	}

}
