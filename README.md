# spring-template

Test with a side YAML config file loaded in a SpringBoot app (with `ObjectMapper` and `YAMLFactory`).  
This is just a test.  

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

## Override classpath directory from CLI
To add file in the ressources (not only the application.yml), you can use this syntax :  
`java -cp new-config:application.jar application.main.class`  
- `new-config` : a directory containing the overridden files
- `application.main.class` :  fully qualified name of the class with the 'main' (can be found in MANIFEST.MF)

There is a catch with the delimiter :  
- windows : `;`
  - ✔ `java -cp C:\Users\path-to-project\target\project.jar org.springframework.boot.loader.launch.JarLauncher`
  - ❌ `java -cp src\test\ressources\donnees\UC001\SC001;C:\Users\path-to-projec\target\project.jar org.springframework.boot.loader.launch.JarLauncher`
- linux : `:`
  - ✔ `java -cp /c/Users/path-to-projec/target/project.jar org.springframework.boot.loader.launch.JarLauncher`
  - ✔ `java -cp src/test/ressources/donnees/UC001/SC001:/c/Users/path-to-projec/target/project.jar org.springframework.boot.loader.launch.JarLauncher`
