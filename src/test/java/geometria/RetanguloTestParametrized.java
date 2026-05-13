package geometria;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class RetanguloTestParametrized {

    private Retangulo retangulo;

    @BeforeEach
    void setup() {
        retangulo = new Retangulo(1, 1);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1, 1",
            "2, 2, 4",
            "3.5, 4.5, 15.75"
    })
    void deveCalcularAreaDoRetangulo(double base, double altura, double areaEsperada) {
        retangulo.setBase(base);
        retangulo.setAltura(altura);
        assertEquals(areaEsperada, retangulo.area(), 0.0001);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1, 4",
            "2, 2, 8",
            "3.5, 4.5, 16"
    })
    void deveCalcularPerimetroDoRetangulo(double base, double altura, double perimetroEsperado) {
        retangulo.setBase(base);
        retangulo.setAltura(altura);
        assertEquals(perimetroEsperado, retangulo.perimetro(), 0.0001);
    }

    @ParameterizedTest
    @ValueSource(doubles = { 0.5, 1, 2, 3.25, 7.8, 10 })
    void deveSetarBasePositivoComValueSource(double base) {
        retangulo.setBase(base);
        assertEquals(base, retangulo.getBase());
    }

    @Test
    void deveLancarExcecaoAoSetarBaseNegativo() {
        assertThrows(GeometriaException.class, () -> retangulo.setBase(-1));
    }

    @ParameterizedTest
    @ValueSource(doubles = { 0.5, 1, 2, 3.25, 7.8, 10 })
    void deveSetarAlturaPositivoComValueSource(double altura) {
        retangulo.setAltura(altura);
        assertEquals(altura, retangulo.getAltura());
    }

    @Test
    void deveLancarExcecaoAoSetarAlturaNegativo() {
        assertThrows(GeometriaException.class, () -> retangulo.setAltura(-1));
    }

    @Test
    void deveLancarExcecaoAoCriarRetanguloComBaseNegativo() {
        assertThrows(GeometriaException.class, () -> new Retangulo(-1, 1));
    }

    @Test
    void deveLancarExcecaoAoCriarRetanguloComAlturaNegativo() {
        assertThrows(GeometriaException.class, () -> new Retangulo(1, -1));
    }

    @Test
    void deveLancarExcecaoAoCriarRetanguloComBaseZero() {
        assertThrows(GeometriaException.class, () -> new Retangulo(0, 1));
    }

    @Test
    void deveLancarExcecaoAoCriarRetanguloComAlturaZero() {
        assertThrows(GeometriaException.class, () -> new Retangulo(1, 0));
    }
}
