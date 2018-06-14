
#####   DEVELOPER TEST
#####   ANAGRAM EXERCISE

As specified in Wikipedia, an anagram is a type of word play, the
result of rearranging the letters of a word or phrase to produce a
new word or phrase, using all the original letters exactly once; e.g.,
orchestra = carthorse, A decimal point = I&#39;m a dot in place.
An anagramic poem is a poem where each line or each verse is an
anagram of all other lines or verses in the poem. Please prepare
Java code that, given a poem, returns a Boolean value indicating
whether or not the poem is an anagramic poem.
Your example should include the following:

- Unit tests
- Argument validation
- Error handling
- Comments as deemed necessary
- Documentation on how to run and test the code
- Any assumptions that you have made
- The exercise should be resolved using objects.

We should be able to run your program as delivered (i.e. without
modifying any code). If any third-party dependencies are required,
you should either (a) include the dependencies with the delivered
solution, or, (b) include a build solution in either Ant or Maven that
will allow us to resolve all required dependencies.

# Assumptions
        
    -	It is assumed that a poem must have at least two lines, 
        if it has less it will be considered as not valid, 
        then it is not an anagrammatic poem.

    -   The poem is anagrammatic when each line is an
        anagram of all other lines or each verse is an
        anagram of all other verses in the poem.
        
# Requirements
	
	maven 3.5.3
	jdk 8
	
# Generation
	
        To generate the package it has to execute the next command
		
	mvn package

# Execution
	
	java -jar target/anagram_poem-1.0.jar {{POEM FILEPATH}}
	
	ejemplo:
	java -jar target/anagram_poem-1.0.jar poema.txt
	
# Exit

	- In case that the poem is anagrammatic the output will be
	
		TRUE - Poem is anagrammatic

	- In case that the poem is not anagrammatic the output will be
	
		FALSE - Poem is not anagrammatic	
		
