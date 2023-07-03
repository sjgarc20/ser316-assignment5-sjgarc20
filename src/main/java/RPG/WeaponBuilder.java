package RPG;

public abstract class WeaponBuilder {
    
    protected abstract void setDamageMultiplier();
    
    protected abstract void setSpeedMultiplier();
    
    protected abstract void setLevel();
    
    protected abstract void setBaseDamage();
    
    protected abstract void setBaseSpeed();
    
    protected abstract void setName();
    
    protected abstract Weapon getWeapon();
    
}
