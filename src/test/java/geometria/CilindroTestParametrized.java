package geometria;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CilindroTestParametrized {

    @ParameterizedTest
    @CsvSource({
            "2, 5",
            "1.5, 3",
            "4, 2.5"
    })
    void deveCalcularAreaDoCilindro(double raio, double altura) {
        Circulo base = new Circulo(raio);
        Cilindro cilindro = new Cilindro(base, altura);

        double esperado = 2 * base.area() + altura * base.perimetro();
        assertEquals(esperado, cilindro.area(), 0.0001);
    }

    @ParameterizedTest
    @CsvSource({
            "2, 5",
            "1.5, 3",
            "4, 2.5"
    })
    void deveCalcularVolumeDoCilindro(double raio, double altura) {
        Circulo base = new Circulo(raio);
        Cilindro cilindro = new Cilindro(base, altura);

        double esperado = base.area() * altura;
        assertEquals(esperado, cilindro.volume(), 0.0001);
    }

    @ParameterizedTest
    @CsvSource({
            "2, 5",
            "3, 7",
            "1.2, 9.4"
    })
    void deveRetornarBaseEAlturaInformadasNoConstrutor(double raio, double altura) {
        Circulo base = new Circulo(raio);
        Cilindro cilindro = new Cilindro(base, altura);

        assertSame(base, cilindro.getBase());
        assertEquals(altura, cilindro.getAltura(), 0.0001);
    }
}
