import DAOTest.ClientDAOTest;
import DAOTest.ProdutoDAOTest;
import DAOTest.VendaDAOTest;
import ServiceTest.ClientServiceTest;
import ServiceTest.ProdutosServiceTest;
import ServiceTest.VendaServiceTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ProdutoDAOTest.class,
        ProdutosServiceTest.class,
        VendaDAOTest.class,
        VendaServiceTest.class,
        ClientDAOTest.class,
        ClientServiceTest.class
})
public class AllTests {
}
