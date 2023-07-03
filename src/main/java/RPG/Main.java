package rpg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /**
     * Starting point of application.
     * @param args program arguments
     */
    public static void main(String[] args) {
        
        Logic logic = Logic.getInstance();
        logic.init();
//        CharacterDirector director = new CharacterDirector();
//        CharacterBuilder playerBuilder = new PlayerBuilder();
//        director.makeCharacter(playerBuilder);
//        Character player = playerBuilder.getCharacter();
//        System.out.println(player.getCurrentHealth());
//        System.out.println(player.getLevel());
//        System.out.println(player.getExperience());
//        System.out.println(player.getWeapon().getName());
//        System.out.println(player.getGold());
    }
    
}
