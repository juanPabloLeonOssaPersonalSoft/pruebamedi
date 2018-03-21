package aplicacion.serenity.login.definitions;

import aplicacion.serenity.menuprincipal.MenuPrincipalSteps;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import aplicacion.serenity.login.steps.LoginSteps;
import static net.thucydides.core.steps.stepdata.StepData.withTestDataFrom;


public class LoginDefinitions {

    @Steps
    LoginSteps loginSteps;

    @Steps
    MenuPrincipalSteps menuPrincipalSteps;

    @Given("como usuario ingreso a la pagina de Medicarte")
    public void ingresarSitio(){
        loginSteps.ingresar();
    }

    @When("ingreso las credenciales:$logueo")
    public void ingresarDatosLogueo(ExamplesTable logueo){
        loginSteps.ingresarDatosLogin(logueo);
    }

    @When("ingreso las credenciales")
    public void ingresarDatosLogueo() throws Throwable{
        loginSteps.ingresarDatosLogin(loginSteps.datosCsvAExampleTable());
     }

    @Then("ingreso a la pagina prinacipal del sitio")
    public void  verificarIngreso(){
    }
}