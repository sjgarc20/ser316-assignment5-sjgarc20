package rpg;

public abstract class CharacterBuilder {
    
    protected abstract void setMaxHealth();
    
    protected abstract void setLevel();
    
    protected abstract void setWeapon();
    
    protected abstract void setSpecialTraits();
    
    protected abstract Character getCharacter();
    
}
