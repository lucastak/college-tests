package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculadoraTestParametrized {

    private Calculadora calculadora;

    @BeforeEach
    void setup() {
        calculadora = new Calculadora();
    }

    @ParameterizedTest
    @CsvSource({
            "2, 3, 5",
            "10, 7, 17",
            "-1, 4, 3",
            "0.5, 0.25, 0.75"
    })
    void deveSomarDoisNumeros(double a, double b, double esperado) {
        double resultado = calculadora.somar(a, b);
        assertEquals(esperado, resultado, 0.0001);
    }

    @ParameterizedTest
    @CsvSource({
            "5, 2, 3",
            "20, 8, 12",
            "4, 9, -5",
            "0.5, 0.25, 0.25"
    })
    void deveDiminuirDoisNumeros(double a, double b, double esperado) {
        double resultado = calculadora.diminuir(a, b);
        assertEquals(esperado, resultado, 0.0001);
    }
}
