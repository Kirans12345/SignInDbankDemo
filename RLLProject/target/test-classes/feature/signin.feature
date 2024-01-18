#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template


Feature: Testing SignIn feature of dbankdemo website

  Scenario: User logs in with valid credentials from Excel
  	
    Given I open my dbankdemo website on chrome browser
    When I entered the login credentials from Excel "J:\MPHASIS\RLL\SignInDbankDemo.xlsx" and i clicked on signin
    Then I close my browser

	#| username         | password        |
	#| kirans@gmail.com | Kiran4301@S     |
	#| InvalidUserName  | Kiran4301@S     |
	#| kirans@gmail.com | InvalidPassword |
	
  # Add more scenarios as needed for different test cases

