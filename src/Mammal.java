
public class Mammal extends Animal {

    private String furColor;

    // Constructor
    public Mammal(String name, int age, String furColor) {
        super(name, age);
        this.furColor = furColor;
    }

    // Getter dan Setter
    public String getFurColor() {
        return furColor;
    }

    public void setFurColor(String furColor) {
        this.furColor = furColor;
    }

    // Override suara
    @Override
    public String makeSound() {
        return "The mammal makes a sound.";
    }

    // Override informasi
    @Override
    public String getInfo() {
        return super.getInfo() + ", Fur Color: " + furColor;
    }
}
