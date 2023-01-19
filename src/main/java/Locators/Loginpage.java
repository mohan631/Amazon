package Locators;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sample.Baseclass;

public class Loginpage extends Baseclass {
	//WebDriver driver;

	public Loginpage(WebDriver xdriver) {
		this.driver=xdriver;
		PageFactory.initElements(driver, this);

	}


	@FindBy(id = "twotabsearchtextbox")
	private WebElement Amzonsearchbox;

	public WebElement getAmzonsearchbox() {
		return Amzonsearchbox;
	}

	@FindBy(id = "nav-search-submit-button")
	private WebElement searchbutton;

	public WebElement getSearchbutton() {
		return searchbutton;
	}		


	@FindBy(xpath = "//img[@class='s-image']")
	private WebElement find_image;

	public WebElement getFind_image() {
		return find_image;
	}
@FindBy(xpath = "//span[text()='RESULTS']//following::span[contains(@class,'a-size-medium')]")
public List<WebElement> Result_product;

}
