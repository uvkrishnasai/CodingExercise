#README

This repository is created to push the following BCBS coding exercises:

1. ENCODER/DECODER Algorithm
2. Employee Leave/Vacation tracking App

-----------------------------------------------------------------------------------------------------------
ENCODER/DECODER Algorithm
-------------------------
The code corresponding this exercise is present in the following location:
https://github.com/uvks/BCBS-CodingExcercise/tree/master/EncryptionAlgorithm

Assumptions
-----------
This program will only decode the given text.
Input text consists of upper/lower/special characters

Tools Used
----------
Eclipse

Code Explanation
----------------
(i) Initialized an array with length = max ascii value of upper/lower/special characters which is 126
(ii) From the given 3 encode-decode patterns, populated the encoded character ascii value index of the array with its corresponding decoded character ascii value.
(iii) Created an input text file with encoded text which needs to be decoded.
(iv) Run Ecruption.java to create Output.txt file in bin directory with the decoded text.
(v) Since the algorithm uses fixed length array using index to retrieve decoded characters, the runtime complexity is O(1) , and the space is 126 integer length array.
(vi) This Algorithm can be modified to fill out the empty spaces in the array for the characters which are absent in given 3 encode-decode patterns.

Execution
---------
Run Encryption class
-----------------------------------------------------------------------------------------------------------

Employee Leave/Vacation tracking App
-----------------------------------
The code corresponding this exercise is present in the following location:
https://github.com/uvks/BCBS-CodingExcercise/tree/master/employee-vacation-app

Requirement Assumptions
----------------------
Build an Application to keep track of vacation/leaves of employees

Design & Explanation:
---------------------
Used Spring boot to create the application
Created an UI page to Create Employee, getEmplyeeById and getAllEmployees
Used spring MVC design pattern
Used Restful WebServices to expose the Services - createEmployee, getEmployeeByEmplId, getAllEmployees, addEmployeeVacation
Used DAO Pattern to persist and retrieve data
Used H2 Inmemory database to store the data
Used Maven to build the project
Used JSTL and spring form taglibs to diaplay the data

Following are the design patterns used while developing the applciation:
(i)   Factory pattern - To create and get DB connections
(ii)  Singleton pattern - To create single instance of service and dao implementations.
(iii) MVC pattern - To persist and retrieve data to and from UI, database
(iv)  Filter Pattern - To filter the input request URL and invoke corresponding contoller/servlet
(v)   Composite pattern - To treat employee and vacation as single object and display in the front-end
(vi)  Facade Pattern- At every stage, the interfaces or controller hides the complexities of the system
(vii) Mediator pattern - Restful webservices as the mediator between Spring web controller and backEnd services
(viii)Front Controller pattern - All the input requests are controlled by a single Front controller and dipatched to their corresponding servlets
(ix)  DAO pattern - To persist and retreive information to/from database.

Execution
-----------
Build the application using maven, e.g mvn clean install eclipse:eclipse
Run Application.java file
Enter the url in browser - http://localhost:8080/emp-vac-app/web/ 

Conclusion
------------
I am able to finish the exercise. It is a working application but for time being did not implement some of the functionalities.

