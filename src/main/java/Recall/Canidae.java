package Recall;

public class Canidae extends Animals {

    public Canidae(String species, String name, int age, String action) {
        super(species, name, age, action);
    }

    @Override
    public void getSpecies() {
        System.out.println("Вид " + species + " относится к семейству псовых.");
    }

    @Override
    public void swim() {
        System.out.println("Да, " + species + " действительно умеет плавать.");

    }

    @Override
    public void getInfo() {
        System.out.println("Псовые, или собачьи, или волчьи, или собаки, или каниды (лат. Canidae), — семейство млекопитающих отряда хищных.");
    }







}
