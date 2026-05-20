package geometria;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import java.util.function.DoubleFunction;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class CilindroTestParametrized {

    private static final DoubleFunction<Circulo> FABRICA_CIRCULO = CilindroTest::criarCirculo;

    @ParameterizedTest
    @MethodSource("dadosAreaCilindro")
    void deveCalcularAreaDoCilindro(double raio, double altura) {
        Circulo base = FABRICA_CIRCULO.apply(raio);
        Cilindro cilindro = new Cilindro(base, altura);

        double esperado = 2 * base.area() + altura * base.perimetro();
        assertEquals(esperado, cilindro.area(), 0.0001);
    }

    private static Stream<Arguments> dadosAreaCilindro() {
        return Stream.of(
                arguments(2.0, 5.0),
                arguments(1.5, 3.0),
                arguments(4.0, 2.5));
    }

    @ParameterizedTest
    @CsvSource({
            "2, 5",
            "1.5, 3",
            "4, 2.5"
    })
    void deveCalcularVolumeDoCilindro(double raio, double altura) {
        Circulo base = FABRICA_CIRCULO.apply(raio);
        Cilindro cilindro = new Cilindro(base, altura);

        double esperado = base.area() * altura;
        assertEquals(esperado, cilindro.volume(), 0.0001);
    }

    @ParameterizedTest
    @CsvSource({
            "2, 5",
            "3, 7",
            "1.2, 9.4"
    })
    void deveRetornarBaseEAlturaInformadasNoConstrutor(double raio, double altura) {
        Circulo base = FABRICA_CIRCULO.apply(raio);
        Cilindro cilindro = new Cilindro(base, altura);

        assertSame(base, cilindro.getBase());
        assertEquals(altura, cilindro.getAltura(), 0.0001);
    }

    //Passar parametro no teste:
    //exemplo do professor atraves de metodo
    //private static stream (arguments) dadosTestDobrat () { return stream.of(arguments.of(5,10), arguments.of(-2-4))}
}
