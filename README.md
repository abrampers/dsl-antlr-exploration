# ANTLR

## Generating code
```sh-session
antlr4 Graph.g4
```

## Running graph
```sh-session
javac Graph*.java Edge.java Vertex.java TspSolver.java
java GraphDslAntlrSample
```