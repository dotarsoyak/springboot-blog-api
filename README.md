# springboot-blog-api
Springboot api rest for blog application with mysql database y jparepository

### Nota
#### Configuracion para generar jar desde intellij:
ir a: https://www.jetbrains.com/idea/guide/tutorials/hello-world/packaging-the-application/

<br/>
Para ejecutar el jar con java -jar, debes tener instalado en tu pc de desarrollo, la misma versión de java que tienes configurada en tu pom.xml.
<br/>

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

### Generar el jar
**<ruta-hacia-el-jar>** El jar por defecto se genera el raíz de la carpeta target.
<br/>

c:\...> java -jar <ruta-hacia-el-jar>














