#Database setup

##Install Wildfly PostgreSQL driver
Copy the modules folder to your wildfly folder so that the end result looks like
```
wildfly-18.0.1.Final\modules\org\postgresql\main\module.xml
wildfly-18.0.1.Final\modules\org\postgresql\main\postgresql-42.2.23.jar
```


##Modify the Wildfly standalone.xml
First shut down the Wildfly server if it is running, as it will overwrite your changes to the xml.

Then add the following datasource under the `<datasources>` tag:
```xml
<datasource jndi-name="java:jboss/datasources/cbsDS" pool-name="cbsDS" enabled="true" use-java-context="true" statistics-enabled="${wildfly.datasources.statistics-enabled:${wildfly.statistics-enabled:false}}">
    <connection-url>jdbc:postgresql://localhost:5432/cbs</connection-url>
    <driver>postgresql</driver>
    <security>
        <user-name>postgres</user-name>
        <password>postgres</password>
    </security>
</datasource>
```
Lastly add the following driver, also under the `<datasources>` tag:
```xml
<driver name="postgresql" module="org.postgresql">
    <driver-class>org.postgresql.Driver</driver-class>
    <xa-datasource-class>org.postgresql.xa.PGXADataSource</xa-datasource-class>
</driver>
```