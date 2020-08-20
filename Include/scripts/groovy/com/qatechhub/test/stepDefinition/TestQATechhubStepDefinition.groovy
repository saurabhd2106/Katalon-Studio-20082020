package com.qatechhub.test.stepDefinition
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import io.cucumber.datatable.DataTable


class TestQATechhubStepDefinition {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Given("User navigate to test qatechhub website")
	def invokeBrowserAndNavigateToApp() {


		WebUI.openBrowser("")

		WebUI.maximizeWindow()

		WebUI.deleteAllCookies()

		WebUI.waitForPageLoad(30)

		WebUI.navigateToUrl("https://test.qatechhub.com/form-elements/")
	}

	/*@When("User enters all the required details")
	 def userEntersAllDetails(DataTable dataTable) {
	 List<String> dataTableAsList = dataTable.asList();
	 WebUI.sendKeys((findTestObject('Page_Form Elements/input__firstName')), dataTableAsList.get(0))
	 WebUI.sendKeys(findTestObject('Page_Form Elements/input_LastName'), dataTableAsList.get(1))
	 WebUI.sendKeys(findTestObject('Page_Form Elements/input__EmailId'), dataTableAsList.get(2))
	 if(dataTableAsList.get(4) == "Male") {
	 WebUI.click(findTestObject('Page_Form Elements/input__maleRadioButton'))
	 } else {
	 }
	 WebUI.sendKeys(findTestObject('Page_Form Elements/input__phoneNumber'), dataTableAsList.get(3))
	 WebUI.selectOptionByLabel(findTestObject('Page_Form Elements/select_Course'), "Cypress", false)
	 }*/

	@When("User enters all the required details")
	def userEntersAllDetails(DataTable dataTable) {

		Map<String, String> dataTableAsMap = dataTable.asMap(String.class, String.class)


		WebUI.sendKeys(findTestObject('Page_Form Elements/input__firstName'), dataTableAsMap.get("FirstName"))

		WebUI.sendKeys(findTestObject('Page_Form Elements/input_LastName'),dataTableAsMap.get("LastName"))


		WebUI.sendKeys(findTestObject('Page_Form Elements/input__EmailId'),dataTableAsMap.get("EmailId"))

		if(dataTableAsMap.get("Gender") == "Male") {


			WebUI.click(findTestObject('Page_Form Elements/input__maleRadioButton'))
		} else {
		}

		WebUI.sendKeys(findTestObject('Page_Form Elements/input__phoneNumber'), dataTableAsMap.get("PhoneNumber"))



		WebUI.selectOptionByLabel(findTestObject('Page_Form Elements/select_Course'), dataTableAsMap.get("Course"), false)
	}

	@And("User clicks on submit button")
	def userClickOnSubmit(){
		WebUI.click(findTestObject('Page_Form Elements/button_Submit'))
	}

	@Then("Success message appears on the screen")
	def I_verify_the_status_in_step(String status) {
		assert WebUI.getText(findTestObject('Page_Form Elements/successMessage')) == "You have successfully filled in the form!"
	}
}