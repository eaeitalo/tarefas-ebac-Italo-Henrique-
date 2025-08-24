package repository;

import com.Usuario;
import com.repository.UsuarioRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {

    private EntityManagerFactory emf;
    private EntityManager em;
    private UsuarioRepository repository;

    @BeforeAll
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("test-pu");
        em = emf.createEntityManager();
        repository = new UsuarioRepository();

        try {
            var field = UsuarioRepository.class.getDeclaredField("entityManager");
            field.setAccessible(true);
            field.set(repository, em);
        } catch (Exception e) {
            fail("Erro ao injetar EntityManager: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Deve salvar um usuário com sucesso")
    public void testSalvarUsuario() {
        em.getTransaction().begin();

        Usuario usuario = new Usuario("Italo Teste", "italo@teste.com", "11999999999");
        repository.salvar(usuario);

        em.getTransaction().commit();

        assertNotNull(usuario.getId());
        assertEquals("Italo Teste", usuario.getNome());
    }

    @Test
    @DisplayName("Deve listar todos os usuários")
    public void testListarUsuarios() {
        em.getTransaction().begin();

        repository.salvar(new Usuario("Usuario 1", "user1@teste.com", "11111111111"));
        repository.salvar(new Usuario("Usuario 2", "user2@teste.com", "22222222222"));

        em.getTransaction().commit();

        List<Usuario> usuarios = repository.listarTodos();
        assertTrue(usuarios.size() >= 2);
    }

    @AfterAll
    public void tearDown() {
        if (em != null) em.close();
        if (emf != null) emf.close();
    }
}
