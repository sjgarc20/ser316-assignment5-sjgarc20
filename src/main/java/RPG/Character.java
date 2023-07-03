package rpg;

public class Character {
    private int maxHealth;
    private int currentHealth;
    private int level;
    private Weapon weapon;
    private int experience;
    private int gold;
    private String name;
    
    public int getMaxHealth() {
        return maxHealth;
    }
    
    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }
    
    public int getCurrentHealth() {
        return currentHealth;
    }
    
    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }
    
    public void takeDamage(int damageTaken) {
        this.currentHealth = this.currentHealth - (damageTaken);
    }
    
    public int getLevel() {
        return level;
    }
    
    public void setLevel(int level) {
        this.level = level;
    }
    
    /**
     * Levels up the character.
     * Subtracts experience and increments level only if there's enough
     * experience to level up. Then it calculates the new maxHealth value
     * and sets the current Health value to it
     * @return true if character leveled up, false otherwise
     */
    public boolean levelUp() {
        int experienceToLevelUp = (level + 1) * 100;
        if (experience >= experienceToLevelUp) {
            experience -= experienceToLevelUp;
            this.level += 1;
            this.maxHealth = level * 5 + 10;
            this.currentHealth = this.maxHealth;
            return true;
        }
        return false;
    }
    
    public Weapon getWeapon() {
        return weapon;
    }
    
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
    
    public int getExperience() {
        return experience;
    }
    
    public void setExperience(int experience) {
        this.experience = experience;
    }
    
    public void addExperience(int experience) {
        this.experience += experience;
    }
    
    public int getGold() {
        return gold;
    }
    
    public void setGold(int gold) {
        this.gold = gold;
    }
    
    public void addGold(int gold) {
        this.gold = this.gold + gold;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
