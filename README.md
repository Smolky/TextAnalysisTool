# UMUTextStats
> Retrieves statictical information from texts

## Description
This application is a tool to retrieve statictics from a corpora to apply machine learning algorithms. It is based on LIWC (https://liwc.wpengine.com/), a standard about retrieving statictics of texts but with the intend to 1) make an open source similar application, 2) create dimensions for specific domains.

This application is an console application. A web graphic interface can be found at https://github.com/Smolky/TextAnalysisToolGUI

There are a set of predefined dimensions to use. These are some samples

- *LengthDimension*: Gets the length of the text
- *SentenceCountDimension*: Counts the number of sentences inside the text
- *CompositeDimension*: Allows to apply the composite pattern to group dimensions

Once we have defined which dimensions we want to use, we can analyze a bunch of texts

For example, for this input
```
the lazy dog jumps over the quick brown fox
El veloz murciélago hindú comía feliz cardillo y kiwi. La cigüeña tocaba el saxofón detrás del palenque de paja.
```

will output
```
word-count,sentences,words-per-sentence
9,1,9
19,2,9.5
```

## Instalation
### Prerequisites
This project has been developed in Java. Requires Java 1.8 to work

### Creating JAR
This project manages his dependencies using Maven. Once the project is loaded into Eclipse (or another IDE) you need to build its .JAR file to run

### Parameters
The parameters of the application are

- -c The path to the config fle
- -s The path to the source files. A directory which contains the files to anaylze
- -f The format output. For example, the format `%s, ` outputs the results divided by ","

## Tests
The tests are located inside the TextAnalysisTool/src/es/um/dis/umutextstats/tests/ folder

## Assets
### Config
This is a sample of a configuration that uses the wordcountdimension

```xml
<?xml version="1.0" encoding="UTF-8"?>
<configuration>
    
    <!-- Use spanish dictionaries -->
    <directory_folder>assets/dictionaries/es/</directory_folder>
    
    
    <!-- Configuration -->
    <dimensions>
        <dimension>
            <key>wc</key>
            <class>WordCountDimension</class>
            <description>Counts how many words there are in the text</description>
        </dimension>
  </dimension>
</configuration>
```

### Dictionaries
Dictionaries are a set of words and regexpresions to match words within the texts. Dictionaries have these format

```
lorem
ipsum
word with spaces
lorem.*
```

While parsing, each of thease words are search inside the text as a whole word using the POSIX word boundaries. The `.*` shortcut will match everything until a word boundary was found.

This is an example about a complex dictionary
```
\w{3,}(a|d|ón|z|te|is|ie|umbre|@|@s)
NEG:\w{3,}(ma|ta)
NEG:(arpa)
(noche|piel|gente|clase|imagen|nieve|mano|foto|cárcel|parte)
(acompañante)
```

Here we can see at the first line we want to match words with 3 or more characters that ends of certain suffixs. 

The sentences which starts with `NEG:\` will count as negative matches. This is useful to split complex regular expressions into more easy ones.

#### Common pitfalls ####
Building complex dictionaries could lead to common pitfalls and mistakes. For example, these dictionary:
```
lorem
lorem ipsum
```

against the text

```
lorem ipsum
```

will match 2 matches and it is possible to not to be the desired result.


## Dimension
Each dimension analyzes certain parts of the text. 

The application provides built-in dimensions to match the regular cases and some extensible dimensions to parametrize some aspects. These include dimensions to get the word count, length, word average, etc and other dimensions to retrieve texts from a dictionary

```xml
<!-- This dimension allows to capture positive numbers with a regex pattern -->
<dimension>
  <key>positive-numbers</key>
  <description>Total of positive numbers identified</description>
  <class>PatternDimension</class>
  <pattern>\b\+?[1-9]\d*\b</pattern>
</dimension>


## Contributing
1. Fork it (<https://github.com/smolky/textanalysistool>)
2. Create your feature branch (`git checkout -b feature/fooBar`)
3. Commit your changes (`git commit -am 'Add some fooBar'`)
4. Push to the branch (`git push origin feature/fooBar`)
5. Create a new Pull Request
