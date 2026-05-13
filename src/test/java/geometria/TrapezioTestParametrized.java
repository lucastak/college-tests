package geometria;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class TrapezioTestParametrized {

    private Trapezio trapezio;

    @BeforeEach
    void setup() {
        trapezio = new Trapezio(1, 1, 1, 1, 1);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1, 1, 1, 1, 1",
            "2, 2, 2, 2, 2, 4",
            "3.5, 4.5, 5.5, 6.5, 7.5, 22"
    })
    void deveCalcularAreaDoTrapezio(double baseMaior, double baseMenor, double altura, double ladoEsq, double ladoDir,
            double areaEsperada) {
        trapezio.setBaseMaior(baseMaior);
        trapezio.setBaseMenor(baseMenor);
        trapezio.setAltura(altura);
        trapezio.setLadoEsq(ladoEsq);
        trapezio.setLadoDir(ladoDir);
        assertEquals(areaEsperada, trapezio.area(), 0.0001);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1, 1, 1, 1, 4",
            "2, 2, 2, 2, 2, 8",
            "3.5, 4.5, 5.5, 6.5, 7.5, 22"
    })
    void deveCalcularPerimetroDoTrapezio(double baseMaior, double baseMenor, double altura, double ladoEsq,
            double ladoDir, double perimetroEsperado) {
        trapezio.setBaseMaior(baseMaior);
        trapezio.setBaseMenor(baseMenor);
        trapezio.setAltura(altura);
        trapezio.setLadoEsq(ladoEsq);
        trapezio.setLadoDir(ladoDir);
        assertEquals(perimetroEsperado, trapezio.perimetro(), 0.0001);
    }

    @ParameterizedTest
    @ValueSource(doubles = { 0.5, 1, 2, 3.25, 7.8, 10 })
    void deveSetarBaseMaiorPositivo(double valor) {
        trapezio.setBaseMaior(valor);
        assertEquals(valor, trapezio.getBaseMaior());
    }

    @ParameterizedTest
    @ValueSource(doubles = { 0.5, 1, 2, 3.25, 7.8, 10 })
    void deveSetarBaseMenorPositivo(double valor) {
        trapezio.setBaseMenor(valor);
        assertEquals(valor, trapezio.getBaseMenor());
    }

    @ParameterizedTest
    @ValueSource(doubles = { 0.5, 1, 2, 3.25, 7.8, 10 })
    void deveSetarAlturaPositivo(double valor) {
        trapezio.setAltura(valor);
        assertEquals(valor, trapezio.getAltura());
    }

    @ParameterizedTest
    @ValueSource(doubles = { 0.5, 1, 2, 3.25, 7.8, 10 })
    void deveSetarLadoEsqPositivo(double valor) {
        trapezio.setLadoEsq(valor);
        assertEquals(valor, trapezio.getLadoEsq());
    }

    @ParameterizedTest
    @ValueSource(doubles = { 0.5, 1, 2, 3.25, 7.8, 10 })
    void deveSetarLadoDirPositivo(double valor) {
        trapezio.setLadoDir(valor);
        assertEquals(valor, trapezio.getLadoDir());
    }

    @Test
    void deveLancarExcecaoAoSetarBaseMaiorNegativo() {
        assertThrows(GeometriaException.class, () -> trapezio.setBaseMaior(-1));
    }

    @Test
    void deveLancarExcecaoAoSetarBaseMenorNegativo() {
        assertThrows(GeometriaException.class, () -> trapezio.setBaseMenor(-1));
    }

    @Test
    void deveLancarExcecaoAoSetarAlturaNegativo() {
        assertThrows(GeometriaException.class, () -> trapezio.setAltura(-1));
    }

    @Test
    void deveLancarExcecaoAoSetarLadoEsqNegativo() {
        assertThrows(GeometriaException.class, () -> trapezio.setLadoEsq(-1));
    }

    @Test
    void deveLancarExcecaoAoSetarLadoDirNegativo() {
        assertThrows(GeometriaException.class, () -> trapezio.setLadoDir(-1));
    }

    @ParameterizedTest
    @CsvSource({
            "-1, 1, 1, 1, 1",
            "1, -1, 1, 1, 1",
            "1, 1, -1, 1, 1",
            "1, 1, 1, -1, 1",
            "1, 1, 1, 1, -1",
            "0, 1, 1, 1, 1",
            "1, 0, 1, 1, 1",
            "1, 1, 0, 1, 1",
            "1, 1, 1, 0, 1",
            "1, 1, 1, 1, 0"
    })
    void deveLancarExcecaoAoCriarTrapezioComValoresInvalidos(double baseMaior, double baseMenor, double altura,
            double ladoEsq, double ladoDir) {
        assertThrows(GeometriaException.class, () -> new Trapezio(baseMaior, baseMenor, altura, ladoEsq, ladoDir));
    }
}
