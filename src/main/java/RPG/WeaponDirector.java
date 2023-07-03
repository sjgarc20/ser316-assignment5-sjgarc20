package RPG;

public class WeaponDirector {
    /**
     * Directs the building of weapon type objects.
     * @param weaponBuilder weapon builder object
     */
    public void makeWeapon(WeaponBuilder weaponBuilder) {
        weaponBuilder.setDamageMultiplier();
        weaponBuilder.setSpeedMultiplier();
        weaponBuilder.setLevel();
        weaponBuilder.setBaseDamage();
        weaponBuilder.setBaseSpeed();
        weaponBuilder.setName();
    }
}
