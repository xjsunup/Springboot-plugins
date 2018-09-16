@ echo off 
title jersey-swagger
cd ..
@ set JAVA_OPT= -Xms128m -Xmx512m -XX:MaxPermSize=128M -XX:+PrintGCDateStamps -XX:+PrintGCDetails -Xloggc:./gc.log
@ set JAVA_HOME=D:\xuejian.sun\java\JDK\jdk1.8.0_25_win
@ echo %JAVA_HOME%
@ "%JAVA_HOME%\bin\java.exe" %JAVA_OPT%  -Djava.library.path=cfg -cp "config;lib/*;cfg" org.springframework.boot.loader.JarLauncher

@ pause