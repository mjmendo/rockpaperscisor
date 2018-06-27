**RockPaperScissors Console Game**

Design:
* App as host client.
* RockPaperScissors as game holder (service) orchestrating communication with outside.
* Dependency Injection approach.
* Interface for RockPaperScissors class only, since I dont consider necesary if class has few access methods.

App has:
* dependency injection pattern to enable testability testability
* mocks
* build and dependency management with maven

Missing:
* move the dependency injection to some lib (Inversion of Control)
* logging strategy, like SLF4J to have better debugging knowledge.
* using some lib to get rid of boilerplate code (Lombok)


How to run:
* install maven 3 and run mvn package
* execute `java -jar ./target/rock-paper-scissors-1.0-SNAPSHOT-jar-with-dependencies.jar`
