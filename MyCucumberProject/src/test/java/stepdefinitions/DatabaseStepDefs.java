package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.DBUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.microsoft.schemas.vml.STExt.Enum.table;

public class DatabaseStepDefs {
    @Given("user connects to the database")
    public void user_connects_to_the_database() {
        DBUtils.createConnection();
    }

    @Given("user gets the {string} from {string} table")
    public void user_gets_the_from_table(String column, String table) {
//  select  * from tp_customer
        String myDynamicQuery = "Select" + column + "from" + table;
        DBUtils.executeQuery(myDynamicQuery);
    }

    @Given("user reads all of the {string} column data")
    public void user_reads_all_of_the_column_data(String ssn) throws SQLException {
        //next() takes us to the next row
        DBUtils.getResultset().next();

        //I am on row 1
        //this gives me the single object on that row
        Object columnData = DBUtils.getResultset().getObject(ssn);//123¬34¬3434
        System.out.println(columnData);

        //Going to the next row
        DBUtils.getResultset().next();
        //Getting the data on that row
        Object columnData2 = DBUtils.getResultset().getObject(ssn);//823¬25¬7239
        System.out.println(columnData2);
        Object columnData3 = DBUtils.getResultset().getObject(ssn);//823¬25¬7239
        System.out.println(columnData3);//761¬59¬2911

    //    while (DBUtils.getResultset().next()) {
            //If there ıs the next then lop wıll be executed
    //       Object columnData = DBUtils.getResultset().getObject(ssn);
    //      System.out.println(columnData);

        }
       @Then("close the database connection")
        public void close_the_database_connection () {
            DBUtils.closeConnection();
       }
    @Then("verify {string} table {string} column contains {string}")
    public void verify_table_column_contains(String table, String column, String data) {
        List<Object> allColumnData = DBUtils.getColumnData("Select * from " +table,column);
        System.out.println(allColumnData);
        // Create a list and add all expected data -- login
        List<Object> expectedData = new ArrayList<>();
        expectedData.add(data);
        Assert.assertTrue(allColumnData.containsAll(expectedData));
    }
    @Given("verify the row count")
    public void verify_the_row_count() throws Exception {
        int rowNumber = DBUtils.getRowCount();
        System.out.println(rowNumber);
    }
    @Then("verify the column names of {string} table")
    public void verify_the_column_names_of_table(String table) {
        List<String> columnNames= DBUtils.getColumnNames("Select * from "+ table);
        System.out.println(columnNames);
    }
}




