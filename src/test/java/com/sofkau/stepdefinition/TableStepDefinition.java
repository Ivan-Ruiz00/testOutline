package com.sofkau.stepdefinition;
import com.sofkau.page.FormPage;
import com.sofkau.setup.WebUI;
import org.apache.log4j.Logger;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class TableStepDefinition extends WebUI {
    public static Logger LOGGER = Logger.getLogger(String.valueOf(TableStepDefinition.class));
    @Given("el administrador esta en la pagina principal")
    public void elAdministradorEstaEnLaPaginaPrincipal() {
        generalSetUp();
        LOGGER.info("Inicio de la Automatizacion");
    }
    @When("navega hasta la opcion de webTables")
    public void navegaHastaLaOpcionDeWebTables() throws InterruptedException {
        FormPage formPage = new FormPage(super.driver);
        formPage.clickForm();
    }
    @When("completa la informacion el primer nombre {string}, apellido {string}, edad {int}, correo electronico {string}, salario {int}, departamento {string}")
    public void completaLaInformacionElPrimerNombreApellidoEdadCorreoElectronicoSalarioDepartamento(String string, String string2, Integer int1, String string3, Integer int2, String string4) {

    }
    @Then("debe observar la tabla con la informacion ingresada")
    public void debeObservarLaTablaConLaInformacionIngresada() {

    }
}
