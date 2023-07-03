package rpg;

import java.io.IOException;

public class PlayerBuilder extends CharacterBuilder {

    private Character player = new Character();
    
    @Override
    protected void setMaxHealth() {
        player.setMaxHealth(10);
        player.setCurrentHealth(10);
    }

    @Override
    protected void setLevel() {
        player.setLevel(0);
        player.setExperience(0);
    }

    @Override
    protected void setWeapon() {
        System.out.println("It's time to pick your starting weapon. "
                + "You'll be able to change this later, but for a cost.");
        System.out.println("1: Sword, does heavy damage, albeit not very fast");
        System.out.println("2: Dagger, great for a fast attacking style, "
                + "but the damage is not very high");
        System.out.println("3: Spear, a balance between attacking power and speed");
        System.out.println("Please input the number of the weapon you would like to choose.");
        
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
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    protected void setSpecialTraits() {
        player.setGold(0);
    }

    @Override
    protected Character getCharacter() {
        return player;
    }

}
