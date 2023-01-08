package stepdefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import pages.CommonPageElements;
import pages.MoneyTransferPage;
import utilities.Driver;
import java.io.File;
import java.io.IOException;
    public class MoneyTransferStepDefs {
        CommonPageElements commonPage = new CommonPageElements();
        MoneyTransferPage moneyTransfer = new MoneyTransferPage();
        @Given("user clicks on my operations")
        public void user_clicks_on_my_operations() {
           Driver.waitAndClick(commonPage.myOperations);
        }
        @Given("user clicks on transfer money")
        public void user_clicks_on_transfer_money() {
            Driver.waitAndClick(commonPage.moneyTransferOption);
        }
        @When("user select the current account to transfer money from")
        public void user_select_the_current_account_to_transfer_money_from() {
            // We can use index for this example
            // select.selectbyIndex(1)-- selectByIndex(1)
            Driver.selectByIndex(moneyTransfer.transferFrom,1);
        }
        @When("user select the other account to transfer money to")
        public void user_select_the_other_account_to_transfer_money_to() {
            Driver.selectByIndex(moneyTransfer.transferTo,1);
        }
        @When("user provides the balance {string} for dolar and {string} for cent")
        public void user_provides_the_balance_for_dolar_and_for_cent(String balance, String cent) {
            Driver.waitAndSendText(moneyTransfer.balance,balance);
            Driver.waitAndSendText(moneyTransfer.balanceCent,cent);
        }
        @When("user types the description")
        public void user_types_the_description() {
            Driver.waitAndSendText(moneyTransfer.description,"Payment for Education");
        }
        @Then("user makes the money transfer and verify success message")
        public void user_makes_the_money_transfer_and_verify_success_message() throws IOException {
            Driver.waitAndClick(moneyTransfer.makeTransferButton);
            Assert.assertTrue(moneyTransfer.successMessageToastContainer.isDisplayed());
            File successMessage = moneyTransfer.successMessageToastContainer.getScreenshotAs(OutputType.FILE);
            File path = new File("successMessage.png");
            FileUtils.copyFile(successMessage,path);
        }

    }


