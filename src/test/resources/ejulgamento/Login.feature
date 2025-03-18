@tag
Feature: Login
  

  @tag1
  Scenario: Login com sucesso
    Given que o usuario acesse o sistema "http://172.20.134.14/ejulgamento/dpl_login/"
		When selecionar o departamento desejado "departamento"
		Then o sistema realiza o login com sucesso
  
     