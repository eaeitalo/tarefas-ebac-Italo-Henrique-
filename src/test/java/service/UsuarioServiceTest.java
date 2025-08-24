package service;

import com.Usuario;
import com.italo.repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UsuarioServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    private UsuarioService usuarioService;

    @BeforeEach
    void setUp() {
        usuarioService = new UsuarioService();
        // Injeta o repository manualmente (como não temos CDI em testes)
        usuarioService.usuarioRepository = usuarioRepository;
    }

    @Test
    void deveCadastrarUsuarioComSucesso() throws Exception {
        // Arrange
        Usuario usuario = new Usuario("Italo", "italo@teste.com", "11999999999");

        // Act
        usuarioService.cadastrarUsuario(usuario);

        // Assert
        verify(usuarioRepository, times(1)).salvar(usuario);
    }

    @Test
    void deveLancarExcecaoQuandoNomeForVazio() {
        Usuario usuario = new Usuario("", "italo@teste.com", "11999999999");

        Exception exception = assertThrows(Exception.class, () -> {
            usuarioService.cadastrarUsuario(usuario);
        });

        assertEquals("Nome é obrigatório!", exception.getMessage());
        verify(usuarioRepository, never()).salvar(any());
    }

    @Test
    void deveLancarExcecaoQuandoEmailForInvalido() {
        Usuario usuario = new Usuario("Italo", "email-invalido", "11999999999");

        Exception exception = assertThrows(Exception.class, () -> {
            usuarioService.cadastrarUsuario(usuario);
        });

        assertEquals("Email inválido!", exception.getMessage());
        verify(usuarioRepository, never()).salvar(any());
    }

    @Test
    void deveListarUsuarios() {

        usuarioService.listarUsuarios();

        verify(usuarioRepository, times(1)).listarTodos();
    }
}