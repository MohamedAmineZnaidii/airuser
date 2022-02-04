### Project Overview
This project contain 2 Rest APIs that can be used to Register a user and to show his information
User has those field which some are required and others are mandatory

'firstName: "string" a required field, size must be > 1

lastName: "string" a required field, size must be > 1

street: "string" a mandatory field

city: "string" a mandatory field

country: "France" a required field, only user from France can make registration,

password: "password" a required field size must be superior to 8 and inferior to 30 ,

passwordConfirmation: "password", a required field that must match with password field

birthDate: "2000-01-01" a required field, only +18 years old users can register,

email: "string" a required field, mail address must be valid,

phoneNumber: "string" a mandatory field


### Build and Deploy the Project
```
mvn clean install
```

This is a Spring Boot project, so you can deploy it by simply using the main class: `Airuser.java`

Once deployed, you can access the app at:

https://localhost:8080


### Set up MySQL
By default, the project is configured to use the embedded H2 database.
If you want to use the MySQL instead, you need to uncomment relevant section in the [application.properties](src/main/resources/application.properties) and create the db user as shown below:
```
mysql -u root -p 
> CREATE USER 'airuser'@'localhost' IDENTIFIED BY 'airuser';
> GRANT ALL PRIVILEGES ON *.* TO 'airuser'@'localhost';
> FLUSH PRIVILEGES;
```
In case you want to user H2 database, you can access H2 console using this link

http://localhost:8080/h2-console/

###  REST Api documentation
Api documentation are automatically generated using SWAGGER.
When the application is deployed you can find documentation using this link.

http://localhost:8080/swagger-ui/#/

### UML Diagrams
You can find uml diagrams on documentation/UML/schemas




 