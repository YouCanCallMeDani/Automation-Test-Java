package StepDef;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchBooks {
    WebDriver driver;
    @Given("User go to Search Book")
    public void user_Go_To_Demoqa() {
        final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);
        System.setProperty("webdriver.chrome.driver", dir+"/driver/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @When("User in Book Store Page")
    public void user_In_Book_Store_Page() {
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/books");
    }

    @And("User search book qa engineer")
    public void user_Search_Book_Qa_Engineer() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id='searchBox']")).sendKeys("qa engineer");
        Thread.sleep(1000);
    }

    @Then("User see No rows found")
    public void user_See_No_Rows_Found() throws InterruptedException {
        driver.close();
        driver.quit();
        Thread.sleep(8000);
    }
}
