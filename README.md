#README

This repository is created to push the following BCBS coding exercises:
1. ENCODER/DECODER Algorithm
2. Employee Leave/Vacation tracking App
3. 
-----------------------------------------------------------------------------------------------------------
ENCODER/DECODER Algorithm
-------------------------
The code corresponding this exercise is present in the following location:
https://github.com/uvks/BCBS-CodingExcercise/tree/master/EncryptionAlgorithm

Assumptions
-----------
This program will only decode the given text.
Input text consists of upper/lower/special characters

Tools Used
----------
Eclipse

Code Explanation
----------------
(i) Initialized an array with length = max ascii value of upper/lower/special characters which is 126
(ii) From the given 3 encode-decode patterns, populated the encoded character ascii value index of the array with its corresponding decoded character ascii value.
(iii) Created an input text file with encoded text which needs to be decoded.
(iv) Run Ecruption.java to create Output.txt file in bin directory with the decoded text.
(v) Since the algorithm uses fixed length array using index to retrieve decoded characters, the runtime complexity is O(1) , and the space is 126 integer length array.
(vi) This Algorithm can be modified to fill out the empty spaces in the array for the characters which are absent in given 3 encode-decode patterns.

Execution
---------
Run Encryption class
-----------------------------------------------------------------------------------------------------------

Employee Leave/Vacation tracking App
-----------------------------------
Assumptions
-----------

