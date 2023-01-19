package TestRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import Locators.Loginpage;
import Pageobjectmodel.pageobject;
import sample.Baseclass;

public class Runner extends Baseclass {

	private static final String ANSI_RESET = "";
	private static final String ANSI_GREEN = "";
	private static String write;

	public static void main(String[] args  ) throws IOException, InterruptedException {


		Browserlaunch();
		windows_maxmize();
		get_URL("https://www.amazon.in/");

		elementsendkeys(driver.findElement(By.id("twotabsearchtextbox")),"iphone");
		pageobject obj=new pageobject(driver);
		elementclick(obj.getLoginpage().getSearchbutton());
		mobilesearch(obj.getHomepage().getMobilesearch());
		switchToWindow();
		addcart(obj.getHomepage().getAddtocart());
		addcart(obj.getHomepage().getCart());
		quantity(obj.getHomepage().getQuantity());
		//	selectQty(obj.getHomepage().getQtyDropdown(),"2");

	
		int m =2;
		dropdown1(obj.getHomepage().getQtyoption(), "index",String.valueOf(m));
		Thread.sleep(20000);

		WebElement price = driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold']"));
		String text = price.getText().replaceAll("[^0-9]", "").replace(" ", "");
		int Exp_price = Integer.parseInt(text)*m;
		//System.err.println("expected price"+Exp_price);

		WebElement price1 = driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap'])[2]"));
		String text1 = price1.getText().replaceAll("[^0-9]", "").replace(" ", "");
		int Act_price = Integer.parseInt(text1);
		// System.err.println("actual price"+Act_price);

		
		

		
		 final String ANSI_RED = "\u001B[31m";
	        final String ANSI_BLUE = "\u001B[34m";
	        final String ANSI_WHITE = "\u001B[37m";
	       
	          
	            System.out.println(ANSI_BLUE + "Expected price"+ Exp_price);
	           
	            System.out.println(ANSI_RED+"Act_price"+Act_price);
	          
		
		
		
		
		
		
		

		if (Exp_price==Act_price) {
			System.out.println("Pass");

		}else {
			System.out.println("Fail");
		}
		
		
	        
	                              
	             
		//String actualText = getPriceText(obj.getHomepage().getPrice());
		//System.out.println(actualText);
		//verifyTextValue(actualText,"59,900.00");
		//System.out.println("end the program");


		//   pricetext(obj.getHomepage().getPricetagname());




		//driver.findElement(By.)





	}




	/*
	 * String price ="$69,900.00"; String replaceall=price.replaceAll("(^0-9)", "");
	 * int de=Integer.parseInt(replaceall); System.out.println(de);
	 */
}


//price(obj.gettext("(//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap'])[2]")));
//Select select = new Select(driver.findElement(By.xpath("//span[@class='a-button-text a-declarative']")));

// select.selectByIndex(1);








//Takescreenshot("homepage");
//elementsendkeys(driver.findElement(By.id("twotabsearchtextbox")), null);
// elementsendkeys(driver.findElement(By.id("twotabsearchtextbox")),"iphone");
//elementclick(driver.findElement(By.id("nav-search-submit-button")));

//Takescreenshot("productsearch");


//WebElement product =
//driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[7]"));
//elementsendkeys(driver.findElement(By.id("twotabsearchtextbox")),gettext(
//product)+"\n")z


//>>>>>>>>>>>>>>>>>>>>>EXCEL SHEET WRITE METHOD>>>>>>>>>>>>>
/*String path=".\\src\\test\\resource\\testdata\\excelsheet.xlsx";
		File f=new File(path);
		FileInputStream fis= new FileInputStream(f);
		Workbook wb =new XSSFWorkbook(fis);
		Sheet sheetAt = wb.getSheetAt(0);
		int physicalNumberOfRows = sheetAt.getPhysicalNumberOfRows();

		for (int i = 0; i < physicalNumberOfRows; i++) {


		Row row = sheetAt.getRow(i);
		for (int j = 0; j <  physicalNumberOfRows; j++) {



		Cell cell = row.getCell(j);
		DataFormatter data=new DataFormatter();
		String formatCellValue = data.formatCellValue(cell);
		System.out.println(formatCellValue);
		  //  pageobject obj=new pageobject(driver);
		    //elementsendkeys(obj.getLoginpage().getAmzonsearchbox(), readxl(0, 0));

		//>>>>>>>>>>>>>>>>>>>>..excel sheet write method>>>>>>>>>>>>>>




List<WebElement> productName=obj.getLoginpage().Result_product;
for (int i = 0; i < productName.size(); i++) {

	writexl(i, 0, productName.get(i).getText());

}
}
 */
