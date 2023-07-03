package RPG;

public class BanditBuilder extends CharacterBuilder {

    Character bandit = new Character();
    
    @Override
    protected void setMaxHealth() {
        int health = RandomNumberGenerator.getRandomIntRange(Game.getCurrentFloor(), Game.getCurrentFloor() * 2);
        if (Game.getCurrentFloor() % 10 == 5) {
            health = health * 2;
        } else if (Game.getCurrentFloor() % 10 == 0) {
            health = health * 3;
        }
        bandit.setMaxHealth(health);
    }

    @Override
    protected void setLevel() {
        bandit.setLevel(Game.getCurrentFloor());
    }

    @Override
    protected void setWeapon() {
        WeaponDirector weaponDirector = new WeaponDirector();
        WeaponBuilder daggerBuilder = new DaggerBuilder();
        weaponDirector.makeWeapon(daggerBuilder);
        Weapon dagger = daggerBuilder.getWeapon();
        bandit.setWeapon(dagger);
    }

    @Override
    protected void setArmor() {
        
    }

    @Override
    protected void setSpecialTraits() {
        if (Game.getCurrentFloor() % 10 == 5) {
            bandit.setExperience(Game.getCurrentFloor() * 100);
        } else if (Game.getCurrentFloor() % 10 == 0) {
            bandit.setExperience(Game.getCurrentFloor() * 200);
        } else {
            bandit.setExperience(Game.getCurrentFloor() * 50);
        }
    }

    @Override
    protected Character getCharacter() {
        return bandit;
    }

}
