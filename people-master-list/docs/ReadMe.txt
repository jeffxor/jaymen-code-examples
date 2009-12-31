The project has been build using maven2.

Once maven is installed and configured simple run the following command from the project root:

$>mvn package

This will compile, test and package the application. Once this completes you will find an executable jar
file in the target directory. The application can then simple be run by

$>java -jar cyrus-0.0.1-SNAPSHOT.jar

I have used a basic factory pattern to determing what builder to used based on the string read from a file. 
It returns an instance of a builder which is then used to contruct a Person Object which is simply added to 
master list of persons. I have then used simple implementations of comparator to sort the set as requested.