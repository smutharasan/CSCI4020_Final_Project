.PHONY: build run clean

name = assignment_3

CLASSPATH = /antlr-4.11.1-complete.jar:./target
JAVAC = javac -cp $(CLASSPATH)
ANTLR = java -jar /antlr-4.11.1-complete.jar 
TESTRIG = java -cp $(CLASSPATH) org.antlr.v4.gui.TestRig

build:
	mkdir -p ./target
	kotlinc -cp $(CLASSPATH) -d ./target ./src/backend/*.kt
	$(ANTLR) -o ./target/ ./src/*.g4
	$(JAVAC) -d ./target ./target/src/*.java

run:
	@jupyter nbconvert \
		--to notebook --execute worksheet.ipynb --output output.ipynb 2>&1 | \
		grep -v '\[main\]' | grep -v '\[IOPUB\]' | grep -v '\[Thread-' | \
	       	grep -v '\[NbConvertApp\]'

get:
	cp -R -T ~/public/$(name) ~/work/$(name)/

view_parsers:
	cd ./target
	non_empty_args-Copy1.txt 
	java -cp /antlr-4.11.1-complete.jar:/kotlinc/lib/kotlin-stdlib.jar:. org.antlr.v4.gui.TestRig PL program -tree < non_empty_args-Copy1.txt 
    
clean:
	rm -rf ./target
	rm -f ./output.ipynb
