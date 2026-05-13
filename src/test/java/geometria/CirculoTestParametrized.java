package geometria;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CirculoTestParametrized {

    private Circulo circulo;

    @BeforeEach
    void setup() {
        circulo = new Circulo(1);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 3.141592653589793",
            "2, 12.566370614359172",
            "3.5, 38.48451000647496"
    })
    void deveCalcularAreaDoCirculo(double raio, double areaEsperada) {
        circulo.setRaio(raio);
        assertEquals(areaEsperada, circulo.area(), 0.0001);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 6.283185307179586",
            "2, 12.566370614359172",
            "3.5, 21.991148575128552"
    })
    void deveCalcularPerimetroDoCirculo(double raio, double perimetroEsperado) {
        circulo.setRaio(raio);
        assertEquals(perimetroEsperado, circulo.perimetro(), 0.0001);
    }

    @ParameterizedTest
    @ValueSource(doubles = { 0.5, 2, 10 })
    void deveSetarRaioPositivo(double raio) {
        circulo.setRaio(raio);
        assertEquals(raio, circulo.getRaio());
    }

    @Test
    void deveLancarExcecaoAoSetarRaioNegativo() {
        assertThrows(GeometriaException.class, () -> circulo.setRaio(-1));
    }
}
