package rpg;

import java.io.IOException;

/**
 * Singleton object, since we only need one instance of the logic to run the game.
 * @author Sam
 *
 */
public final class Logic {
    
    private static Logic INSTANCE;
    
    private Character player;
    private Character enemy;
    private int maxTick;
    private int playerTick;
    private int enemyTick;
    
    private Logic() {
    }
    
    /**
     * Generates singleton instance of Logic if it doesn't already exist.
     * @return instance of Logic
     */
    public static Logic getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Logic();
        }
        
        return INSTANCE;
    }
    
    /**
     * Initializes game play.
     * generates player character using playerBuilder pattern.
     * Enters gameplay loop by calling levelController()
     */
    public void init() {
        CharacterDirector director = new CharacterDirector();
        CharacterBuilder playerBuilder = new PlayerBuilder();
        director.makeCharacter(playerBuilder);
        player = playerBuilder.getCharacter();
        levelController();
    }
    
    /**
     * generates unique enemy per each floor.
     * Floors 1-10 = bandits
     * Floors 11-20 = monsters
     * Floors 21-30 = undead
     */
    public void generateEnemy() {
        CharacterDirector director = new CharacterDirector();
        CharacterBuilder enemyBuilder;
        if (Game.getCurrentFloor() <= 10) {
            enemyBuilder = new BanditBuilder();
        } else if (Game.getCurrentFloor() <= 20) {
            enemyBuilder = new MonsterBuilder();
        } else {
            enemyBuilder = new UndeadBuilder();
        }
        
        director.makeCharacter(enemyBuilder);
        enemy = enemyBuilder.getCharacter();
    }
    
    /**
     * Handles what shows up on each floor.
     * 0th floor means the player hasn't entered the dungeon yet.
     * Allows the player to go to the shop after every 5th floor, not including floor 0 or 30.
     * Generates an enemy and has the player battle said enemy each floor.
     */
    public void levelController() {
        while (Game.getCurrentFloor() < 31) {
            if (Game.getCurrentFloor() == 0) {
                levelUp();
                System.out.println("Are you ready to begin your dive into the dungeon?");
                System.out.println("1: Enter the shop");
                System.out.println("2: Show me my stats");
                System.out.println("3: Enter the dungeon!");
                System.out.println("Type the number of your selection, then press Enter");
                try {
                    int input = UserInput.getSelection();
                    if (input == 1) {
                        goToShop();
                    } else if (input == 2) {
                        displayStats();
                    } else if (input == 3) {
                        Game.advanceFloor();
                    } else {
                        throw new IOException("Invalid Input, must be 1, 2, or 3");
                    }
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            } else if (Game.getCurrentFloor() % 10 == 6
                    || Game.getCurrentFloor() == 11
                    || Game.getCurrentFloor() == 21) {
                goToShop();
            }
            if (Game.getCurrentFloor() != 0) {
                generateEnemy();
                battleLoop();
            }
        }
        winningSequence();
    }
    
    /**
     * Handles player going to the shop.
     * allows player to reforge their weapon into one of the other variants,
     * exit the dungeon, starting back at floor 1,
     * or continue through the dungeon.
     */
    public void goToShop() {
        System.out.println("Welcome to the shop, what would you like to do?");
        System.out.println("1: Reforge Weapon");
        System.out.println("2: Exit dungeon");
        System.out.println("3: Continue your adventure");
        
        try {
            int input = UserInput.getSelection();
            if (input == 1) {
                reforgeWeapon();
                goToShop();
            } else if (input == 2) {
                Game.setCurrentFloor(0);
            } else if (input == 3) {
                System.out.println("Good luck, adventurer!");
            } else {
                throw new IOException("Invalid Input, must be 1, 2, or 3");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void displayStats() {
        
    }
    
    /**
     * Facilitates battle between player and enemy.
     * characters repeatedly attack each other until either
     * of their health drops to 0 or lower.
     */
    public void battleLoop() {
        playerTick = player.getWeapon().getTotalWeaponSpeed();
        enemyTick = enemy.getWeapon().getTotalWeaponSpeed();
        if (playerTick > enemyTick) {
            maxTick = playerTick;
        } else {
            maxTick = enemyTick;
        }
        
        /**
         * Continue fighting until someone loses
         */
        while (player.getCurrentHealth() > 0 && enemy.getCurrentHealth() > 0) {
            if (playerTick >= maxTick) {
                if (playerTick >= enemyTick) {
                    // player attacks enemy
                    attackCharacter(player, enemy);
                    playerTick -= maxTick;
                } else {
                    // enemy attacks player
                    attackCharacter(enemy, player);
                    enemyTick -= maxTick;
                }
            } else if (enemyTick >= maxTick) {
                // enemy attacks player
                attackCharacter(enemy, player);
                enemyTick -= maxTick;
            } else {
                playerTick += player.getWeapon().getTotalWeaponSpeed();
                enemyTick += enemy.getWeapon().getTotalWeaponSpeed();
            }
        }
        
        if (player.getCurrentHealth() > 0) {
            System.out.println("You beat level " + enemy.getLevel() + " " + enemy.getName());
            System.out.println("Gained " + enemy.getExperience() + " experience");
            player.addExperience(enemy.getExperience());
            Game.advanceFloor();
        } else {
            System.out.println("You were defeated by level "  + enemy.getLevel() 
                + " " + enemy.getName());
            System.out.println("You lost " + player.getGold() + " Gold");
            Game.setCurrentFloor(0);
            player.setGold(0);
            player.setCurrentHealth(player.getMaxHealth());
        }
    }
    
    private void attackCharacter(Character attacker, Character defender) {
        int damage = attacker.getWeapon().getTotalWeaponDamage();
        defender.takeDamage(damage);
    }
    
    private void winningSequence() {
        System.out.println("Congratulations, you won the game!");
    }
    
    private void reforgeWeapon() {
        System.out.println("Please select the weapon you'd like to reforge to");
        System.out.println("1: Sword, does heavy damage, albeit not very fast");
        System.out.println("2: Dagger, great for a fast attacking style, "
                + "but the damage is not very high");
        System.out.println("3: Spear, a balance between attacking power and speed");
        System.out.println("Please input the number of the weapon you would like to choose.");
        
        int weaponLevel = player.getWeapon().getLevel();
        try {
            int input = UserInput.getSelection();
            WeaponDirector weaponDirector = new WeaponDirector();
            if (input == 1) {
                WeaponBuilder swordBuilder = new SwordBuilder();
                weaponDirector.makeWeapon(swordBuilder);
                Weapon sword = swordBuilder.getWeapon();
                player.setWeapon(sword);
            } else if (input == 2) {
                WeaponBuilder daggerBuilder = new DaggerBuilder();
                weaponDirector.makeWeapon(daggerBuilder);
                Weapon dagger = daggerBuilder.getWeapon();
                player.setWeapon(dagger);
            } else if (input == 3) {
                WeaponBuilder spearBuilder = new SpearBuilder();
                weaponDirector.makeWeapon(spearBuilder);
                Weapon spear = spearBuilder.getWeapon();
                player.setWeapon(spear);
            } else {
                throw new IOException("Invalid Input, must be 1, 2, or 3");
            }
            player.getWeapon().setLevel(weaponLevel);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private void levelUp() {
        while (player.levelUp()) {
            System.out.println("Level Up!");
            System.out.println("New level: " + player.getLevel());
            player.getWeapon().addLevel(1);
        }
    }
}
