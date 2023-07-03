package rpg;

public class WeaponDirector {
    public void makeWeapon(WeaponBuilder weaponBuilder) {
        weaponBuilder.setDamageMultiplier();
        weaponBuilder.setSpeedMultiplier();
        weaponBuilder.setLevel();
        weaponBuilder.setBaseDamage();
        weaponBuilder.setBaseSpeed();
        weaponBuilder.setName();
    }
}
