# data-entry-demo-spring

This is an exercise that uses Spring Boot backend and Thymeleaf front end to render a simple data entry form.

To run the project, you can clone the repo and run locally in VSCode (if you have Spring Boot Extension Pack).

You could also run the JAR file included in this repo too, inside the target folder. 

You can run the JAR file like so from the terminal:
java -jar target/simpledataentry-0.0.1-SNAPSHOT.jar 

Then, view the app on http://localhost:8080

-----------------------
There's a confirmation page, and a data table that displays all the employees available in the H2 DBMS (in-memory) Employees table. Initially I used MongoDB but decided on a light weight DB that works easily and has quick setup.

I've also setup a Rest Controller that is mostly used for Postman testing.

If you would like to view the contents of the H2 DBMS table, you can login through http://127.0.0.1:8080/h2-console, click Connect, and you should see an EMPLOYEE table you can run a SQL query on to show all rows.