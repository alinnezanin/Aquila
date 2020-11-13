# Aquila
A Linguagem de Domínio Específico Aquila, que foi projetada para modelagem de testes funcionais em equipes ágeis. Aquila é uma extensão da Linguagem de Domínio Específico Gherkin, aonde novas palavras chaves, relacionadas a testes funcionais, são adicionadas para permitir a geração automatizada de scripts. 

Aquila is a Domain-specific language (DSL), it was designed for modeling functional tests in agile teams. It extends the Gherkin DSL by introducing new keywords. These new keywords are related to functional testing and allow the creation of automated Scripts.

### Requirements
Java Development Kit 11


### Quick Start (For linux)
1. Run _"sudo apt install default-jdk"_ to install the jdk (if not installed)
1. Download the project from Github and unzip
1. On the root of the project run  _"mkdir classes"_ to create a folder to store the binaries
1. Run _"javac -cp src/gson-2.8.1.jar  -d classes/ src/*/*.java src/*/*/*.java"_ to compile the project
1. _"cp src/gson-2.8.1.jar classes"_ to copy the gson library to the classes folder
1. _"cp -R src/images classes"_ to copy the images folder
1. _"cp src/gherkin/gherkin-languages.json classes/gherkin/"_ copying another file
1. _"cd classes"_ to change to the classes directory
1. Finally run _"java -cp .:gson-2.8.1.jar view.TelaInicial"_ to start the program

### How to use
- The feature input file is the fire in Aquila, an example named Feature-Completa.txt is available in "Arquivos auxiliares" directory
- Script Output File is the name and location to create the test script (note that despite the Open button, you should specify a name to the file and not a file to open)
- Click generate and it will create the file specified in the Script Output file.

### More information about Aqula will be available soon


Developed by Henry Cabral Nunes, Aline Zanin, Avelino Francisco Zorzo

