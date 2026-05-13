package geometria;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class FigurasContratoTestParametrized {

    @ParameterizedTest
    @CsvSource({
            "1, 3.141592653589793, 6.283185307179586",
            "2, 12.566370614359172, 12.566370614359172",
            "3.5, 38.48451000647496, 21.991148575128552"
    })
    void circuloDeveRespeitarContratoDeFiguraPlana(double raio, double areaEsperada, double perimetroEsperado) {
        FiguraPlana figura = new Circulo(raio);

        assertEquals(areaEsperada, figura.area(), 0.0001);
        assertEquals(perimetroEsperado, figura.perimetro(), 0.0001);
    }

    @ParameterizedTest
    @CsvSource({
            "2, 3, 6, 10",
            "1.5, 4, 6, 11",
            "7, 2.5, 17.5, 19"
    })
    void retanguloDeveRespeitarContratoDeFiguraPlana(double base, double altura, double areaEsperada,
            double perimetroEsperado) {
        FiguraPlana figura = new Retangulo(base, altura);

        assertEquals(areaEsperada, figura.area(), 0.0001);
        assertEquals(perimetroEsperado, figura.perimetro(), 0.0001);
    }

    @ParameterizedTest
    @CsvSource({
            "2, 5",
            "1.5, 3",
            "4, 2.5"
    })
    void cilindroDeveRespeitarContratoDeFiguraEspacial(double raio, double altura) {
        FiguraEspacial figura = new Cilindro(new Circulo(raio), altura);

        assertEquals((Math.PI * raio * raio) * altura, figura.volume(), 0.0001);
        assertEquals(2 * (Math.PI * raio * raio) + altura * (2 * Math.PI * raio), figura.area(), 0.0001);
    }
}
