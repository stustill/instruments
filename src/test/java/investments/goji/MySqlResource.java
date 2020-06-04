package investments.goji;

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;
import org.testcontainers.containers.MySQLContainer;

import java.util.Map;

public class MySqlResource implements QuarkusTestResourceLifecycleManager {
    private MySQLContainer<?> mysql;

    @Override
    public Map<String, String> start() {
        mysql = new MySQLContainer<>();
        mysql.start();
        return Map.of(
            "quarkus.datasource.username", mysql.getUsername(),
            "quarkus.datasource.password", mysql.getPassword(),
            "quarkus.datasource.jdbc.url", mysql.getJdbcUrl(),
            "quarkus.datasource.reactive.url", mysql.getJdbcUrl().replace("jdbc:", "")
        );
    }

    @Override
    public void stop() {
        mysql.stop();
    }
}
