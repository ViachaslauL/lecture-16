<h3>Home task #16</h3>
<h4>Description</h4>
<p>This application inserts data about a person. Surname, name and patronymic,
 as well as address.</p>
<h4>Task list</h4>
<ol>
<li>Git repo
<li>README file with rules from lecture
<li>create new maven/gradle project
<li>Create 2 POJO classes with 1 to 1 relation
<li>Create DB schema for classes from #4
<li>Add JPA + hibernate libs to project
<li>Configure POJO mapping with JPA annotations
<li>Create DAO (use EntityManager) for POJOs with 2 method: save(pojo) and find(id)
<li>Tests
</ol> 
<h4>Technologies</h4>
<ol>
<li>Java version: 11
<li>MySQL database
<li>docker-compose
<li>Flyway
<li>Hibernate
<li>Slf4j+Log4j
<li>Lombok
<li>jUnit-jupiter
<li>Mockito
</ol>
<h4>How to run</h4>
<p>In order to build and run the application, follow these steps. 
In the console, go to the project directory and type:</p>
<ol>
<li>mvn clean install
<li>docker-compose up -d
<li>mvn flyway:migrate
</ol>