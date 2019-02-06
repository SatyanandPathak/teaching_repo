Steps to execute:
----------------
If the eclipse does not work, go to the command prompt into the folder where you download the code.

Execute the commands below:
1. mvn clean install spring-boot:run
2. Go to browser: open the URL: http://localhost:8080/h2-console. This is for H2 
3. Once login you will Employee table being created. Select Employee, which will display the sql query on the right side as "SELECT * FROM EMPLOYEE". Click on the Run tab
4. You will see all the rows displayed which we are setting it up while the application is started


Now Test all the operations through postman, which are as below:

1. Get all employees: http://localhost:8080/employees (GET call in postman)

2. Create a new employee: http://localhost:8080/employees (POST call in Postman)
		The body will look like below:
		{
        "firstName": "David",
        "lastName": "Reed",
        "salary": 14000
		}
	-- you will see a new employee in the response body
	-- Check if a new employee is created by giving the URL as 
		http://localhost:8080/employees(GET call in postman)
	-- A new employee will be added with next id as 5 with the details given
	
3. Update a existing employee: http://localhost:8080/employees/5 (PUT call in Postman)
	Update any or all the fields in the above body something like below:
		{
        "firstName": "Varun",
        "lastName": "Bhaweja",
        "salary": 14000
		}
	-- you will see the updated employee response in the body
	-- Check if the updated employee is values are reflected by giving the URL as: 
		http://localhost:8080/employees/5  (GET call in postman)
	-- You should see the employee No 5 should be updated with the value given above
	
4. Delete an employee: http://localhost:8080/employees/5 (DELETE call in Postman)
	-- You should see no content
	-- Check if the employee is deleted by using the below URL in Postman:
		http://localhost:8080/employees (GET call in Postman)
	-- You should see employee with id 5 should be deleted and should not be present in the Response
	
	