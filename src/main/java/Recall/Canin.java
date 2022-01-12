package Recall;

public class Canin extends Animals {

    public Canin(String species, String name, int age, String action) {
        super(species, name, age, action);
    }

    @Override
    public void getSpecies() {
        System.out.println("Вид " + species + " относится к семейству псовых");
    }
}
