Sample app which allows employees to book a car.
Idea was to use Java servlets + JSP + DB to practice building MVC web app. Also practiced to create database pool.

Install:
1) git clone
2) cd into project folder
3) install with Maven - mvn install
4) run on tomcat - mvn:tomcat7:run
5) open browser and go to localhost:8080
6) log in with any user found in postgre_init file


Technologies/tools:
- Eclipse for JEE Devs
- Maven
- PostgreSQL
- JQuery
- Bootstrap


TODO
I failed to implement logic which restricts date ranges that can be selected for
each car (other users book the car). Some AJAX magic with JQuery is necessary that I am not familiar with yet.   

