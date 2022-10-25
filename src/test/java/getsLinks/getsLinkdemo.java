package getsLinks;

import actions.ManejoDeArchivos;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class getsLinkdemo {

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        //PhantomJSOptions options = new PhantomJSOptions();
        /*File src = new File("C:\\browser\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
        System.setProperty("phantomjs.binary.path",src.getAbsolutePath());*/


        /*DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "C:\\browser\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
        driver = new PhantomJSDriver(caps);*/
        ChromeOptions opt= new ChromeOptions();
        opt.addExtensions(new File("C:\\getLink\\src\\test\\java\\resources\\1.44.4_0.crx"));

        WebDriverManager.chromedriver().setup();

        driver= new ChromeDriver(opt);
        //driver.manage().window().setPosition(new Point(10000,200));;
        driver.get("https://www.cursosdev.com/coupons");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();



    }

    @Test
    public void  alltest() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        int cantidad=1;
        String ge="";
        String rutaAndName = "C:\\getLink\\src\\test\\java\\listaCup\\listOfCoupon.txt";
        ManejoDeArchivos.crearArchivo(rutaAndName);
        while(cantidad <=18){
            if(cantidad==6 || cantidad==16){
                js.executeScript("window.scrollBy(0,1000)");
            }

            try{
                driver.findElement(By.xpath("/html/body/main/div[4]/div["+cantidad+"]/a/div[2]/div[1]/div[1]/span[1]")).click();

                ge=driver.findElement(By.xpath("//a[contains(text(),'Obtener')]")).getAttribute("href");


                ManejoDeArchivos.anexarArchivo(rutaAndName,"\n"+ge);
                System.out.println(ge);

                driver.navigate().back();
            } catch (Exception e) {

            }




            cantidad=cantidad+1;
            System.out.println(cantidad);
        }

    }
    @AfterClass
    public void close(){
        driver.quit();
    }

}
