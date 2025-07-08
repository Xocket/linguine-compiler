.class public OperacionLogica
.super java/lang/Object

.method public static main([Ljava/lang/String;)V
   .limit stack 3
   .limit locals 1

   getstatic java/lang/System/out Ljava/io/PrintStream;
   ldc 1
   ldc 0
   iand
   invokevirtual java/io/PrintStream/println(I)V

   return
.end method
