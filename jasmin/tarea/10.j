.class public MetodoRetorno
.super java/lang/Object

.method public static main([Ljava/lang/String;)V
   .limit stack 2
   .limit locals 1

   getstatic java/lang/System/out Ljava/io/PrintStream;
   invokestatic MetodoRetorno/retornarInt()I
   invokevirtual java/io/PrintStream/println(I)V

   return
.end method

.method public static retornarInt()I
   .limit stack 2
   .limit locals 0

   ldc 5
   ldc 6
   iadd
   ireturn
.end method
