package screen;

import atributes.EjulgamentoAtributes;
import metodos.Metodos;

public class EjulgamentoScreen {

	Metodos metodos = new Metodos();
	EjulgamentoAtributes ejulgamentoatributes = new EjulgamentoAtributes();
	
	public void acessarLogin(String url,String usuario,String senha) {
		metodos.abrirNavegador(url);
		metodos.inserirValorInput(ejulgamentoatributes.getFIELD_USUARIO(),usuario);
		metodos.inserirValorInput(ejulgamentoatributes.getFIELD_SENHA(),senha);
	}
	
	public void selecionarDepartamento(String departamento) {
		
	}
	
	public void validarLogin() {
		
	}
	
}
