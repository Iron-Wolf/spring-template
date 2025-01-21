# spring-template

Test with a sideway YAML config file loading in a SpringBoot app, with `ObjectMapper` and `YAMLFactory`.  
Projet is juste a test, this has nothing of value in it.  
Maybe the conf is not up to date, with the lateast Spring standard but this is working so...

## IntelliJ stuff
~~If IntelliJ is lost with lombock processors, go to : `Settings | Build, Execution, Deployement | Compiler | Annotation Processors`  
And check that `Obtain processors from project classpath` is selected.~~  
-> just setup the pom.xml correctly and it's should work  

~~To configure maven config : `Settings | Build, Execution, Deployement | Build Tools | Maven`  
Override settings and path config.~~  
-> juste use `maven.config` file (see below)  

## Maven config
Customize Maven with a file : `.mvn/maven.config`  
```properties
# sample for Windows (remove this line in the file)
-Dmaven.repo.local=..\.m2\repository
# must override the two 'settings' to work (remove this line in the file)
--settings=..\.m2\settings.xml
--global-settings=..\.m2\settings.xml
```
Config ref : https://maven.apache.org/ref/current/maven-embedder/cli.html  
Other ref : https://maven.apache.org/ref/current/maven-model-builder/index.html  
