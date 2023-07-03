package RPG;

public class SwordBuilder extends WeaponBuilder {

    Weapon sword = new Weapon();
    
    @Override
    protected void setDamageMultiplier() {
        sword.setDamageMultiplier(2);
    }

    @Override
    protected void setSpeedMultiplier() {
        sword.setSpeedMultiplier(1);
    }

    @Override
    protected void setLevel() {
        sword.setLevel(0);
    }

    @Override
    protected void setBaseDamage() {
        sword.setBaseDamage(1);
    }

    @Override
    protected void setBaseSpeed() {
        sword.setBaseSpeed(1);
    }

    @Override
    protected void setName() {
        sword.setName("Sword");
    }
    
    @Override
    protected Weapon getWeapon() {
        return sword;
    }
}
