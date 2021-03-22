# Spring Boot HOTEL RESERVATION

Il s'agit d'un exemple d'application Java / Maven / Spring Boot, pour créer des API REST. Principalement remplis des fonction CRUD :
- CREATE
- UPDATE
- DELETE

JE SUIS ENCORE SUR LA PHASE DE CONCEPTION DONC LE CODE NE FONCTIONNE PAS CORRECTEMENT.

# Lancement

Cette application est empaquetée sous la forme d'un war dans lequel Tomcat 8 est intégré. Aucune installation de Tomcat ou de JBoss n'est nécessaire. Vous l'exécutez en utilisant la commande ``java -jar``.

* Ouvrir
* importer et clonez le dépôt 
* Assurez-vous que vous utilisez JDK 1.8 et Maven 3.x.
* Vous pouvez construire le projet et exécuter les tests en lançant la commande "mvn clean package"
* Une fois construit avec succès, vous pouvez lancer l'application via le runner eclipse :
* Vérifiez le stdout ou la console d'eclipse pour vous assurer qu'aucune exception n'est levée.

Une fois l'application lancée, vous devriez voir quelque chose comme ceci

```
/\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::  (v2.3.10.BUILD-SNAPSHOT)

2021-03-16 17:15:02.820  INFO 59541 --- [           main] c.m.r.RerservationSpringBootApplication  : Starting RerservationSpringBootApplication on AirdeChristanis with PID 59541 (/Users/christanismerilbanzouzi/Documents/rerservation/target/classes started by christanismerilbanzouzi in /Users/christanismerilbanzouzi/Documents/rerservation)
2021-03-16 17:15:02.828  INFO 59541 --- [           main] c.m.r.RerservationSpringBootApplication  : No active profile set, falling back to default profiles: default
2021-03-16 17:15:04.253  INFO 59541 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Multiple Spring Data modules found, entering strict repository configuration mode!
2021-03-16 17:15:04.256  INFO 59541 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JDBC repositories in DEFAULT mode.
2021-03-16 17:15:04.353  INFO 59541 --- [           main] .RepositoryConfigurationExtensionSupport : Spring Data JDBC - Could not safely identify store assignment for repository candidate interface com.meril.rerservation.repository.ReservationRepository. If you want this repository to be a JDBC repository, consider annotating your entities with one of these annotations: org.springframework.data.relational.core.mapping.Table.
2021-03-16 17:15:04.357  INFO 59541 --- [           main] .RepositoryConfigurationExtensionSupport : Spring Data JDBC - Could not safely identify store assignment for repository candidate interface com.meril.rerservation.repository.RoomRepository. If you want this repository to be a JDBC repository, consider annotating your entities with one of these annotations: org.springframework.data.relational.core.mapping.Table.
2021-03-16 17:15:04.358  INFO 59541 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 92ms. Found 0 JDBC repository interfaces.
2021-03-16 17:15:04.372  INFO 59541 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Multiple Spring Data modules found, entering strict repository configuration mode!
2021-03-16 17:15:04.375  INFO 59541 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JPA repositories in DEFAULT mode.
2021-03-16 17:15:04.437  INFO 59541 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 53ms. Found 2 JPA repository interfaces.
2021-03-16 17:15:05.464  INFO 59541 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2021-03-16 17:15:05.482  INFO 59541 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2021-03-16 17:15:05.482  INFO 59541 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.43]
2021-03-16 17:15:05.680  INFO 59541 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2021-03-16 17:15:05.680  INFO 59541 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 2749 ms
2021-03-16 17:15:05.975  INFO 59541 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2021-03-16 17:15:06.691  INFO 59541 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2021-03-16 17:15:06.780  INFO 59541 --- [           main] o.hibernate.jpa.internal.util.LogHelper  : HHH000204: Processing PersistenceUnitInfo [name: default]
2021-03-16 17:15:06.914  INFO 59541 --- [           main] org.hibernate.Version                    : HHH000412: Hibernate ORM core version 5.4.28.Final
2021-03-16 17:15:07.295  INFO 59541 --- [           main] o.hibernate.annotations.common.Version   : HCANN000001: Hibernate Commons Annotations {5.1.2.Final}
2021-03-16 17:15:07.592  INFO 59541 --- [           main] org.hibernate.dialect.Dialect            : HHH000400: Using dialect: org.hibernate.dialect.MySQL8Dialect
2021-03-16 17:15:08.670  INFO 59541 --- [           main] o.h.e.t.j.p.i.JtaPlatformInitiator       : HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
2021-03-16 17:15:08.684  INFO 59541 --- [           main] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
2021-03-16 17:15:09.170  WARN 59541 --- [           main] JpaBaseConfiguration$JpaWebConfiguration : spring.jpa.open-in-view is enabled by default. Therefore, database queries may be performed during view rendering. Explicitly configure spring.jpa.open-in-view to disable this warning
2021-03-16 17:15:09.391  INFO 59541 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
2021-03-16 17:15:09.939  INFO 59541 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2021-03-16 17:15:09.951  INFO 59541 --- [           main] c.m.r.RerservationSpringBootApplication  : Started RerservationSpringBootApplication in 7.76 seconds (JVM running for 9.169)

```

### Ajouter au fichier pom.xml : 

Pour pouvoir utiliser une BDD MySQL

```
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
        </dependency>
```

## Infos sur les Services avec la BDD

Simple service REST permettent la réservation d'une chambre d'hotel. J'utilise une base de données relationnelle comme MySQL. Si les propriétés de connexion de la base BDD fonctionnent dans le fichier application.properties comme ceci :

```
# Database Connection
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/hotel
spring.datasource.username=root
spring.datasource.password=rootroot
```
### Lancer ce script pour initier la BDD: 

```
DROP TABLE IF EXISTS Room;
CREATE TABLE Room
(roomId int NOT NULL PRIMARY KEY,
roomName varchar NOT NULL,
reservationId int NULL);


DROP TABLE IF EXISTS Reservation;
CREATE TABLE Reservation
(reservationId int NOT NULL PRIMARY KEY,
reservationName varchar NOT NULL,
dateStart date NOT NULL,
dateEnd date NOT NULL);

```

### Les web services disponible.

```
http://localhost:8080/reservations
http://localhost:8080/reservation/{reservationid}
http://localhost:8080/deleteReservation/{reservationid}
http://localhost:8080/saveReservation
http://localhost:8080/modifyReservation
http://localhost:8080/rooms
```

# Questions et Commentaires: merilb78@gmail.com
