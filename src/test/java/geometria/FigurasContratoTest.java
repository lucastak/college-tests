package geometria;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class FigurasContratoTest {

    @Test
    void circuloDeveRespeitarContratoDeFiguraPlana() {
        FiguraPlana figura = new Circulo(2);

        assertEquals(Math.PI * 4, figura.area(), 0.0001);
        assertEquals(2 * Math.PI * 2, figura.perimetro(), 0.0001);
    }

    @Test
    void retanguloDeveRespeitarContratoDeFiguraPlana() {
        FiguraPlana figura = new Retangulo(2, 3);

        assertEquals(6, figura.area(), 0.0001);
        assertEquals(10, figura.perimetro(), 0.0001);
    }

    @Test
    void cilindroDeveRespeitarContratoDeFiguraEspacial() {
        FiguraEspacial figura = new Cilindro(new Circulo(2), 5);

        assertEquals((Math.PI * 4) * 5, figura.volume(), 0.0001);
        assertEquals(2 * (Math.PI * 4) + 5 * (2 * Math.PI * 2), figura.area(), 0.0001);
    }
}
