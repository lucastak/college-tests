import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.annotation.SetUp
import com.kms.katalon.core.annotation.TearDown

@SetUp
void setUp() {
	WebUI.openBrowser('http://127.0.0.1:5500/formulario-cadastro.html')
	WebUI.maximizeWindow()
}

// 1. Preenchimento de Textos Comuns
WebUI.setText(findTestObject('Formulario/input_Nome'), 'Lucas Santos')
WebUI.setText(findTestObject('Formulario/input_Email'), 'lucas@email.com')

// O setEncryptedText é muito usado para senhas (o Katalon criptografa a string gravada no script)
WebUI.setEncryptedText(findTestObject('Formulario/input_Senha'), 'Senh@Criptografada123')

// 2. Elementos de Seleção (Dropdown / Select)
// Selecionando pela label (texto visível que o usuário lê na tela)
WebUI.selectOptionByLabel(findTestObject('Formulario/select_Estado'), 'São Paulo', false)

// 3. Botões de Rádio e Checkboxes
// Verificando se já não está checado antes de clicar
if (!WebUI.verifyElementChecked(findTestObject('Formulario/radio_GeneroMasculino'), 2, com.kms.katalon.core.model.FailureHandling.OPTIONAL)) {
	WebUI.click(findTestObject('Formulario/radio_GeneroMasculino'))
}

// Marcando os termos de uso (checkbox)
WebUI.check(findTestObject('Formulario/checkbox_TermosDeUso'))

// 4. Submissão do Formulário
WebUI.click(findTestObject('Formulario/btn_Cadastrar'))

// 5. Esperar navegação e verificar a nova página
// Aguarda até 10 segundos para que a URL mude ou a página carregue após o click
WebUI.waitForPageLoad(10)

// Podemos também esperar um elemento específico da página de sucesso ficar visível antes de validar
WebUI.waitForElementVisible(findTestObject('Sucesso/h1_CadastroRealizado'), 10)

// Verifica se a URL atual contém a rota esperada
String urlAtual = WebUI.getUrl()
WebUI.verifyMatch(urlAtual, '.*sucesso.html', true)

// Verifica se a mensagem de sucesso está correta na nova página
WebUI.verifyElementText(findTestObject('Sucesso/h1_CadastroRealizado'), 'Cadastro realizado com sucesso!')

@TearDown
void tearDown() {
	WebUI.closeBrowser()
}
