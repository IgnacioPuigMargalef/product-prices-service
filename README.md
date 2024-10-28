# Product Prices Service

**Product Prices Service** es una aplicación desarrollada en Java que permite obtener el precio de productos en tiempo real basándose en criterios como el `productId`, `brandId` y `dateRequest`.

### Tabla de Contenidos

- [Descripción de la Prueba](#descripción-de-la-prueba)
- [Tecnologías Usadas](#tecnologías-usadas)
- [Explicación de la solución propuesta](#explicación-de-la-solución-propuesta)
- [Instalación](#instalación)
- [Prueba](#prueba)

---

# Descripción de la Prueba
La prueba técnica tiene como objetivo implementar un servicio REST que permita obtener el precio de un producto en función de varios criterios. Para ello, se deberá crear una API REST que reciba los parámetros productId, brandId y dateRequest (fecha y hora de la consulta) y devuelva el precio correspondiente a ese producto, dependiendo de las reglas de negocio predefinidas.

# Tecnologías Usadas
Para la realizacion de esta prueba, se ha usado las siguientes tecnologias:
  - Spring Boot 3.3.5
  - Open JDK 21 (Java 21)
  - Maven 3.8.x
  - Docker

Como dependencias dentro del proyecto, se han incluido:
  - Spring Boot DevTools (como apoyo al desarrollo)
  - Lombok
  - Spring web MVC
  - Jdbc api
  - H2 database
  - Mapstruct

# Explicación de la solución propuesta
Para desarrollar la [solución descrita](#descripción-de-la-prueba), se ha implementado Arquitectura Hexagonal.

<p align="center">
  <img src="https://github.com/user-attachments/assets/876f9430-edac-4f31-a87a-e617deda412c" alt="Diagrama arquitectura">
</p>

La aplicación se compone de varias capas principales, cada una encargada de una responsabilidad específica, y de adaptadores que permiten la comunicación con el exterior y entre módulos internos. A continuación, se explica cómo están organizadas las diferentes capas y adaptadores en el proyecto:

### Dominio
En la capa de dominio, he definido la única entidad que se maneja: **Prices**. En esta, se pretende reflejar el precio de un producto, el cual puede ser cambiante según la tarifa que aplique.
Para crear un dominio más robusto, se ha introducido un principio de **Domain Driven Design** llamado **Value Object**, al que he llamado Currency. En este, separamos la lógica específica del mismo para evitar futuras sobrecargas de validaciones en la entidad Prices. Esto se puede ver en la siguiente figura:
<p align="center">
  <img src="https://github.com/user-attachments/assets/612292fc-cbc7-4dcd-9bd7-f2c1ad239526" alt="Diagrama entidades de dominio">
</p>


### Aplicacion
En la capa de **aplicación**, definiremos los puertos, es decir, interfaces abstraídas de toda infraestructura tecnológica como frameworks, librerías, bases de datos, etc. Además, definiremos la lógica de los casos de uso/servicios de los puertos de entrada, teniendo en cuenta la misma restricción.
Se han definido dos puertos:
  - ### PricesInPort
    Este define las funciones que representarán el comportamiento de entrada a la aplicación. En jerga técnica, está dentro del "Driving side".
  - ### PricesOutPort
    Este define las funciones de comunicación con la base de datos, abstraído del tipo de base de datos utilizada.
    
Además, como se ha comentado, se desarrolla el servicio que actuará como "Bean" para el **PricesInPort**. En otras implementaciones, podríamos encontrarlo como "Use Cases". Como nota, cabe mencionar que la implementación de este bean, para abstraernos completamente del framework, se desarrolla en una clase llamada BeanConfiguration.


### Infraestructura
Por último, y como ya hemos mencionado, la capa de infraestructura se encarga de implementar un framework, librería, base de datos o tipo de entrada, consiguiendo desacoplarlo del core de la aplicación.Se ha utilizado:
  - ### Api HTTP Rest
    Define la entrada en la aplicación, usando las dependencias que nos provee Spring Web MVC.
  - ### Base de datos H2
  Funciona como base de datos en memoria y se inicia automáticamente al iniciar la aplicación.

# Instalación
### Requisitos
  1. Tener instalado docker en su ultima version: https://get.docker.com/

### Instrucciones
  1. Clonar este repositorio.
  2. Situarnos dentro de la carpeta del proyecto, donde se encuentra el dockerfile.
  3. Crear la imagen con el comando "docker build -t product-price-container .".
  4. Arrancar la imagen con el comando "docker run -p 8080:8080 product-price-container".
     
# Prueba
Tras arrancar, se ha configurado una instruccion para ejecutar los 5 test que se adjuntan en la prueba, justo antes de levantar la aplicacion que podremos encontrar en el puerto indicado en el paso 4 de las instrucciones.
Para probar el endpoint definido, se adjunta en el repositorio una coleccion de postman con los datos ya preparados.








