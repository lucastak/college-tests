import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling as FailureHandling

/* =======================================================================
 *  GUIA DE REVISÃO PARA A PROVA - KATALON STUDIO (WEB UI)
 * =======================================================================
 * Este script serve como uma 'cola' ou guia de estudos contendo as 
 * principais funções e comandos do Katalon que caem em provas.
 * Leia os comentários de cada seção para entender o comportamento.
 * ======================================================================= */

// ---------------------------------------------------------
// 1. ABRINDO E CONFIGURANDO O NAVEGADOR
// ---------------------------------------------------------
// Abre o browser (se vazio, abre na página em branco)
WebUI.openBrowser('')
// Navega para a URL especificada
WebUI.navigateToUrl('https://katalon-demo-cura.herokuapp.com/')
// Maximiza a janela (muito importante para evitar que botões fiquem escondidos na responsividade)
WebUI.maximizeWindow()


// ---------------------------------------------------------
// 2. INTERAGINDO COM CAMPOS DE TEXTO
// ---------------------------------------------------------
// setText: Apaga o que tem no campo e escreve o texto novo
WebUI.setText(findTestObject('Login/txt_UserName'), 'John Doe')
// sendKeys: Apenas envia teclas (não apaga o campo antes). Muito útil para enviar comandos como ENTER no teclado
WebUI.sendKeys(findTestObject('Login/txt_UserName'), org.openqa.selenium.Keys.chord(org.openqa.selenium.Keys.ENTER))
// setEncryptedText: Usado para senhas, o Katalon salva uma string criptografada ao invés da senha exposta no script
WebUI.setEncryptedText(findTestObject('Login/txt_Password'), 'g3/DOGG74jC3Flrr3yH+3D/yKbOqqUNM')


// ---------------------------------------------------------
// 3. INTERAGINDO COM BOTÕES E CLIQUES
// ---------------------------------------------------------
// click: Clique simples padrão com o botão esquerdo do mouse
WebUI.click(findTestObject('Login/btn_Login'))
// doubleClick: Clique duplo (útil em elementos de tabelas ou grids que requerem double-click para editar)
WebUI.doubleClick(findTestObject('Tabela/item_Tabela'))
// rightClick: Clique com o botão direito (geralmente para abrir menu de contexto)
WebUI.rightClick(findTestObject('Tabela/item_Tabela'))


// ---------------------------------------------------------
// 4. INTERAGINDO COM DROPDOWNS (SELECTS)
// ---------------------------------------------------------
// No Katalon existem 3 formas clássicas de selecionar opções em um combo box <select>
// O último parâmetro (false) refere-se ao isRegex (se a string buscada é uma expressão regular)

// a) Pelo atributo 'value' (Ex: <option value="sp">São Paulo</option> -> Busca por "sp")
WebUI.selectOptionByValue(findTestObject('Form/sel_Dropdown'), 'sp', false)
// b) Pelo texto visível (O que o usuário efetivamente lê na tela)
WebUI.selectOptionByLabel(findTestObject('Form/sel_Dropdown'), 'São Paulo', false)
// c) Pelo index (A posição do item na lista; o primeiro item é o 0)
WebUI.selectOptionByIndex(findTestObject('Form/sel_Dropdown'), 1)


// ---------------------------------------------------------
// 5. CAIXAS DE SELEÇÃO (CHECKBOX) E BOTÕES DE RÁDIO
// ---------------------------------------------------------
// check: Marca um checkbox ou input radio
WebUI.check(findTestObject('Form/chk_Termos'))
// uncheck: Desmarca um checkbox
WebUI.uncheck(findTestObject('Form/chk_Termos'))
// verifyElementChecked: Valida se o elemento já está marcado. Retorna um booleano (true/false)
// Timeout de 2 segundos. Usando OPTIONAL para o teste seguir em frente mesmo se falhar (não interromper)
boolean estaMarcado = WebUI.verifyElementChecked(findTestObject('Form/chk_Termos'), 2, FailureHandling.OPTIONAL)


// ---------------------------------------------------------
// 6. ESPERAS (WAITS / TIMEOUTS) - EXTREMAMENTE IMPORTANTE
// ---------------------------------------------------------
// waitForPageLoad: Aguarda a página terminar de carregar por completo (neste caso, timeout de 10s)
WebUI.waitForPageLoad(10)
// waitForElementPresent: Aguarda o elemento existir no código HTML (DOM), mesmo que invisível ao usuário
WebUI.waitForElementPresent(findTestObject('Form/lbl_Carregando'), 10)
// waitForElementVisible: Aguarda o elemento aparecer na tela visivelmente
WebUI.waitForElementVisible(findTestObject('Form/lbl_Carregando'), 10)
// delay: Força uma parada "dura" no script, travando a thread. **EVITE USAR**, prefira sempre os "waitFor..." dinâmicos!
WebUI.delay(2) 


// ---------------------------------------------------------
// 7. VALIDAÇÕES (VERIFY / ASSERTS)
// ---------------------------------------------------------
// verifyElementPresent: Confere se o elemento HTML existe no DOM da página atual
WebUI.verifyElementPresent(findTestObject('Header/logo'), 5)
// verifyElementText: Confere o texto contido numa tag (como parágrafo, span ou div)
WebUI.verifyElementText(findTestObject('Mensagem/lbl_Sucesso'), 'Processo concluído')
// verifyElementAttributeValue: Confere se um atributo (ex: 'class', 'value', 'placeholder') tem o valor exato passado
WebUI.verifyElementAttributeValue(findTestObject('Input/txt_Email'), 'placeholder', 'Digite seu e-mail', 2)
// verifyMatch: Função poderosa! Compara dois textos ou varáveis. Pode inclusive usar Expressão Regular (Regex).
String textoTela = WebUI.getText(findTestObject('Mensagem/lbl_Sucesso'))
WebUI.verifyMatch(textoTela, 'Processo concluído', false) // o 'false' indica que não estamos usando Regex


// ---------------------------------------------------------
// 8. ALERTAS DO NAVEGADOR (POPUPS JS: alert, prompt, confirm)
// ---------------------------------------------------------
// Aguarda o popup de JavaScript aparecer
WebUI.waitForAlert(5)
// Coleta o texto do alerta para poder validar
String textoAlerta = WebUI.getAlertText()
// Clica no botão 'OK' do popup (Aceitar)
WebUI.acceptAlert()
// Clica no botão 'Cancelar' do popup (Recusar)
// WebUI.dismissAlert()


// ---------------------------------------------------------
// 9. FINALIZANDO E LIMPANDO O TESTE
// ---------------------------------------------------------
// Fecha o navegador (encerra o chromedriver/geckodriver)
WebUI.closeBrowser()

/* =======================================================================
 * DICA DE OURO PARA A PROVA:
 * Lembre-se sempre da diferença entre PRESENT e VISIBLE:
 * - PRESENT = O elemento existe no HTML (DOM), mas pode estar oculto por CSS (display: none) ou fora da visão.
 * - VISIBLE = O elemento está fisicamente aparecendo na tela.
 *
 * Se tomar erro de "ElementNotInteractableException" (Elemento não interativo), geralmente significa que 
 * ele está bloqueado por outro elemento ou fora da tela. Soluções:
 * 1. Use "WebUI.waitForElementClickable(...)"
 * 2. Role a tela até ele: "WebUI.scrollToElement(...)"
 * ======================================================================= */
