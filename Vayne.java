// TODO: THIS CLASS SHOULD BE DELETED AND JUST PUT INTO A SIMPLE CHAMPION MAP


/*
    @author: Chris Lail
	@version: 1.0

	Contains all of the relevant stats for the champion Vayne.
 */
public class Vayne extends Champion {
    private static final String NAME = "Vayne";
    private static final double BASE_HEALTH = 498.44;
    private static final double BASE_HEALTH_REGEN = 5.42;
    private static final double BASE_MANA = 231.8;
    private static final double BASE_MANA_REGEN = 6.97;
    private static final double BASE_ATTACK_DAMAGE = 55.88;
    private static final double BASE_ATTACK_SPEED = 0.658;
    private static final double BASE_ARMOR = 19.012;
    private static final double BASE_MAGIC_RESIST = 30;

    protected final double HEALTH_GROWTH = 80;
    protected final double HEALTH_REGEN_GROWTH = .65;
    protected final double MANA_GROWTH = 38;
    protected final double MANA_REGEN_GROWTH = .7;
    protected final double ATTACK_DAMAGE_GROWTH = 2.41;
    protected final double ATTACK_SPEED_GROWTH = .033;
    protected final double ARMOR_GROWTH = 3;
    protected final double MAGIC_RESIST_GROWTH = 0;

    public Vayne() {
        super(NAME, BASE_HEALTH, BASE_HEALTH_REGEN, BASE_MANA, BASE_MANA_REGEN,
                BASE_ATTACK_DAMAGE, BASE_ATTACK_SPEED, BASE_ARMOR,
                BASE_MAGIC_RESIST, 1);
    }

    /*
        Calculates and sets the new stats for this champion after leveling up
    */
    public void levelUp() {
        // If the champion's level is less than 18 then it is a valid level up
        if (super.level < 18) {
            // Update champion level
            super.level += 1;
        }

        // Save the new level as a new variable to save calls to super
        int newLevel = super.level;

        health = levelUpStat(BASE_HEALTH, HEALTH_GROWTH, newLevel);
        healthRegen = levelUpStat(BASE_HEALTH_REGEN, HEALTH_REGEN_GROWTH, newLevel);
        mana = levelUpStat(BASE_MANA, MANA_GROWTH, newLevel);
        manaRegen = levelUpStat(BASE_MANA_REGEN, MANA_REGEN_GROWTH, newLevel);
        attackDamage = levelUpStat(BASE_ATTACK_DAMAGE, ATTACK_DAMAGE_GROWTH, newLevel);
        attackSpeed = levelUpStat(BASE_ATTACK_SPEED, ATTACK_SPEED_GROWTH, newLevel);
        armor = levelUpStat(BASE_ARMOR, ARMOR_GROWTH, newLevel);
        magicResist = levelUpStat(BASE_MAGIC_RESIST, MAGIC_RESIST_GROWTH, newLevel);
    }
}
