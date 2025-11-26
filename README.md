# 🐾 CRUD de Cadastro de Animais – Java

Um sistema simples de **CRUD (Create, Read, Update, Delete)** desenvolvido em **Java**, utilizando conceitos de **POO**, **herança**, **polimorfismo** e o padrão **MVC**.  
Possui duas interfaces:  
- **Console (CLI)**  
- **Interface gráfica (Swing)**  

O sistema permite cadastrar, listar, atualizar e remover **Gatos** e **Cachorros**.

---

## 📁 Estrutura do Projeto

```
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
```



---

## 🧱 Arquitetura (MVC)

### **Model**
Representa os dados e regras de negócio:
- `Animal` — classe abstrata base
- `Cat` — adiciona atributo `color`
- `Dog`

### **Controller**
Gerencia a lista de animais e as operações CRUD:
- `AnimalController`

### **View**
Interface com o usuário:
- `Main` → Console  
- `MainGui` → Swing (gráfica)

---

## 🐶🐱 Model (Detalhes das Classes)

### **Animal.java**
Classe abstrata para todos os animais.

**Atributos:**
- `name`
- `age`
- `breed`

**Métodos:**
- Getters e setters
- `public abstract void update(Scanner sc)`
- `toString()` personalizado

---

### **Cat.java**
Herda de `Animal`.

**Atributos extras:**
- `color`

**Métodos sobrescritos:**
- `update()` → atualiza nome, idade, raça e cor
- `toString()` → inclui a cor

---

### **Dog.java**
Herda de `Animal`.

**Métodos sobrescritos:**
- `update()` → atualiza nome, idade e raça

---

## 🧠 Controller – AnimalController.java

Gerencia a lista de animais **em memória**.

**Métodos principais:**
- `addAnimal(Animal a)`  
- `listAnimal()`  
- `deleteAnimalById(int id)`  
- `updateAnimal(id, name, age, breed, color)`  

Possui verificação de índices e retorno booleano para operações sensíveis.

---

## 🖥️ Interface Console (CLI) – Main.java

O menu oferece:
```
1 - Cadastrar Gato
2 - Cadastrar Cachorro
3 - Listar animais
4 - Atualizar animal
5 - Remover animal
0 - Sair
```

**Características:**
- Atualização usa **polimorfismo**: `animal.update(scanner)`
- ID do animal é o **índice da lista**
- Previne entradas inválidas

---

## 🪟 Interface Gráfica (Swing) – MainGui.java

Interface gráfica simples, usando:
- `JFrame`
- `JPanel`
- `JList`
- `DefaultListModel`
- `JOptionPane`

**Funções:**
- Adicionar Gato
- Adicionar Cachorro
- Atualizar
- Remover
- Recarregar lista

Tudo é manipulado pelo `AnimalController`.

---

## 🔄 Funcionamento do CRUD

| Operação | Console (CLI) | GUI |
|----------|----------------|-----|
| Criar | Entradas pelo teclado | Formulários `JOptionPane` |
| Ler | Exibe lista no console | Lista `JList` |
| Atualizar | `animal.update(sc)` (polimorfismo) | Controller + formulários |
| Remover | `deleteAnimalById(id)` | Botão de deletar |

---

## 🚀 Como Executar o Projeto

### ▶️ Executar versão Console (CLI)

```
cd src
javac crud/**/*.java
java crud.view.Main
```

### 🪟 Executar versão gráfica (GUI)


```
cd src
javac crud/**/*.java
java crud.view.MainGui
```

---
