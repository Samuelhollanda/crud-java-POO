// src/crud/view/MainGui.java
package crud.view;

import crud.controller.AnimalController;
import crud.model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainGui extends JFrame {
    private final AnimalController controller = new AnimalController();
    private final DefaultListModel<Animal> model = new DefaultListModel<>();
    private final JList<Animal> list = new JList<>(model);

    public MainGui() {
        super("Cadastro de Animais - GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setupLayout();
        setLocationRelativeTo(null);
        refreshList();
    }

    private void setupLayout() {
        JPanel panel = new JPanel(new BorderLayout(8,8));
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        panel.add(new JScrollPane(list), BorderLayout.CENTER);

        JPanel buttons = new JPanel(new GridLayout(1,5,5,5));
        JButton btnAddCat = new JButton("Adicionar Gato");
        JButton btnAddDog = new JButton("Adicionar Cachorro");
        JButton btnUpdate = new JButton("Atualizar");
        JButton btnDelete = new JButton("Remover");
        JButton btnRefresh = new JButton("Atualizar Lista");

        btnAddCat.addActionListener(e -> addCat());
        btnAddDog.addActionListener(e -> addDog());
        btnUpdate.addActionListener(e -> updateSelected());
        btnDelete.addActionListener(e -> deleteSelected());
        btnRefresh.addActionListener(e -> refreshList());

        buttons.add(btnAddCat);
        buttons.add(btnAddDog);
        buttons.add(btnUpdate);
        buttons.add(btnDelete);
        buttons.add(btnRefresh);

        panel.add(buttons, BorderLayout.SOUTH);
        setContentPane(panel);
    }

    private void addCat() {
        JTextField name = new JTextField();
        JTextField age = new JTextField();
        JTextField breed = new JTextField();
        JTextField color = new JTextField();
        Object[] fields = {
                "Nome:", name,
                "Idade:", age,
                "Raça:", breed,
                "Cor:", color
        };
        int ok = JOptionPane.showConfirmDialog(this, fields, "Novo Gato", JOptionPane.OK_CANCEL_OPTION);
        if (ok == JOptionPane.OK_OPTION) {
            try {
                controller.addAnimal(new Cat(name.getText(), Integer.parseInt(age.getText()), breed.getText(), color.getText()));
                refreshList();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Idade inválida", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void addDog() {
        JTextField name = new JTextField();
        JTextField age = new JTextField();
        JTextField breed = new JTextField();
        Object[] fields = {
                "Nome:", name,
                "Idade:", age,
                "Raça:", breed
        };
        int ok = JOptionPane.showConfirmDialog(this, fields, "Novo Cachorro", JOptionPane.OK_CANCEL_OPTION);
        if (ok == JOptionPane.OK_OPTION) {
            try {
                controller.addAnimal(new Dog(name.getText(), Integer.parseInt(age.getText()), breed.getText()));
                refreshList();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Idade inválida", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void updateSelected() {
        int idx = list.getSelectedIndex();
        if (idx == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um animal primeiro", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Animal a = model.get(idx);
        JTextField name = new JTextField(a.getName());
        JTextField age = new JTextField(String.valueOf(a.getAge()));
        JTextField breed = new JTextField(a.getBreed());
        JTextField color = new JTextField(a instanceof Cat ? ((Cat) a).getColor() : "");
        Object[] fields = {
                "Nome:", name,
                "Idade:", age,
                "Raça:", breed,
                "Cor (apenas gatos):", color
        };
        int ok = JOptionPane.showConfirmDialog(this, fields, "Atualizar Animal", JOptionPane.OK_CANCEL_OPTION);
        if (ok == JOptionPane.OK_OPTION) {
            try {
                Integer ageVal = Integer.parseInt(age.getText());
                controller.updateAnimal(idx, name.getText(), ageVal, breed.getText(), color.getText());
                refreshList();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Idade inválida", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void deleteSelected() {
        int idx = list.getSelectedIndex();
        if (idx == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um animal primeiro", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this, "Remover animal selecionado?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            controller.deleteAnimalById(idx);
            refreshList();
        }
    }

    private void refreshList() {
        model.clear();
        for (Animal a : controller.listAnimal()) model.addElement(a);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainGui().setVisible(true));
    }
}
