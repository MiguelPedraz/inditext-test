# inditext-test

## 1. Proyecto completo

### 1.1 Arrancar proyecto

Ejecutar tanto eureka-server (descubridor de servicios), api-gateway (gateway de la api), ms-product (servicio)

### 1.2 Endpoints

- Todos los precios: http://localhost:8010/api/v1/prices
- El filtro que se pedia en el ejercicio: http://localhost:8010/api/v1/prices/date-productid-brandid?date=2020-06-1621:00:00&productId=35455&brandId=1
- Consola H2base http://localhost:8010/api/v1/h2-console/login.jsp?jsessionid=1324092b351a89986f20325716efe636
- Actuator http://localhost:8010/api/v1/actuator

A partir del actuator el endpoint deseado.

### 1.3 Notas

1. La consola y el actuator no tendrian porque ser publicas y mapearlas en el api gateway pero he mapeado todo por defecto
2. Este seria el unico servicio publico y donde se centraria la seguridad y alguna cosa más

## 2. Solo el servicio productos

### 2.1 Arrancar proyecto

Ejecutar el ms-product

### 2.2 Endpoints

- Todos los precios: http://localhost:8011/api/v1/prices
- El filtro que se pedia en el ejercicio:http://localhost:8011/prices/date-productid-brandid?date=2020-06-1621:00:00&productId=35455&brandId=1
- Consola H2base http://localhost:8011/h2-console/login.jsp?jsessionid=1324092b351a89986f20325716efe636
- Actuator http://localhost:8010/api/v1/actuator

### 2.3 Notas

1- Dara todo el rato error ya que esta buscando todo el rato el descubridor de servicios

## 3. Implementar a futuro

- Logs/monitorizacion
- Exceptions
- Seguridad
- Docker
