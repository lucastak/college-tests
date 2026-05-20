package suites;

import org.junit.platform.suite.api.ExcludePackages;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectPackages({ "geometria", "com.example" })
@ExcludePackages("com.example")
class ProjetoSuiteTest {
    // Suite de testes:
    // 1) procura testes nos pacotes definidos em @SelectPackages
    // 2) remove os pacotes definidos em @ExcludePackages
}
