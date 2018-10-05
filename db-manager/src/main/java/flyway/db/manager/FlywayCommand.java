package flyway.db.manager;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Optional;

/**
 * Created by xuejian.sun on 2018/10/5.
 */
@Slf4j
public enum FlywayCommand {
    MIGRATE("migrate","数据库升级"),

    CLEAN("clean","数据库清理"),

    INFO("info","数据库详情"),

    VALIDATE("validate","校验基本配置");

    private String command;

    private String description;

    FlywayCommand(String command,String description) {
        this.command = command;
        this.description = description;
    }

    public static Optional<FlywayCommand> from(String command) {
        return Arrays.stream(FlywayCommand.values())
                .filter(flywayCommand
                        -> flywayCommand.name().equals(command)
                        || flywayCommand.command.equals(command))
                .findFirst();
    }

    public static void printCommand(){
        log.info("======================== 数据库操作COMMAND ==================================");
        Arrays.stream(FlywayCommand.values())
                .forEach((flywayCommand -> log.info("指令:[{},{}] =========>> {}",flywayCommand.name(),flywayCommand.command,flywayCommand.description)));
    }
}
