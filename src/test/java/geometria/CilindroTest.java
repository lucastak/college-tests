package geometria;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CilindroTest {

    private Circulo base;
    private Cilindro cilindro;

    @BeforeEach
    void setup() {
        base = new Circulo(2);
        cilindro = new Cilindro(base, 5);
    }

    @Test
    void deveCalcularAreaDoCilindro() {
        double esperado = 2 * base.area() + 5 * base.perimetro();
        assertEquals(esperado, cilindro.area(), 0.0001);
    }

    @Test
    void deveCalcularVolumeDoCilindro() {
        double esperado = base.area() * 5;
        assertEquals(esperado, cilindro.volume(), 0.0001);
    }

    @Test
    void deveRetornarBaseEAlturaInformadasNoConstrutor() {
        assertSame(base, cilindro.getBase());
        assertEquals(5, cilindro.getAltura(), 0.0001);
    }
}
