package rpg;

/**
 * Part of the Builder design pattern. 
 * Directs the creation of player and non-player characters
 * See also : CharacterBuilder, Character, PlayerBuilder, EnemyBuilder, BanditBuilder, 
 * MonsterBuilder, and UndeadBuilder
 * @author Sam
 *
 */
public class CharacterDirector {
    /**
     * Directs the building of all characters, players and npc's.
     * @param characterBuilder character builder object
     */
    public void makeCharacter(CharacterBuilder characterBuilder) {
        characterBuilder.setMaxHealth();
        characterBuilder.setLevel();
        characterBuilder.setWeapon();
        characterBuilder.setSpecialTraits();
    }
}
