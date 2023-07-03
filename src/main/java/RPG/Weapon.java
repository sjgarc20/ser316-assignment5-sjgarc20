package RPG;

public class Weapon {
    
    private double damageMultiplier;
    private double speedMultiplier;
    private int level;
    private int baseDamage;
    private int baseSpeed;
    private String name;
    private StatusEffect statusEffect;
    
    
    /**
     * Calculates total weapon damage.
     * Starts with baseDamage * level,
     * then total is multiplied by the weapon-specific multiplier
     *  ex. Sword damage multiplier is 2, and if the damage is 10
     *  then the damage after the multiplier will be 20
     * @return total weapon damage
     */
    public int getTotalWeaponDamage() {
        int totalDamage = baseDamage * (level + 1);
        totalDamage = (int) (totalDamage * damageMultiplier);
        return totalDamage;
    }
    
    /**
     * Calculates total weapon speed.
     * Starts with baseSpeed * level
     * then total is multiplied by the weapon-specific multiplier
     *  ex. Spear speed multiplier is 1.5, and if the damage is 10
     *  then the Speed after the multiplier will be 15
     * @return total weapon speed
     */
    public int getTotalWeaponSpeed() {
        int totalSpeed = baseSpeed * (level + 1);
        totalSpeed = (int) (totalSpeed * speedMultiplier);
        return totalSpeed;
    }
    
    public double getDamageMultiplier() {
        return damageMultiplier;
    }
    
    public void setDamageMultiplier(double damageMultiplier) {
        this.damageMultiplier = damageMultiplier;
    }
    
    public double getSpeedMultiplier() {
        return speedMultiplier;
    }

    public void setSpeedMultiplier(double speedMultiplier) {
        this.speedMultiplier = speedMultiplier;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public StatusEffect getStatusEffect() {
        return statusEffect;
    }
    
    public int getLevel() {
        return level;
    }
    
    public void setLevel(int newLevel) {
        this.level = newLevel;
    }
    
    public void addLevel(int level) {
        this.level += level;
    }
    
    public int getBaseDamage() {
        return baseDamage;
    }
    
    public void setBaseDamage(int damage) {
        this.baseDamage = damage;
    }
    
    public int getBaseSpeed() {
        return baseSpeed;
    }
    
    public void setBaseSpeed(int block) {
        this.baseSpeed = block;
    }
    
    
}
