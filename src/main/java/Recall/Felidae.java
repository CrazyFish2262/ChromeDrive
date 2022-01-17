package Recall;

public class Felidae extends Animals {
    public Felidae(String species, String name, int age, String action) {
        super(species, name, age, action);
    }

    @Override
    public void getSpecies() {
        System.out.println("Вид " + species + " относится к семейству кошачьих.");
    }

    @Override
    public void swim() {
        System.out.println("Да, " + species + " действительно умеет плавать, но очень не любит это делать.");
    }

    @Override
    public void getInfo() {
        System.out.println("Кошачьи, или кошки, или фелиды (лат. Felidae), — семейство млекопитающих отряда хищных.");
    }
}
