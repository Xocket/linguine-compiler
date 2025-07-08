# PL3 - Compiladores: The Linguine Compiler

This project is a complete compiler for a custom programming language named "Linguine," developed as the final project for the "Compilers" (591000) course at the Universidad de Alcalá.

The compiler is built in Java using Maven and leverages powerful tools like ANTLR 4 for parsing and Jasmin for generating Java bytecode. It can take a source file written in Linguine, process it through a full compilation pipeline, and produce an executable `.j` assembly file.

## The Linguine Language

Linguine is a simple, imperative language with functional features. Its key capabilities include:

- **Variable Declaration**: Using the `let` keyword (e.g., `let x = 5;`).
- **Arithmetic Operations**: Standard operators `+`, `-`, `*`, `/`.
- **Conditional Logic**: `if-then-else` statements.
- **Looping Constructs**: `for` and `while` loops for iteration.
- **Functions**: First-class functions with parameters and return values using the `fun` keyword, supporting recursion (e.g., `fun factorial(n) -> ...`).
- **Pattern Matching**: A `match-with` statement, similar to a `switch` in other languages, for handling different cases.
- **Built-in I/O**: A `show()` function to print values to the console.
- **Data Types**: The compiler handles integers, strings, and supports operations between them (like string concatenation).


## How It Works: The Compilation Pipeline

1.  **Input**: The user runs the `CLI.Menu` and provides Linguine source code, either by typing it directly or by selecting one of the example files.
2.  **Lexical Analysis & Parsing (ANTLR)**: The source code is fed into an ANTLR-generated `LinguineLexer` and `LinguineParser`. This process validates the syntax and builds a **Parse Tree**, which is a structured in-memory representation of the code.
3.  **Semantic Analysis & Code Generation (Visitor)**:
    - The `LinguineVisitor` class traverses the Parse Tree node by node.
    - During traversal, it uses the `TablaSimbolos` to store and retrieve information about variables and functions, performing basic semantic checks (e.g., ensuring a variable is declared before use).
    - As it understands the meaning of each statement, it calls methods on the `CodeGenerator` instance to emit the corresponding **Jasmin assembly instructions**.
4.  **Output**: The `CodeGenerator` assembles all the instructions into a complete `.j` file, which is saved to `test/test.j`. This file contains Java bytecode that can be assembled and run on the JVM.

## How to Run

### Prerequisites

- **Java JDK 21** (as specified in `pom.xml`)
- **Apache Maven**
- **Jasmin**: Download the `jasmin.jar` from an official source like the [Jasmin homepage](https://jasmin.sourceforge.net/).

### Steps

1.  **Build the Project**:
    Open a terminal in the project root and run Maven to compile the code and package it into a JAR.
    ```bash
    mvn clean install
    ```

2.  **Run the Compiler**:
    Execute the packaged JAR to launch the interactive menu.
    ```bash
    java -cp target/PL3-Compiladores-1.0-SNAPSHOT.jar CLI.Menu
    ```
    You will be prompted to either write an instruction or choose a test file from `src/main/resources/ficheros/linguine/`. After execution, the generated Jasmin code will be in `test/test.j`.

3.  **Assemble the Jasmin Code**:
    Use the `jasmin.jar` to assemble the generated `.j` file into a Java `.class` file.
    ```bash
    # Make sure jasmin.jar is in your current directory or path
    java -jar jasmin.jar test/test.j
    ```
    This will create a `CodGen.class` file in the `test/` directory.

4.  **Run the Final Program**:
    Finally, execute the generated class file using the Java runtime.
    ```bash
    # Navigate to the directory containing the .class file
    cd test
    
    # Run the program
    java CodGen
    ```
    The output of the original Linguine program will be printed to the console.

## Authors

- **Daniel Mihai Bostan Tiron**
- **Daniel Dichtl Fernandez**
- **Gonzalo Todo Gabino**