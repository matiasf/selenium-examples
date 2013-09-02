package com.vectorns.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public final class SeleniumUtils {
	
	private static WebDriver drv;
	
	private SeleniumUtils(){};
	
	public static WebDriver getDrv() {
		return drv;
	}
	
	public static void configureDriver() {
		final DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		drv = new FirefoxDriver(capabilities);
	}

}
