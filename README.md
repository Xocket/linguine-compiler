Of course! Here is a professional `README.md` file and a concise project description based on the files you provided.

### Project Description

This project is a complete compiler for a custom high-level programming language named "Linguine," developed for the Compilers course at the Universidad de Alcalá. Written in Java, the compiler leverages ANTLR 4 for lexical analysis and parsing, and generates Java bytecode in the form of Jasmin assembly files (`.j`). The architecture includes a custom visitor for semantic analysis, a symbol table to manage variables and functions, and a code generator to produce the final executable output. The Linguine language supports features like variable declarations, arithmetic operations, conditional logic (`if-then-else`), `for` and `while` loops, functions, and a `match` statement for pattern matching.

---

### README.md

Here is the content for your `README.md` file.

```markdown
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

## Project Structure

The project is organized into several key packages and directories:

```
.
├── jasmin/
│   ├── Ejemplo/      # A small demo ANTLR project for summing numbers
│   └── tarea/        # Manually written Jasmin files for Part 1 of the assignment
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── CLI/              # Menu.java: The main entry point and command-line interface.
│   │   │   ├── gramaticas/       # ANTLR grammar files (LinguineLexer.g4, LinguineParser.g4) and generated code.
│   │   │   ├── IO/               # Utility classes for file and console I/O.
│   │   │   ├── jasminGen/        # CodeGenerator.java: Helper class to build Jasmin instructions.
│   │   │   ├── tablaSimbolos/    # Simbolo.java & TablaSimbolos.java: Implementation of the symbol table.
│   │   │   └── visitors/         # LinguineVisitor.java: The core of the compiler, handling semantic analysis and code generation.
│   │   └── resources/
│   │       └── ficheros/
│   │           └── linguine/     # Example .linguine source files for testing.
│   └── test/
│       └── test.j                # Default output file for the generated Jasmin code.
├── pom.xml                       # Maven project configuration.
└── README.md                     # This file.
```

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

- **Daniel Dichtl Fernandez**
- **Gonzalo Todo Gabino**
```