#Hello REST Filter

Before running application need create database which called "hello_db"  

In application you can use mysql for DEV profile or postgres for PROD profile
Script for creating database create database hello_db

###After that fellow these steps:
- Clone repository url
- Run maven commands: mvn clean install
- Run app with profile dev or prod. Use this java -jar -Dspring.profiles.active=#profile #path for jar file

Application will create table and migrate data automatic wait a few minutes.
When application will running enter 
 - http://localhost:9080/hello/contacts?nameFilter=^B.*$ - for dev
 - http://localhost:9090/hello/contacts?nameFilter=^B.*$ - for prod

In application use cache when you send your first filter request api collect all rows and filter them by regexp. When you send next requests for the same filter and use pagination you will get response quickly.  
Use page param for pagination response.
page - page number
size - count of row per page
http://localhost:9080/hello/contacts?nameFilter=^B.*$&page=1&size=30

[![Build Status]

