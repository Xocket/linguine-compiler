.class public Multiplicar
.super java/lang/Object

.method public static main([Ljava/lang/String;)V
   .limit stack 3       ; 3 huecos en el stack
   .limit locals 1      ; almacena únicamente el array de parámetros de java

   getstatic java/lang/System/out Ljava/io/PrintStream;
   ldc 2
   ldc 5
   imul
   invokevirtual java/io/PrintStream/println(I)V

   return
.end method