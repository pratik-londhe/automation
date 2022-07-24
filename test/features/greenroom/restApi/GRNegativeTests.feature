@negative_test_gr_api

Feature: GR Negative Testing

Scenario: Negative Testing for Write-State
	Given Check producer app access
	And Login to greenroom with greenroom
	And Pass incorrect JSON file
	And Pass incorrect data inside JSON file 