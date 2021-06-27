# Work-India Job Portal
-------------------

A Job Portal to search jobs, by filling necessary details into an application. Just login with valid credentials then select location and after that fill all user details into the application.


# Technology-Set
-------------------

1. Appium
2. Core Java
3. Cucumber/BDD
4. Extent Reports
5. Log4j
6. Page Object Model


## REQUIREMENTS
-------------------

1. eclipse JDK 1.8
2. Work-India 'apk'
3. Avd manager with one emulator device created (Android Version 9.0)
4. Appium
5. Android sdk installed
6. A stable internet connection


## CONTENTS
-------------------

1. readme.md - this file
2. testng.xml - testng file to run the test code manually 
3. config.properties - external property file for setting different values while running the application
4. android.properties - external property file for setting different values specific to Android
5. pom.xml - To resolve all dependencies of this project
6. Feature file - A Feature File is an entry point to the Cucumber tests. This is a file where you will describe your tests in Descriptive language (Like English). It is an essential part of Cucumber, as it serves as an automation test script as well as live documents.
7. Step definition file - Step definition maps the Test Case Steps in the feature files(introduced by Given/When/Then) to code. It which executes the steps on Application Under Test and checks the outcomes against expected results. For a step definition to be executed, it must match the given component in a feature. 
8. src/main/java - contains multiple packages like BaseClass, Locators, pageobjects and utilities.
9. src/test/java - contains hooks, step definitions, Test Runner.
10. src/test/resources - contains Feature file


## INSTALLATION
-------------------
1. Download the project zipped folder and extract at some location in your PC (preferably place it in your workspace)
2. Import the extracted project as maven project into the eclipse
3. When the project is shown in the eclipse check for any error in pom.xml.( in case of any error do force update the maven project option found after right click the project)
4. We are good to go to run the project once all error are resolved. 


## MANDATE CHANGES BEFORE RUNNING THE EXAMPLE
-------------------

Update the common.propertiees file in src/main/resources for following parameters:
1. PLATFORM_VERSION < should be same as the emulator platform version>
2. DEVICE_NAME < enter the device name you have used in your virtual device setup> 
3. UDID < in case you have multiple emulators connected at one time, do provide the emulator UDID on which you 	want to run the test steps>
4. DRIVER_URL < change as per your system specific values>


## RUNNING THE EXAMPLE
-------------------
1. Open the local terminal window in eclipse and go to the project location ( can use cd <path of the project>)
2. initially type "mvn clean compile install" to automatically download the maven dependencies required to run the project code and to run the code at the same time
3. later we can run the code via "mvn clean test" or "mvn clean verify"
4. only those testng.xml's will be executed which have a entry in pom.xml under <test> tag.
5. TESTNG.XML can also be directly run from cmd by typing "mvn clean test"