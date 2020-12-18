# SOAINT API
**EVIDENCIA DE EJECUCION DE PRUEBAS UNITARIAS.**
Se utilizo mockbean para la ejecución de los controladores del servicio. En la pruebas unitarias se establece escenarios como modificar un producto que no existe, o validacion de ingreso de campos obligatorios

![](https://i.ibb.co/2g9xz17/ejecucion-pruebas.jpg)

**Validaciones de los servicios personalizados**
Los mensajes de errores y validaciones  han sido puestos en el header de la respuesta del servicio, se establecio un codigo para cada tipo de error y validación. Estas validaciones estan concentradas en la clase BaseController.

![](https://i.ibb.co/vqm6XVh/producto-validacion.jpg)

** Imagen docker**
Dentro de la solución esta el archivo dockerfile, para la construccion de la imagen se utiliza la solución que ha sido publicada en github.
*construccion de  imagen
![](https://i.ibb.co/BssmhrS/construccion-imagen.jpg)

**Base de datos y script.**
Se utilizo mysql como motor de base de datos. Dentro de la carpeta resource esta el script del backup (dbSoaint.sql) del modelo de la base de datos.

![](https://i.ibb.co/2Wrgjg4/base-datos.jpg)
