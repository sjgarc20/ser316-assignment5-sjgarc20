package RPG;

public class UndeadWeaponBuilder extends WeaponBuilder {
    
    Weapon undeadWeapon = new Weapon();
    
    @Override
    protected void setDamageMultiplier() {
        undeadWeapon.setDamageMultiplier(2);
    }

    @Override
    protected void setSpeedMultiplier() {
        undeadWeapon.setSpeedMultiplier(1);
    }

    @Override
    protected void setLevel() {
        undeadWeapon.setLevel(0);
    }

    @Override
    protected void setBaseDamage() {
        undeadWeapon.setBaseDamage(1);
    }

    @Override
    protected void setBaseSpeed() {
        undeadWeapon.setBaseSpeed(1);
    }

    @Override
    protected void setName() {
        undeadWeapon.setName("Life-Stealing Limbs");
    }
    
    @Override
    protected Weapon getWeapon() {
        return undeadWeapon;
    }
}
