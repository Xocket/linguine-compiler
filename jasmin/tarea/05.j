.class public StringConcatenar
.super java/lang/Object

.method public static main([Ljava/lang/String;)V
   .limit stack 3
   .limit locals 3

   getstatic java/lang/System/out Ljava/io/PrintStream;

   ldc "Este es un string + "
   astore_1

   ldc 6
   invokestatic java/lang/Integer/toString(I)Ljava/lang/String;
   astore_2

   aload_1
   aload_2
   invokevirtual java/lang/String/concat(Ljava/lang/String;)Ljava/lang/String;
   invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

   return
.end method

