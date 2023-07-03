package rpg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        
        CharacterDirector director = new CharacterDirector();
        CharacterBuilder playerBuilder = new PlayerBuilder();
        director.makeCharacter(playerBuilder);
        Character player = playerBuilder.getCharacter();
        System.out.println(player.getCurrentHealth());
        System.out.println(player.getLevel());
        System.out.println(player.getExperience());
        System.out.println(player.getWeapon().getName());
        System.out.println(player.getGold());
    }
    
    public static int getSelection() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int i = 0;
        try {
            i = Integer.parseInt(input);
        } catch(NumberFormatException e) {
            System.err.println("Invalid selection");
        }
        return i;
    }
}
