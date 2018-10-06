package flyway.db.manager.config;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * Created by xuejian.sun on 2018/10/4.
 */
@Configuration
public class FlywayConfiguration {

    @Autowired
    private Flyway flyway;



    /**
     * spring-boot集成后的flyway启动时会默认执行migrate操作，
     * 重写此类，可根据配置来确定初始化时是否需要migrate动作
     * @return
     */
    @ConditionalOnProperty(
            name = "flyway.init.autoMigrate",
            havingValue = "false",
            matchIfMissing = true
    )
    @Bean(name = "flywayInitializer")
    @Primary
    public MyFlywayInitializer flywayInitializer(){
        return new MyFlywayInitializer(flyway,null);
    }

}
