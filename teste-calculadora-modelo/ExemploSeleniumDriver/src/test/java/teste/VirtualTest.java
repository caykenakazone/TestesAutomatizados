package teste;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VirtualTest {
    
    @Test
    public void search() {
          WebDriverManager.chromedriver().setup();
          WebDriver driver = new ChromeDriver();
          //WebDriver driver = new FirefoxDriver();
          driver.get("https://virtualif.iftm.edu.br");

          WebElement searchBox = driver.findElement(By.id("usuario"));
          searchBox.sendKeys("teste");

          searchBox = driver.findElement(By.id("senha"));
          searchBox.sendKeys("teste");

          searchBox = driver.findElement(By.id("btnEntrar"));
          searchBox.click();

          WebElement searchResults = driver.findElement(By.id("status-login"));

          assertTrue(searchResults.isDisplayed());
          assertEquals(searchResults.getText(), "Usuário ou senha não cadastrados ou inativo!");
          
          
          //driver.quit();
    }
}
