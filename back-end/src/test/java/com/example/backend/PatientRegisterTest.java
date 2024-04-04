package com.example.backend;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PatientRegisterTest {
    public static void main(String[] args) {
        // Set the path to your ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");

        // Initialize the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to your web application
        driver.get("http://127.0.0.1:5500/patient_register.html");

        // Find the registration form fields and enter patient information
        WebElement firstNameInput = driver.findElement(By.id("first_name"));
        firstNameInput.sendKeys("John");

        WebElement lastNameInput = driver.findElement(By.id("last_name"));
        lastNameInput.sendKeys("Doe");

        WebElement ageNameInput = driver.findElement(By.id("age"));
        ageNameInput.sendKeys("24");

        WebElement mobileNoInput = driver.findElement(By.id("mobile_no"));
        mobileNoInput.sendKeys("0761234567");

        WebElement emailInput = driver.findElement(By.id("email"));
        emailInput.sendKeys("john@gmail.com");

        WebElement usernameInput = driver.findElement(By.id("username"));
        usernameInput.sendKeys("john");

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("1234");

        WebElement confirmPasswordInput = driver.findElement(By.id("confirm_password"));
        confirmPasswordInput.sendKeys("1234");

        // Find and click the submit button to register the patient
        WebElement submitButton = driver.findElement(By.id("register"));
        submitButton.click();

        // Wait for the response to be processed
        try {
            Thread.sleep(3000); // You might need to adjust the wait time depending on your application response time
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Check if the registration was successful by verifying if the success message is displayed
        WebElement successMessage = driver.findElement(By.id("successMessage")); // Replace "successMessage" with the actual ID of the success message element
        String message = successMessage.getText();

        if (message.contains("Patient registered successfully")) {
            System.out.println("Patient registration successful.");
        } else {
            System.out.println("Patient registration failed.");
        }

        // Close the browser
        driver.quit();
    }
}
