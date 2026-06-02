package geometria;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RetanguloTest {

    private Retangulo retangulo;
    private List<double[]> casosArea;
    private List<double[]> casosPerimetro;

    @BeforeEach
    void setup() {
        retangulo = new Retangulo(1, 1);

        casosArea = new ArrayList<>();
        casosArea.add(new double[] { 1, 1, 1 * 1 });
        casosArea.add(new double[] { 2, 2, 2 * 2 });
        casosArea.add(new double[] { 3.5, 4.5, 3.5 * 4.5 });

        casosPerimetro = new ArrayList<>();
        casosPerimetro.add(new double[] { 1, 1, 2 * 1 + 2 * 1 });
        casosPerimetro.add(new double[] { 2, 2, 2 * 2 + 2 * 2 });
        casosPerimetro.add(new double[] { 3.5, 4.5, 2 * 3.5 + 2 * 4.5 });
    }

    @Test
    void deveCalcularAreaDoRetangulo() {
        for (double[] caso : casosArea) {
            retangulo.setBase(caso[0]);
            retangulo.setAltura(caso[1]);
            assertEquals(caso[2], retangulo.area(), 0.0001);
        }
    }

    @Test
    void deveCalcularPerimetroDoRetangulo() {
        for (double[] caso : casosPerimetro) {
            retangulo.setBase(caso[0]);
            retangulo.setAltura(caso[1]);
            assertEquals(caso[2], retangulo.perimetro(), 0.0001);
        }
    }

    @Test
    void deveSetarBasePositivo() {
        retangulo.setBase(2);
        assertEquals(2, retangulo.getBase());
    }

    @Test
    void deveLancarExcecaoAoSetarBaseNegativo() {
        assertThrows(GeometriaException.class, () -> retangulo.setBase(-1));
    }

    @Test
    void deveSetarAlturaPositivo() {
        retangulo.setAltura(2);
        assertEquals(2, retangulo.getAltura());
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
