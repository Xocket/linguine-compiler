.class public IfAnidado
.super java/lang/Object

.method public static main([Ljava/lang/String;)V
   .limit stack 2
   .limit locals 4

   ldc 1
   istore_1
   ldc 2
   istore_2
   ldc 3
   istore_3

   iload_1
   ifgt If1
   goto End

   If1:
      getstatic java/lang/System/out Ljava/io/PrintStream;
      ldc "El primer valor es mayor que 0."
      invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
      iload_2
      ifgt If2
   goto End

   If2:
      getstatic java/lang/System/out Ljava/io/PrintStream;
      ldc "El segundo valor es mayor que 0."
      invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
      iload_3
      ifgt If3
   goto End

   If3:
      getstatic java/lang/System/out Ljava/io/PrintStream;
      ldc "El tercer valor es mayor que 0."
      invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

   End:
    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "Fin de ejecución"
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

   return
.end method