package rpg;

public class Weapon {
    
    private double damageMultiplier;
    private double speedMultiplier;
    private int level;
    private int baseDamage;
    private int baseSpeed;
    private String name;
    private StatusEffect statusEffect;
    
    
    
    public int getTotalWeaponDamage() {
        int totalDamage = baseDamage * level;
        totalDamage = (int) (totalDamage * damageMultiplier);
        return totalDamage;
    }
    
    public int getTotalWeaponSpeed() {
        int totalSpeed = baseSpeed * level;
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
