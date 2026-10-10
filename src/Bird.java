
public class Bird extends Animal {

    private boolean canFly;

    // Constructor
    public Bird(String name, int age, boolean canFly) {
        super(name, age);
        this.canFly = canFly;
    }

    // Getter dan Setter
    public boolean isCanFly() {
        return canFly;
    }

    public void setCanFly(boolean canFly) {
        this.canFly = canFly;
    }

    // Override suara
    @Override
    public String makeSound() {
        return "The bird chirps.";
    }

    // Override informasi
    @Override
    public String getInfo() {
        return super.getInfo() + ", Can Fly: " + canFly;
    }
}
