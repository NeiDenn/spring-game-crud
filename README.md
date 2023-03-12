# spring-crud-jpa

Spring CRUD es una demostración de cómo implementar operaciones CRUD simples con las entidades Juego, Genero y Desarrolladora

## Installation 
El proyecto se crea con Maven y Java17, por lo que solo necesita importarlo a su IDE y compilar el proyecto para resolver las dependencias.

## Database configuration 
Ejecute la base de datos MySQL con el nombre `bd_games_jpa` que se encuentra en `/src/main/resources/bd_mysql` y estas credenciales para `/resources/application.properties`. No olvide verificar su contraseña, los predeterminados son:

```
server.port=8091
spring.jpa.database=MYSQL
spring.jpa.show-sql=true
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/bd_games_jpa?serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=mysql
```

## Usage 
Ejecute el proyecto y diríjase a [http://localhost:8091](http://localhost:8091)

En caso si Spring no reconoce los datasource de tu `application.properties`, es raro pero suele pasar, siga estas instrucciones. 
```
$ Click derecho al proyecto > Maven > Update Project > Click Ok
$ Click derecho al proyecto > Close Project
$ Click derecho al proyecto > Open Project
$ Y ejecute el proyecto
```
## Screenshots
![image](https://user-images.githubusercontent.com/85379478/224551383-93381407-c579-4cf2-86d4-46c29383f6fc.png)
![image](https://user-images.githubusercontent.com/85379478/224550934-d6340531-2542-4f92-9ab2-22fd6cc05c78.png)
![image](https://user-images.githubusercontent.com/85379478/224551213-b9475cd7-487d-47fe-aee7-96f7fbac5714.png)
![image](https://user-images.githubusercontent.com/85379478/224551056-7ac47035-b742-41e7-8598-f9d5770ef6d8.png)
![image](https://user-images.githubusercontent.com/85379478/224551128-bc1008a9-e1be-4d30-8487-d4df5c005549.png)
![image](https://user-images.githubusercontent.com/85379478/224551186-c4c781bd-76b2-4785-8451-8ee81b7e4c79.png)

## Features

- Listado
- Registro
- Actualización
- Eliminación
- Búsqueda
- Mensajes De Alerta
- Validaciones
- Menú 
- Etc.

## Contributing

Pull requests are welcome. For major changes, please open an issue first
to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License

[MIT](https://choosealicense.com/licenses/mit/)
