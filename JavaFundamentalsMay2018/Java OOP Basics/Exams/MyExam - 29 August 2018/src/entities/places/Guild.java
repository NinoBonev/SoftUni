package entities.places;

import constants.Messages;
import interfaces.Hero;
import interfaces.IGuild;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Nino Bonev - 29.8.2018 г., 9:21
 */
public class Guild implements IGuild {
    private String name;
    private Map<String, Hero> heroes;

    public Guild(String name) {
        this.name = name;
        this.heroes = new LinkedHashMap<>();
    }

    protected String getName() {
        return name;
    }

    public Map<String, Hero> getHeroes() {
        return heroes;
    }

    @Override
    public String addHero(Hero hero) {
        if (!this.heroes.containsKey(hero.getName())) {
            this.heroes.put(hero.getName(), hero);
            return String.format(Messages.ADDED_HERO, hero.getName());
        } else {
            boolean isStronger = this.heroes.get(hero.getName()).getTotalPoints() < hero.getTotalPoints();
            if (isStronger) {
                this.heroes.replace(hero.getName(), hero);
                return String.format(Messages.UPDATED_HERO, hero.getName());
            } else {
                return String.format(Messages.NOT_UPDATED, hero.getName());
            }
        }
    }

    @Override
    public String removeHero(Hero hero) {
        if (this.heroes.containsKey(hero.getName())) {
            this.heroes.remove(hero.getName());
            return String.format(Messages.REMOVE_HERO, hero.getName(), this.name);
        }
        return null;
    }

    @Override
    public Hero getHeroByName(String heroName) {
        if (this.heroes.containsKey(heroName)) {
            return this.heroes.get(heroName);
        }
        return null;
    }

    @Override
    public Long getGuildSize() {
        Long size = 0L;
        size += this.heroes.size();
        return size;
    }

    @Override
    public double getGuildPower() {
        double totalPower = 0.0;
        for (Hero hero : heroes.values()) {
            totalPower += hero.getTotalPoints();
        }
        return Math.round(totalPower * 100.0) / 100.0;
    }

    @Override
    public String getGuildSpecialization() {
        Map<String, Integer> compare = new HashMap<>();
        compare.put("Endurance", 0);
        compare.put("Strength", 0);
        compare.put("Willpower", 0);

        int willpower = 0;
        int endurance = 0;
        int strength = 0;

        for (Hero hero : heroes.values()) {
            switch (hero.getClass().getSimpleName()) {
                case "Nord":
                    compare.replace("Endurance", compare.get("Endurance") + 1);
                    break;
                case "Orc":
                    compare.replace("Endurance", compare.get("Endurance") + 1);
                    break;
                case "Khajiit":
                    compare.replace("Strength", compare.get("Strength") + 1);
                    break;
                case "Redguard":
                    compare.replace("Strength", compare.get("Strength") + 1);
                    break;
                case "Breton":
                    compare.replace("Willpower", compare.get("Willpower") + 1);
                    break;
                case "Dunmer":
                    compare.replace("Willpower", compare.get("Willpower") + 1);
                    break;
            }
        }
        compare.entrySet().stream().sorted((a, b) -> {
            int result = b.getValue().compareTo(a.getValue());

            if (result == 0) {
                String classNameA = a.getKey();
                String classNameB = b.getKey();
                String a1 = "";
                String a2 = "";
                String b1 = "";
                String b2 = "";
                switch (classNameA) {
                    case "Endurance":
                        a1 = "Nord";
                        a2 = "Orc";
                        break;
                    case "Strength":
                        a1 = "Khajiit";
                        a2 = "Redguard";
                        break;
                    case "Willpower":
                        a1 = "Breton";
                        a2 = "Dunmer";
                        break;
                }
                switch (classNameB){
                    case "Endurance":
                        b1 = "Nord";
                        b2 = "Orc";
                        break;
                    case "Strength":
                        b1 = "Khajiit";
                        b2 = "Redguard";
                        break;
                    case "Willpower":
                        b1 = "Breton";
                        b2 = "Dunmer";
                        break;
                }
                double totalPointsA = 0.0;
                double totalPointsB = 0.0;
                for (Hero hero : heroes.values()) {
                    if (hero.getClass().getSimpleName() == a1 || hero.getClass().getSimpleName() == a2){
                        totalPointsA += hero.getTotalPoints();
                    }
                    if (hero.getClass().getSimpleName() == b1 || hero.getClass().getSimpleName() == b2){
                        totalPointsB += hero.getTotalPoints();
                    }
                }

                result = Double.compare(totalPointsB, totalPointsA);
            }

            return result;
        })
                .limit(1)
                .forEach(x -> {
                    System.out.println(x.getKey());
                });

        return null;
    }
}
