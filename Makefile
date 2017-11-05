all:
	javacc lang.jj
	javac *.java
run:
	java Parser < prog.txt
clean:
	rm -rf $(shell ls -I "Makefile" -I "lang.jj" -I "AST.java" -I "Table.java" -I "TypeVisitor.java" -I "Visitor.java" -I "prog.txt" -I "README.md")
