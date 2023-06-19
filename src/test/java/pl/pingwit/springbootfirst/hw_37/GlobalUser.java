package pl.pingwit.springbootfirst.hw_37;

import com.zaxxer.hikari.HikariDataSource;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
@Component
public class GlobalUser {

    private final UserService userService;

    private static final String URL = "jdbc:postgresql://localhost:5432/hw_35";
    private static final String USERNAME = "pingwit";
    private static final String PASSWORD = "pingwit_password";

    public GlobalUser(UserService userService) {
        this.userService = userService;
    }
    @PostConstruct
    public void init() {
        userService.printUsers();
    }

    @Bean
    private static DataSource createDataSource() {
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl(URL);
        ds.setUsername(USERNAME);
        ds.setPassword(PASSWORD);
        return ds;
    }

    public static void main(String[] args) {
        DataSource dataSource = createDataSource();

        UserRepository userRepository = new UserRepository(dataSource);

        UserService userService = new UserService(userRepository);

        userService.printUsers();
    }

}
