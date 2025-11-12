package crud.view;

import crud.model.*;
import java.util.Scanner;
import crud.controller.AnimalController;
import java.util.List; // Importe a classe List

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AnimalController controller = new AnimalController();
        int op, age, id;
        String name, breed, color;

        do {
            System.out.println("--CADASTRO DE ANIMAIS--");
            System.out.println("1 - Cadastrar Gato.");
            System.out.println("2 - Cadastrar Cachorro");
            System.out.println("3 - Listar animais");
            System.out.println("4 - Atualizar animais");
            System.out.println("5 - Remover animal");
            System.out.println("0 - Sair"); // Adicionei a opção de sair
            System.out.println("Digite uma opção: ");
            op = sc.nextInt();
            sc.nextLine(); // Limpar o buffer

            switch (op) {
                case 1:
                    System.out.println("Digite o nome do Gato: ");
                    name = sc.nextLine();
                    System.out.println("Digite a idade: ");
                    age = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Digite a raça: ");
                    breed = sc.nextLine();
                    System.out.println("Digite a cor: ");
                    color = sc.nextLine();
                    controller.addAnimal(new Cat(name, age, breed, color));
                    System.out.println("Gato Cadastrado: ");
                    break;
                case 2:
                    System.out.println("Digite o nome do cachorro: ");
                    name = sc.nextLine();
                    System.out.println("Digite a idade: ");
                    age = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Digite a raça: ");
                    breed = sc.nextLine();
                    controller.addAnimal(new Dog(name, age, breed));
                    System.out.println("Cachorro cadastrado");
                    break;
                case 3:
                    System.out.println("--- ANIMAIS CADASTRADOS ---");
                    List<Animal> list = controller.listAnimal(); // Use a interface List
                    if (list.isEmpty())
                        System.out.println("Nenhum registro");
                    else {
                        for (int i = 0; i < list.size(); i++)
                            System.out.println(i + " - " + list.get(i)); // 'i' é o ID/índice
                    }
                    System.out.println("-----------------------------");
                    break;
                case 4:
                    System.out.println("ATUALIZAR INFORMAÇÕES");
                    System.out.println("Digite o índice (ID) do animal: ");
                    id = sc.nextInt();
                    sc.nextLine(); // Limpar o buffer

                    // --- INÍCIO DA CORREÇÃO ---

                    // 1. Pegar a lista para verificar o ID e obter o animal
                    List<Animal> listToUpdate = controller.listAnimal();

                    // 2. Verificar se o ID é válido
                    if (id >= 0 && id < listToUpdate.size()) {
                        // 3. Pegar o animal específico
                        Animal animalParaAtualizar = listToUpdate.get(id);

                        // 4. Chamar o método update() DO PRÓPRIO ANIMAL
                        // Ele usará o Scanner (polimorfismo)
                        System.out.println("--- Atualizando dados para: " + animalParaAtualizar.getName() + " ---");
                        animalParaAtualizar.update(sc);

                        System.out.println("ATUALIZADO!");
                    } else {
                        System.out.println("INDICE INVÁLIDO!");
                    }
                    // --- FIM DA CORREÇÃO ---
                    break;
                case 5:
                    System.out.println("REMOVER ANIMAL");
                    System.out.println("Digite o índice (ID) do animal: ");
                    id = sc.nextInt();
                    sc.nextLine(); // Limpar o buffer

                    // --- AJUSTE DE LÓGICA ---
                    // Chame o método delete e verifique seu retorno booleano
                    if (controller.deleteAnimalById(id)) {
                        System.out.println("ANIMAL REMOVIDO!!!");
                    } else {
                        System.out.println("INDICE INVÁLIDO!!!");
                    }
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
            // Adiciona uma pausa para o usuário ler a saída
            if (op != 0) {
                System.out.println("\nPressione Enter para continuar...");
                sc.nextLine();
            }

        } while (op != 0);

        sc.close(); // Fechar o Scanner ao sair
    }
}