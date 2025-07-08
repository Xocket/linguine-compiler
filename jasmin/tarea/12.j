.class public MetodoRetornoCon2Parametros
.super java/lang/Object

.method public static main([Ljava/lang/String;)V
   .limit stack 3
   .limit locals 1

   getstatic java/lang/System/out Ljava/io/PrintStream;
   ldc 5
   ldc 6
   invokestatic MetodoRetornoCon2Parametros/retornarIntConParametros(II)I
   invokevirtual java/io/PrintStream/println(I)V

   return
.end method

.method public static retornarIntConParametros(II)I
   .limit stack 2
   .limit locals 2

   iload 0
   iload 1
   iadd
   ireturn
.end method