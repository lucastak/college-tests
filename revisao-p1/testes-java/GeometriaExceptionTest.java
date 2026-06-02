package geometria;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

class GeometriaExceptionTest {

    @Test
    void deveCriarExcecaoComMensagemECausa() {
        Throwable causa = new IllegalArgumentException("erro interno");

        GeometriaException exception = new GeometriaException("mensagem", causa);

        assertEquals("mensagem", exception.getMessage());
        assertSame(causa, exception.getCause());
    }

    @Test
    void deveCriarExcecaoApenasComMensagem() {
        GeometriaException exception = new GeometriaException("mensagem");

        assertEquals("mensagem", exception.getMessage());
    }

    @Test
    void deveCriarExcecaoApenasComCausa() {
        Throwable causa = new IllegalStateException("falha");

        GeometriaException exception = new GeometriaException(causa);

        assertSame(causa, exception.getCause());
        assertEquals(causa.toString(), exception.getMessage());
    }
}
