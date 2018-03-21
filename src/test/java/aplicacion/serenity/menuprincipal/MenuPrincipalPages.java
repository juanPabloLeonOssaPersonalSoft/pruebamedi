package aplicacion.serenity.menuprincipal;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class MenuPrincipalPages extends PageObject {

    @FindBy(xpath = "//*[@id='simHeader']/ul[1]/li[1]/a")
    WebElementFacade lnkMenuPrincipal;

    @FindBy(xpath = "//*[@id='simSidebar']/ul/li[1]/a")
    WebElementFacade lnkAdministracion;


    public WebDriver driver;

    public MenuPrincipalPages(WebDriver driver){
        super(driver);
        this.driver=driver;
    }

    public void seleccionarMenuPrincipal(){
        esperar(5);
        lnkMenuPrincipal.click();
        esperar(3);
    }

    public void seleccionarAdministracion(){
        esperar(3);
        lnkAdministracion.click();

    }

    private void esperar(int timeInMilliseconds){
        try {
            Thread.sleep(timeInMilliseconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
