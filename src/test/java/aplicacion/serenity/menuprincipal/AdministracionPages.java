package aplicacion.serenity.menuprincipal;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AdministracionPages extends PageObject {


    @FindBy(xpath = "//*[@id='simSidebar']//div[contains(text(),'Usuarios')]")
    WebElementFacade lnkUsuarios;

    public WebDriver driver;


    public AdministracionPages(WebDriver driver){
        super(driver);
        this.driver=driver;
    }

    public void seleccionarUsuariosMenu(){
        lnkUsuarios.click();
    }
}
