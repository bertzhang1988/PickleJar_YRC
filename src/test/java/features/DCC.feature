Feature: Dock Command Center 

Scenario: Test Forced Shipment Summary
	Given the "dcc.url" web page is available
	When I log in using "dcc.login"
	Then I should see "dcc.forced.shipment.summary"
	And the following table elements from "dcc.forced.shipment.headers":
	|Loc|
	|Dest|
	|Trailer|
	|Status|
	|Count|
	
Scenario: Test Guaranted Shipments
	Given the "dcc.url" web page is available
	When I log in using "dcc.login"
	Then I should see "dcc.guaranted.shipments.text"
	And the following table elements from "dcc.guaranteed.shipments.headers":
	|Total Pros|
	|Late Total|
	|Total HU|
	|Total Weight|
	
	
	
	