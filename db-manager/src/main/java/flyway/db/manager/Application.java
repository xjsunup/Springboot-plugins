package flyway.db.manager;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.util.Optional;

/**
 * Created by xuejian.sun on 2018/10/4.
 */
@Slf4j
@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private Upgrade upgrade;

    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class).web(WebApplicationType.NONE).run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        if(args.length==0){
            log.warn("数据库操作，请参考以下指令");
            FlywayCommand.printCommand();
            return;
        }
        for(String arg : args){
            Optional<FlywayCommand> command = FlywayCommand.from(arg);
            if(!command.isPresent()){
                log.error("未知的指令：{}，无法进行数据库操作",args);
                FlywayCommand.printCommand();
                return;
            }
            upgrade.execCommand(command.get());
        }
    }
}
