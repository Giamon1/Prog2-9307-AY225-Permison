MP08 – Filter records using a keyword.
This program reads a CSV dataset of exam records and asks the user to input the file path and a keyword. It processes each valid row and checks if the exam field contains the given keyword. Matching records are displayed in a readable format, showing the name, exam, and result. At the end, the program prints the total number of matches. The program also handles errors such as missing or unreadable files.


MP09 – Display dataset statistics.
This program reads a CSV dataset containing exam results and asks the user for the dataset file path. It processes each data row and counts the total number of records, as well as how many results are “PASS” and “FAIL.” The program displays these statistics in a formatted output. It ensures that only valid data rows are counted and skips headers or empty rows. Errors in reading the file are also handled gracefully.


MP10– Detect duplicate records.
This program reads a CSV dataset and asks the user to enter the file path. It checks each valid row against a set of previously seen rows to detect duplicates. If a duplicate is found, the program prints the duplicate record and increments the duplicate count. At the end, it shows the total number of duplicate records. The program ensures that only actual data rows are processed and handles file read errors safely.

