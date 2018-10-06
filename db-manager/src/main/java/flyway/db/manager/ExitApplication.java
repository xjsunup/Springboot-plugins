package flyway.db.manager;

import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Created by xuejian.sun on 2018/10/6.
 */
@SpringBootApplication
public class ExitApplication {

    @Bean
    public ExitCodeGenerator exitCodeGenerator(){
        return () -> 42;
    }

    public static void main(String[] args) {
        System.exit(SpringApplication.exit(SpringApplication.run(Application.class,args)));
    }
}
