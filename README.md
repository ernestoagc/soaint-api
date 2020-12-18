# SOAINT API
#### **1. EVIDENCIA DE EJECUCION DE PRUEBAS UNITARIAS.**
Se utilizo mockbean para la ejecución de los controladores del servicio. En la pruebas unitarias se establece escenarios como modificar un producto que no existe, o validacion de ingreso de campos obligatorios

![](https://i.ibb.co/2g9xz17/ejecucion-pruebas.jpg)

#### **2. Validaciones de los servicios personalizados**
Los mensajes de errores y validaciones  han sido puestos en el header de la respuesta del servicio, se establecio un codigo para cada tipo de error y validación. Estas validaciones estan concentradas en la clase BaseController.

![](https://i.ibb.co/vqm6XVh/producto-validacion.jpg)

#### **3.  Imagen docker**
Dentro de la solución esta el archivo dockerfile, para la construccion de la imagen se utiliza la solución que ha sido publicada en github.

*construccion de  imagen. utilizar comandos: docker build -t ernestoagc/soaint-prueba:0.4 .

Tambien se puede utilizar la version que se ha subido al repositorio de docker, para ello se ejecuta los comandos
docker pull ernestoagc/soaint-prueba:0.5

![](https://i.ibb.co/BssmhrS/construccion-imagen.jpg)

#### **4. Base de datos y script.**
Se utilizo mysql como motor de base de datos. Dentro de la carpeta resource esta el script del backup (dbSoaint.sql) del modelo de la base de datos.


![](https://i.ibb.co/2Wrgjg4/base-datos.jpg)

#### **5. Levantar ambiente de prueba para probar aplicacion**
Se van a utilizar dos contenedores para probar la aplicacion, la primera es para hospedar el servicio de la base de datos y la segunda para levantar la aplicacion

**Levantando contenedor mysql**
a) Ejecutar comando: 
*docker container run -d --network soaint-red  --name dbSoaintTest -p 3306:3306 -e MYSQL_ROOT_PASSWORD=password123 mysql:8.0*

b) Entrar a la consola del contener para crear la base de datos:  *docker exec -it dbSoaintTest  /bin/sh*

c) Identificarse en mysql: 
  -mysql -u root -p;
   -password123
   
 d) crear base datos: CREATE DATABASE dbSoaint;
 
 **Levantando contenedor de la aplicacion**
 ejecutar comandos: 
*docker run -p 8700:8700  -d --link dbSoaintTest:mysql  --network soaint-red  -e spring.profiles.active=test  --name=soaint-api ernestoagc/soaint-prueba:0.4*

**Importar coleccion de postman para ejecutar casos:**
Dentro de la carpeta resource esta el archivo que contiene la coleccion de postman para probar los casos.
![](https://i.ibb.co/8KGDT9F/postman-casos.jpg)