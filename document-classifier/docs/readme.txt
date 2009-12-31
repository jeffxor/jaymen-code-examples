The project has been build using maven2.

Once maven is installed and configured simple run the following command from the project root:

$>mvn package

This will compile, test and package the application. Once this completes you will find an executable jar
file in the target directory. The application can then simple be run by

$>cd target
$> java -jar lateralminds-0.0.1-SNAPSHOT.jar  ../docs/vocabulary.csv ../docs/input.txt

There are 4 main classes to my design.

The CsvVocabularyLoader which deals with reading the csv file and constructing a vocabulary model that can be used
by to score a Document. The CsvVocabularyLoader hands of it's work to the CategoryBuilder class, in this case the 
concrete CategoryBuilder is the CsvCategoryBuilder which handles Category builder with csv separate fields.

The Vocabulary is model is represented by the Vocabulary class. It contains a Collection of Categories. Each Category
contains a name and Collection of Phrases for the Category. A Phrase simple contains the phrase text and the weight
associated to it.

The Document class deals with loading the documents text from a file. In this case a simple BufferedReader is used
to read line by line of the file. Each line of the file is cleaned and converted into the correct format. To keep things 
simple the string split method was used with a regex and the resulting tokens added to a buffer and converted to 
lower case. This allows for simple searching of the document's text using the phrase as a regex. One small problem with
the use of regex for cleaning the file input is that it strip all characters that are none word eg. "it's" becomes "it s".

The Document class also contains the name of the document and it's score against the vocabulary. It also provides a
simple print statement to output the results as requested.

The last class of importance is the DocumentProcessor. It takes both the document and the vocabulary and performs
the matching of phrases and scoring. It again uses a simple regex and java's Matcher class to determine how many times
a phrase appears in the document's text.


 
