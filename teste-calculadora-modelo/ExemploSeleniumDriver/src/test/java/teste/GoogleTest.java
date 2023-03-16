package teste;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleTest {
    
    @Test
    public void search() {
          WebDriverManager.chromedriver().setup();
          WebDriver driver = new ChromeDriver();
          //WebDriver driver = new FirefoxDriver();
          driver.get("https://www.google.com.br");

          WebElement searchBox = driver.findElement(By.cssSelector("[name='q']"));
          searchBox.sendKeys("Editora Globo");
          searchBox.submit();

          WebElement searchResults = driver.findElement(By.cssSelector("#search"));

          assertTrue(searchResults.isDisplayed());
          assertThat(driver.getTitle()).startsWith("Editora Globo");

          driver.quit();
    }
}
