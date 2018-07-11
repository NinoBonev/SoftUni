package p09_Google;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nino Bonev - 19.6.2018 г., 10:06
 */
public class Person {
    private String name;
    private Company company;
    private Car car;
    private List<Parents> parents;
    private List<Children> children;
    private List<Pokemon> pokemons;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
        this.company = new Company();
        this.car = new Car();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.pokemons = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return this.company;
    }

    public void setCompany(String name, String department, double salary) {
        this.company = new Company(name, department, salary);
    }

    public Car getCar() {
        return this.car;
    }

    public void setCar(String model, Integer speed) {
        this.car = new Car(model, speed);
    }

    public List<Parents> getParents() {
        return this.parents;
    }

    public void addParents(String name, String birthday) {
        Parents parents = new Parents(name, birthday);
        this.getParents().add(parents);
    }

    public List<Children> getChildren() {
        return this.children;
    }

    public void addChildren(String name, String birthday) {
        Children children = new Children(name, birthday);
        this.getChildren().add(children);
    }

    public List<Pokemon> getPokemons() {
        return this.pokemons;
    }

    public void addPokemons(String name, String type) {
        Pokemon pokemon = new Pokemon(name, type);
        this.getPokemons().add(pokemon);
    }

    @Override
    public String toString() {
        StringBuilder printInfo = new StringBuilder();
        printInfo.append(this.getName()).append(System.lineSeparator());
        printInfo.append("Company:").append(System.lineSeparator());
        if (this.company.getName() != null){
            printInfo
                    .append(this.company.getInfo())
                    .append(System.lineSeparator());
        }
        printInfo.append("Car:").append(System.lineSeparator());
        if (this.car.getModel() != null){
            printInfo
                    .append(this.car.getInfo())
                    .append(System.lineSeparator());
        }
        printInfo.append("Pokemons:").append(System.lineSeparator());
        for (Pokemon pokemon:
             this.getPokemons()) {
            printInfo.append(pokemon.getInfo()).append(System.lineSeparator());
        }
        printInfo.append("Parents:").append(System.lineSeparator());
        for (Parents prts:
             this.getParents()) {
            printInfo.append(prts.getInfo()).append(System.lineSeparator());
        }
        printInfo.append("Children").append(System.lineSeparator());
        for (Children child:
             this.getChildren()) {
            printInfo.append(child.getInfo()).append(System.lineSeparator());
        }
        return printInfo.toString().replace(",", ".");
    }
}
