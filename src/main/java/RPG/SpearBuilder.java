package RPG;

public class SpearBuilder extends WeaponBuilder {

    Weapon spear = new Weapon();
    
    @Override
    protected void setDamageMultiplier() {
        spear.setDamageMultiplier(1.5);
    }

    @Override
    protected void setSpeedMultiplier() {
        spear.setSpeedMultiplier(1.5);
    }

    @Override
    protected void setLevel() {
        spear.setLevel(0);
    }

    @Override
    protected void setBaseDamage() {
        spear.setBaseDamage(1);
    }

    @Override
    protected void setBaseSpeed() {
        spear.setBaseSpeed(1);
    }

    @Override
    protected void setName() {
        spear.setName("Spear");
    }
    
    @Override
    protected Weapon getWeapon() {
        return spear;
    }
    
}
