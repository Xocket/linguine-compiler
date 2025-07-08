.class public BucleFor
.super java/lang/Object

.method public static main([Ljava/lang/String;)V
   .limit stack 2
   .limit locals 2

   ldc 6
   istore_1

   Buclefor:
      iload_1
      ifle End
      getstatic java/lang/System/out Ljava/io/PrintStream;
      ldc "Test"
      invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
      iinc 1 -1
      goto Buclefor
   End:

      return
.end method