package rpg;

public class MonsterBuilder extends CharacterBuilder {

    Character monster = new Character();
    
    @Override
    protected void setMaxHealth() {
        int health = RandomNumberGenerator.getRandomIntRange(Game.getCurrentFloor() * 2, Game.getCurrentFloor() * 3);
        if (Game.getCurrentFloor() % 10 == 5) {
            health = health * 2;
        } else if (Game.getCurrentFloor() % 10 == 0) {
            health = health * 3;
        }
        monster.setMaxHealth(health);
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
    protected void setArmor() {
        // TODO Auto-generated method stub
        
    }

    @Override
    protected void setSpecialTraits() {
        if (Game.getCurrentFloor() % 10 == 5) {
            monster.setExperience(Game.getCurrentFloor() * 100);
        } else if (Game.getCurrentFloor() % 10 == 0) {
            monster.setExperience(Game.getCurrentFloor() * 200);
        } else {
            monster.setExperience(Game.getCurrentFloor() * 50);
        }
    }
    
    @Override
    protected Character getCharacter() {
        return monster;
    }

}
