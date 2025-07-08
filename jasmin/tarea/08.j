.class public BucleWhile
.super java/lang/Object

.method public static main([Ljava/lang/String;)V
   .limit stack 3
   .limit locals 2

   ldc 6
   istore_1

   BucleWhile:
      iload_1
      getstatic java/lang/System/out Ljava/io/PrintStream;
      ldc "Test"
      invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
      iinc 1 -1
   ifgt BucleWhile

   return
.end method