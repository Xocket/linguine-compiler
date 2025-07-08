.class public CodGen
.super java/lang/Object
.method public static main([Ljava/lang/String;)V
.limit stack 100
.limit locals 100
ldc 'piltrafa'
astore 0
ldc 'amongus'
astore 1
getstatic java/lang/System/out Ljava/io/PrintStream;
aload 0
aload 1
invokevirtual java/lang/String/concat(Ljava/lang/String;)Ljava/lang/String;
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
return
.end method
