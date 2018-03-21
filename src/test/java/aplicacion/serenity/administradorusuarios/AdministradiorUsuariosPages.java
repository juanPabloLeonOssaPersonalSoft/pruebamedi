package aplicacion.serenity.administradorusuarios;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AdministradiorUsuariosPages extends PageObject {

    @FindBy(xpath = "//*[@id='user']")
    WebElementFacade txtUsuario;

    @FindBy(xpath = "//*[@id='nombre']")
    WebElementFacade txtNombres;

    @FindBy(xpath = "//*[@id='simContainer']/ng-component/div/div/div/div[2]/div[1]/div/form/div[3]/div[2]/ngl-virtual-select/a[1]/input")
    WebElementFacade selRol;

    @FindBy(xpath = "//*[@id='simContainer']/ng-component/div/div/div/div[2]/div[2]/button[1]")
    WebElementFacade btnConsultar;

    @FindBy(xpath = "//*[@id='simContainer']/ng-component/div/div/div/div[2]/div[2]/button[2]")
    WebElementFacade btnNuevo;

    public WebDriver driver;

    public AdministradiorUsuariosPages(WebDriver driver){
        super(driver);
        this.driver=driver;
    }

    public void ingresarEnOpcionNuevo(){
        esperar(4);
        btnNuevo.click();
    }

    private void esperar(int timeInMilliseconds){
        try {
            Thread.sleep(timeInMilliseconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }




}
