package geometria;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.Test;

class GeometriaExceptionTestParametrized {

    @ParameterizedTest
    @ValueSource(strings = { "mensagem", "erro", "falha de validacao", "x", "123", "mensagem longa" })
    void deveCriarExcecaoApenasComMensagem(String mensagem) {
        GeometriaException exception = new GeometriaException(mensagem);
        assertEquals(mensagem, exception.getMessage());
    }

    @Test
    void deveCriarExcecaoComMensagemECausa() {
        Throwable causa = new IllegalArgumentException("erro interno");

        GeometriaException exception = new GeometriaException("mensagem", causa);

        assertEquals("mensagem", exception.getMessage());
        assertSame(causa, exception.getCause());
    }

    @Test
    void deveCriarExcecaoApenasComCausa() {
        Throwable causa = new IllegalStateException("falha");

        GeometriaException exception = new GeometriaException(causa);

        assertSame(causa, exception.getCause());
        assertEquals(causa.toString(), exception.getMessage());
    }
}
