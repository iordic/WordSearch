# WordSearch
Word Search Puzzle Solver. At the moment this Java application can solve a word search puzzle
passed as an array and a list with the words to solve.

## Use of Solver
An example of usage is at TestSolver.java class:
```java
String [] aves = {"LORO", "PALOMA", "PATO", "PAVO", "PERICO", "POLLO", "TUCAN"};

char [][] sopaAves = {
		{'Q','G','N','G','F','P','F','F','J','G'},
		{'X','Z','B','F','N','D','F','Z','M','P'},
		{'R','T','U','C','A','N','G','E','D','L'},
		{'W','J','H','P','C','M','K','B','V','T'},
		{'C','D','I','A','U','R','V','T','E','O'},
		{'M','P','O','L','L','O','F','W','N','X'},
		{'W','H','X','O','X','S','P','A','T','O'},
		{'B','G','L','M','P','E','R','I','C','O'},
		{'P','E','M','A','D','L','P','E','S','C'},
		{'P','A','V','O','L','N','L','O','R','O'}
	};

Solver s = new Solver();
s.solve(sopaAves, aves);
```
And output looks like:
```
Solved in 10 miliseconds and 458 iterations.



      P             
      A             
  P O L L O         
      O     P A T O
      M P E R I C O
      A             
P A V O     L O R O
All elements found.
```

## TO DO List
- [ ] Implement a GUI.
- [ ] Create a generator.
- [ ] OCR to transform images to an array (?).
