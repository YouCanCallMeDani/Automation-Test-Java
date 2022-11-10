# Automation-Test-Java

Test Automation menggunakan Selenium menggunakan bahasa pemrograman Java + Cucumber.

Tools yang digunakan :
1. Java 1.8
2. IntelliJ IDEA
3. IntelliJ IDEA Plugin : Cucumber for Java
4. IntelliJ IDEA Plugin : Gherkin
5. Chromedriver
6. Maven

**Berikut adalah langkah2 nya :**
1. Buat Project pada IDE, disini saya menggunakan IntelliJ (https://www.jetbrains.com/idea/download/)
![image](https://user-images.githubusercontent.com/117799202/201160433-6f2b6397-51e1-4a86-bba5-ac0c2da6c876.png)

2. Install Plugin ini "Cucumber for Java" dan "Gherkin"
![image](https://user-images.githubusercontent.com/117799202/201160967-e91c1e9e-2dfc-48b3-a12c-8e3171ca8c57.png)

3. Buka pom.xml dan add dependency ini
```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>org.example</groupId>
    <artifactId>automation-bdd-google</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>15</maven.compiler.source>
        <maven.compiler.target>15</maven.compiler.target>
    </properties>
    <dependencies>

        <!-- https://mvnrepository.com/artifact/io.cucumber/cucumber-java -->
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-java</artifactId>
            <version>6.9.0</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/junit/junit -->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.13.1</version>
            <scope>test</scope>
        </dependency>

        <!-- https://mvnrepository.com/artifact/io.cucumber/cucumber-junit -->
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-junit</artifactId>
            <version>6.9.0</version>
            <scope>test</scope>
        </dependency>

        <!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>3.141.59</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/net.masterthought/cucumber-reporting -->
        <dependency>
            <groupId>net.masterthought</groupId>
            <artifactId>cucumber-reporting</artifactId>
            <version>5.4.0</version>
        </dependency>


    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>2.22.0</version>
                <configuration>
                    <testFailureIgnore>true</testFailureIgnore>
                </configuration>
            </plugin>
            <plugin>
                <groupId>net.masterthought</groupId>
                <artifactId>maven-cucumber-reporting</artifactId>
                <version>2.8.0</version>
                <executions>
                    <execution>
                        <id>execution</id>
                        <phase>verify</phase>
                        <goals>
                            <goal>generate</goal>
                        </goals>
                        <configuration>
                            <projectName>automation-bdd-google</projectName>
                            <outputDirectory>${project.build.directory}/cucumber-report-html</outputDirectory>
                            <cucumberOutput>${project.build.directory}/cucumber.json</cucumberOutput>
                        </configuration>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>
</project>
```

4. Tambahkan Webdriver (disini saya menggunakan ChromeDriver dan bisa di download di "https://chromedriver.chromium.org/downloads") lalu buat Directory driver dan simpan ChromeDriver

![image](https://user-images.githubusercontent.com/117799202/201161415-38ae3bb1-dd61-4500-803b-1b086cba79c3.png)

5. Buat Directory "StepDef" dan "TestRunner" pada src/test/java dan juga buat Directory "Features" pada src/test/resources
![image](https://user-images.githubusercontent.com/117799202/201161761-e5b3e16d-9304-4529-8766-c032cda7d0f5.png)

6. Buat Feature file "SearchGoogle.feature" pada directory Features
Feature: Select Menu
  Scenario: I want to using select menu on demoqa
    Given User go to https://demoqa.com/select-menu
    When User in select menu page
    And User choose select value Another root option
    And User choose select one Other
    And User choose old style select menu Aqua
    And User choose multi select drop down all color
    Then User success input all select menu
    
7. Hover ke Gherkin scenarionya dan akan muncul action dan klik "More Action" lalu klik lagi "Create all step definitions" lalu buat nama class nya sesuai dengan nama Feature file dan klik "OK"

![image](https://user-images.githubusercontent.com/117799202/201162396-84e48c62-4889-4213-94fb-1bd0a7e92968.png)

8. Isi scenario di java code nya seperti dibawah ini ya
```
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
```

9. Hover pada feature file dan klik Run

![image](https://user-images.githubusercontent.com/117799202/201162900-58ba9b8b-33d9-4961-976f-49d033e0e82c.png)

10. Maka akan otomatis running test nya, seperti video dibawah ini :
https://user-images.githubusercontent.com/117799202/201165081-f4babe33-8edc-40eb-8af9-3a61fc430be4.mp4
