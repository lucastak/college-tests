package com.example;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.example.Calculadora;

class CalculadoraTest {

    @Test
    void deveSomarDoisNumeros() {
        Calculadora calculadora = new Calculadora();
        List<double[]> casos = new ArrayList<>();
        casos.add(new double[] { 2, 3, 5 });
        casos.add(new double[] { 10, 7, 17 });
        casos.add(new double[] { -1, 4, 3 });

        for (double[] caso : casos) {
            double resultado = calculadora.somar(caso[0], caso[1]);
            assertEquals(caso[2], resultado, 0.0001);
        }
    }

    @Test
    void deveDiminuirDoisNumeros() {
        Calculadora calculadora = new Calculadora();
        List<double[]> casos = new ArrayList<>();
        casos.add(new double[] { 5, 2, 3 });
        casos.add(new double[] { 20, 8, 12 });
        casos.add(new double[] { 4, 9, -5 });

        for (double[] caso : casos) {
            double resultado = calculadora.diminuir(caso[0], caso[1]);
            assertEquals(caso[2], resultado, 0.0001);
        }
    }
}
