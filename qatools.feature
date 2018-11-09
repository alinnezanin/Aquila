Feature: Teste da FSM


Scenario: use valid data test
    Given <http://toolsqa.com/automation-practice-form/>
	When use-valid-data:
    |firstname|lastname|datepicker|sex-0|exp-0|profession-0|Selenium Automation Hybrid Framework|tool-0|Africa|Switch Commands|
    |Aline|Zanin|09/10/1991|sex-0|exp-0|profession-0|Selenium Automation Hybrid Framework|tool-0|Africa|Switch Commands|
	And click[submit]
	
Scenario: checked test
    Given <http://toolsqa.com/automation-practice-form/>
	When checked[profession]
	|profession|
	|Automation Tester|
    
