# CountWords
This is an application that counts the occurrences of the words in a specific text

## Install instructions
1- Have installed and configured JDK 8. Official link: http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html

2- Install eclipse IDE or similar like STS (with installed pluggins) https://spring.io/tools/sts/all

3- Clone the repository.

4- Run the SpringBoot Aplication.

5- Post to localhost REST API (http://localhost:8080/solr/countWords/) the text to analyze. Ex.:
curl -X POST \
  http://localhost:8080/solr/countWords/ \
  -H 'cache-control: no-cache' \
  -H 'postman-token: 52863c48-d7bc-8d0a-8cea-a5043c3db874' \
  -d 'Take this paragraph of text and return an alphabetized list of ALL unique words.  A unique word is any form of a word often communicated with essentially the same meaning. For example, fish and fishes could be defined as a unique word by using their stem fish. For each unique word found in this entire paragraph, determine the how many times the word appears in total. Also, provide an analysis of what sentence index position or positions the word is found. The following words should not be included in your analysis or result set: "a", "the", "and", "of", "in", "be", "also" and "as".  Your final result MUST be displayed in a readable console output in the same format as the JSON sample object shown below.'
  
