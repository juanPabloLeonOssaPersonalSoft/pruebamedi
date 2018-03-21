package aplicacion.serenity.administradorusuarios;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import org.jbehave.core.model.ExamplesTable;

public class AdministradorUsuariosSteps extends ScenarioSteps {

    UsuariosPages usuariosPages=new UsuariosPages(getDriver());
    AdministradiorUsuariosPages administradiorUsuariosPages=new AdministradiorUsuariosPages(getDriver());

    public AdministradorUsuariosSteps(Pages pages){
        super(pages);
    }

    @Step
    public void ingresarDatosBasicosDeUsuario(ExamplesTable datosUsuario){
        usuariosPages.ingresarUsuario(datosUsuario);
        usuariosPages.ingresarNombre(datosUsuario);
        usuariosPages.ingresarPrimerApellido(datosUsuario);
        usuariosPages.ingresarRol(datosUsuario);
        usuariosPages.seleccionarFechaInicio(datosUsuario);
        usuariosPages.ingresarContrasena(datosUsuario);
        usuariosPages.ingresarConfirmarContrasena(datosUsuario);
        usuariosPages.ingresarEmail(datosUsuario);
    }

    @Step
    public void seleccionarNuevoUsuario(){
       administradiorUsuariosPages.ingresarEnOpcionNuevo();
    }

    @Step
    public void seleccionarCede(ExamplesTable datosUsuario){
        usuariosPages.seleccionarSedes();
        usuariosPages.seleccionarTodasLasSedes();
        usuariosPages.seleccionarSedePredeterminada(datosUsuario);
    }

}
