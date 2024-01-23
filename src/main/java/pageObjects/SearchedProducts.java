package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import reusable_Utility.Utility;

public class SearchedProducts extends Utility
{

	WebDriver driver;
	
	public SearchedProducts(WebDriver driver)
	{
		//initialization
		super(driver);
		this.driver=driver; 
				
	PageFactory.initElements(driver,this);
	
	}	
	
	@FindBy(css="div.productNaming h2")
	List<WebElement>getallproducts;
	
	
	By waitforallproducts=By.cssSelector("div.productNaming h2"); 
	
	
	public ProductDetails getProductByName(String ProductName)
	{
		
		List <WebElement>list=getallproducts;
		String arr[]=new String[list.size()];
	
		System.out.println(list.size());

		for(int i=0;i<list.size();i++)
		{
			
			arr[i]=list.get(i).getText();
			String ProdNames=arr[i].toString();
			
			System.out.println(ProdNames);
			
			//wait for product display
			WaitForDisplayAllProducts(waitforallproducts);
			
			if(ProdNames.equalsIgnoreCase(ProductName))
			{
				System.out.println("clicked");
				WaitForDisplayAllProducts(waitforallproducts);				
				list.get(i).click();
				break;
			}
			else
			{
				//wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.productNaming h2")));
				
				//scroll main window
				//js.executeScript("window.scrollBy(0,100)");
				ScrollUntilProductgetsFind();
			}
			
			
		}	
		
		ProductDetails productdetails=new ProductDetails(driver);
		return productdetails;
		
		
		
		
	}
	
	
	
	
	
	
	
	
}
