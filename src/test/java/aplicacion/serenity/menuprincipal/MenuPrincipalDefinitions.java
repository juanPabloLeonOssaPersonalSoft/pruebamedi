package aplicacion.serenity.menuprincipal;

import aplicacion.serenity.administradorusuarios.AdministradorUsuariosSteps;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

public class MenuPrincipalDefinitions {

    @Steps
    MenuPrincipalSteps menuPrincipalSteps;

    @Steps
    AdministradorUsuariosSteps administradorUsuariosSteps;

    @When("ingreso a la seccion de usuarios:$datosUsuario")
    public void ingresarEnMenuUsuarios(ExamplesTable datosUsusario){
        menuPrincipalSteps.ingresarEnMenuPrincipal();
        menuPrincipalSteps.ingresarEnMenuUsuarios();
        administradorUsuariosSteps.seleccionarNuevoUsuario();
        administradorUsuariosSteps.ingresarDatosBasicosDeUsuario(datosUsusario);
        administradorUsuariosSteps.seleccionarCede(datosUsusario);
        //administradorUsuariosSteps.seleccionarFechaInicio(datosUsusario);
        //administradorUsuariosSteps.seleccionarFechaFin(datosUsusario);
    }
}
