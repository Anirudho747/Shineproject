Feature: User Login and Logout from Naukri Portal

@Login
Scenario Outline: Testing Login Feature of Shine Portal with valid credentials
Given User is on homepage
When User clicks on Login Button
And User enters "<Username>" and "<Password>"
Then User should be able to Login to his/her Naukri Account
Examples:
|Username|Password|
|anirudho.sengupta@gmail.com|Gmail@2020|
|anirudho.sengupta@gmail.com|Gmail@2020|
|anirudho.sengupta@gmail.com|Gmail@2020|
|anirudho.sengupta@gmail.com|Gmail@2020|


@Logout
Scenario Outline: Testing Logout Feature of Naukri Portal
Given User is on homepage
When User clicks on Login Button
And User enters "<Username>" and "<Password>"
When User's mouse hovers over My Name Option
And User clicks on Logout Option
Then User should be logged out of Shine portal
Examples:
|Username|Password|
|anirudho.sengupta@gmail.com|Gmail@2020|
|anirudho.sengupta@gmail.com|Gmail@2020|
|anirudho.sengupta@gmail.com|Gmail@2020|
|anirudho.sengupta@gmail.com|Gmail@2020|