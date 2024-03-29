package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage clickFormAuthentication()   {

        clickLink("Form Authentication");
        return new LoginPage(driver);
    }

    public DropdownPage clickDropDown() {
        clickLink("Dropdown");
        return new DropdownPage(driver);
    }

//    public HoversPage clickHovers(){
//        clickLink("Hovers");
//        return new HoversPage(driver);
//    }

    public InputPage clickInputs() {
        clickLink("Inputs");
        return new InputPage(driver);
    }

    public void clickLink(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }

}
