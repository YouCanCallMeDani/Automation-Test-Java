package StepDef;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectMenu {
    WebDriver driver;
    @Given("User go to https://demoqa.com/select-menu")
    public void user_Go_To_Demoqa() {
        final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);
        System.setProperty("webdriver.chrome.driver", dir+"/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @When("User in select menu page")
    public void user_In_Select_MenuPage() {
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/select-menu");
    }

    @And("User choose select value Another root option")
    public void user_Choose_Select_Value_Another_Root_Option() throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='react-select-2-input']")).sendKeys("Another root option");
        Thread.sleep(1000);
        WebElement textbox = driver.findElement(By.xpath("//input[@id='react-select-2-input']"));
        textbox.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
    }

    @And("User choose select one Other")
    public void user_Choose_Select_One_Other() throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='react-select-3-input']")).sendKeys("Other");
        Thread.sleep(1000);
        WebElement textbox = driver.findElement(By.xpath("//input[@id='react-select-3-input']"));
        textbox.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
    }

    @And("User choose old style select menu Aqua")
    public void user_Choose_Old_Style_Select_Menu_Aqua() throws InterruptedException {
        WebElement staticDropdown = driver.findElement(By.id("oldSelectMenu"));
        Select dropdown = new Select(staticDropdown);
        Thread.sleep(1000);
        dropdown.selectByValue("10");
        Thread.sleep(3000);
    }

    @And("User choose multi select drop down all color")
    public void user_Choose_Multi_Select_DropDown_All_Color() throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='react-select-4-input']")).sendKeys("Green");
        WebElement textbox1 = driver.findElement(By.xpath("//input[@id='react-select-4-input']"));
        textbox1.sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='react-select-4-input']")).sendKeys("Blue");
        WebElement textbox2 = driver.findElement(By.xpath("//input[@id='react-select-4-input']"));
        textbox2.sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='react-select-4-input']")).sendKeys("Black");
        WebElement textbox3 = driver.findElement(By.xpath("//input[@id='react-select-4-input']"));
        textbox3.sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='react-select-4-input']")).sendKeys("Red");
        WebElement textbox4 = driver.findElement(By.xpath("//input[@id='react-select-4-input']"));
        textbox4.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
    }

    @Then("User success input all select menu")
    public void user_Success_Input_All_Select_Menu() throws InterruptedException {
        driver.close();
        driver.quit();
        Thread.sleep(8000);
    }
}
