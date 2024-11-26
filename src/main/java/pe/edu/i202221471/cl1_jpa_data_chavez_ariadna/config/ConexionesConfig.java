package pe.edu.i202221471.cl1_jpa_data_chavez_ariadna.config;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
public class ConexionesConfig {
    @Value("${DB_WORLD_URL}")
    private String dbWorldUrl;
    @Value("${DB_WORLD_USER}")
    private String dbWorldUser;
    @Value("${DB_WORLD_PASS}")
    private String dbWorldPass;
    @Value("${DB_WORLD_DRIVER}")
    private String dbWorldDriver;

    @Bean
    public HikariDataSource hikariDataSource() {
        HikariConfig config = new HikariConfig();
        // Configurar propiedad de conexion a BD
        config.setJdbcUrl(dbWorldUrl);
        config.setUsername(dbWorldUser);
        config.setPassword(dbWorldPass);
        config.setDriverClassName(dbWorldDriver);
        // Configurar el pool de conexiones
        config.setMaximumPoolSize(30);     // Número máximo de conexiones en el pool
        config.setMinimumIdle(4);          // Número mínimo de conexiones inactivas en el pool
        config.setIdleTimeout(240000);     // Tiempo de inactividad en milisegundos (4 minutos)
        config.setConnectionTimeout(45000);// Tiempo de espera en milisegundos para obtener una conexión (45 segundos)
        System.out.println("####### HikariCP initialized ####");
            return new HikariDataSource(config);
    }
}


