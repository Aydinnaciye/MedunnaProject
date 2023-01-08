package stepdefinitions;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import pages.CommonPageElements;
import pages.LoginPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ExcelUtil;
import utilities.ReusableMethods;

import java.io.IOException;
import java.util.List;
import java.util.Map;
    public class ExcelStepDefs {
        //Excel Util will be used for the reusable excel methods
        //We will use this for set ups and getting the test data from excel
        ExcelUtil excelUtil;
        //test data will be used to store the Excel data
        List<Map<String, String>> testData;
        //LoginPage Object to access the login page elements
        LoginPage loginPage = new LoginPage();
        //To access to common page elements
        CommonPageElements commonPageElements = new CommonPageElements();
        public void setUp() throws InterruptedException {
            Driver.getDriver().get(ConfigurationReader.getProperty("gmi_login_url"));
//        loginPage = new LoginPage();
//        commonPageElements = new CommonPageElements();
            ReusableMethods.waitFor(1);
            loginPage.loginDropdown.click();
            ReusableMethods.waitFor(1);;
            try{
                loginPage.signOut.click();
                ReusableMethods.waitFor(1);
                loginPage.loginDropdown.click();
                ReusableMethods.waitFor(1);
            }catch (Exception e){
//            System.out.println("Sign out link is not exist");
            }
            loginPage.signInButton.click();
        }


        @Given("user login with excel as {string}")
    public void user_login_with_excel_as(String string) throws InterruptedException, IOException {
         String path = "./src/test/resources/testdata/mysmoketestdata.xlsx";
         String sheetName = string +"login_info";
         //admin_login_info=string+"login_info";
         //   employee_login_info
          //   customer_login_info

         excelUtil=new ExcelUtil(path,sheetName);
         testData =excelUtil.getDataList();
         System.out.println(testData);

         //using loop to get list of credentials
            for (Map<String, String> eachData  : testData){
                setUp();
                loginPage.username.sendKeys(eachData.get("username"));
                loginPage.password.sendKeys(eachData.get("password"));
                loginPage.loginButton.click();
        //Assert if login is successful
                ReusableMethods.waitFor(3);
                Assert.assertTrue(commonPageElements.myOperations.isDisplayed());
                ReusableMethods.getScreenshot("profiles");
            }

    }
}