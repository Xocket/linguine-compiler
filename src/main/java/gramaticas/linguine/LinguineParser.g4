// Archivo Parser para el lenguaje Linguine.
parser grammar LinguineParser;
/*
    Los cambios que se han realizado para arreglar la incoherencia en el uso de las expresiones el cual permitía
    ser usados en cualquier lugar de cualquier statements dando lugar a sin sentidos, ha sido separar en asignaciones,
    expresiones y aritmetica, permitiendo que dependiendo del statement, se puedan anidar o no cada uno de las tres reglas
    mencionas.
    El ejemplo más claro era dentro del statement condicional, la primera parte del IF demanda una comparacion de dos
    valores, anteriormente el usuario podia introducir una comparacion de dos expresiones, en este caso statements, lo cual,
    no tenia mucho sentido. Ahora solo permite comparar dos valores, en este caso las llamadas asiganciones, que pueden ser
    variables, numeros o una llamada a funcion que almacena un valor comparable.
*/

options {
    tokenVocab= LinguineLexer;
    language = Java;
}

/*
   Primera regla donde el lenguaje empieza a comprobar la gramatica
   que se ha introducido.
*/
prog: statement+ SEMICOLON;

/*
   Todas las sentencias del lenguaje Linguine.
*/
statement: declaration
         | conditional
         | function
         | function_call
         | show_statement
         | match_statement
         | forLoop
         | whileLoop;

// Declaración de variables
declaration: LET ID EQ (aritmetic | conditional);

/*
   Condicional
*/
conditional: IF LPAREN ID comparator aritmetic RPAREN THEN expression  (ELSE expression)?;

/*
   Crear función
*/
function: FUN ID LPAREN param_list RPAREN ASIGNACION expression;

/*
   Llamada a función
*/
function_call: ID EQ ID LPAREN (aritmetic (COMA aritmetic)*) RPAREN
            | ID LPAREN (aritmetic (COMA aritmetic)*) RPAREN;

// Mostrar por pantalla
show_statement: SHOW  LPAREN aritmetic RPAREN;

// Sentencia MATCH equivalente a SWITCH
match_statement: MATCH ID WITH case+;

//Bucle FOR
forLoop: FOR LPAREN declaration SEMICOLON ID comparator aritmetic SEMICOLON ID PLUSONE RPAREN expression;

//Bucle while
whileLoop: WHILE LPAREN ID comparator aritmetic RPAREN expression;

/*
   Las asignaciones son usadas para ser declaradas ya sea para cambiar su valor o simplemente usar el que ya tiene.
*/

asignation: INT
          | ID
          | FLOAT
          | STRING
          | function_call;

/*
   La aritmetica es usada para hacer operaciones  con asignaciones dentro de statements.
*/
aritmetic:   LPAREN aritmetic RPAREN // Paréntesis
         |   aritmetic ASTERISCO aritmetic // Multiplicación
         |   aritmetic DIVISION aritmetic // División
         |   aritmetic PLUS aritmetic // Suma
         |   aritmetic MENOS aritmetic // Resta
         |   asignation
         ;
 /*
    Las expresiones son usadas para incluir statements dentro de statements de manera lógica. Se excluse la llamda a funcion
    ya que se considera una variable con un valor por lo tanto es una asignación.
 */
expression: declaration
          | conditional
          | function_call
          | show_statement
          | match_statement
          | aritmetic
          | forLoop
          | whileLoop
          ;

/*
   Comparadores para la sentencia condicional.
*/
comparator: GT  // Mayor que
         | GTE // Mayor o igual
         | LT  // Menor que
         | LTE // Menor o igual que
         | EQ  // Igual a
         ;

/*
   Lista de parámetros para la sentencia de crear funciones.
*/
param_list: ID (COMA ID)* | function (COMA ID | function)*;

/*
   Los casos de la sentencia MATCH.
*/
case: BARRA (INT | INTERR) ASIGNACION (expression|COMILLA ID COMILLA);

simbolo: ASTERISCO
       | DIVISION
       | PLUS
       | MENOS
       ;
