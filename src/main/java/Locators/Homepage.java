package Locators;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sample.Baseclass;

public class Homepage extends Baseclass{


	public Homepage(WebDriver ydriver) {
		this.driver= ydriver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "(//span[@class='a-size-medium a-color-base a-text-normal'])[3]")
	private WebElement mobilesearch;
	public WebElement getMobilesearch() {
		return mobilesearch;
	}
	@FindBy(id = "add-to-cart-button")
	private WebElement addtocart;
	public WebElement getAddtocart() {
		return addtocart;
	}
	@FindBy(id = "attach-sidesheet-view-cart-button")
	private WebElement cart;
	public WebElement getCart() {
		return cart;
	}	

	@FindBy(xpath = "//span[@class='a-button-text a-declarative']")	
	private WebElement quantity;
	public WebElement getQuantity() {
		return quantity;
	}

	@FindBy(xpath = "//li[contains(@class,'quantity-option')]/child::a")
	private List<WebElement> qtyDropdown;
	public List<WebElement> getQtyDropdown() {
		return qtyDropdown;
	}
	@FindBy(id = "quantity")
	private WebElement qtyoption;

	public WebElement getQtyoption() {
		return qtyoption;
	}

	/*
	 * @FindBy(xpath = "//*[text()='79,900.00']") private WebElement pricetagname;
	 * public WebElement getPricetagname() { return pricetagname; }
	 */
	@FindBy(xpath = "//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold']")
	private WebElement price;
	public WebElement getPrice() {
		return price;
	}






}
