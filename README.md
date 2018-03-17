# Red Social SDI

[![Build Status](https://travis-ci.com/antonioalfa22/RedSocial-SDI.svg?token=paxWmMD1E3zNeS1ssC5y&branch=master)](https://travis-ci.com/antonioalfa22/RedSocial-SDI)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/8fd426065496482e9138d81312c74542)](https://www.codacy.com?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=antonioalfa22/RedSocial-SDI&amp;utm_campaign=Badge_Grade)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

*Red social realizada con [Spring boot](https://projects.spring.io/spring-boot/)  para la asignatura de SDI*

*Repositorio con las pruebas hechas con Selenium -> [RedSocial-SDI-Test](https://github.com/antonioalfa22/RedSocial-SDI-Test)*

## Descripción

Esta aplicación se trata de una red social en la que los usuarios pueden registrarse, crear publicaciones, enviar
invitaciones de amistad, listar usuarios registrados y el resto de opciones que comúnmente se pueden hacer en 
una red social.

## Autores

* Antonio Payá González(UO251065)
* Pablo Díaz Rancaño(UO251017)

## Manual de uso

### Ejecución

#### Prerequisitos

Para poder ejecutar la aplicación necesitaremos:

##### 1. Java JDK

Se necesita tener instalado correctamente y configurado en las variables de entorno del sistema el JDK de Java.

Para más información visita [Java JDK](http://www.oracle.com/technetwork/es/java/javase/downloads/index.html)

##### 2. Maven

Maven es una herramienta de software para la gestión y construcción de proyectos Java basado en un formato xml.
Se debe tener instalado correctamente y configurado en las variables de entorno del sistema.

Para más información visita [Maven](https://maven.apache.org/download.cgi)

##### 3. Git

Git se usará para poder descargar el proyecto, por lo que no es estríctamente necesario, pero sí recomendable, ya que mediante el uso de git nos aseguraremos de tener la última versión del proyecto.

##### 4. Spring-Boot STS

Al igual que Git, el entorno de desarrollo integrado [Spring Boot STS](https://spring.io/tools/sts/all) no es estríctamente necesario. Es el IDE que ofrece Spring para trabajar con el framework y es el que recomendamos.

#### Lanzamiento

El primer paso que debemos hacer es descargarnos el código fuente, para ello podemos hacerlo mediante git con el comando:

```git
$ git clone https://github.com/antonioalfa22/RedSocial-SDI.git
```

Si no tenemos instalado Git podemos descargarnos el código fuente en formato [zip](https://github.com/antonioalfa22/RedSocial-SDI/archive/master.zip)

Para ejecutar la aplicación en Windows tenemos que iniciar el servidor HSQLDB jecutando el archivo: `db/bin/runDB.bat`

Una vez levantada la base de datos ejecutamos el proyecto spring-boot, para ello podemos hacerlo de tres formas:

1. Por línea de comandos:

```bash
$ mvn spring-boot:run
```

2. Ejecutando el archivo _run.bat_

3. Mediante Spring-Boot STS, importamos el proyecto como un proyecto maven, y ejecutamos el mismo como "Spring boot Application"


## Javadoc

[Javadoc de RedSocial-SDI](https://antonioalfa22.github.io/RedSocial-SDI/)


