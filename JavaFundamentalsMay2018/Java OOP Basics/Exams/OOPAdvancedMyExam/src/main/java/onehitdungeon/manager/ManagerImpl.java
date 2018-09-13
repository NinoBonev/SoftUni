package onehitdungeon.manager;

import onehitdungeon.constants.Messages;
import onehitdungeon.interfaces.DungeonManager;
import onehitdungeon.interfaces.Hero;
import onehitdungeon.myinterfaces.HeroFactory;
import onehitdungeon.interfaces.HeroTrainer;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Nino Bonev - 3.8.2018 г., 15:59
 */
public class ManagerImpl implements DungeonManager {
    private static final int DUNGEON_BATTLE_POWER = 20;
    private static final int DUNGEON_EARN_GOLD = 15;

    private final HeroTrainer heroTrainer;
    private final HeroFactory heroFactory;
    private final Map<String, Hero> heroes;
    private final Map<String, Integer> heroesTrained;
    private String selected;
    private int levelReached;


    public ManagerImpl(HeroTrainer heroTrainer, HeroFactory heroFactory) {
        this.heroTrainer = heroTrainer;
        this.heroes = new LinkedHashMap<>();
        this.heroesTrained = new LinkedHashMap<>();
        this.heroFactory = heroFactory;
        this.selected = "";
        this.levelReached = 1;
    }


    @Override
    public String hero(List<String> arguments) {
        String type = arguments.get(0);
        String name = arguments.get(1);
        if (!type.equals("") && !name.equals("") ) {
            Hero hero = this.heroFactory.createHero(type, name);
            if (this.heroes.size() == 0) {
                selected = name;
            }
            this.heroes.putIfAbsent(name, hero);
            this.heroesTrained.putIfAbsent(name, 0);
            return String.format(Messages.ADDED_HERO, type, name);
        }
        return null;
    }

    @Override
    public String select(List<String> arguments) {
        String name = arguments.get(0);
        if (this.heroes.containsKey(name)){
            selected = name;
            return String.format(Messages.SELECTED_HERO, this.heroes.get(name).getHeroClass(), name);
        }
        return null;
    }

    @Override
    public String status(List<String> arguments) {
        if (!selected.equals("")){
            Hero hero = this.heroes.get(selected);
            if (this.heroes.get(selected).getHeroClass().equals("Paladin")){

                return String.format(Messages.GET_SELECTED_PALADIN_INFO,
                        hero.getName(),
                        this.heroesTrained.get(selected) + 1,
                        hero.getWeapon().getBattlePower(),
                        hero.getOffhand().getBattlePower(),
                        hero.getArmor().getBattlePower(),
                        hero.getGold(),
                        hero.getTotalPriceForUpgrade());
            } else if (this.heroes.get(selected).getHeroClass().equals("Mage")){
                return String.format(Messages.GET_SELECTED_MAGE_INFO,
                        hero.getName(),
                        this.heroesTrained.get(selected) + 1,
                        hero.getWeapon().getBattlePower(),
                        hero.getOffhand().getBattlePower(),
                        hero.getArmor().getBattlePower(),
                        hero.getGold(),
                        hero.getTotalPriceForUpgrade());
            }

        }
        return null;
    }

    @Override
    public String fight(List<String> arguments) {
        if (!selected.equals("")){
            Hero hero = this.heroes.get(selected);
            if (hero.getTotalBattlePower() > DUNGEON_BATTLE_POWER * this.levelReached){
                hero.earnGold(this.levelReached * 15.0);
                return String.format(Messages.FIGHT_WON, this.levelReached * 15.0);
            } else {
                if (this.levelReached > 1) {
                    this.levelReached--;
                }
                return Messages.FIGHT_LOST;
            }
        }
        return null;
    }

    @Override
    public String advance(List<String> arguments) {
        if (!selected.equals("")){
            this.levelReached++;
            return String.format(Messages.ADVANCED, this.levelReached);
        }

        return null;
    }

    @Override
    public String train(List<String> arguments) {
        if (!selected.equals("")){
            Hero hero = this.heroes.get(selected);
            if (hero.getGold() >= hero.getTotalPriceForUpgrade()){
                hero.payGold(hero.getTotalPriceForUpgrade());
                this.heroTrainer.trainHero(hero);
                this.heroesTrained.replace(selected, this.heroesTrained.get(selected) + 1);
                return String.format(Messages.TRAIN_HERO, hero.getTotalBattlePower());
            } else {
                return String.format(Messages.UNABLE_TO_TRAIN_HERO, hero.getTotalPriceForUpgrade(), hero.getGold());
            }
        }
        return null;
    }

    @Override
    public String quit(List<String> arguments) {
        StringBuilder result = new StringBuilder();

        for (Hero hero : heroes.values()) {
            result.append(String.format(Messages.HERO_DETAILS, hero.getHeroClass(), hero.getName(), hero.getTotalBattlePower()))
            .append(System.lineSeparator());
        }
        result.append("####################")
                .append(System.lineSeparator())
        .append(String.format(Messages.DUNGEON_INFO, this.levelReached));

        return result.toString();
    }
}
