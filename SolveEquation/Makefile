all:
	javacc lang.jj
	javac *.java
run:
	java EvalVisitor < prog.txt
clean:
	rm -rf $(shell ls -I "Makefile" -I "lang.jj" -I "AST.java" -I "SymTable.java" -I "TypeVisitor.java" -I "Visitor.java" -I "EvalVisitor.java" -I "EvalTable.java" -I "prog.txt"  -I "README.md")
