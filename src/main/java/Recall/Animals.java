package Recall;

public abstract class Animals implements Info, LoveToSwim {
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
    public void getName(){
        System.out.println("Имя - " + name);
    }

}
