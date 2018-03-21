package aplicacion.serenity.menuprincipal;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class MenuPrincipalSteps extends ScenarioSteps {

    MenuPrincipalPages menuPrincipalPages= new MenuPrincipalPages(getDriver());
    AdministracionPages administracionPages= new AdministracionPages(getDriver());


    public MenuPrincipalSteps(Pages pages) {
        super(pages);
    }

    @Step
    public void ingresarEnMenuPrincipal(){
        menuPrincipalPages.seleccionarMenuPrincipal();
    }

    @Step
    public void ingresarEnMenuUsuarios(){
        menuPrincipalPages.seleccionarAdministracion();
        administracionPages.seleccionarUsuariosMenu();
    }
}
