Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: logueo en aplicacion Medicarte
Given como usuario ingreso a la pagina de Medicarte
When ingreso las credenciales:
|usuario|contrasena|
|admin|admin123*|
Then ingreso a la pagina prinacipal del sitio
