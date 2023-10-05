# springboot-blog-api
Springboot api rest for blog application with mysql database y jparepository

### Nota
#### Configuracion para generar jar desde intellij:
ir a: https://www.jetbrains.com/idea/guide/tutorials/hello-world/packaging-the-application/

<br/>
Para ejecutar el jar con java -jar, debes tener instalado en tu pc de desarrollo, la misma versión de java que tienes configurada en tu pom.xml.

# Configuración:

### Configuración jpa + mysql

**application.properties:**<br/>
```javascript
# propiedades mínimas con las que puedes deployar en productivo.
spring.datasource.url=jdbc:mysql://localhost:3306/blog?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=<your-pass>
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# propiedades para entorno desarrollo
#spring.jpa.show-sql=true
#spring.jpa.generate-ddl=true
#spring.jpa.database-platform=org.hibernate.dialect.MySQL5InnoDBDialect
#spring.jpa.hibernate.ddl-auto=create
#logging.level.org.hibernate.SQL=DEBUG
#spring.jpa.properties.hibernate.format-sql=true
```

### Nota sobre la versión 6 de hibernate

A partir de la versión 6x de hibernate ya no es necesario declarar estas dos propiedades en el _application.properties_
porque esa versión de hibernate ya puede inferir el classname y el platform.
<br/>

**spring.datasource.driver-class-name**=com.mysql.cj.jdbc.Driver
<br/>**spring.jpa.database-platform**=org.hibernate.dialect.MySQL5InnoDBDialect

### Generar el jar - package
#### **En Intellij**
Ir a menú View\Tool Windows\Maven
<br/>
Cuando se abra el menú _Maven_ desde ahi dar doble clic en _Lifecycle_ \ _package_
<br/>para que se genere el jar en la carpeta target, o bien desde tu carpeta raíz en la consola de windows ejecutar el siguiente comando:

```java
c:\..>mvn clean package -DskipTests=true
```

### Ejecutar el jar
**<ruta-hacia-el-jar>** El jar por defecto se genera el raíz de la carpeta target.
<br/>

```java
c:\...> java -jar <ruta-hacia-el-jar>
```

**Ejemplo, ejecutar el jar, enviando como argumento un puerto**

```java
java -jar springboot-blog-api.jar --server.port=9090
```














