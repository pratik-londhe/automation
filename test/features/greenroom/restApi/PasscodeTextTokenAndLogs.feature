@passcodeTextTokenAndLogs_api
Feature: Passcode_Text_Token_Logs_API Feature

Scenario: Check Passcode Apis
	Given Check producer app access
	And Login to greenroom with greenroom
	And Get all standalone GR channels
	And Create new standalone GR Event 
	And Create greenroom passcode details 
	And Get greenroom passcode details
 	And Delete greenroom passcode details

Scenario: Check Text and Email Links Apis
	Given Check producer app access
	And Send Email Text Link 
	#And Send Phone Text Link 

Scenario: Check Token and Logs Apis
	Given Check producer app access
	And Refresh Bl-Token
	And Get Tokbox Session
	And Post Logs  
	And Get Logs