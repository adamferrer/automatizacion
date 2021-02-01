package com.qualitystream.tutorial;
//PAQUETES
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.KeyInput;
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

        driver.get("https://serene-kirch-6aa923.netlify.app/");
        Thread.sleep(2000);
    }


    @Test // aqui ejecutaremos las instrucciones
    public void testGooglePage() throws InterruptedException {

        WebElement campoNombre = driver.findElement(By.id("nombres"));
        campoNombre.clear();
        campoNombre.sendKeys("Loner");
        campoNombre.sendKeys(Keys.ENTER);
        System.out.println("Nombre colocado correctamente");


        Thread.sleep(1000);
        WebElement campoApellido = driver.findElement(By.id("apellidos"));
        campoApellido.clear();
        campoApellido.sendKeys("Stay Will");
        campoApellido.sendKeys(Keys.ENTER);
        System.out.println("Apellido colocado correctamente");

        Thread.sleep(1000);
        WebElement campoCorreo = driver.findElement(By.id("correo"));
        campoCorreo.clear();
        campoCorreo.sendKeys("noSurprises@hotmail.com");
        campoCorreo.sendKeys(Keys.ENTER);
        System.out.println("Correo colocado correctamente");

        Thread.sleep(1000);
        WebElement campoPass = driver.findElement(By.id("clave"));
        campoPass.clear();
        campoPass.sendKeys("cl366a");
        campoPass.sendKeys(Keys.ENTER);
        System.out.println("Clave colocada correctamente");
        Thread.sleep(3000);

        WebElement campoRes = driver.findElement(By.id("reset"));
        campoRes.sendKeys(Keys.ENTER);
        System.out.println("correcto");
        Thread.sleep(3000);

        System.out.println("Test Passed");


/*               !!!!!!!!POSIBLE AUTOMATIZACION DE JUEGO!!!!!!!!!!

        WebElement ele11=  driver.findElement(By.xpath("//*[@id=\"scene\"]"));
           Point eleect = ele11.getLocation();


        int xCoordinate = driver.findElement(By.xpath("/html/body/div[1]/canvas")).getLocation().getX();

        int yCoordinate = driver.findElement(By.xpath("/html/body/div[1]/canvas")).getLocation().getY();
        Thread.sleep(4000);
        System.out.println(eleect);
        System.out.println(xCoordinate);
        System.out.println(yCoordinate);

        Actions action= new Actions(driver);
        action.moveToElement(ele11).contextClick(ele11).sendKeys(Keys.NUMPAD6).sendKeys(Keys.NUMPAD8).build().perform();

        Thread.sleep(4000);

        System.out.println("correcto 222");
        */

    }

    @After
    public void CerrarGooglePage() {
        driver.quit();
    }
}

