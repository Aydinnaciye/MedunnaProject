package stepdefinitions;


    import io.cucumber.java.en.Given;
import pages.CommonPageElements;

    import pages.UserManagementPage;
    import utilities.Driver;
    public class UserCreationStepDefs {
        CommonPageElements commonpage = new CommonPageElements();
        UserManagementPage userManagementPage = new UserManagementPage();
        @Given("admin clicks user management")
        public void admin_clicks_user_management() {
            Driver.waitAndClick(commonpage.administrationDropdown);
            Driver.waitAndClick(commonpage.userManagementButton);
        }
        @Given("admin clicks the button to create a user")
        public void admin_clicks_the_button_to_create_a_user() {
            Driver.waitAndClick(userManagementPage.CreateUserButton);
        }
        @Given("admin enters {string} for login")
        public void admin_enters_for_login(String loginText) {
            Driver.waitAndSendText(userManagementPage.login,loginText);
        }
        @Given("admin enters {string} for firstname and {string} for lastname")
        public void admin_enters_for_firstname_and_for_lastname(String firstName, String lastName) {
            Driver.waitAndSendText(userManagementPage.firstName,firstName);
            Driver.waitAndSendText(userManagementPage.lastName,lastName);
        }
        @Given("user clicks Save button")
        public void user_clicks_save_button() {

            Driver.waitAndClick(userManagementPage.saveButton);
        }
}
