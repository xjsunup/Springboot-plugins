package flyway.db.manager;

import lombok.extern.slf4j.Slf4j;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.MigrationInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by xuejian.sun on 2018/10/5.
 */
@Slf4j
@Component
public class Upgrade {

    @Autowired
    private Flyway flyway;

    public void execCommand(FlywayCommand flywayCommand){
        log.info("开始执行 flyway:{} 操作",flywayCommand);
        switch(flywayCommand){
            case CLEAN:flyway.clean();break;
            case VALIDATE:flyway.validate();break;
            case MIGRATE:flyway.migrate();break;
            case INFO: printInfo();break;
            default:
                log.info("unSupport command {}",flywayCommand);
        }
    }

    private void printInfo(){
        MigrationInfoService infoService = flyway.info();
        Arrays.stream(infoService.all())
                .forEach(info -> {
                    log.info("checksum ====> {}",info.getChecksum());
                    log.info("description ===> {}",info.getDescription());
                    log.info("executionTime ===> {}",info.getExecutionTime());
                    log.info("installedBy ===> {}",info.getInstalledBy());
                    log.info("installedOn ===> {}",info.getInstalledOn());
                    log.info("installedRank ===> {}",info.getInstalledRank());
                    log.info("script ===> {}",info.getScript());
                    log.info("state ===> {}",info.getState());
                    log.info("type ===> {}",info.getType());
                    log.info("version ===> {}",info.getVersion());
                });

    }
}
