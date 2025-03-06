Feature: login verfication
@regression
Scenario: check the login with valid crenditials
Given user open the browser
When user enter url as "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"                       
And user enter email as "Admin1" and password as "admin123"
And user click on login
Then user able to see dashboard
When close the browser

@smoke
Scenario Outline:chek login by DDT
Given user open the browser
When user enter url as "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"                       
And user enter email as "<email>" and password as "<password>"
And user click on login
Then user able to see dashboard
When close the browser
Examples:
|email|password|
|Admin| admin123|
|admin|admin34|