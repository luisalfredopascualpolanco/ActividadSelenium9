import driverConfiguracion.Inicio;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SecureAreaPage;
import org.openqa.selenium.Dimension;

import static org.testng.Assert.assertTrue;

public class pruebaLogin extends Inicio {

//HomePage homePage;
    //Datos Validos para loggin
    @Test
    public void loginSatisfactorio() throws InterruptedException {
        LoginPage loginPage = homepage.clickFormAuthentication();
        loginPage.setUsername("LuisPascual");
        loginPage.setPassword("123456789");
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();

        assertTrue(secureAreaPage.getAlertText()
                        .contains("Tu usuario ha sido validado"),
                "Alerta texto invalido");
    }


    //    usuario invalido

    @Test
    public void usuarioIncorrecto() throws InterruptedException {
        LoginPage loginPage = homepage.clickFormAuthentication();
        loginPage.setUsername("nosoyluis");
        loginPage.setPassword("123456789");
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();

        assertTrue(secureAreaPage.getAlertText()
                        .contains("Usuario invalido"),
                "Alerta texto invalido");
    }

    @Test
    public void contrasenaIncorrecta() throws InterruptedException {

        LoginPage login = homepage.clickFormAuthentication();
        login.setUsername("LuisPascual");
        login.setPassword("987654321"); // password incorrect
        SecureAreaPage secureAreaPage = login.clickLoginButton();

        assertTrue(secureAreaPage.getAlertText()
                        .contains("Tu contrasena es invalida"),
                "Alerta texto incorrecto");
    }




}
