# This is the template folder for ECSE 429 - Assignments 3.


We include an overview of the files included in this repository. Additionally, we provide relevant commands to correctly install the dependencies.

## Overview of files

###  __Folder: `res/`__
The `res/` folder contains two `.jar` files which constitute the system-under-test. Both files have been included as dependencies in the `pom.xml` file. However, in order for the project to build successfully, you must install both `.jar` files manually on your maven build path. To do so, you must run the following commands (while in the current directory):
* For the `cruisecontrol-api-1.0-SNAPSHOT.jar` file: <br>
```
mvn install:install-file -Dfile=res/cruisecontrol-api-1.0-SNAPSHOT.jar -DgroupId=ca.mcgill.ecse429.cruisecontrol -DartifactId=api -Dversion=1.0 -Dpackaging=jar
```
* For the `cruisecontrol-impl-1.0-SNAPSHOT.jar` file: <br>
```
mvn install:install-file -Dfile=res/cruisecontrol-impl-1.0-SNAPSHOT.jar -DgroupId=ca.mcgill.ecse429.cruisecontrol -DartifactId=impl -Dversion=1.0 -Dpackaging=jar
```

---

### __File: `documentation.txt`__

This file contains some _additional documentation_ regarding the source code packaged inside the `.jar` files mentioned above.  

---

### __File: `src/main/java/ecse429/Runner.java`__

This file is simply a sample file that gives an example on how to access the contents of the system-under-test (the `.jar` files indicated above). It is included only as an explanatory file, and it is not directly relevant to the work that you need to do for the assignment. You may delete this file if you wish.

_NOTE:_ When you first clone the repository, you will encounter some compilation errors related to the imports. These errors should disappear once you  install the `.jar` files, as indicated above.

---

### __File: `src/main/java/ecse429/insertjsonStatechartHere.txt`__

This is a placeholder file. You should replace this file by the `.json` file you generate from your statechart in GraphWalker Studio.

## Additional details

For further details on how to run your GraphWalker project, please refer to [Tutorial 8](https://github.com/McGill-ECSE429-Winter2022/tutorials/wiki/Tutorial-8:-Model-based-testing).
