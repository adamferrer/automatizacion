package com.qualitystream.tutorial;
//PAQUETES
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//PAQUETES

public class FormularioAutomatico {

    private WebDriver driver;

    @Before /* (BASICAMENTE ES EL "ANTES" DE EJECUTAR UNAS INSTRUCCIONES.
                en este caso antes de ejecutar las instrucciones de el proceso automatico, necesitamos que
                inicie el chrome, para eso tenemos un paquete llamado resources donde va a estar el fichero .exec */

    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver_win32/chromedriver.exe");

        driver= new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://infallible-hodgkin-e9fc14.netlify.app/");
        Thread.sleep(2000);
    }


    @Test // aqui ejecutaremos las instrucciones
    public void testGooglePage() throws InterruptedException {

        WebElement campoNombre = driver.findElement(By.id("nombres"));
        campoNombre.clear();
        campoNombre.sendKeys("Adam Abel");
        campoNombre.sendKeys(Keys.ENTER);
        System.out.println("Nombre colocado correctamente");


        Thread.sleep(3000);
        WebElement campoApellido = driver.findElement(By.id("apellidos"));
        campoApellido.clear();
        campoApellido.sendKeys("Ferrer Belisario");
        campoApellido.sendKeys(Keys.ENTER);
        System.out.println("Apellido colocado correctamente");

        Thread.sleep(3000);
        WebElement campoCorreo = driver.findElement(By.id("correo"));
        campoCorreo.clear();
        campoCorreo.sendKeys("nvidia@hotmail.com");
        campoCorreo.sendKeys(Keys.ENTER);
        System.out.println("Correo colocado correctamente");
        Thread.sleep(3000);


        System.out.println("Test Passed");

        //Posible manejo de juego (Canvas)////////
       // Actions clickAt = new Actions(d);
      //  clickAt.moveToElement(d.findElement(By.xpath("your canvas id here")), 60, 30).click();
      //  clickAt.moveToElement(d.findElement(By.xpath("your canvas id here")), 90, 30).click();
      //  clickAt.build().perform();
    }

    @After
    public void CerrarGooglePage() {
        driver.quit();
    }
}

