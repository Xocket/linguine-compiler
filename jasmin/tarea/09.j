.class public MetodoSinParametros
.super java/lang/Object

.method public static main([Ljava/lang/String;)V
   .limit stack 0
   .limit locals 1

   invokestatic MetodoSinParametros/printearString()V

   return
.end method

.method public static printearString()V
   .limit stack 2
   .limit locals 0

    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "Test"
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
    return
.end method
