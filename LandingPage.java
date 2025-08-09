package SeleniumFrameWorkProjects.pageobjects;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SeleniumFrameWorkProjects.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent{
    WebDriver driver;
    public LandingPage(WebDriver driver) {
    	super(driver);
    	//initialization
    	this.driver = driver;
    	PageFactory.initElements(driver, this);
    }
    
	//WebElement userEmail = driver.findElement(By.id("userEmail"));

	//pageFactory
    @FindBy(id="userEmail")
    WebElement userEmail;
    
    @FindBy(id="userPassword")
    WebElement passwordElement;
    
    @FindBy(id="login")
    WebElement submit;
    

    @FindBy(css="[class*='flyInOuty']")
    WebElement errorMessage;

    
    
    public ProductCatalogue loginApplication(String email, String password) {
    	userEmail.sendKeys(email);
    	passwordElement.sendKeys(password);
    	 // Wait until the submit button is clickable before clicking
      //  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       // wait.until(ExpectedConditions.elementToBeClickable(submit));
    	submit.click();
    	ProductCatalogue productCatalogue = new ProductCatalogue(driver);
    	return productCatalogue;
    	
    }
    

    public String getErrorMessage(){
        waitForWebElementToAppear(errorMessage);
       return  errorMessage.getText();

    }
    
    public void goTo() {
    	driver.get("https://rahulshettyacademy.com/client");
    }
    
	
}
