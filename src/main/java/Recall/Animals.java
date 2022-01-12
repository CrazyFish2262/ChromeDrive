package Recall;

public abstract class Animals {
    String species;
    String name;
    int age;
    String action;

    public Animals(String species, String name, int age, String action) {
        this.species = species;
        this.name = name;
        this.age = age;
        this.action = action;
    }

    public abstract void getSpecies();

}
