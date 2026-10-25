# SIGP — Módulo de gestión de tareas

**Evidencia:** GA7-220501096-AA2-EV02 — Módulos de software codificados y probados.

## Propósito
Módulo demostrativo del Sistema de Información y Gestión de Proyectos (SIGP). Permite registrar tareas con prioridad y consultar el listado durante la sesión del navegador.

## Tecnologías
- Java (código fuente configurado para Java 17 o superior)
- Jakarta Servlet 6.0
- HTML5 y formularios GET/POST
- JSP
- Maven para empaquetar como WAR
- Apache Tomcat 10.1

Tomcat 10.1 implementa Servlet 6.0 y JSP 3.1; por eso este proyecto utiliza los paquetes `jakarta.servlet`. Documentación oficial: https://tomcat.apache.org/tomcat-10.1-doc/

## Requisitos para ejecutar
1. JDK instalado.
2. Apache Maven instalado.
3. Apache Tomcat 10.1 instalado.

## Compilar
Desde la carpeta que contiene `pom.xml`, ejecutar:

```bash
mvn clean package
```

Se generará `target/SIGP.war`.

## Ejecutar en Tomcat
1. Copiar `target/SIGP.war` a la carpeta `webapps` de Tomcat.
2. Iniciar Tomcat.
3. Abrir `http://localhost:8080/SIGP/`.
4. Registrar una tarea y luego consultar el listado.

## Pruebas funcionales manuales
1. Abrir `index.html` desde la aplicación desplegada.
2. Enviar el formulario con nombre y prioridad: debe registrar la tarea mediante POST.
3. Pulsar “Consultar tareas (GET)”: debe mostrar el listado.
4. Enviar el formulario vacío: el navegador debe impedirlo por el atributo `required`.
5. Registrar varias tareas: deben aparecer en la lista de la misma sesión.

## Métodos implementados
- `doGet`: consulta tareas y presenta la vista JSP.
- `doPost`: recibe y valida los datos del formulario, registra la tarea y redirige al listado.
- `tareas.jsp`: muestra las tareas y un mensaje de resultado.

## Alcance y limitaciones
Esta versión académica guarda las tareas en la sesión del usuario; no utiliza base de datos, por lo que los datos no son permanentes y no se comparten entre usuarios. Puede ampliarse posteriormente con entidades Proyecto, Usuario y Estado y una base de datos.

## Control de versiones
Comandos sugeridos desde la carpeta del proyecto:

```bash
git init
git add .
git commit -m "Crear modulo SIGP de gestion de tareas"
```

Luego crea un repositorio propio en GitHub y conecta su URL:

```bash
git branch -M main
git remote add origin URL_DE_TU_REPOSITORIO
git push -u origin main
```
