Intsallation:
    - Java 11
    - Maven
    - IntelliJ Idea Community Version
    - Allure Report

Framework Technologies:
    - Java Programming Language
    - Selenium Webdriver for UI Automation Scripts
    - Selenium Webdriver Manager to Manage Drivers automatically
    - TestNG Framework for Parallel execution and other testng features
    - Maven Surefire
    - Allure Reports for reporting
    - Project Lombok to use with POJO classes
    - JsonSimple and Gson library for operation on JSON file 

Applications Covered In Automation:
    -Netflix
    -Amazon
    -Linkedin
    -Facebook
    -Instagram
    -Google

Testcases written for this Application:
    1. Launch Netflix Application and verify it's title [This TC will fail because we are intentionally failing it to see report screenshot feature]
    2. Launch Netflix Application and validate login error message for wrong credentials [Credentials Data is coming from JSON file]
    3. Launch Amazon Application and verify it's title
    4. Launch Amazon Application and get book price using Author Name
    5. Launch Google Application and verify it's title
    6. Launch Google Application and search for wikipedia and validate wikipedia is coming in search results
    7. Launch Facebook Application and verify it's title
    8. Launch Facebook Application and verify login error message for wrong credentials [Credentials Data is coming from CSV file]
    9. Launch Instagram Application and verify it's title
    10.Launch Facebook Application and verify login error message for wrong credentials [Credentials Data is coming from env variables]
    11.Launch LinkedIn Application and verify it's title
    12.Launch LinkedIn Application and verify login error message for wrong credentials [Hardcoded Credentials]

Framework Highlights:
    - Parallel Execution Setup: It will run 6 TCs in Parallel to make execution faster
    - Data Providers: Data can come from JSON, CSV files. Also we can store env variables to modify data at run time
    - Reporting: Allure report is integrated with framework to view detailed level reports. And It will attach failure screenshot when TC fails.

Files/Folder Information:
    -   src/main/java/BaseClasses/UIBaseTest: It has BaseClass for UI TC which has method to launch and kill browser which can be use by any test methods.
    -   src/main/java/BaseClasses/UITestListner: When UI Test fails, It should capture screenshot. That logic is written in this class
    -   src/main/java/helpers: Common Functions required for Page and Test classes. I have created one method to check if element is present on page or not
    -   src/main/java/PageClasses: All WebElements of Page are stored in this class
    -   src/main/java/Pojo: POJO Classes of JSON are stored here
    -   src/main/java/Util: URLs of Applications
    -   src/main/resources/Data: TestData for our TC in CSV and JSON files
    -   src/test/java: All Testcase class. All class will run in parellel execution upto 10 max. As Threadcount is 10.
    -   src/test/resources: Allure Property to tell where allure reports folder will be stores
    -   POM.xml: For All Dependency and Surefire configuration

How to run TestCases:
    - To Run all TCs: mvn test
    - To Run specific Test: mvn test -Dtest=testname or click run button on left to testcase
    - To Run Specific Group: mvn test -Dgroups=groupname [Group name is attached with @Test Method in Test classes]
    - To Run TC with Env Variables: mvn test -Denv="QA" [D{VariableName}=value]

How to view Report:
    - Once your TC execution is done, go to your reporistory location/target folder in explorer
    - Open Cmd window in that folder
    - Run "allure serve" command. It will open report in Browser 
    