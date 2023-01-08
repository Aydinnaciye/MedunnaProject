package stepdefinitions;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import pages.RegistrationPage;
import utilities.ConfigurationReader;
import utilities.Driver;
public class RegistrationStepDefs {
    RegistrationPage registrationPage = new RegistrationPage();
    Faker faker = new Faker();

    @Given("user is on the registration page")
    public void user_is_on_the_registration_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("gmiBank_registration_url"));
    }
    @Given("user enters ssn number as {string}")
    public void user_enters_ssn_number_as(String string) {
//        registrationPage.ssnTextbox.sendKeys(string);
//        NOTE: there is a reusable method in the Driver class.
//        We can use it for sending the text to the element
//         It will wait when needed as well
        string=faker.idNumber().ssnValid();
        Driver.waitAndSendText(registrationPage.ssnTextbox,string);
    }
    @Given("user enters firstname as {string} and lastname as {string}")
    public void user_enters_firstname_as_and_lastname_as(String string, String string2) {
//        registrationPage.firstnameTextbox.sendKeys(string);
//        registrationPage.lastnameTextbox.sendKeys(string2);
        string=faker.name().firstName();
        string2=faker.name().lastName();
        Driver.waitAndSendText(registrationPage.firstnameTextbox,string);
        Driver.waitAndSendText(registrationPage.lastnameTextbox,string2);
    }
    @Given("user provides address {string}")
    public void user_provides_address(String string) {
        Driver.waitAndSendText(registrationPage.addressTextbox,string);
    }
    @Given("user provides phoneNumber {string}")
    public void user_provides_phone_number(String string) {
        Driver.waitAndSendText(registrationPage.mobilephoneTextbox,string);
    }
    @Given("user provides username {string}")
    public void user_provides_username(String string) {
        string=faker.name().username();
        Driver.waitAndSendText(registrationPage.usernameTextbox,string);
    }
    @Given("user provides email {string}")
    public void user_provides_email(String string) {
        string=faker.internet().emailAddress();
        Driver.waitAndSendText(registrationPage.emailTextbox,string);
    }
    @Given("user provides the firstPassword as {string} and secondPassword as {string}")
    public void user_provides_the_first_password_as_and_second_password_as(String string, String string2) {
        Driver.waitAndSendText(registrationPage.firstPasswordTextbox,string);
       Driver.waitAndSendText(registrationPage.newPasswordTextbox,string2);
    }
   @Given("user clicks on the register button and see the success message as {string}")
    public void user_clicks_on_the_register_button_and_see_the_success_message_as(String string) {
//        registrationPage.registerButton.click();
        Driver.waitAndClick(registrationPage.registerButton);
        Driver.wait(1);
        Assert.assertTrue(registrationPage.successMessageToastContainer.isDisplayed());
//     Assert.assertEquals(string,registrationPage.successMessageToastContainer.getText());
    }
}

