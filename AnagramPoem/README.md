################################
#####   DEVELOPER TEST     #####
#####   ANAGRAM EXERCISE   #####
################################

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
		