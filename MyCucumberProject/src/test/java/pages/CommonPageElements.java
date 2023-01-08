package pages;


    import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
    public class CommonPageElements {
        public CommonPageElements(){
            PageFactory.initElements(Driver.getDriver(),this);
        }
        @FindBy(xpath = "//*[text()='My Operations']")
        public WebElement myOperations;

        @FindBy(xpath = "//*[text()='Transfer Money']")
        public WebElement moneyTransferOption;


        @FindBy(xpath = "//*[text()='Administration']")
        public WebElement administrationDropdown;

        @FindBy(xpath = "//*[text()='User management']")
        public WebElement userManagementButton;

    }
