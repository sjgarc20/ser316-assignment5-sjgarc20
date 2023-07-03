package rpg;

public class MonsterBuilder extends CharacterBuilder {

    Character monster = new Character();
    
    @Override
    protected void setMaxHealth() {
        RandomNumberGenerator random = RandomNumberGenerator.getInstance();
        int health = random.getRandomIntRange(Game.getCurrentFloor() * 2, 
                Game.getCurrentFloor() * 3);
        if (Game.getCurrentFloor() % 10 == 5) {
            health = health * 2;
        } else if (Game.getCurrentFloor() % 10 == 0) {
            health = health * 3;
        }
        monster.setMaxHealth(health);
        monster.setCurrentHealth(health);
    }

    @Override
    protected void setLevel() {
        monster.setLevel(Game.getCurrentFloor());
    }

    @Override
    protected void setWeapon() {
        WeaponDirector weaponDirector = new WeaponDirector();
        WeaponBuilder monstrousWeaponBuilder = new MonstrousWeaponBuilder();
        weaponDirector.makeWeapon(monstrousWeaponBuilder);
        Weapon monstrousWeapon = monstrousWeaponBuilder.getWeapon();
        monster.setWeapon(monstrousWeapon);
    }

    @Override
    protected void setSpecialTraits() {
        if (Game.getCurrentFloor() % 10 == 5) {
            monster.setExperience(Game.getCurrentFloor() * 100);
            monster.setName("Minotaur");
        } else if (Game.getCurrentFloor() % 10 == 0) {
            monster.setExperience(Game.getCurrentFloor() * 200);
            monster.setName("Gelatinous Mass");
        } else {
            monster.setExperience(Game.getCurrentFloor() * 50);
            monster.setName("Orc");
        }
    }
    
    @Override
    protected Character getCharacter() {
        return monster;
    }

}
