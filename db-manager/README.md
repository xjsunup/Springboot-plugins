## Flyway Setting
```
flyway.baseline-description 对执行迁移时基准版本的描述.
flyway.baseline-on-migrate  当迁移时发现目标schema非空，而且带有没有元数据的表时，是否自动执行基准迁移，默认false.
flyway.baseline-version 开始执行基准迁移时对现有的schema的版本打标签，默认值为1.
flyway.check-location   检查迁移脚本的位置是否存在，默认false.
flyway.clean-on-validation-error    当发现校验错误时是否自动调用clean，默认false.
flyway.enabled  是否开启flywary，默认true.
flyway.encoding 设置迁移时的编码，默认UTF-8.
flyway.ignore-failed-future-migration   当读取元数据表时是否忽略错误的迁移，默认false.
flyway.init-sqls    当初始化好连接时要执行的SQL.
flyway.locations    迁移脚本的位置，默认db/migration.
flyway.out-of-order 是否允许无序的迁移，默认false.
flyway.password 目标数据库的密码.
flyway.placeholder-prefix   设置每个placeholder的前缀，默认${.
flyway.placeholder-replacementplaceholders  是否要被替换，默认true.
flyway.placeholder-suffix   设置每个placeholder的后缀，默认}.
flyway.placeholders.[placeholder name]  设置placeholder的value
flyway.schemas  设定需要flywary迁移的schema，大小写敏感，默认为连接默认的schema.
flyway.sql-migration-prefix 迁移文件的前缀，默认为V.
flyway.sql-migration-separator  迁移脚本的文件名分隔符，默认__
flyway.sql-migration-suffix 迁移脚本的后缀，默认为.sql
flyway.tableflyway  使用的元数据表名，默认为schema_version
flyway.target   迁移时使用的目标版本，默认为latest version
flyway.url  迁移时使用的JDBC URL，如果没有指定的话，将使用配置的主数据源
flyway.user 迁移数据库的用户名
flyway.validate-on-migrate  迁移时是否校验，默认为true.

```
 --- 
 
>注意点： flyway的sql升级文件命令默认是以V开头，例如V1__test_table.sql,V1后面必须是以2个下划线分开

>默认升级脚本存放路径都是 classpath:db/migration下,如需更改请手动指定需要升级的目录
 

## 使用
> 可启动spring-boot项目直接进行升级操作，也可以使用maven相关命令进行操作

## spring-boot工程的操作
1. 在不同的application-*.properties中配置你当前需要升级或清理的数据库配置信息,
在vmOption中传入参数 ```-DDB_ENV={your profile name}``` 然后启动项目即可完成对数据库的升级
2. 使用spring-boot来构建项目会默认执行**migrate**操作,相当于**flyway:migrate**指令,在项目内部也做了一些其他指令操作的
调用，例如你启动项目的时候可以发现有FlywayCommand的日志输出,你可以使用日志提示的指令来做你想做的操作，这个指令我们需要通过
program arguments传入：例如 
```
info: 打印当前连接的数据库配置信息
clean: 清除当前数据库的所有配置
validate: check一些连接信息
migrate: 数据库升级操作
```
参数传递参考以下图片
![image][start.png]

 ---

## flyway maven的使用

> 在pom.xml中配置了许多profile来应对不同环境的数据库升级，我们通过引用这些配置来进行数据库操作

**例如以下这段配置：**
> profile
```$xslt
<profile>
    <id>flyway_test</id>
     <properties>
         <flyway.db.dirver>com.mysql.jdbc.Driver</flyway.db.dirver>
         <flyway.db.user>flyway</flyway.db.user>
         <flyway.db.password>flyway_123456</flyway.db.password>
         <flyway.db.url>jdbc:mysql://192.168.1.9:3306/test?useUnicode=true&amp;characterEncoding=UTF-8&amp;useSSL=false</flyway.db.url>
         <!--<flyway.location>classpath:db/migration/</flyway.location>-->
     </properties>
 </profile>
```
> flyway maven-plugin配置
```$xslt
            <plugin>
                <groupId>org.flywaydb</groupId>
                <artifactId>flyway-maven-plugin</artifactId>
                <version>4.0.3</version>
                <configuration>
                    <driver>${flyway.db.dirver}</driver>
                    <url>${flyway.db.url}</url>
                    <user>${flyway.db.user}</user>
                    <password>${flyway.db.password}</password>
                </configuration>
            </plugin>
```
在flyway插件中我们引用了我们的配置，这样可以做到指定环境的数据库升级
>关于flyway-maven命令操作
-P 指定具体的profile Id ， -X输出debug信息，用于跟踪异常问题
```$xslt
mvn flyway:migrate -Pflyway_test -X  

mvn flyway:clean -Pflyway_test -X

mvn flyway:validate -Pflyway_test -X
```