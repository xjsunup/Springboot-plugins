package flyway.db.manager.config;

import org.flywaydb.core.Flyway;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationInitializer;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;

/**
 * Created by xuejian.sun on 2018/10/6.
 */
public class MyFlywayInitializer extends FlywayMigrationInitializer {

    public MyFlywayInitializer(Flyway flyway) {
        super(flyway);
    }

    public MyFlywayInitializer(Flyway flyway, FlywayMigrationStrategy migrationStrategy) {
        super(flyway, migrationStrategy);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        //不做任何处理
    }

    @Override
    public int getOrder() {
        return -1;
    }
}
