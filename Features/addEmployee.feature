Feature: add employee 
@sanity 
Scenario: add employee by providing details
Given user open the browser
When user enter url as "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"                       
And user enter email as "Admin" and password as "admin123"
And user click on login
Then user able to see dashboard
When user click on PIM
Then he can see PIM dashboard
When user click on add
And  user fill the values
And  click on save
Then user can see profiles details
When close the browser

