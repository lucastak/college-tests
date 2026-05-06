package geometria;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CirculoTest {

    private Circulo circulo;
    private List<double[]> casosArea;
    private List<double[]> casosPerimetro;

    @BeforeEach
    void setup() {
        circulo = new Circulo(1);

        casosArea = new ArrayList<>();
        casosArea.add(new double[] { 1, Math.PI * 1 * 1 });
        casosArea.add(new double[] { 2, Math.PI * 2 * 2 });
        casosArea.add(new double[] { 3.5, Math.PI * 3.5 * 3.5 });

        casosPerimetro = new ArrayList<>();
        casosPerimetro.add(new double[] { 1, 2 * Math.PI * 1 });
        casosPerimetro.add(new double[] { 2, 2 * Math.PI * 2 });
        casosPerimetro.add(new double[] { 3.5, 2 * Math.PI * 3.5 });

    }

    @Test
    void deveCalcularAreaDoCirculo() {
        for (double[] caso : casosArea) {
            circulo.setRaio(caso[0]);
            assertEquals(caso[1], circulo.area(), 0.0001);
        }
    }

    @Test
    void deveCalcularPerimetroDoCirculo() {
        for (double[] caso : casosPerimetro) {
            circulo.setRaio(caso[0]);
            assertEquals(caso[1], circulo.perimetro(), 0.0001);
        }
    }

    @Test
    void deveSetarRaioPositivo() {
        circulo.setRaio(2);
        assertEquals(2, circulo.getRaio());
    }

    @Test
    void deveLancarExcecaoAoSetarRaioNegativo() {
        assertThrows(GeometriaException.class, () -> circulo.setRaio(-1));
    }
}
