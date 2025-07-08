.class public MetodoRetornoConParametro
.super java/lang/Object

.method public static main([Ljava/lang/String;)V
   .limit stack 2
   .limit locals 1

   getstatic java/lang/System/out Ljava/io/PrintStream;
   ldc "Test"
   invokestatic MetodoRetornoConParametro/retornarStringConParametro(Ljava/lang/String;)V

   return
.end method

.method public static retornarStringConParametro(Ljava/lang/String;)V
   .limit stack 2
   .limit locals 1

   getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 0
   invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
   return
.end method

