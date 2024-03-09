package driverConfiguracion;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;


import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import pages.HomePage;


public class Inicio {

  private WebDriver driver;
  protected HomePage homepage;

  // para que sea ejecutado primero
  @BeforeMethod
  public void setUp() {
//

    WebDriverManager.edgedriver().setup();
    EdgeOptions edgeOptions = new EdgeOptions();
    edgeOptions.addArguments("--disable-popup-blocking");
    edgeOptions.addArguments("--inprivate");
    // edgeOptions.addArguments("--headless");


    driver = new EdgeDriver(edgeOptions);
    driver.get("https://the-internet.herokuapp.com/");
    driver.manage().window().maximize();
    homepage = new HomePage(driver);




  }

  @AfterMethod
  public void tearDown() {
    driver.quit();
  }


}
