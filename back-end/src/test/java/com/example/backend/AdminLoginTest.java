package com.example.backend;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AdminLoginTest {
	public static void main(String[] args) {
		// Set the path to your ChromeDriver executable
		System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		// Navigate to your web application
		driver.get("http://127.0.0.1:5500/admin_login.html"); // Assuming your application runs on localhost port 8080

		WebElement usernameInput = driver.findElement(By.id("username"));
		usernameInput.sendKeys("menda");

		WebElement passwordInput = driver.findElement(By.id("password")); // Replace "password" with the actual id of the password input field
		passwordInput.sendKeys("1234"); // Replace "password123" with the actual admin password

		// Find the login button and click it
		WebElement loginButton = driver.findElement(By.id("login")); // Replace "loginButton" with the actual id of the login button
		loginButton.click();

		// Wait for the response to be processed
		try {
			Thread.sleep(3000); // You might need to adjust the wait time depending on your application response time
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Check if the login was successful by verifying if the adminId is displayed
		WebElement adminIdElement = driver.findElement(By.id("1")); // Replace "adminId" with the actual id of the element displaying the adminId
		String adminId = adminIdElement.getText();

		if (!adminId.isEmpty()) {
			System.out.println("Login successful. Admin ID: " + adminId);
		} else {
			System.out.println("Login failed.");
		}

		// Close the browser
		driver.quit();
	}

}
