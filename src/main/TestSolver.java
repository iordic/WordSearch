package main;

/**
 * Tester with examples
 * @author Jordi Castelló
 *
 */
public class TestSolver {

	public static void main(String[] args) {
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
			
		String [] paises = {"PORTUGAL","ESPANHA","HOLANDA","ALEMANHA","ITALIA","BRASIL","ANGOLA",
							"INDIA","CHINA","QUENIA","AUSTRALIA","TURQUIA","MARROCOS","INDONESIA",
							"RUSSIA","MALASIA","LUXEMBURGO","ANDORRA","CHILE"};
		char [][] sopaPaises = {
				{'C','O','R','A','A','I','D','N','I','D','V','L','Q','F','U'},
				{'D','J','N','N','L','P','N','S','B','F','G','M','Z','Y','J'},
				{'E','G','H','G','A','U','S','T','R','A','L','I','A','U','D'},
				{'O','B','O','O','G','Q','U','E','N','I','A','Y','V','Y','X'},
				{'H','D','L','L','U','F','A','A','N','D','O','R','R','A','W'},
				{'C','F','A','A','T','L','R','H','C','I','T','A','L','I','A'},
				{'C','S','N','T','R','T','U','P','N','G','N','M','R','I','D'},
				{'Z','T','D','S','O','T','H','X','G','A','A','E','S','T','T'},
				{'M','W','A','L','P','J','U','E','E','R','M','E','N','K','D'},
				{'I','A','Q','I','T','C','S','R','R','M','N','E','J','T','E'},
				{'C','T','L','M','S','P','H','O','Q','O','B','H','L','T','R'},
				{'H','D','E','A','A','S','C','I','D','U','V','U','W','A','A'},
				{'I','S','C','N','S','O','U','N','N','R','I','H','R','E','D'},
				{'L','M','H','S','S','I','I','R','G','A','B','A','B','G','Y'},
				{'E','A','N','D','L','Z','A','B','R','A','S','I','L','Y','O'}
			};
		
		String [] lista2 = {"ADAPTACIONES", "ADULTA", "ANIVERSARIO", "AUTOR", "AVENTURA", "BOOKTRAILER", 
				 "COLABORACION", "EDITORIAL", "EPICA", "FANTASIA", "IMAGINACION", "JUVENIL", 
				 "LECTURA", "LIBRO", "MUNDOS", "PORTADA", "POSTAPOCALIPTICO", "RESEÑAS", "SAGA", 
				 "SCIFI", "SERES", "SERIE", "SINOPSIS", "SWEETDARKNESS", "TRILOGIA"};
		char [][] sopa2 = {
				{'L','M','S','F','L','Ñ','X','S','U','F','U','Z','S','G','E','S','W','U','A','J','H','H','E','N','S'},
				{'E','E','Z','O','K','V','A','E','S','J','N','E','G','D','D','I','F','C','Z','X','C','T','I','H','E'},
				{'G','S','C','K','D','J','E','B','R','E','R','N','I','F','G','S','I','U','I','S','N','K','Q','D','R'},
				{'O','B','H','T','R','N','Q','F','E','I','N','T','X','S','R','P','J','D','E','D','O','O','W','F','E'},
				{'P','N','F','W','U','S','U','J','E','N','O','K','E','C','E','O','A','A','A','L','I','O','B','B','S'},
				{'Ñ','I','Ñ','A','S','R','U','M','C','R','S','N','R','O','F','N','D','X','M','P','C','W','O','I','L'},
				{'L','E','X','L','L','V','A','O','I','C','O','Z','O','A','F','I','N','C','H','Z','A','A','O','N','Q'},
				{'A','N','I','V','E','R','S','A','R','I','O','A','Y','X','D','S','R','B','Y','H','R','T','K','L','D'},
				{'O','D','H','N','R','A','L','N','C','V','M','H','I','Ñ','Z','T','W','P','A','W','O','L','T','T','B'},
				{'O','C','I','T','P','I','L','A','C','O','P','A','T','S','O','P','E','R','T','O','B','U','R','S','N'},
				{'T','L','D','K','G','Y','T','M','T','G','W','Y','G','R','A','N','U','E','T','B','A','D','A','A','Y'},
				{'O','R','M','A','G','P','A','M','A','I','G','O','L','I','R','T','A','H','W','B','L','A','I','G','A'},
				{'P','O','R','T','A','D','A','S','Ñ','C','E','Ñ','O','Ñ','N','G','N','S','T','S','O','K','L','A','Z'},
				{'D','I','G','D','X','W','P','K','A','E','E','L','T','E','O','A','H','A','H','S','C','R','E','M','N'},
				{'X','I','A','P','S','F','D','H','J','L','H','E','V','R','B','W','C','M','F','N','H','E','R','C','F'},
				{'P','N','G','O','J','G','G','F','Q','I','T','A','W','D','V','T','O','I','F','C','K','S','L','Q','D'},
				{'O','H','D','V','R','L','G','Q','I','B','E','L','E','P','Y','V','D','R','O','G','O','E','K','T','J'},
				{'H','H','E','E','Z','O','E','S','C','R','V','W','E','M','M','T','I','A','K','N','Q','Ñ','T','M','T'},
				{'Ñ','E','S','A','E','D','T','P','L','O','I','F','I','C','S','Y','B','A','F','S','T','A','D','O','D'},
				{'L','M','S','G','N','Z','B','U','V','I','O','A','O','P','H','T','V','T','H','V','Y','S','U','J','G'},
				{'X','M','V','O','F','D','H','D','A','D','S','C','F','Z','P','P','P','L','T','R','W','L','L','L','D'},
				{'Z','A','S','T','L','B','O','T','S','X','O','P','B','Y','U','B','O','F','W','H','O','B','Y','S','Q'},
				{'G','N','Q','G','K','A','P','E','K','D','O','X','S','U','F','J','H','J','C','J','Q','N','C','A','Y'},
				{'E','S','T','K','Z','Z','A','D','A','G','Z','S','M','E','J','N','N','B','C','K','C','D','Q','T','J'},
				{'J','E','V','M','O','Ñ','H','O','W','U','V','N','O','B','U','J','D','G','V','A','L','A','S','V','W'}
			};
		
		Solver s = new Solver();
		s.solve(sopaAves, aves);
		s.solve(sopaPaises, paises);
		s.solve(sopa2, lista2);
	}

}
