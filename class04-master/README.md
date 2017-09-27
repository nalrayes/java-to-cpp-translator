# Class 4

## Tools: sbt

* sbt is an extensible, interactive build tool.

* Provides commands to build, test and run your code.

  * Those commands are executed in a interactive console.

* Other build tools: Make, Gradle, Stack, Rake, Maven, Ant, ...

* sbt is typically associated with Scala projects, but works equally well for Java projects.

### Dependency Management

* sbt is also a *dependency manager*
  * Most non-trivial software projects have code libraries that they depend on (e.g. JUnit).

  * Where do those libraries come from? Bundled with the code?

  * That presents problems (such as version management).

  * sbt fetches your dependencies from the internet

  * All dependencies that are to be managed by sbt are specified in the file `build.sbt`.

### Structure of sbt projects

* sbt enforces a specific *project structure*

* It has a specific set of conventions for layout of a Java project

* The following questions are all answered by sbt:
 
  * Where does code go?

  * Where to tests go?

  * How about project configuration?

* Every sbt project we work with this semester will have the same structure, as follows:

  * `build.sbt` - project configuration. Where dependencies and custom commands are define

  * `lib` - the directory that contains unmanaged dependencies

  * `logs` - when using the logging class, output will go here as well as the console.

  * `output` - the directory for target code, will also contain provided C++ library code

  * `project` - sbt configuration, you should not need to touch this

  * `src/main/java` - your code for the project

  * `src/test/java` - your unit tests and test inputs for the translator

  * `src/main/resources` - `xtc.properties` configure your team name and other details here.

  * `target` - compiled class files

### sbt Commands

* The following sbt commands will mostly suffice for this course:

  * `compile` - compiles the Java code in your project

  * `run` - looks for the main method and runs it, if there is more
    than one, it gives you a menu; will implicitly invoke
    `compile` if there are any code changes since the last compilation.
  

  * `clean` - removes compiled class files

  * `test` - runs all unit tests in your project; will implicitly invoke
    `compile` if there are any code changes since the last compilation.

  * `test-only` - like `test` but runs only specific tests based on a
    pattern. Globbing allowed with asteriks, e.g., `test-only
    *MethodVisitorTest*`

* The template `build.sbt` for the translator project provides some additional custom commands:

  * `format` - formats all code (C++, Java tests and main sources) using AStyle

  * `compilec` - compiles all C++ code in output directory

  * `execc` - executes C++ in output directory

  * `cpp` - alias for executing both of the previous commands
  
  * `runxtc` - runs the `Boot` class which is the main class of the translator.


## Tools: Git and Github

* Git is a *version control system*

  * Provides change tracking on files and *backup* of versions of
files, if you so choose.

  * Enables multiple people to work on same code without too much headache.

* Git was initially designed and developed by Linus Torvalds for Linux kernel development

* Git is distributed

  * Every Git *working directory* is a full-fledged repository with complete history and full version-tracking capabilities.

  * A *working directory* is just a copy on disk of a *repository*

  * A *repository* is a code base that you want to collaborate on with
    others (often called 'repo' for short).

* Github is a hosting service for Git repositories

  * Github has generously donated an *organization* to us.

  * An organization is just a private site for us to share repositories as a group.
  
  * Github will contain repositories for each of homeworks, in-class code, each team's translator, etc..

  * We will effectively download the code from Github to work on it,
    then we will upload the code back there so other team members can
    retrieve it.

* Basic Git workflow:

  1. First, you `clone` a repository from Github (translation: make a
  local copy of the *remote* repository hosted at Github, you do this
  only once!)
  
  2. Next you `add` new files and modified existing files.
  
  3. Then you `commit` those changes and additions (translation: take a backup of that version and add it to your local repository)
  
  4. Finally, you will `push` the commit to Github (translation: make
  your local repository changes visible to your collaborators).


* After you have cloned a repository your local repository consists of three data structures maintained by Git:

  * the first one is your *working directory* which holds the
    currently checked out version of the files in your repository
    (usually the most recent version).
  

  * the second one is the *index* which acts as a staging area of the
    changes and additions for the next commit.

  * and finally the *repository* that keeps track of all past
    commits. The repository has a pointer called `HEAD` which points
    to the last commit you have made.

* You can propose changes (add it to the *index*) using

  ```git add .```

* To actually commit these changes use

  ```git commit -m "<your commit message>"```

* Now the changes are committed as a new version in your local
  repository and `HEAD` points to that new version. However, the new
  version is not in the remote repository yet (i.e. on Github) and
  hence not visible to others.

* To send those changes to your remote repository, execute

  ```git push origin master```

  or just

  ```git push```


* Interleaved throughout that process you may want to see if your
  teammates have pushed anything. You can get their recent changes by
  executing

  ```git pull origin master```

  or just

  ```git pull```

* When you pull from the remote repository, git tries to auto-merge
  the changes made by your teammates with your local changes that you
  have committed concurrently.

* This is not always possible and may result in conflicts.

* You are responsible to resolve those conflicts manually by editing the files shown by git.

* After changing, you need to mark those files as merged with

  ```git add <filename>```

* Never break the build!! I.e. do not push code that is known to be
  broken. Always run your unit tests before a commit to make sure that
  you have not introduced any regressions in your code.

* Sometimes, you will need to make larger code changes that break the
  build or introduce regressions. In this case, create a *branch* to
  protect your teammates from being affected by those changes. When
  your code is working again, you can merge your branch back
  to the *master* branch.


## Tools: JUnit

* JUnit is a unit testing framework for Java.

* Unit testing refers to the testing of the functionality provided by an individual class.

* Configuration and execution of the unit tests is all managed by sbt.

* You only need to know 3 things...
  1. How to write tests.
  2. How to use assertions.
  3. How to execute tests.

* WARNING: we are using JUnit v4, which introduced significant changes
  from v3. Many online tutorials are using JUnit v3.

### How to write tests

* Create a Java class, put it in the `src/test/java/some/package`
  directory that mirrors the `src/main/java/some/package` directory
  that the code you want to test is located

* Write some test methods (using assertions) and put the `@Test` annotation on that method

* There are also the `@Before`, `@After`, `@BeforeClass` and
  `@AfterClass` annotations (see `ExampleJunitTest.java` in the
  `xtc-demo` repository)

### How to use assertions

* Assertions are functions, provided by JUnit, that test whether
  some expected condition is true.
  
* This is the way we signal to JUnit if tests pass or fail.
  There are many provided assertion types, but essentially
  they all can be reduced to the following..

  ```assertEquals(expected, actual);```

  However, that can be inconvenient, so JUnit provides
  many specialized assertion methods (see `ExampleJunitAssertions.java`
  in the `xtc-demo` repository).

### How to execute tests

* You know already, right?


## Design Patterns

* What are Design Patterns?

  * a general, reusable solution to a commonly occurring problem

  * abstracts from programming language specifics

  * identifies classes and their roles in the solution to a problem

  * patterns are not code, only design

  * sometimes they are indicative of missing language features.

* Classic textbook to learn more about design patterns: "Design
  Patterns: Elements of Reusable Object-Oriented Software" by Erich
  Gamma, Richard Helm, Ralph Johnson, and John Vlissides (Gang of
  Four)

  * useful for job interviews

### Example: Iterator Pattern

* Iterator Pattern

* iterator: an object that provides a standard way to examine all elements of any collection

* uniform interface for traversing many different data structures

* supports concurrent iteration and element removal

```java
for (Iterator<T> iter = l.iterator(); iter.hasNext()) {
  T t = iter.next();
  System.out.println(t);
}
```

### Example: Chain of Responsibility (CoR)

* CoR is a design pattern consisting of a source of *command* objects and a
  series of *processing* objects.

* Each processing object contains logic that defines
  the types of command objects that it can handle;

* A processing *pipeline*, good for programs that pass the same data
  through a series of *phases*.

* Our code example is as follows:

  * A company needs to have any expenditure approved.

  * Depending on the price, the expenditure needs approval by different levels of management.

  * Small priced expenditures require manager approval whereas large priced expenditures require director approval and so on.

  * We can apply the CoR as a design pattern to solve this problem!
 