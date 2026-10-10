
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ZooFrame extends JFrame {

    // Menyimpan daftar hewan
    private final ArrayList<Animal> animals = new ArrayList<>();

    // Komponen input
    private JTextField nameField;
    private JTextField ageField;
    private JComboBox<String> animalTypeBox;
    private JTextField furColorField;
    private JCheckBox canFlyCheckBox;

    // Area untuk menampilkan informasi
    private JTextArea logArea;

    public ZooFrame() {

        setTitle("Digital Zoo Manager");
        setSize(600, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel utama
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(
                BorderFactory.createEmptyBorder(20, 20, 20, 20)
        );

        // Panel formulir
        JPanel formPanel = new JPanel(new GridLayout(6, 2, 10, 10));

        nameField = new JTextField();
        ageField = new JTextField();

        animalTypeBox = new JComboBox<>(
                new String[]{"Generic Mammal", "Generic Bird"}
        );

        furColorField = new JTextField();
        canFlyCheckBox = new JCheckBox("Yes");

        formPanel.add(new JLabel("Animal Name:"));
        formPanel.add(nameField);

        formPanel.add(new JLabel("Animal Age:"));
        formPanel.add(ageField);

        formPanel.add(new JLabel("Animal Type:"));
        formPanel.add(animalTypeBox);

        formPanel.add(new JLabel("Fur Color:"));
        formPanel.add(furColorField);

        formPanel.add(new JLabel("Can Fly?"));
        formPanel.add(canFlyCheckBox);

        JButton addButton = new JButton("Add Animal");

        formPanel.add(new JLabel(""));
        formPanel.add(addButton);

        // Area log
        logArea = new JTextArea();
        logArea.setEditable(false);
        logArea.setLineWrap(true);
        logArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(logArea);
        scrollPane.setBorder(
                BorderFactory.createTitledBorder("Zoo Activity Log")
        );

        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        add(mainPanel);

        // Menyesuaikan input berdasarkan jenis hewan
        animalTypeBox.addActionListener(e -> updateAnimalFields());
        updateAnimalFields();

        // Menjalankan fungsi ketika tombol diklik
        addButton.addActionListener(e -> addAnimal());
    }

    private void updateAnimalFields() {
        boolean isMammal = animalTypeBox.getSelectedIndex() == 0;

        furColorField.setEnabled(isMammal);
        canFlyCheckBox.setEnabled(!isMammal);
    }

    private void addAnimal() {

        String name = nameField.getText().trim();
        String ageText = ageField.getText().trim();

        if (name.isEmpty() || ageText.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Please enter the animal name and age."
            );
            return;
        }

        try {
            int age = Integer.parseInt(ageText);

            if (age < 0) {
                JOptionPane.showMessageDialog(
                        this,
                        "Age cannot be negative."
                );
                return;
            }

            Animal animal;
            String type;

            if (animalTypeBox.getSelectedIndex() == 0) {

                String furColor = furColorField.getText().trim();

                animal = new Mammal(name, age, furColor);
                type = "Mammal";

            } else {

                boolean canFly = canFlyCheckBox.isSelected();

                animal = new Bird(name, age, canFly);
                type = "Bird";
            }

            // Simpan ke ArrayList
            animals.add(animal);

            // Tampilkan informasi hewan
            logArea.append(
                    "Added a new " + type + "!\n" +
                            "Info: " + animal.getInfo() + "\n" +
                            "Sound: " + animal.makeSound() + "\n" +
                            "------------------------------\n"
            );

            // Kosongkan form setelah berhasil
            nameField.setText("");
            ageField.setText("");
            furColorField.setText("");
            canFlyCheckBox.setSelected(false);

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Age must be a valid whole number."
            );
        }
    }
}
