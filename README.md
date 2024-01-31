# HospitalManagement

1. The application allows the user/hospital staff to signup/login into the portal and access the required APIs.
2. JWT token authentication is used to login and validate the session for the client/user.
3. SpringBoot is used to make the REST APIs for all the different functionalities.
4. MySQL is used as the database due to the relational nature of entities in the problem statement.

How to install and run the project:
1. Start MYSQL server.
2. Update the database credentials in the application.properties file.
3. Run init.sql file in mysql to make required database and tables in SQL.
4. Run the application class to run the project.

Entities that are used : 
1. User
2. Patient
3. Room
4. Hospital
5. Admission
6. Doctor

It is assumed that concurrent transactions are not taking place. At one time, one update/save is taking place in the db.

APIs implemented : 

1. POST "/api/signup" ------------------------------------------------  Signup for user
   
2. POST "/api/login"  ------------------------------------------------  Login for user
   
3. POST "/api/rooms"  ------------------------------------------------  Create rooms
   
4. GET "/api/rooms/{id}" ---------------------------------------------- Get a room by Id
   
5. POST "/api/doctors/" -----------------------------------------------  Create doctor
   
6. GET "/api/doctors/{id}" -------------------------------------------- Get doctor by Id
 
7. POST "/api/patients/" ----------------------------------------------  Create Patient
   
8. GET "/api/patients/{id}"--------------------------------------------  Get patient by id
   
9.  POST "/api/hospitals/" --------------------------------------------- Create hospital
    
10. GET "/api/hospitals/{id}" ------------------------------------------ Get hospital by Id.

11. POST "/patients/{patientId}/admit" --------------------------------- Admits a patient into the system

12. POST "/patients/{patientId}/discharge"------------------------------ Discharge a patient from the system

13. GET "/hospitals/{hospitalId}/admitted-patients"--------------------- Get all admitted patients in the hospitals
