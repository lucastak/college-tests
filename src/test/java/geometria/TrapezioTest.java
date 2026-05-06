package geometria;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TrapezioTest {

    private Trapezio trapezio;
    private List<double[]> casosArea;
    private List<double[]> casosPerimetro;

    @BeforeEach
    void setup() {
        trapezio = new Trapezio(1, 1, 1, 1, 1);

        casosArea = new ArrayList<>();
        casosArea.add(new double[] { 1, 1, 1, 1, 1, ((1 + 1) * 1) / 2.0 });
        casosArea.add(new double[] { 2, 2, 2, 2, 2, ((2 + 2) * 2) / 2.0 });
        casosArea.add(new double[] { 3.5, 4.5, 5.5, 6.5, 7.5, ((3.5 + 4.5) * 5.5) / 2.0 });

        casosPerimetro = new ArrayList<>();
        casosPerimetro.add(new double[] {
                1, 1, 1, 1, 1,
                1 + 1 + 1 + 1
        });
        casosPerimetro.add(new double[] {
                2, 2, 2, 2, 2,
                2 + 2 + 2 + 2
        });
        casosPerimetro.add(new double[] {
                3.5, 4.5, 5.5, 6.5, 7.5,
                3.5 + 4.5 + 6.5 + 7.5
        });
    }

    @Test
    void deveCalcularAreaDoTrapezio() {
        for (double[] caso : casosArea) {
            trapezio.setBaseMaior(caso[0]);
            trapezio.setBaseMenor(caso[1]);
            trapezio.setAltura(caso[2]);
            trapezio.setLadoEsq(caso[3]);
            trapezio.setLadoDir(caso[4]);
            assertEquals(caso[5], trapezio.area(), 0.0001);
        }
    }

    @Test
    void deveCalcularPerimetroDoTrapezio() {
        for (double[] caso : casosPerimetro) {
            trapezio.setBaseMaior(caso[0]);
            trapezio.setBaseMenor(caso[1]);
            trapezio.setAltura(caso[2]);
            trapezio.setLadoEsq(caso[3]);
            trapezio.setLadoDir(caso[4]);
            assertEquals(caso[5], trapezio.perimetro(), 0.0001);
        }
    }

    @Test
    void deveSetarBaseMaiorPositivo() {
        trapezio.setBaseMaior(2);
        assertEquals(2, trapezio.getBaseMaior());
    }

    @Test
    void deveLancarExcecaoAoSetarBaseMaiorNegativo() {
        assertThrows(GeometriaException.class, () -> trapezio.setBaseMaior(-1));
    }

    @Test
    void deveSetarBaseMenorPositivo() {
        trapezio.setBaseMenor(2);
        assertEquals(2, trapezio.getBaseMenor());
    }

    @Test
    void deveLancarExcecaoAoSetarBaseMenorNegativo() {
        assertThrows(GeometriaException.class, () -> trapezio.setBaseMenor(-1));
    }

    @Test
    void deveSetarAlturaPositivo() {
        trapezio.setAltura(2);
        assertEquals(2, trapezio.getAltura());
    }

    @Test
    void deveLancarExcecaoAoSetarAlturaNegativo() {
        assertThrows(GeometriaException.class, () -> trapezio.setAltura(-1));
    }

    @Test
    void deveSetarLadoEsqPositivo() {
        trapezio.setLadoEsq(2);
        assertEquals(2, trapezio.getLadoEsq());
    }

    @Test
    void deveLancarExcecaoAoSetarLadoEsqNegativo() {
        assertThrows(GeometriaException.class, () -> trapezio.setLadoEsq(-1));
    }

    @Test
    void deveSetarLadoDirPositivo() {
        trapezio.setLadoDir(2);
        assertEquals(2, trapezio.getLadoDir());
    }

    @Test
    void deveLancarExcecaoAoSetarLadoDirNegativo() {
        assertThrows(GeometriaException.class, () -> trapezio.setLadoDir(-1));
    }

    @Test
    void deveLancarExcecaoAoCriarTrapezioComBaseMaiorNegativo() {
        assertThrows(GeometriaException.class, () -> new Trapezio(-1, 1, 1, 1, 1));
    }

    @Test
    void deveLancarExcecaoAoCriarTrapezioComBaseMenorNegativo() {
        assertThrows(GeometriaException.class, () -> new Trapezio(1, -1, 1, 1, 1));
    }

    @Test
    void deveLancarExcecaoAoCriarTrapezioComAlturaNegativo() {
        assertThrows(GeometriaException.class, () -> new Trapezio(1, 1, -1, 1, 1));
    }

    @Test
    void deveLancarExcecaoAoCriarTrapezioComLadoEsqNegativo() {
        assertThrows(GeometriaException.class, () -> new Trapezio(1, 1, 1, -1, 1));
    }

    @Test
    void deveLancarExcecaoAoCriarTrapezioComLadoDirNegativo() {
        assertThrows(GeometriaException.class, () -> new Trapezio(1, 1, 1, 1, -1));
    }

    @Test
    void deveLancarExcecaoAoCriarTrapezioComBaseMaiorZero() {
        assertThrows(GeometriaException.class, () -> new Trapezio(0, 1, 1, 1, 1));
    }

    @Test
    void deveLancarExcecaoAoCriarTrapezioComBaseMenorZero() {
        assertThrows(GeometriaException.class, () -> new Trapezio(1, 0, 1, 1, 1));
    }

    @Test
    void deveLancarExcecaoAoCriarTrapezioComAlturaZero() {
        assertThrows(GeometriaException.class, () -> new Trapezio(1, 1, 0, 1, 1));
    }

    @Test
    void deveLancarExcecaoAoCriarTrapezioComLadoEsqZero() {
        assertThrows(GeometriaException.class, () -> new Trapezio(1, 1, 1, 0, 1));
    }

    @Test
    void deveLancarExcecaoAoCriarTrapezioComLadoDirZero() {
        assertThrows(GeometriaException.class, () -> new Trapezio(1, 1, 1, 1, 0));
    }
}
