package atributes;

import org.openqa.selenium.By;

public class EjulgamentoAtributes {

	private By FIELD_USUARIO = By.id("id_sc_field_login");
	private By FIELD_SENHA = By.id("id_sc_field_senha");
	private By BTN_LOGIN = By.xpath("//*[@id='sub_form_b']");
	
	public By getFIELD_USUARIO() {
		return FIELD_USUARIO;
	}
	public By getFIELD_SENHA() {
		return FIELD_SENHA;
	}
	public By getBTN_LOGIN() {
		return BTN_LOGIN;
	}
	
	
	
	
	
}
