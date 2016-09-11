#README

This repository is created to push the following BCBS coding exercises:

1. ENCODER/DECODER Algorithm <br />
2. Employee Leave/Vacation tracking App

-----------------------------------------------------------------------------------------------------------
1. ENCODER/DECODER Algorithm
-------------------------
The code corresponding this exercise is present in the following location:<br />
https://github.com/uvks/BCBS-CodingExcercise/tree/master/EncryptionAlgorithm

Assumptions
-----------
This program will only decode the given text.<br />
Input text consists of upper/lower/special characters

Tools Used
----------
Eclipse

Code Explanation
----------------
(i) Initialized an array with length = max ascii value of upper/lower/special characters which is 126 <br />
(ii) From the given 3 encode-decode patterns, populated the encoded character ascii value index of the array with its corresponding decoded character ascii value.<br />
(iii) Created an input text file with encoded text which needs to be decoded.<br />
(iv) Run Ecruption.java to create Output.txt file in bin directory with the decoded text.<br />
(v) Since the algorithm uses fixed length array using index to retrieve decoded characters, the runtime complexity is O(1) , and the space is 126 integer length array.<br />
(vi) This Algorithm can be modified to fill out the empty spaces in the array for the characters which are absent in given 3 encode-decode patterns.<br />

Execution
---------
Run Encryption class
-----------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------

2. Employee Leave/Vacation tracking App
-----------------------------------
The code corresponding this exercise is present in the following location:<br />
https://github.com/uvks/BCBS-CodingExcercise/tree/master/employee-vacation-app

Requirement Assumptions
----------------------
Build an Application to keep track of vacation/leaves of employees

Design & Explanation:
---------------------
Used Spring boot to create the application.<br />
Created an UI page to Create Employee, getEmplyeeById and getAllEmployees.<br />
Used spring MVC design pattern.<br />
Used Restful WebServices to expose the Services - createEmployee, getEmployeeByEmplId, getAllEmployees, addEmployeeVacation.<br />
Used DAO Pattern to persist and retrieve data.<br />
Used H2 Inmemory database to store the data.<br />
Used Maven to build the project.<br />
Used JSTL and spring form taglibs to diaplay the data.<br />

Following are the design patterns used while developing the applciation:<br />
(i)   Factory pattern - To create and get DB connections.<br />
(ii)  Singleton pattern - To create single instance of service and dao implementations.<br />
(iii) MVC pattern - To persist and retrieve data to and from UI, database.<br />
(iv)  Filter Pattern - To filter the input request URL and invoke corresponding contoller/servlet.<br />
(v)   Composite pattern - To treat employee and vacation as single object and display in the front-end.<br />
(vi)  Facade Pattern- At every stage, the interfaces or controller hides the complexities of the system.<br />
(vii) Mediator pattern - Restful webservices as the mediator between Spring web controller and backEnd services.<br />
(viii)Front Controller pattern - All the input requests are controlled by a single Front controller and dipatched to their corresponding servlets.<br />
(ix)  DAO pattern - To persist and retreive information to/from database.<br />

Execution
-----------
Build the application using maven, e.g mvn clean install eclipse:eclipse<br />
Run Application.java file<br />
Enter the url in browser - http://localhost:8080/emp-vac-app/web/ <br />

After running the Application.java, if the link doens't work -> <br />
Uncomment the code in the following 3 places of MyAppBeanConfiguration.java, rebuild the app and restart Application.java<br />
1. //@EnableWebMvc <br />
2. // extends WebMvcConfigurerAdapter <br />
3. configureViewResolvers <br />

Conclusion
------------
I am able to finish the exercise. It is a working application (not fully tested), for time being did not implement some of the functionalities like adding vacations from UI, etc.

UI images are added to the wiki.
https://github.com/uvks/BCBS-CodingExcercise/wiki

