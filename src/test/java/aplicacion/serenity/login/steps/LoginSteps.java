package aplicacion.serenity.login.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import net.thucydides.core.steps.stepdata.CSVTestDataSource;
import net.thucydides.core.steps.stepdata.TestDataSource;
import org.jbehave.core.model.ExamplesTable;
import aplicacion.serenity.login.pages.LoginPages;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LoginSteps extends ScenarioSteps {

    private static final String SEPARADOR = "|";
    private static final String SALTOLINEA = "\n";



    LoginPages loginPages=new LoginPages(getDriver());

    public LoginSteps(Pages pages){
        super(pages);
    }

    public  ExamplesTable datosCsvAExampleTable() throws IOException {
        TestDataSource testData = new CSVTestDataSource("src/resources/dataLogueo.csv", ';');
        List<Map<String, String>> loadedData = testData.getData();
        List<String> cabeceras = testData.getHeaders();
        StringBuilder tablaComoCadena = new StringBuilder();
        Iterator<String> iteradorCabeceras = cabeceras.iterator();
        tablaComoCadena.append(SEPARADOR);
        while (iteradorCabeceras.hasNext()) {
            tablaComoCadena.append(iteradorCabeceras.next() + SEPARADOR);
        }
        tablaComoCadena.append(SALTOLINEA);
        for (Map<String, String> map : loadedData) {
            tablaComoCadena.append(SEPARADOR);
            iteradorCabeceras = cabeceras.iterator();
            while (iteradorCabeceras.hasNext()) {
                tablaComoCadena.append(map.get(iteradorCabeceras.next()) + SEPARADOR);
            }
            tablaComoCadena.append(SALTOLINEA);
        }
        return new ExamplesTable(tablaComoCadena.toString());
    }

    @Step
    public void ingresar(){
        loginPages.open();
    }

    @Step
    public void ingresarDatosLogin(ExamplesTable datos){
        loginPages.ingresarUsuario(datos);
        loginPages.ingresarPassword(datos);
        loginPages.clicIngresar();
    }

    @Step
    public void ingresarDatoUsuario(String usuario){
        loginPages.ingresarUsuario(usuario);
    }

    @Step
    public void ingresarDatoPassword(String password){
        loginPages.ingresarPassword(password);
    }

    @Step
    public void ingresarEnSitio(){
        loginPages.clicIngresar();
    }
}


