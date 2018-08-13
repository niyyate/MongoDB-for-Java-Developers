# Setting Up Logger
## Maven + Spark (Web Application)

create a log4j.properties file
```java
# Root logger option
log4j.rootLogger=INFO, file

# Direct log messages to a log file
log4j.appender.file=org.apache.log4j.RollingFileAppender

#Redirect to Tomcat logs folder
#log4j.appender.file.File=${catalina.home}/logs/logging.log

log4j.appender.file.File=/logs/logigng.log
log4j.appender.file.MaxFileSize=10MB
log4j.appender.file.MaxBackupIndex=10
log4j.appender.file.layout=org.apache.log4j.PatternLayout
log4j.appender.file.layout.ConversionPattern=%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n
```
Save in a similar location 
```java
/Users/MrsGrandChamps/[projectName]/src/main/resources/log4j.properties 
```
Watch this video for more insight 
[**Logging and Log4j.properties Explained**](https://www.youtube.com/watch?v=-GkRuFU_sUg)
