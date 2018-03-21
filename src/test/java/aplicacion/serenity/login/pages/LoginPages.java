package aplicacion.serenity.login.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.jbehave.core.model.ExamplesTable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DefaultUrl("https://medicarte.personalsoft.net:4432/#/login")
public class LoginPages extends PageObject {

    @FindBy(xpath = "/html/body/login/div[2]/div/div/div/div/form/div[1]/div[2]/input")
    WebElementFacade txtUsuario;

    @FindBy(xpath = "/html/body/login/div[2]/div/div/div/div/form/div[1]/div[3]/input")
    WebElementFacade txtPassword;

    @FindBy(xpath = "/html/body/login/div[2]/div/div/div/div/form/div[1]/div[4]/button")
    WebElementFacade btnIngresar;

    public WebDriver driver;

public LoginPages(WebDriver driver){
    super(driver);
    this.driver=driver;
}

public  void ingresarUsuario(ExamplesTable datos){
    txtUsuario.type(datos.getRow(0).get("usuario"));

}

public void ingresarPassword(ExamplesTable datos){
    txtPassword.type(datos.getRow(0).get("password"));
}

public  void ingresarUsuario(String usuario){
        txtUsuario.type(usuario);
}

public void ingresarPassword(String password){
        txtPassword.type(password);
}

public void clicIngresar(){
    btnIngresar.click();
}

}
