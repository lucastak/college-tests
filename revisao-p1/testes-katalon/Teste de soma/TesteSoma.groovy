import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.SetUp
import com.kms.katalon.core.annotation.TearDown
import com.kms.katalon.core.annotation.TearDownIfError
import com.kms.katalon.core.annotation.TearDownIfFailed
import com.kms.katalon.core.annotation.TearDownIfPassed
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

@SetUp
void setUp() {
	println("O TESTE COMEÇOU")
	WebUI.openBrowser('')
	WebUI.navigateToUrl('http://127.0.0.1:5500/testes-calculadora/index.html')
}

TestObject inpPrimeiro, inpSegundo, btnSomar, btnSubtrair, btnMultiplicar, btnDividir, pResultado

inpPrimeiro    = findTestObject('Page_Calculadora Bsica/input_Primeiro nmero')
inpSegundo     = findTestObject('Page_Calculadora Bsica/input_Segundo nmero')
btnSomar       = findTestObject('Page_Calculadora Bsica/button_Somar')
btnSubtrair    = findTestObject('Page_Calculadora Bsica/button_Subtrair')
btnMultiplicar = findTestObject('Page_Calculadora Bsica/button_Multiplicar')
btnDividir     = findTestObject('Page_Calculadora Bsica/button_Dividir')
pResultado     = findTestObject('Page_Calculadora Bsica/p_resultado')

List<Tuple> dt = List.of(
	new Tuple("10", "5", "Resultado: 15", "+"),
	new Tuple("20", "4", "Resultado: 16", "-"),
	new Tuple("6", "7", "Resultado: 42", "*"),
	new Tuple("80", "10", "Resultado: 8", "/")
)

for( Tuple t : dt ) {
	WebUI.setText(inpPrimeiro, t.get(0))
	WebUI.setText(inpSegundo, t.get(1))
	
	String op = t.get(3)
	if (op == "+") {
		WebUI.click(btnSomar)
	} else if (op == "-") {
		WebUI.click(btnSubtrair)
	} else if (op == "*") {
		WebUI.click(btnMultiplicar)
	} else if (op == "/") {
		WebUI.click(btnDividir)
	}
	
	WebUI.verifyElementText(pResultado, t.get(2))
}

@TearDownIfFailed
void tearDownIfFailed() {
	println( "O TESTE FALHOU!" )
}

@TearDownIfPassed
void TearDownIfPassed() {
	println("O TESTE FOI BEM SUCEDIDO!")
}

@TearDownIfError
void tearDownIfError() {
	println("UM ERRO INESPERADO OCORREU DURANTE O TESTE!")
}

@TearDown
void tearDown() {
	println("O TESTE TERMINOU")
	WebUI.closeBrowser()
}
