# Translator Team 2 

### Features (So Far):

- translates java into C++ header files for required provided inputs (test000 through test020)
- supports method overriding and overloading

###  Execution:

To execute translator, within sbt run the command with the following format:

```
runxtc -translate file/path/to/test/file.java
```

For example, to translate Test 10:

```
runxtc -translate src/test/java/inputs/Test010/Test010.java
```

Output will be placed in the output.h file within the output directory.

## Project Map:

![Alt text](https://github.com/nyu-oop-fa17/translator-2/blob/master/process.png)


#### Collection of Java AST:
###### TraverseAst.java
####Custom Java Objects to retain data:
###### CustomClassObject.java, CustomMethodClass.java, CustomConstructorClass.java, CustomVariablesClass.java
####CPP Data Layout (Intermediate Data Structure)
######CppDataLayout.java
####Build CPP AST
######CppHeaderASTCreator.java, cppNodeActions.java, CPPAST.java
####Print CPP AST 
######CppHeaderPrinter.java, CppHeaderVisitor.java


### Directory Overview
- README.md

- build.sbt (managed library dependencies and c++ compilation configuration)

- .gitignore (prevent certain files from being commmited to the git repo)

- lib (unmanaged library dependencies, like xtc and its source) 

- logs (logger output)
  *  xtc.log 

- .idea (project settings stored as a set of xml files)

- doc

- output (target c++ source & supporting java_lang library)
  *  output.h

- project (sbt configuration, shouldn't need to be touched)

- src 
  *   logs (logger output)
      -  xtc.log
  *   main
      -  java
         *  edu (translator source code)
      -  resources
         *   xtc.properties (translator properties file)
  *   test
      -   java
          *   edu (translator unit tests)
          *   inputs (translator test inputs)

