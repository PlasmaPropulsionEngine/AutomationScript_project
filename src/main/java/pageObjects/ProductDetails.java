package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;

import reusable_Utility.Utility;

public class ProductDetails extends Utility {

	WebDriver driver;
	public ProductDetails(WebDriver driver)
	{
		
		super(driver);
		this.driver=driver;
				
	PageFactory.initElements(driver,this); 
			
	}
	
	
	@FindBy(id="testProName")
	WebElement productname;
	
	public String verifySameProductNameDisplayed()
	{
		
			String expected=productname.getText();
		return expected;
		
		
	}
	
	
	By Lodder=By.xpath("//img[@title='Loading...']");
	
	@FindBy(xpath ="//span[normalize-space()='Size Guide']")
	WebElement SizeGuide;
	
	@FindBy(css="iframe")
	WebElement frame;
	public void ClickonSizeGuide()
	{
		WaitforLodder(Lodder);
		SizeGuide.click();
		System.out.println("switched");
		driver.findElement(By.cssSelector("i.icon_close")).click();
		//driver.findElement(By.id("cmsGuideLabel")).click();
	}
	
	
	@FindBy(xpath ="//div[@id='testSizes_L']/span")
	WebElement size;
	public void selectSize()
	{
		WaitforLodder(Lodder);
		size.click();
		ScrollToClickOnAddBagBtn();
		
		
	}
	
	@FindBy(css="div.p-add-bag")
	WebElement AddBtn;
	
	public void ClickOnAddToBagBtn()
	{
		AddBtn.click();
		
	}
	
	@FindBy(css="i.icon_bag")
	WebElement CartBtn;
	public ProductPurchasePage ClickonCart()
	{
		WaitforLodder(Lodder);
		CartBtn.click();
	
		ProductPurchasePage productpurchasepage=new ProductPurchasePage(driver);
		
		return productpurchasepage;
				
		
	}
	
	
	
	
	
	
}
