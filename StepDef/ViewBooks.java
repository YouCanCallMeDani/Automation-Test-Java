package StepDef;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ViewBooks {
    WebDriver driver;
    @Given("User go to View Books")
    public void user_Go_To_Demoqa() {
        final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);
        System.setProperty("webdriver.chrome.driver", dir+"/driver/chromedriver.exe");
        driver = new ChromeDriver();
    }
    @When("User in Book Store page")
    public void userInBookStorePage() {
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/books");
    }

    @And("User search book Git Pocket Guide")
    public void userSearchBookGitPocketGuide() throws InterruptedException {
         driver.findElement(By.xpath("//*[@id='searchBox']")).sendKeys("Git Pocket Guide");
         Thread.sleep(1000);
    }

    @And("User click book Git Pocket Guide")
    public void userClickBookGitPocketGuide() throws InterruptedException {
        driver.findElement(By.id("see-book-Git Pocket Guide")).click();
        Thread.sleep(1000);
    }

    @Then("User see Git Pocket Guide")
    public void userSeeGitPocketGuide() throws InterruptedException {
        driver.close();
        driver.quit();
        Thread.sleep(8000);
    }
}
