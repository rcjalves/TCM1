package metodos;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Metodos {

    public static WebDriver driver;

    // Método para tirar screenshot
    public void screenShot(String print) throws IOException {
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File descFile = new File(print);
        FileUtils.copyFile(srcFile, descFile);
    }

    // Método para realizar o sleep (espera)
    public void sleep(int tempo) throws InterruptedException {
        try {
            Thread.sleep(tempo);
        } catch (NoSuchElementException e) {
            Assert.fail(LocalDateTime.now() + " Não foi possível esperar, favor verificar");
        }
    }

    public void sleep() throws InterruptedException {
        sleep(5000);  // Espera de 5 segundos
    }

    // Método para clicar em um elemento
    public void clicar(By elemento) {
        try {
            driver.findElement(elemento).click();
        } catch (NoSuchElementException e) {
            Assert.fail(LocalDateTime.now() + " - Elemento não encontrado para clique: " + elemento);
        }
    }

    // Método para clicar com JavaScript
    public void clicarBotaoJS(By elemento) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement botao = driver.findElement(elemento);
            js.executeScript("arguments[0].click();", botao);
        } catch (NoSuchElementException e) {
            Assert.fail(LocalDateTime.now() + " - Botão não encontrado para clique via JS: " + elemento);
        }
    }

    // Método para clicar em checkbox
    public void clicarCheckbox(By elemento) {
        try {
            WebElement checkbox = driver.findElement(elemento);
            if (!checkbox.isSelected()) {
                checkbox.click();
            }
        } catch (NoSuchElementException e) {
            Assert.fail(LocalDateTime.now() + " - Checkbox não encontrado: " + elemento);
        }
    }

    
    public void inserirValorInput(By elemento, String texto) {
        try {
            driver.findElement(elemento).clear();
            driver.findElement(elemento).sendKeys(texto);
        } catch (NoSuchElementException e) {
            Assert.fail(LocalDateTime.now() + " - Não foi possível preencher o campo: " + elemento);
        }
    }

    
    public void inserirValorInputComTAB(By elemento, String texto) {
        try {
            WebElement input = driver.findElement(elemento);
            input.clear();
            input.sendKeys(texto);
            Actions actions = new Actions(driver);
            actions.sendKeys("\t").perform();  
        } catch (NoSuchElementException e) {
            Assert.fail(LocalDateTime.now() + " - Não foi possível inserir valor no input com TAB: " + elemento);
        }
    }

    
    public String getText(By elemento) {
        try {
            return driver.findElement(elemento).getText();
        } catch (NoSuchElementException e) {
            Assert.fail(LocalDateTime.now() + " - Não foi possível obter o texto do elemento: " + elemento);
            return null;
        }
    }

    
    public void fecharNavegador() {
        try {
            if (driver != null) {
                driver.quit();  
            }
        } catch (Exception e) {
            Assert.fail(LocalDateTime.now() + " - Não foi possível fechar o navegador.");
        }
    }

    
    public void scrollParaElemento(By elemento) {
        try {
            WebElement webElement = driver.findElement(elemento);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", webElement);  // Realiza o scroll até o elemento
        } catch (Exception e) {
            Assert.fail(LocalDateTime.now() + " - Não foi possível realizar o scroll até o elemento: " + elemento);
        }
    }

   
    public void rolarParaBaixo() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,1000)");  // Rolagem de 1000px para baixo
        } catch (Exception e) {
            Assert.fail(LocalDateTime.now() + " - Não foi possível rolar para baixo.");
        }
    }
    
    public void rolarParaCima() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,-1000)");  // Rolagem de 1000px para cima
        } catch (Exception e) {
            Assert.fail(LocalDateTime.now() + " - Não foi possível rolar para cima.");
        }
    }
    
    public void abrirNavegador(String url) {
    	
    	System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
    	driver = new ChromeDriver();
    	driver.get(url);
    	driver.manage().window().maximize();    }
}
