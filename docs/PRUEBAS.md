# Registro de pruebas

## Estado
Casos de prueba propuestos para ejecutar después de desplegar en Tomcat. No se afirma que la aplicación ya haya sido ejecutada en el equipo del aprendiz.

| ID | Caso | Resultado esperado |
|---|---|---|
| CP-01 | Abrir la página principal | Se visualiza el formulario SIGP |
| CP-02 | Enviar tarea válida mediante POST | Se muestra mensaje de registro correcto y la tarea en el listado |
| CP-03 | Consultar tareas mediante GET | Se visualiza el listado de la sesión |
| CP-04 | Intentar enviar el formulario sin nombre | El navegador solicita completar el campo |
| CP-05 | Registrar tarea con caracteres como `<` o `&` | Los caracteres se muestran escapados en el listado |

## Evidencia recomendada
Tomar capturas reales del navegador al ejecutar CP-01, CP-02 y CP-03 y agregarlas al informe de entrega.
