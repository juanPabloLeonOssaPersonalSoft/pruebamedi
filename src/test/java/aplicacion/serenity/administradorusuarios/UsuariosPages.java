package aplicacion.serenity.administradorusuarios;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.PageUrls;
import net.serenitybdd.core.pages.WebElementFacade;
import org.jbehave.core.model.ExamplesTable;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;

public class UsuariosPages extends PageObject {

    @FindBy(xpath = "//*[@id='simContainer']/ng-component/div[1]/div/div[2]/form/div[1]/div[2]/input")
    WebElementFacade txtUsuario;

    @FindBy(xpath = "//*[@id='simContainer']/ng-component/div[1]/div/div[2]/form/div[2]/div[2]/input")
    WebElementFacade txtNombres;

    @FindBy(xpath = "//*[@id='simContainer']/ng-component/div[1]/div/div[2]/form/div[3]/div[2]/input")
    WebElementFacade txtPrimerApellido;

    @FindBy(xpath = "//*[@id='simContainer']/ng-component/div[1]/div/div[2]/form/div[4]/div[2]/input")
    WebElementFacade txtSegundoApellido;

    @FindBy(xpath = "//*[@id='simContainer']/ng-component/div[1]/div/div[2]/form/div[5]/div[2]/ngl-virtual-select/a[1]/input")
    WebElementFacade selRol;

    @FindBy(xpath = "//*[@id='simContainer']/ng-component/div[1]/div/div[2]/form/div[5]/div[2]/ngl-virtual-select/a[2]/input")
    WebElementFacade txtRol;

    @FindBy(xpath = "//*[@id='simContainer']/ng-component/div[1]/div/div[2]/form/div[6]/div[2]/p-calendar/span/input")
    WebElementFacade selFechaInicio;

    @FindBy(xpath = "//*[@id='simContainer']/ng-component/div[1]/div/div[2]/form/div[7]/div[2]/p-calendar/span/input")
    WebElementFacade selFechaFin;

    @FindBy(xpath = "//*[@id='Password']")
    WebElementFacade txtcontrasena;

    @FindBy(xpath = "//*[@id='ConfirmPassword']")
    WebElementFacade txtConfirmarContrasena;

    @FindBy(xpath = "//*[@id='email']")
    WebElementFacade txtEmail;

    @FindBy(xpath = "//*[@id='btnSelectLocations']")
    WebElementFacade btnSeleccionarSedes;

    @FindBy(xpath = "//*[@id='simContainer']/ng-component/div[2]/div/div/div[2]/div[1]/table/thead/tr/th[2]/a[1]")
    WebElementFacade lnkTodasLasSedes;

    @FindBy(xpath = "//*[@id='simContainer']/ng-component/div[2]/div/div/div[2]/div[2]/button[1]")
    WebElementFacade bntAceptarCedes;


    public WebDriver driver;

    public UsuariosPages(WebDriver driver){
        super(driver);
        this.driver=driver;
    }

    public void seleccionarFecha(String dia,String mes, String anio,String xpathSelectorMes,String xpathSelectorAnio,String tablaFecha){
        String diaTemporal=dia;
        String mesTemporal=mes;
        String anioTemporal=anio;
        esperar(2);
        selFechaInicio.click();
        Select selMes= new Select(driver.findElement((By.xpath(xpathSelectorMes))));
        selMes.selectByVisibleText(mesTemporal);
        Select selAnio= new Select(driver.findElement((By.xpath(xpathSelectorAnio))));
        esperar(2);
        selAnio.selectByVisibleText(anioTemporal);
        esperar(2);
        WebElement dateWidgetFrom = driver.findElement(By.xpath(tablaFecha));
        List<WebElement> columns = dateWidgetFrom.findElements(By.tagName("td"));
        for (WebElement cell: columns) {
            if(cell.getText().equals(diaTemporal)){
                cell.click();
                esperar(2);
                break;
            }
        }
    }
    public void seleccionarFechaInicio(ExamplesTable datosUsuario){
        String xpathSelectorMes="//*[@id='simContainer']/ng-component/div[1]/div/div[2]/form/div[6]/div[2]/p-calendar/span/div/div/div/select[1]";
        String xpathSelectorAnio="//*[@id='simContainer']/ng-component/div[1]/div/div[2]/form/div[6]/div[2]/p-calendar/span/div/div/div/select[2]";
        String xpathTablaFecha="//*[@id='simContainer']/ng-component/div[1]/div/div[2]/form/div[6]/div[2]/p-calendar/span/div/table";
        String fechaCompletaInicio= datosUsuario.getRow(0).get("fechaInicio");
        String[] partesDeFecha= fechaCompletaInicio.split("/");
        String diaInicio=partesDeFecha[0];
        String mesInicio=partesDeFecha[1];
        String anioInicio=partesDeFecha[2];
        esperar(2);
        selFechaInicio.click();
        seleccionarFecha(diaInicio,mesInicio,anioInicio,xpathSelectorMes,xpathSelectorAnio,xpathTablaFecha);
    }

    public void ingresarUsuario(ExamplesTable datosUsuario){
        esperar(3);
        txtUsuario.type(datosUsuario.getRow(0).get("usuario"));
        esperar(3);
    }

    public void ingresarNombre(ExamplesTable datosUsuario){
        txtNombres.type(datosUsuario.getRow(0).get("nombre"));
    }

    public void ingresarPrimerApellido(ExamplesTable datosUsuario){
        txtPrimerApellido.type(datosUsuario.getRow(0).get("primerApellido"));
    }

    public void ingresarSegundoApellido(ExamplesTable datosUsuario){
        txtSegundoApellido.type(datosUsuario.getRow(0).get("segundoApellido"));
    }

    public void ingresarRol(ExamplesTable datosUsuario){
        esperar(2);
        selRol.click();
        txtRol.type(datosUsuario.getRow(0).get("rol"));
        txtRol.sendKeys(Keys.ENTER);
    }

    public void ingresarContrasena(ExamplesTable datosUsusario){
        txtcontrasena.type(datosUsusario.getRow(0).get("contrasena"));
    }

    public void ingresarConfirmarContrasena(ExamplesTable datosUsusario){
        txtConfirmarContrasena.type(datosUsusario.getRow(0).get("confirmarContrasena"));
    }

    public void ingresarEmail(ExamplesTable datosUsusario){
        txtEmail.type(datosUsusario.getRow(0).get("email"));
    }

    public void seleccionarSedes(){
        btnSeleccionarSedes.click();
    }

    public void seleccionarTodasLasSedes(){
        lnkTodasLasSedes.click();
    }

    public void seleccionarSedePredeterminada(ExamplesTable datosUsuario){
        String sedePredeterminada= datosUsuario.getRow(0).get("sedepredeterminada");
        String xpathOriginalSedePredeterminada= "//*[@id='simContainer']//table/tbody/tr[contains(.,'comodin')]/td[3]/label ";
        String xpatSedePredeterminada=xpathOriginalSedePredeterminada.replace("comodin",sedePredeterminada);
        $(xpatSedePredeterminada).click();
        esperar(2);
        bntAceptarCedes.click();
    }

    public void cargarArchivo(String urlFile){
        WebElement element = driver.findElement(By.xpath("//input[@type='file']"));
        WebElement btnCargarArchivo=driver.findElement(By.xpath("//*[@id='divProfesional']/div[2]/div[2]/div[2]/div/button"));
        LocalFileDetector detector = new LocalFileDetector();
        File file = detector.getLocalFile(urlFile);
        element.sendKeys(file.getAbsolutePath());
        btnCargarArchivo.click();
    }

    private void esperar(int timeInMilliseconds){
        try {
            Thread.sleep(timeInMilliseconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
