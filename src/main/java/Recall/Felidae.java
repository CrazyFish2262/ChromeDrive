package Recall;

public class Felidae extends Animals{
    public Felidae(String species, String name, int age, String action) {
        super(species, name, age, action);
    }

    @Override
    public void getSpecies() {
        System.out.println("Вид " + species + " относится к семейству кошачьих");
    }
}
