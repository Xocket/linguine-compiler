// Archivo Lexer para el lenguaje linguine.
lexer grammar LinguineLexer;

// Definir tokens para palabras clave.
LET       : 'let';
IF        : 'if';
THEN      : 'then';
ELSE      : 'else';
FUN       : 'fun';
MATCH     : 'match';
WITH      : 'with';
SHOW      : 'show';
WHILE     : 'while';
FOR       : 'for';

// Definir tokens y reglas para variables. Cualquier nombre debe comenzar con una letra o guión bajo y puede tener letras o dígitos.
ID        : [a-zA-Z_] [a-zA-Z0-9_]*;
STRING : '\'' .*? '\'';



// Definir enteros, que deben tener al menos un dígito, y números decimales.
INT       : [0-9]+;
FLOAT     : [0-9]+ '.' [0-9]+;


// Definir paréntesis para condiciones.
LPAREN    : '(';
RPAREN    : ')';

// Definir tokens para operadores.
PLUS      : '+';
MENOS     : '-';
ASTERISCO  : '*';
DIVISION     : '/';
BARRA       : '|';
INTERR    : '?';
PLUSONE   : '++';
MINUSSONE  : '--';

// Definir tokens para operadores de comparación.
GT        : '>';
GTE       : '>=';
LT        : '<';
LTE       : '<=';
EQ        : '=';

// Definir el punto y coma.
SEMICOLON : ';';

// Definir la coma.
COMA      : ',';

// Definit las comillas.
COMILLA   :'"';

// Definir el operador de asignación.
ASIGNACION     : '->';

// Definir espacios en blanco como tabulaciones o saltos de línea.
WS        : [ \t\r\n]+ -> skip;
