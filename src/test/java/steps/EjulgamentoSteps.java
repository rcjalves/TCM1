package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import screen.EjulgamentoScreen;

public class EjulgamentoSteps {

    EjulgamentoScreen ejulgamentoScreen = new EjulgamentoScreen();

    @Given("que o usuario acesse o sistema {string}")
    public void que_o_usuario_acesse_o_sistema(String url) {
        ejulgamentoScreen.acessarLogin(url,"318.467.772-91","12345");
    }

    @When("selecionar o departamento desejado {string}")
    public void selecionar_o_departamento_desejado(String departamento) {
        ejulgamentoScreen.selecionarDepartamento(departamento);
    }

    @Then("o sistema realiza o login com sucesso")
    public void o_sistema_realiza_o_login_com_sucesso() {
        ejulgamentoScreen.validarLogin();
    }
}
