
public class Animal {

    private String name;
    private int age;

    // Constructor
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter dan Setter untuk name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter dan Setter untuk age
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Method suara hewan
    public String makeSound() {
        return "The animal makes a sound.";
    }

    // Method informasi hewan
    public String getInfo() {
        return "Name: " + name + ", Age: " + age;
    }
}
