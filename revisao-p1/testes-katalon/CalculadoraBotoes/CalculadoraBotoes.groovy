import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.annotation.SetUp
import com.kms.katalon.core.annotation.TearDown

@SetUp
void setUp() {
	println("Iniciando teste da Calculadora de Botões")
	WebUI.openBrowser('http://127.0.0.1:5500/calculadora-botoes.html')
	WebUI.maximizeWindow()
}

// Simulando uma tupla: Numero 1, Numero 2, Operação, Resultado Esperado
// Note que para clicar em botões como "12", teríamos que clicar no "1" e depois no "2".
// Para simplificar, vamos assumir cliques em botões numéricos unitários (ex: 1 + 5 = 6)
List<Tuple> dt = List.of(
	new Tuple("1", "5", "+", "6"),
	new Tuple("8", "2", "-", "6"),
	new Tuple("3", "3", "*", "9"),
	new Tuple("9", "3", "/", "3")
)

for(Tuple t : dt) {
	String num1 = t.get(0)
	String num2 = t.get(1)
	String op = t.get(2)
	String esperado = t.get(3)
	
	// Seleção dinâmica do botão baseado no valor numérico
	// Aqui simulamos que temos mapeado os botões no Object Repository como "btn_1", "btn_2", etc.
	WebUI.click(findTestObject("Botoes/btn_" + num1))
	
	if (op == "+") {
		WebUI.click(findTestObject("Botoes/btn_somar"))
	} else if (op == "-") {
		WebUI.click(findTestObject("Botoes/btn_subtrair"))
	} else if (op == "*") {
		WebUI.click(findTestObject("Botoes/btn_multiplicar"))
	} else if (op == "/") {
		WebUI.click(findTestObject("Botoes/btn_dividir"))
	}
	
	WebUI.click(findTestObject("Botoes/btn_" + num2))
	
	// Clicar no botão igual para processar o resultado
	WebUI.click(findTestObject("Botoes/btn_igual"))
	
	// Verificar se o visor da calculadora exibe o resultado correto
	WebUI.verifyElementText(findTestObject("Botoes/visor_resultado"), esperado)
	
	// Clicar no botão de limpar (Clear) para a próxima iteração
	WebUI.click(findTestObject("Botoes/btn_limpar"))
}

@TearDown
void tearDown() {
	WebUI.closeBrowser()
}
