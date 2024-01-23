package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reusable_Utility.Utility;

public class ProductPurchasePage  extends Utility{

	
	WebDriver driver;
	
	
	public ProductPurchasePage(WebDriver driver)
	{
		//initialization
		super(driver);
		this.driver=driver;
				
	PageFactory.initElements(driver,this); 
	
	}
	

@FindBy(id="testChangeSize")
WebElement sizebox;

@FindBy(xpath = "//button[normalize-space()='M']")
WebElement sizeboxselect;
	public void verifyProductSize()
	{
		sizebox.click();
		sizeboxselect.click();
	
	}
	
	
	By Lodder=By.xpath("//img[@title='Loading...']");
	
	@FindBy(id="testChangeQty")
	WebElement quantitybox;	
	
	@FindBy(xpath = "//button[normalize-space()='2']")
	WebElement quantityboxselect;
	public void verifyProductQuantity()
	{	
		WaitforLodder(Lodder);
		quantitybox.click();
		quantityboxselect.click();

	}
	
	@FindBy(css="div.prc-bdn-dsk p")
	List<WebElement> pricesummary;
	public void verifyPriceSummary()
	{	
		pricesummary.stream().forEach(s->System.out.println(s.getText()));
			
	}

	
	@FindBy(css="a.cartProductName")
	WebElement cartproductverify;
	public String CartProductVerify()
	{
		
		String productname=cartproductverify.getText();
		return productname;
	}
	
	
	@FindBy(id="os_payNow_btn")
	WebElement AddressBtn;
	
	@FindBy(xpath ="//h2")
	WebElement Welcometxt;
	
	public String ClickonAddressBtn()
	{
		WaitforLodder(Lodder);
		AddressBtn.click();
		String txt=Welcometxt.getText();
		return txt;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
