package RPG;

public class UndeadBuilder extends CharacterBuilder {

    Character undead = new Character();
    
    @Override
    protected void setMaxHealth() {
        int health = RandomNumberGenerator.getRandomIntRange(Game.getCurrentFloor(), (int) (Game.getCurrentFloor() * 1.5));
        if (Game.getCurrentFloor() % 10 == 5) {
            health = health * 3;
        } else if (Game.getCurrentFloor() % 10 == 0) {
            health = health * 10;
        }
        undead.setMaxHealth(health);
    }

    @Override
    protected void setLevel() {
        undead.setLevel(Game.getCurrentFloor());
    }

    @Override
    protected void setWeapon() {
        WeaponDirector weaponDirector = new WeaponDirector();
        WeaponBuilder daggerBuilder = new DaggerBuilder();
        weaponDirector.makeWeapon(daggerBuilder);
        Weapon dagger = daggerBuilder.getWeapon();
        undead.setWeapon(dagger);
    }

    @Override
    protected void setArmor() {
        // TODO Auto-generated method stub
        
    }

    @Override
    protected void setSpecialTraits() {
        if (Game.getCurrentFloor() % 10 == 5) {
            undead.setExperience(Game.getCurrentFloor() * 100);
        } else if (Game.getCurrentFloor() % 10 == 0) {
            undead.setExperience(Game.getCurrentFloor() * 200);
        } else {
            undead.setExperience(Game.getCurrentFloor() * 50);
        }
    }
    
    @Override
    protected Character getCharacter() {
        return undead;
    }

}
