package controller;

import com.Usuario;
import com.controller.UsuarioBean;
import com.italo.service.UsuarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UsuarioBeanTest {

    @Mock
    private UsuarioService usuarioService;

    private UsuarioBean usuarioBean;

    @BeforeEach
    void setUp() {
        usuarioBean = new UsuarioBean();
        usuarioBean.usuarioService = usuarioService;
    }

    @Test
    void deveInicializarComUsuarioVazio() {
        assertNotNull(usuarioBean.getUsuario());
        assertNull(usuarioBean.getUsuario().getId());
    }

    @Test
    void deveChamarServiceAoCadastrar() throws Exception {
        Usuario usuario = new Usuario("Italo", "italo@teste.com", "11999999999");
        usuarioBean.setUsuario(usuario);

        usuarioBean.cadastrar();

        verify(usuarioService, times(1)).cadastrarUsuario(usuario);
        assertNotNull(usuarioBean.getUsuario()); // Deve ter criado novo usuário
    }

    @Test
    void deveListarUsuariosDoService() {
        List<Usuario> usuariosMock = Arrays.asList(
                new Usuario("Usuario 1", "user1@teste.com", "11111111111"),
                new Usuario("Usuario 2", "user2@teste.com", "22222222222")
        );

        when(usuarioService.listarUsuarios()).thenReturn(usuariosMock);

        List<Usuario> resultado = usuarioBean.getUsuarios();

        assertEquals(2, resultado.size());
        verify(usuarioService, times(1)).listarUsuarios();
    }
}
