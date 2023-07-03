package rpg;

public class MonstrousWeaponBuilder extends WeaponBuilder {

    Weapon mounstrousWeapon = new Weapon();
    
    @Override
    protected void setDamageMultiplier() {
        mounstrousWeapon.setDamageMultiplier(2.5);
    }

    @Override
    protected void setSpeedMultiplier() {
        mounstrousWeapon.setSpeedMultiplier(1.5);
    }

    @Override
    protected void setLevel() {
        mounstrousWeapon.setLevel(0);
    }

    @Override
    protected void setBaseDamage() {
        mounstrousWeapon.setBaseDamage(1);
    }

    @Override
    protected void setBaseSpeed() {
        mounstrousWeapon.setBaseSpeed(1);
    }

    @Override
    protected void setName() {
        mounstrousWeapon.setName("Fiendish Limbs");
    }
    
    @Override
    protected Weapon getWeapon() {
        return mounstrousWeapon;
    }
    
}
