/**
 * Description
Dear Learner, 
 
Please find the below problem statement for the RestAPI assignment
 
Problem Statement -Graded Project.docx
 
 
This is an individual assignment. 
 
 
 
Important instructions
 
i) You should use the H2 In Memory database for the whole project along with Spring JPA and Spring Security.
ii) Provide Screenshots of the operations (PostMan/Browser) along with code submission. (note → Screenshots will be one of the criteria while grading)
 iii) You can also record your screen while demonstrating CRUD operation, upload on the drive and share the drive link along with code.
iv) Spring Boot Application must follow the standard project structure.
v) Code should follow naming conventions along with proper indentations. vi) You are free to choose any Rest client to interact with api while implementation.(Prefer PostMan)
vi)Create a git repository name it as {yourName_RestAPIAssignmentSolution}, make it public
Notes
1.	Refer to the Problem Statement document thoroughly before working on your project. 
2.	The total Score of the project is 50.
3.	Complete the assessment before the deadline.
 
Regards
Program Office
Scoring guide (Rubric) - Graded coding assignment 6
Criteria	Points
Formatting, Indentation, Package Structures and Class Structures
1.The code is formatted correctly; it uses the logical spacing and indentations 5 marks
 2.The classes are separate and not present inside one file 5 marks 3. The Classes are placed inside suitable package(entity, service, dao, controller...) 2.5 marks	12.5
SpringBoot configuration
1.application.properties file configuration - 2.5 marks	2.5
Desired Outputs
Insert Role Operation Working - 3.5 marks 
Insert User Operation Working - 3.5 marks 
Insert Employee Operation Working - 3.5 marks 
Fetch all Employee Operation Working - 3.5 marks 
Find an Employee By Id Operation Working- 3.5 marks 
Updating an Employee Operation Working- 3.5 marks
 Deleting an Employee By ID Operation Working- 3.5 marks
 Searching an Employee by FirstName Operation Working- 3.5 marks 
Fetch all employee sorted based on first name in both order Operation Working - 5 marks 
Screenshots provided - 2 marks	35
Points	50


Question-

You are required to create a Employee Management Rest Api based Web application, where you will be developing CRUD(Create,Read,Update and Delete) functionality along with Sorting and some concepts of security.

Your Rest Api should be secure.And should have different endpoints for different operations-

1.Your application should be able to add roles in the database dynamically in the db.

Ex-
	{
    "name":"USER"
}
Where name specifies a role which can be assigned to a user that will be used for authentication purposes while interacting with the api.

2. Your application should be able to add Users in the db which can be used for authentication purposes.

Ex-
	{
    "username":"temp",
    "password":"12345",
    "roles":[{
        "id":2,
        "name":"USER"
    }]
}

3. Now Your application should be able to add employees data in the db if and only if the authenticated user is ADMIN-
Ex-
	{
    "firstName":"gl",
    "lastName":"postman",
    "email":"postman@gamil.com"
}

4. Your application should provide an endpoint to list all the employees stored in the database.

Ex- 
	Response Body-
[
    {
        "id": 1,
        "firstName": "Ujjawal",
        "lastName": "Sharma",
        "email": "fdfdfd@gmail.com"
    },
    {
        "id": 2,
        "firstName": "temp",
        "lastName": "kaushik",
        "email": "jdfdkfdjj@gmail.com"
    },
    {
        "id": 3,
        "firstName": "postman",
        "lastName": "postman",
        "email": "postman@gamil.com"
    }
]

5. Your application should provide endpoint to fetch or get an employee record specifically based on the id of that employee-

Ex- 	Url- http://localhost:8080/api/employees/3
	Response Body-
{
    "id": 3,
    "firstName": "postman",
    "lastName": "postman",
    "email": "postman@gamil.com"
}

6. Your application should provide an endpoint to update an existing employee record with the given updated json object.

Ex-
	Object to be updated(raw->Json)- 
{
    "id":1,
    "firstName":"postman",
    "lastName":"postman",
    "email":"postman@gamil.com"
}

Response Body after updation-
{
    "id": 1,
    "firstName": "postman",
    "lastName": "postman",
    "email": "postman@gamil.com"
}

7. Your application should also provide an endpoint to delete an existing employee record based on the id of the employee-

Ex-
	Url- http://localhost:8080/api/employees/4
	Response Body-
"Deleted employee id - 4”

8.  Your application should provide an endpoint to fetch an employee by his/her first name and if found more than one record then list them all-

Ex-
	Url- http://localhost:8080/api/employees/search/gl
	Response Body-
[
    {
        "id": 11,
        "firstName": "gl",
        "lastName": "postman",
        "email": "postman@gamil.com"
    }
]

9. Your application should be able to list all employee records sorted on their first name in either ascending order or descending order .

Ex- 
	Url- http://localhost:8080/api/employees/sort?order=”asc”  
		   OR
	Url- http://localhost:8080/api/employees/sort?order=”desc”
	


-------------------------------------------------------------------------------------------------------------------------

Important instructions 
i) You should use the H2 In Memory database for the whole project along with Spring JPA and Spring Security.
ii) Provide Screenshots of the operations(PostMan/Browser) along with code submission. (note → Screenshots will one of the criterias while grading)
 iii) You can also record your screen while demonstrating CRUD operation, upload on the drive and share the drive link along with code. 
iv) Spring Boot Application must follow the standard project structure .
v) Code should follow naming conventions along with proper indentations. vi) You are free to choose any Rest client to interact with api while implementation.(Prefer PostMan)

 */

package com.greatLearning.employeeREST;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import com.greatLearning.employeeREST.model.Employee;

@SpringBootApplication
public class EmployeeSpringRestApiH2Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeSpringRestApiH2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		System.out.println("Hello there");
//		Employee employee = new Employee();
//		employee.setFirstName("Nandita");
	}
}
