Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: ingresar un nuevo usuario
GivenStories: stories/visoraplicaciones/serenitytest/loguin_csv.story
When ingreso a la seccion de usuarios:
|usuario   |nombre|primerApellido|rol     |fechaInicio  |contrasena|confirmarContrasena|email            |sedepredeterminada|
|pruebancio|juan  |leon          |Farmacia|18/Enero/2015|prueba123$|prueba123$         |prueba@correo.com|Armenia           |