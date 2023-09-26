package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.time.Duration;

public class TripBuddiesTest {
    private WebDriver driver;

    @BeforeClass
    public void inicializarDriver() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumWD\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }
    @Test
    public void testRegisterCarrier() {
        driver.get("http://localhost:4200/sign-up/bussiness");

        new WebDriverWait(driver, Duration.ofSeconds(5L)).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

        WebElement registerFirstNameField = driver.findElement(By.name("first_name"));
        registerFirstNameField.sendKeys("Johan Julian");
        WebElement registerLastNameField = driver.findElement(By.name("last_name"));
        registerLastNameField.sendKeys("Huanca Nina");
        WebElement registerPhoneField = driver.findElement(By.name("phone"));
        registerPhoneField.sendKeys("995240514");
        WebElement registerEmailField = driver.findElement(By.name("email"));
        registerEmailField.sendKeys("huanca4141@gmail.com");
        WebElement registerPasswordField = driver.findElement(By.name("password"));
        registerPasswordField.sendKeys("@rduino4141!");
        WebElement registerPasswordConfirmField = driver.findElement(By.name("password_confirm"));
        registerPasswordConfirmField.sendKeys("@rduino4141!");

        WebElement registerMarcaNameField = driver.findElement(By.name("Business_name"));
        registerMarcaNameField.sendKeys("Toyota");
        WebElement registerRucField = driver.findElement(By.name("ruc"));
        registerRucField.sendKeys("20506311927");
        WebElement registerPlateNameField = driver.findElement(By.name("Plate_name"));
        registerPlateNameField.sendKeys("ABC-123");
        WebElement registerAddressField = driver.findElement(By.name("address"));
        registerAddressField.sendKeys("Av.Mexico 1555");
        WebElement registerCountryField = driver.findElement(By.name("country"));
        registerCountryField.sendKeys("Peru");
        WebElement registerCityField = driver.findElement(By.name("city"));
        registerCityField.sendKeys("Lima");

        WebElement CreateAccountButton = driver.findElement(By.name("create_account_button"));
        CreateAccountButton.click();
    }
    @Test(dependsOnMethods = {"testRegisterCarrier"})
    public void testLoginCarrier() {
        driver.get("http://localhost:4200/login");

        new WebDriverWait(driver, Duration.ofSeconds(5L)).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

        WebElement loginCarrierOptionButton = driver.findElement(By.name("carrier_option_button"));
        loginCarrierOptionButton.click();
        WebElement loginEmailField = driver.findElement(By.name("email"));
        loginEmailField.sendKeys("huanca4141@gmail.com");
        WebElement loginPasswordField = driver.findElement(By.name("password"));
        loginPasswordField.sendKeys("@rduino4141!");

        WebElement loginButton = driver.findElement(By.name("login_button"));
        loginButton.click();
    }
    @Test(dependsOnMethods = {"testLoginCarrier"})
    public void testPublicPlace() {
        driver.get("http://localhost:4200/bussiness/home");

        new WebDriverWait(driver, Duration.ofSeconds(5L)).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

        WebElement addPlaceButton = driver.findElement(By.name("add_place_button"));
        addPlaceButton.click();

        WebElement addNamePlaceField = driver.findElement(By.name("add_name_place"));
        addNamePlaceField.sendKeys("Viaje Loreto");
        WebElement addDescriptionPlaceField = driver.findElement(By.name("add_description_place"));
        addDescriptionPlaceField.sendKeys("Viaje en Omnibus");
        WebElement addDatePlaceField = driver.findElement(By.name("add_date_place"));
        addDatePlaceField.sendKeys("20-09-2023");
        WebElement addHourPlaceField = driver.findElement(By.name("add_hour_place"));
        addHourPlaceField.sendKeys("7:00 pm");
        WebElement addOriginPlaceField = driver.findElement(By.name("add_origin_place"));
        addOriginPlaceField.sendKeys("Lima");
        WebElement addDestinationPlaceField = driver.findElement(By.name("add_destination_place"));
        addDestinationPlaceField.sendKeys("Loreto");
        WebElement addPricePlaceField = driver.findElement(By.name("add_price_place"));
        addPricePlaceField.sendKeys("50");
        WebElement addImageUrlPlaceField = driver.findElement(By.name("add_imageUrl_place"));
        addImageUrlPlaceField.sendKeys("https://media.viajando.travel/p/01c9e31d4c9dd0c6dbb0007dd5542fc8/adjuntos/236/imagenes/000/489/0000489821/loreto-peru-1jpg.jpg");

        WebElement loginButton = driver.findElement(By.name("create_place_button"));
        loginButton.click();
    }
    /*
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

     */
}

