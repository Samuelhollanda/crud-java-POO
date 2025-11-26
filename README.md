🐾 CRUD de Cadastro de Animais – Java

Um sistema simples de CRUD (Create, Read, Update, Delete) desenvolvido em Java, utilizando POO, MVC e interfaces tanto em Console (CLI) quanto Swing (GUI).
Permite cadastrar, listar, atualizar e remover Gatos e Cachorros.

📁 Estrutura do Projeto
src/
 └── crud/
     ├── controller/
     │     └── AnimalController.java
     ├── model/
     │     ├── Animal.java
     │     ├── Cat.java
     │     └── Dog.java
     └── view/
           ├── Main.java
           └── MainGui.java

🧱 Arquitetura (MVC)
Model

Contém as classes que representam os animais e suas regras:

Animal — classe abstrata base

Cat — possui atributo extra color

Dog

Controller

Gerencia o CRUD em memória:

AnimalController

View

Interface com o usuário:

Main → Interface por console

MainGui → Interface Swing (gráfica)

🐶🐱 Model (Detalhes das Classes)
Animal.java

Classe abstrata com:

name

age

breed

Método abstrato update(Scanner sc)

toString() formatado

Cat.java

Herda Animal
Adiciona:

color

Sobrescreve:

update() perguntando nome, idade, raça e cor

Dog.java

Herda Animal
Sobrescreve:

update() perguntando nome, idade e raça

🧠 Controller
AnimalController.java

Gerencia a lista interna de animais.

Métodos principais:

addAnimal(Animal a)

listAnimal()

deleteAnimalById(int id)

updateAnimal(id, name, age, breed, color)

A lista fica em memória (sem banco ou arquivo).

🖥️ Interface Console (CLI)

Arquivo: Main.java

Menu principal:

1 - Cadastrar Gato
2 - Cadastrar Cachorro
3 - Listar animais
4 - Atualizar animal
5 - Remover animal
0 - Sair


Destaques:

Atualização usa polimorfismo com animal.update(sc)

ID do animal é o índice na lista

Previne índice inválido

🪟 Interface Gráfica (GUI)

Arquivo: MainGui.java

Funções principais:

Adicionar Gato

Adicionar Cachorro

Atualizar Animal

Remover

Recarregar Lista

Tecnologias:

JFrame, JPanel, JList, DefaultListModel, JOptionPane

Tudo é manipulado via controller.

🔄 Funcionamento do CRUD
Operação	CLI	GUI
Criar	Teclado	Formulários (JOptionPane)
Ler	Listagem no console	JList atualizada
Atualizar	update() polimórfico	Atualização via controller
Deletar	Com índice	Botão de remover


🚀 Como Executar
▶️ Console (CLI)
cd src
javac crud/**/*.java
java crud.view.Main

🪟 Interface Gráfica (GUI)
cd src
javac crud/**/*.java
java crud.view.MainGui
