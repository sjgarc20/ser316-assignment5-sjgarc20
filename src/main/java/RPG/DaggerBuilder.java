package RPG;

public class DaggerBuilder extends WeaponBuilder {

    Weapon dagger = new Weapon();
    
    @Override
    protected void setDamageMultiplier() {
        dagger.setDamageMultiplier(1);
    }

    @Override
    protected void setSpeedMultiplier() {
        dagger.setSpeedMultiplier(2);
    }

    @Override
    protected void setLevel() {
        dagger.setLevel(0);
    }

    @Override
    protected void setBaseDamage() {
        dagger.setBaseDamage(1);
    }

    @Override
    protected void setBaseSpeed() {
        dagger.setBaseSpeed(1);
    }

    @Override
    protected void setName() {
        dagger.setName("Dagger");
    }
    
    @Override
    protected Weapon getWeapon() {
        return dagger;
    }
    
}
