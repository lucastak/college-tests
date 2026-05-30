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
	println("O TESTE COMEÇOU");
	WebUI.openBrowser("http://localhost/teste/calculadora.html");
}

TestObject inpOperandoA, inpOperandoB, selOperador, btnCalcular, inpResultado, divResultado;

inpOperandoA = findTestObject("Object Repository/CDT4/Page_CALCULADORA/input_OPERANDO A OPERADOROPERANDO BRESULTAD_26af2d");
selOperador  = findTestObject("Object Repository/CDT4/Page_CALCULADORA/select_-");
inpOperandoB = findTestObject("Object Repository/CDT4/Page_CALCULADORA/input_OPERANDO A OPERADOROPERANDO BRESULTAD_1d7cbd");
btnCalcular  = findTestObject("Object Repository/CDT4/Page_CALCULADORA/input_OPERANDO A OPERADOROPERANDO BRESULTAD_193736");
inpResultado = findTestObject("Object Repository/CDT4/Page_CALCULADORA/input_OPERANDO A OPERADOROPERANDO BRESULTAD_d2f426");
divResultado = findTestObject("Object Repository/CDT4/Page_CALCULADORA/div_50");

List<Tuple> dt = List.of(
	new Tuple( "23.3", "40", "63.3", "+" ),
	new Tuple( "4", "10", "40", "*" ),
	new Tuple( "40", "4", "10", "/" ),
	new Tuple( "10", "40", "50", "+" ),
	new Tuple( "15", "40", "55", "+" )
);

for( Tuple t : dt ) {
	WebUI.setText(inpOperandoA, t.get(0));
	WebUI.selectOptionByValue(selOperador, t.get(3), false);
	WebUI.setText(inpOperandoB, t.get(1));
	WebUI.click(btnCalcular);
	WebUI.verifyElementAttributeValue(inpResultado, "value", t.get(2), 0);
	WebUI.verifyElementText(divResultado, t.get(2));
}

@TearDownIfFailed
void tearDownIfFailed() {
	println( "O TESTE FALHOU!" );
}

@TearDownIfPassed
void TearDownIfPassed() {
	println("O TESTE FOI BEM SUCEDIDO!");
}

@TearDownIfError
void tearDownIfError() {
	println("UM ERRO INESPERADO OCORREU DURANTE O TESTE!");
}

@TearDown
void tearDown() {
	println("O TESTE TERMINOU");
	WebUI.closeBrowser();
}