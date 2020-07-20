Feature: User updates profile and searches for relevant Jobs

@Srch
Scenario Outline: User should be able to search for relevant jobs
Given User is on homepage
When User clicks on Login Button
And User enters "<Username>" and "<Password>"
When User searches for "<Profile>" in "<City>"
And user sets his experience range
Then User should be able to get the count of requirements
Examples:
|Username|Password|Profile|City|
|anirudho.sengupta@gmail.com|Gmail@2020|API Tester|Chennai|
|anirudho.sengupta@gmail.com|Gmail@2020|Manual Test Engineer|Hyderabad|
|anirudho.sengupta@gmail.com|Gmail@2020|Automation Test Engineer|Mumbai|
|anirudho.sengupta@gmail.com|Gmail@2020|Automation Test Engineer|Chennai|


@Updt
Scenario Outline: Testing update function of Shine portal
Given User is on homepage
When User clicks on Login Button
And User enters "<Username>" and "<Password>"
And User clicks on Edit personal details
And User updated "<Name>" and "<Mail>"
Then User should be able to verify "<Name>" and "<Mail>"
Examples:
|Username|Password|Name|Mail|
|anirudho.sengupta@gmail.com|Gmail@2020|A|9235661481|
|anirudho.sengupta@gmail.com|Gmail@2020|B|9005754733|
|anirudho.sengupta@gmail.com|Gmail@2020|C|9002549525|
|anirudho.sengupta@gmail.com|Gmail@2020|D|9002576410|



