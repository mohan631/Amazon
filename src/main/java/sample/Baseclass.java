package sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Baseclass {
	public static WebDriver driver; // driver declare for global

	public static void Browserlaunch() {
		try {
			System.setProperty("webdriver.edge.driver", ".\\src\\main\\java\\driver\\msedgedriver.exe");
			driver = new EdgeDriver();

		} catch (Exception e) {
			System.out.println("invalid dge broweser" + e.getMessage());
		}

	}

	public static void windows_maxmize() {
		try {
			driver.manage().window().maximize();
		} catch (Exception e) {
			System.out.println("not valid to window maxmize" + e.getMessage());
		}
	}

	public static void get_URL(String url) {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}


	public static void elementsendkeys(WebElement element, String value) {

		element.sendKeys(value);

	}

	public static void elementclick(WebElement element) {
		element.click();
	}

	public static void Takescreenshot(String name) {
		try {

			File dea = new File("D:\\workspace\\Amazon\\src\\test\\java\\screenshot" + name + ".png");
			TakesScreenshot ts = (TakesScreenshot) driver;
			File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
			FileHandler.copy(screenshotAs, dea);
		} catch (Exception e) {
			System.out.println("unble to screnshot" + e.getMessage());
		}
	}
	/*
	 * public static String gettext(WebElement element) { String text=null; try {
	 * text=element.getText(); System.out.println(text); } catch (Exception e) { //
	 * TODO: handle exception } return text;
	 */

	public static void switchToWindow() {

		String mainWindow = driver.getWindowHandle();

		Set<String> allWindows = driver.getWindowHandles();

		for (String window : allWindows) {
			if (!mainWindow.equals(window)) {

				driver.switchTo().window(window);
				System.out.println("Window Switched");
			}
		}
	}

	public static void mobilesearch(WebElement element) {

		try {
			element.click();

		} catch (Exception e) {
			System.out.println("invalid mobile search:" + e.getMessage());
		}
	}

	public static void addcart(WebElement add) {
		try {
			add.click();
		} catch (Exception e) {
			System.out.println("unable to add to cart");
		}

	}

	public static void selectx(WebElement cart) {
		try {
			cart.click();
		} catch (Exception e) {
			System.out.println("unable to selectmethod" + e.getMessage());
		}

	}

	public static void quantity(WebElement click) {

		try {
			click.click();
		} catch (Exception e) {
			System.out.println("unable to click quntity");
		}

	}

	public static void selectQty(List<WebElement> qtyDropdown, String valuesof) {
		try {
			for (WebElement element : qtyDropdown) {
				if ((element.getText()).equals(valuesof)) {
					element.click();
					break;
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void dropdown1(WebElement element, String option, String i) {
		Select s = new Select(element);
		try {
			if (option.equals("index")) {
				s.selectByIndex(Integer.parseInt(i));
				System.out.println(s);

			} else if (option.equals("text")) {
				s.selectByVisibleText(i);
			}
		} catch (Exception e) {
			System.out.println("Unable to entr the qty :" + e.getMessage());
		}
	}

	
	public static void verifytheprice() {
		try {

			String actualprice = driver.getTitle();

			String expectedprice = "";
			System.out.println(actualprice.equals(expectedprice));
		} catch (Exception e) {
			System.out.println("unable to run verify the price " + e.getMessage());
		}

	}

	public WebElement getCart(WebElement cart) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			cart.click();
		} catch (Exception e) {
			System.out.println("unable to click cart" + e.getMessage());
		}

		return cart;
	}

	public static String readxl(int row, int col) throws IOException {
		String path = ".\\src\\test\\resource\\testdata\\excelsheet.xlsx";
		File f = new File(path);
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheetAt = wb.getSheetAt(0);

		Row rows = sheetAt.getRow(row);
		Cell cell = rows.getCell(col);

		DataFormatter data = new DataFormatter();
		String formatCellValue = data.formatCellValue(cell);
		System.out.println(formatCellValue);
		return formatCellValue;
	}

	public static void writexl(int r, int c, String value) throws IOException {

		String path = "D:\\workspace\\Amazon\\src\\test\\resource\\testdata\\excelsheet.xlsx";
		File f = new File(path);
		FileInputStream fis = new FileInputStream(f);
		Workbook ws = new XSSFWorkbook(fis);
		Sheet sheetAt = ws.getSheetAt(0);
		Row row = sheetAt.getRow(r);
		if (row == null) {
			row = sheetAt.createRow(r);
		}

		Cell cell = row.getCell(c);
		if (cell == null) {
			cell = row.createCell(c, CellType.STRING);
		}
		cell.setCellValue(value);
		FileOutputStream out = new FileOutputStream(f);
		ws.write(out);
		out.close();
		System.out.println("write completed");
	}

	public static String getPriceText(WebElement element) {
		String textValue = null;
		try {
			textValue = element.getText();
		} catch (Exception e) {
			Assert.fail("Unable to Get the Text value");
		}
		return textValue;
	}

	public static void verifyTextValue(String actualText, String Expected) {
		try {
			if ((actualText.trim()).equals(Expected)) {
				Assert.assertTrue(true, "Value is Matched");
				
			} else {
				Assert.assertTrue(false,"Value isn't Matched. Actual Text Value "+actualText);
			}
		} catch (Exception e) {
			Assert.fail("Unable to Compare the Text value");
		}
	}
}
