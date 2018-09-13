package manager;

import constants.Messages;
import entities.heroes.endurance.Nord;
import entities.heroes.endurance.Orc;
import entities.heroes.strength.Khajiit;
import entities.heroes.strength.Redguard;
import entities.heroes.willpower.Breton;
import entities.heroes.willpower.Dunmer;
import entities.places.Guild;
import entities.places.Province;
import factories.HeroFactory;
import interfaces.Hero;
import interfaces.IGuild;
import interfaces.IHeroFactory;
import interfaces.IProvince;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Nino Bonev - 3.8.2018 г., 15:59
 */
public class ManagerImpl {
    private final IHeroFactory heroFactory;
    private final Map<String, Hero> heroes;
    private final Map<String, Guild> guilds;
    private final Map<String, Province> provinces;
    private String selected;

    public ManagerImpl(IHeroFactory heroFactory) {
        this.heroFactory = heroFactory;
        this.heroes = new LinkedHashMap<>();
        this.guilds = new LinkedHashMap<>();
        this.provinces = new LinkedHashMap<>();
        this.selected = "";
    }

    private void setSelected(String selected) {
        this.selected = selected;
    }

    public String createProvince(List<String> arguments) {
        String provinceName = arguments.get(0);
        this.setSelected(provinceName);
        if (!this.provinces.containsKey(provinceName)) {
            Province province = new Province(provinceName);
            this.provinces.put(provinceName, province);
            return String.format(Messages.ADDED_PROVINCE, provinceName);
        } else {
            return String.format(Messages.NOT_ADDED_PROVINCE, provinceName);
        }
    }

    public String selectProvince(List<String> arguments) {
        String provinceName = arguments.get(0);
        if (this.selected.equals(provinceName)) {
            return String.format(Messages.ALREADY_SELECTED, provinceName);
        } else if (this.provinces.containsKey(provinceName)) {
            this.setSelected(provinceName);
            return String.format(Messages.SELECTED_PROVINCE, provinceName);
        } else {
            return String.format(Messages.NOT_EXISTING_PROVINCE, provinceName);
        }

    }

    //{guildName} {heroType} {heroName} {health} {fatigue} {magicka}
    public String addHero(List<String> arguments) {
        if (!selected.equals("")){
            List<String> heroTypes = new ArrayList<>();
            heroTypes.add("Breton");
            heroTypes.add("Orc");
            heroTypes.add("Redguard");
            heroTypes.add("Khajiit");
            heroTypes.add("Nord");
            heroTypes.add("Dunmer");

            String guildName = arguments.get(0);
            String heroType = arguments.get(1);
            String heroName = arguments.get(2);
            int health = Integer.parseInt(arguments.get(3));
            int fatigue = Integer.parseInt(arguments.get(4));
            int magicka = Integer.parseInt(arguments.get(5));

            if (!heroTypes.contains(heroType)) {
                return Messages.NO_SUCH_HERO_TYPE;
            } else if (health < 1 || fatigue < 1 || magicka < 1) {
                return Messages.INVALID_CHARACTERS;
            } else {
                if (!this.guilds.containsKey(guildName)) {
                    this.addGuild(arguments);
                }
                switch (heroType) {
                    case "Breton":
                        Breton breton = new Breton(heroName, magicka, fatigue, health, heroType);
                        this.heroes.put(heroName, breton);
                        return this.guilds.get(guildName).addHero(breton);
                    case "Orc":
                        Orc orc = new Orc(heroName, magicka, fatigue, health, heroType);
                        this.heroes.put(heroName, orc);
                        return this.guilds.get(guildName).addHero(orc);
                    case "Redguard":
                        Redguard redguard = new Redguard(heroName, magicka, fatigue, health, heroType);
                        this.heroes.put(heroName, redguard);
                        return this.guilds.get(guildName).addHero(redguard);
                    case "Khajiit":
                        Khajiit khajiit = new Khajiit(heroName, magicka, fatigue, health, heroType);
                        this.heroes.put(heroName, khajiit);
                        return this.guilds.get(guildName).addHero(khajiit);
                    case "Nord":
                        Nord nord = new Nord(heroName, magicka, fatigue, health, heroType);
                        this.heroes.put(heroName, nord);
                        return this.guilds.get(guildName).addHero(nord);
                    case "Dunmer":
                        Dunmer dunmer = new Dunmer(heroName, magicka, fatigue, health, heroType);
                        this.heroes.put(heroName, dunmer);
                        return this.guilds.get(guildName).addHero(dunmer);
                    default: return null;
                }
            }
        } else {
            return Messages.NO_PROVINCE_SELECTED;
        }
    }

    public String addGuild(List<String> arguments) {
        if (!selected.equals("")) {
            String guildName = arguments.get(0);
            if (this.guilds.containsKey(guildName)) {
                return Messages.EXISTING_GUILD;
            } else {
                Guild guild = new Guild(guildName);
                this.guilds.put(guildName, guild);
                return this.provinces.get(selected).addGuild(guild);
            }
        } else {
            return Messages.NO_PROVINCE_SELECTED;
        }
    }

    public String removeGuild(List<String> arguments){
        if (!selected.equals("")) {
            String guildName = arguments.get(0);
            if (!this.guilds.containsKey(guildName)) {
                return String.format(Messages.NO_EXISTING_GUILD, guildName);
            } else {
                Long size = this.guilds.get(guildName).getGuildSize();
                this.provinces.get(selected).removeGuild(this.guilds.get(guildName));
                this.guilds.remove(guildName);
                return String.format(Messages.REMOVE_GUILD, guildName, size);
            }
        } else {
            return Messages.NO_PROVINCE_SELECTED;
        }
    }

    public String removeHero(List<String> arguments){
        if (!selected.equals("")){
            String guildName = arguments.get(0);
            String heroName = arguments.get(1);
            if (!this.guilds.containsKey(guildName)){
                return String.format(Messages.NO_EXISTING_GUILD, guildName);
            } else if (this.guilds.get(guildName).getHeroByName(heroName) == null){
                return Messages.NO_SUCH_HERO;
            } else {
                this.guilds.get(guildName).removeHero(this.guilds.get(guildName).getHeroByName(heroName));
                this.heroes.remove(heroName);
                return String.format(Messages.SUCCESSFULLY_REMOVED_HERO, heroName, guildName);
            }
        } else {
            return Messages.NO_PROVINCE_SELECTED;
        }
    }

    public String guildDetails(List<String> arguments){
        if (!selected.equals("")){
            String guildName = arguments.get(0);
            if (!this.guilds.containsKey(guildName)){
                return String.format(Messages.NO_EXISTING_GUILD, guildName);
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(String.format(Messages.GUILD_DETAILS_MESSAGE, guildName));
                if (this.guilds.get(guildName).getGuildSize() > 0){
                    sb.append(System.lineSeparator());
                    this.guilds.get(guildName).getHeroes().entrySet().stream()
                            .sorted((a, b) -> {
                                int result = Double.compare(b.getValue().getTotalPoints(), a.getValue().getTotalPoints());

                                if (result == 0){
                                    result = a.getKey().compareTo(b.getKey());
                                }

                                return result;
                            }).forEach(x -> {
                        sb.append(String.format(Messages.HEROES_INFO, x.getKey(), x.getValue().getOffense(), x.getValue().getDefense()))
                                .append(System.lineSeparator());
                    });
                } else {
                    sb.append(" None").append(System.lineSeparator());
                }

                return sb.toString();
            }
        }else {
            return Messages.NO_PROVINCE_SELECTED;
        }
    }

    public String heroDetails(List<String> arguments){
        if (!selected.equals("")){
            String guildName = arguments.get(0);
            String heroName = arguments.get(1);
            if (!this.guilds.containsKey(guildName)){
                return String.format(Messages.NO_EXISTING_GUILD, guildName);
            } else if (this.guilds.get(guildName).getHeroByName(heroName) == null){
                return Messages.NO_SUCH_HERO;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(String.format(Messages.HERO_DETAILED_MESSAGE,
                        heroName,
                        this.heroes.get(heroName).getHeroType(),
                        this.heroes.get(heroName).getHealth(),
                        this.heroes.get(heroName).getFatigue(),
                        this.heroes.get(heroName).getMagicka()
                ));
                if (this.heroes.get(heroName).getHeroType().equals("ORSIMER") ||
                        this.heroes.get(heroName).getHeroType().equals("NORD")){
                    sb.append("#Endurance bonuses:").append(System.lineSeparator())
                            .append(String.format("Magic resistance: +%.2f defense.", this.heroes.get(heroName).getMagicResistance()))
                    .append(System.lineSeparator());
                } else if (this.heroes.get(heroName).getHeroType().equals("REDGUARD") ||
                        this.heroes.get(heroName).getHeroType().equals("KHAJIIT")){
                    sb.append("#Strength bonuses:").append(System.lineSeparator())
                            .append(String.format("Magic damage: +%.2f offense.", this.heroes.get(heroName).getMagicDamage()))
                    .append(System.lineSeparator());
                }

                return sb.toString();
            }
        }else {
            return Messages.NO_PROVINCE_SELECTED;
        }
    }

    public String fight(List<String> arguments){
        String guild1Name = arguments.get(0);
        String hero1Name = arguments.get(1);
        String guild2Name = arguments.get(2);
        String hero2Name = arguments.get(3);
        if (!selected.equals("")){
            if (guild1Name.equals(guild2Name)){
                return "Heroes from the same guild can not fight each other.";
            } else {
                Hero hero1 = this.guilds.get(guild1Name).getHeroByName(hero1Name);
                Hero hero2 = this.guilds.get(guild2Name).getHeroByName(hero2Name);
                if (hero1 != null && hero2 != null) {
                    if (hero1.getHealth() > hero2.getHealth()) {
                        while (!(hero1.isDead() || hero2.isDead())) {
                            hero2.attack(hero1);
                            if (!hero1.isDead()) {
                                hero1.attack(hero2);
                            }
                        }
                        if (hero1.isDead()) {
                            this.guilds.get(guild1Name).removeHero(hero1);
                            this.heroes.remove(hero1Name);
                            return String.format("Hero %s sliced hero %s.", hero2Name, hero1Name);
                        } else {
                            this.guilds.get(guild2Name).removeHero(hero2);
                            this.heroes.remove(hero2Name);
                            return String.format("Hero %s sliced hero %s.", hero1Name, hero2Name);
                        }
                    } else if (hero1.getHealth() < hero2.getHealth()) {
                        while (hero1.isDead() || hero2.isDead()) {
                            hero1.attack(hero2);
                            if (!hero2.isDead()) {
                                hero2.attack(hero1);
                            }
                        }
                        if (hero1.isDead()) {
                            this.guilds.get(guild1Name).removeHero(hero1);
                            this.heroes.remove(hero1Name);
                            return String.format("Hero %s sliced hero %s.", hero2Name, hero1Name);
                        } else {
                            this.guilds.get(guild2Name).removeHero(hero2);
                            this.heroes.remove(hero2Name);
                            return String.format("Hero %s sliced hero %s.", hero1Name, hero2Name);
                        }
                    } else {
                        double hero1Offence = hero1.getOffense();
                        double hero2Offence = hero2.getOffense();
                        if (hero1Offence < hero2Offence) {
                            while (hero1.isDead() || hero2.isDead()) {
                                hero1.attack(hero2);
                                if (!hero2.isDead()) {
                                    hero2.attack(hero1);
                                }
                            }
                            if (hero1.isDead()) {
                                this.guilds.get(guild1Name).removeHero(hero1);
                                this.heroes.remove(hero1Name);
                                return String.format("Hero %s sliced hero %s.", hero2Name, hero1Name);
                            } else {
                                this.guilds.get(guild2Name).removeHero(hero2);
                                this.heroes.remove(hero2Name);
                                return String.format("Hero %s sliced hero %s.", hero1Name, hero2Name);
                            }
                        } else {
                            while (hero1.isDead() || hero2.isDead()) {
                                hero2.attack(hero1);
                                if (!hero1.isDead()) {
                                    hero1.attack(hero2);
                                }
                            }
                            if (hero1.isDead()) {
                                this.guilds.get(guild1Name).removeHero(hero1);
                                this.heroes.remove(hero1Name);
                                return String.format("Hero %s sliced hero %s.", hero2Name, hero1Name);
                            } else {
                                this.guilds.get(guild2Name).removeHero(hero2);
                                this.heroes.remove(hero2Name);
                                return String.format("Hero %s sliced hero %s.", hero1Name, hero2Name);
                            }
                        }
                    }
                } else {
                    return "No such hero in this guild!";
                }
            }
        }else {
            return Messages.NO_PROVINCE_SELECTED;
        }
    }

    public String end(List<String> arguments){
        StringBuilder result = new StringBuilder();
        this.provinces.entrySet().stream().sorted((a, b) -> a.getKey().compareTo(b.getKey())).forEach(provinceEntry -> {

            result.append(String.format("Province: %s", provinceEntry.getKey()))
                    .append(System.lineSeparator())
                    .append("#Guilds: ");

            if (provinceEntry.getValue().getGuilds().size() > 0) {
                result.append(System.lineSeparator());
                this.guilds.entrySet().stream().sorted((a, b) -> {
                    int data = Double.compare(b.getValue().getGuildPower(), a.getValue().getGuildPower());

                    if (data == 0){
                        data = a.getKey().compareTo(b.getKey());
                    }
                    return data;
                }).forEach(guild -> {
                    result.append(String.format("##Guild: Name: %s, Power: %.2f, Size: %d",
                            guild.getKey(),
                            guild.getValue().getGuildPower(),
                            guild.getValue().getGuildSize()))
                            .append(System.lineSeparator());
                });
            } else {
                result.append("None").append(System.lineSeparator());
            }
        });

        return result.toString();
    }
}
