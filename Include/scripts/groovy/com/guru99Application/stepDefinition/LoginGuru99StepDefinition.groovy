package com.guru99Application.stepDefinition
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.Scenario
import cucumber.api.java.After
import cucumber.api.java.AfterStep
import cucumber.api.java.Before
import cucumber.api.java.BeforeStep
import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class LoginGuru99StepDefinition {

	@Before(order = 1)
	def preSetup(){
		WebUI.openBrowser("")

		WebUI.maximizeWindow()
	}

	@Before(order = 2)
	def setup(){
		WebUI.deleteAllCookies()

		WebUI.waitForPageLoad(30)
	}
	
	

	@After
	public cleanup(){

		WebUI.takeScreenshot("C:/Users/Admin/Desktop/Katalon Studio Training/screenshots/test.jpeg")
	}

	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Given("User navigates to demo application login page")
	def navigatesToApplicationUrl() {

		WebUI.navigateToUrl("http://demo.guru99.com/v4")
	}

	@When("User enters username as (.*)")
	def enterUsername(String username) {

		WebUI.sendKeys(findTestObject('Page_Guru99 Bank Home Page/input_UserID'), username)
	}

	@And("User enters password as (.*)")
	def enterUserPassword(String password) {

		WebUI.sendKeys(findTestObject('Page_Guru99 Bank Home Page/input_Password'), password)
	}

	@And("User click login button")
	def clickLoginButton() {

		WebUI.click(findTestObject('Page_Guru99 Bank Home Page/input_LoginButton'))
	}

	@Then("User successfully logins to the application")
	def verifyApplicationLogin(){

		assert WebUI.getWindowTitle() == "Guru99 Bank Manager HomePage"

		WebUI.closeBrowser()
	}

	@Then("User gets an invalid user message")
	def verifyInvalidUserMessage(){

		assert WebUI.getAlertText() == "User or Password is not valid"

		WebUI.acceptAlert()

		WebUI.closeBrowser()
	}
}