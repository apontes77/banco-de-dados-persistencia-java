import com.infnet.domain.Cliente;
import com.infnet.domain.Endereco;
import com.infnet.domain.Pedido;
import com.infnet.domain.enums.TipoCliente;
import com.infnet.repositories.ClienteRepository;
import lombok.val;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Testcontainers
@SpringBootTest
@ContextConfiguration
public class AbstractConfigurationTest {

    @Autowired
    private ClienteRepository clienteRepository;

    @BeforeAll
    public static void setUp() {
        container.withReuse(true);
        container.start();
    }

    @AfterAll
    public static void tearDown() {
        container.stop();
    }

    @BeforeEach
    void init() {
        this.clienteRepository.deleteAll();
    }

    @AfterEach
    void cleanUp() {
        this.clienteRepository.deleteAll();
    }

    @Container
    public static MySQLContainer container = new MySQLContainer("mysql:8.0.30")
            .withDatabaseName("example_db")
            .withUsername("test")
            .withPassword("test");

    @DynamicPropertySource
    public static void overrideProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", container::getJdbcUrl);
        registry.add("spring.datasource.username", container::getUsername);
        registry.add("spring.datasource.password", container::getPassword);
        registry.add("spring.datasource.driver-class-name", container::getDriverClassName);
    }

    @Test
    public void testFindCliente() {
        Cliente cliente = new Cliente();
        cliente.setCpfOuCnpj("");
        cliente.setNome("alex");
        cliente.setTipo(TipoCliente.PESSOA_JURIDICA);
        cliente.setEmail("");
        cliente.setEnderecos(List.of(new Endereco()));
        cliente.setPedidos(List.of(new Pedido()));
        val clienteSaved = clienteRepository.save(cliente);
        val clienteObtained = clienteRepository.findById(clienteSaved.getId());
        assertThat(clienteObtained.get().getNome()).isNotEmpty();
        assertThat(clienteObtained.get().getNome()).isEqualTo("alex");

    }
}
