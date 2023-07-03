package rpg;

public class BanditBuilder extends CharacterBuilder {

    Character bandit = new Character();
    
    @Override
    protected void setMaxHealth() {
        int health = RandomNumberGenerator.getRandomIntRange(0, 0);
        bandit.setMaxHealth(0);
    }

    @Override
    protected void setLevel() {
        // TODO Auto-generated method stub
        
    }

    @Override
    protected void setWeapon() {
        // TODO Auto-generated method stub
        
    }

    @Override
    protected void setArmor() {
        // TODO Auto-generated method stub
        
    }

    @Override
    protected void setSpecialTraits() {
        // TODO Auto-generated method stub
        
    }

    @Override
    protected Character getCharacter() {
        return bandit;
    }

}
