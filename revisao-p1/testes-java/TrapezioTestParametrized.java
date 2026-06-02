package geometria;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
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
    @CsvFileSource(resources = "/geometria/trapezio-perimetro.csv", numLinesToSkip = 1)
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
