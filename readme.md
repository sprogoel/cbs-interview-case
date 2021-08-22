# CBS Interview Case - Cinema Booking System
This project was made as part of an application to Copenhagen Business School.

It is a bare-bones booking system for a cinema. It is a REST webservice that is meant to run in a Wildfly 18 server and 
connect to a postgreSQL database.

## Folder structure
### `\setup\ `
Contains a guide and the necessary files to connect the Wildfly server to a postgreSQL database.

### `\SQL\ `
Contains database import script to add movie showings to the database.

### `\src\ `
Contains the source code.

## Deployment
To deploy the code to a locally running Wildfly server, use the following maven command:
```
mvn clean install wildfly:deploy
```

## REST endpoints
The following REST endpoints are exposed by the server
### GET - Lists all movie showings
```
/rest/cbs/show-all
```

### GET - List a single movie showing
```
/rest/cbs/show/{id}
``` 

### POST - Make a reservation
```
/rest/cbs/reserve
``` 

### DELETE - Delete a reservation
```
/rest/cbs/cancel/{id}
```

