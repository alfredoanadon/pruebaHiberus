# Prueba Hiberus
Prueba tecnica de API y microservicios con Spring Hiberus

A continuacion dejo tanto el modelo Entidad-Relacion asi como el proyecto de Eclipse donde
he ralizado la prueba tecnica dentro del plazo orientativo de 3 horas.

Hay clases de prueba de conexion a mi bbdd asi como la clase Usuario.java y Slogan.java
donde se describen los parametros para definir un objeto de sendos tipos asi como los metodos de
login/unlog, insertar/eliminar slogans de un Usuario.

La base de Datos esta realizada en mySQL y el mapeo de las columnas de cada tabla esta hecho con Hibernate.

## Requisitos

* Tener instalado un IDE con Java asi como el JDK dentro del sistema. Este proyecto se ha desarrollado en Eclipse
* Tener instalado un gestor de base de datos relacional. En este proyecto se ha usado mySQL Workbench

## Datos de prueba

Para la prueba se ha creado un Usuario usuario1 y se ha creado un slogan el cual se ha insertado a Usuario
tras haber realizado un loggin. Posteriormente se insertan esos datos en la tabla de la base de datos,se
guardan y se finaliza la conexion.
