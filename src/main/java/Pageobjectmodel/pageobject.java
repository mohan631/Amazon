package Pageobjectmodel;

import org.openqa.selenium.WebDriver;

import Locators.Homepage;
import Locators.Loginpage;
import sample.Baseclass;

public class pageobject extends Baseclass {
	public pageobject(WebDriver xdriver) {
		this.driver=xdriver;
	}
	private Loginpage Loginpage;
	public Loginpage getLoginpage() {
		if (Loginpage==null) {
			Loginpage=new Loginpage(driver);
		}
		return Loginpage;
	}

	private Homepage Homepage;
	public Homepage getHomepage() {
		if (Homepage==null) {
			Homepage=new Homepage(driver);
		}
		return Homepage;
	}













}
