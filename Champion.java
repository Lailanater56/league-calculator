/*
	@author: Chris Lail
	@version: 1.0

	This class holds all the stats of a champion and functions used to manipulate them
	with masteries, runes, levels, and other stats.
 */
public class Champion {
    protected String name;
    protected int level;

    private static double baseHealth;
    private static double baseHealthRegen;
    private static double baseMana;
    private static double baseManaRegen;
    private static double baseAttackDamage;
    private static double baseAttackSpeed;
    private static double baseArmor;
    private static double baseMagicResist;

    protected double healthGrowth;
    protected double healthRegenGrowth;
    protected double manaGrowth;
    protected double manaRegenGrowth;
    protected double attackDamageGrowth;
    protected double attackSpeedGrowth;
    protected double armorGrowth;
    protected double magicResistGrowth;

    protected double health;
    protected double healthRegen;
    protected double mana;
    protected double manaRegen;
    protected double attackDamage;
    protected double attackSpeed;
    protected double armor;
    protected double magicResist;

    protected boolean runes;

    public Champion(String name, int level, double baseHealth, double baseHealthRegen,
                    double baseMana, double baseManaRegen, double baseAttackDamage,
                    double baseAttackSpeed, double baseArmor, double baseMagicResist,
                    double healthGrowth, double healthRegenGrowth, double manaGrowth,
                    double manaRegenGrowth, double attackDamageGrowth, double attackSpeedGrowth,
                    double armorGrowth, double magicResistGrowth) {
        this.name = name;
        this.level = level;
        this.baseHealth = baseHealth;
        this.baseHealthRegen = baseHealthRegen;
        this.baseMana = baseMana;
        this.baseManaRegen = baseManaRegen;
        this.baseAttackDamage = baseAttackDamage;
        this.baseAttackSpeed = baseAttackSpeed;
        this.baseArmor = baseArmor;
        this.baseMagicResist = baseMagicResist;
        this.healthGrowth = healthGrowth;
        this.healthRegenGrowth = healthRegenGrowth;
        this.manaGrowth = manaGrowth;
        this.manaRegenGrowth = manaRegenGrowth;
        this.attackDamageGrowth = attackDamageGrowth;
        this.attackSpeedGrowth = attackSpeedGrowth;
        this.armorGrowth = armorGrowth;
        this.magicResistGrowth = magicResistGrowth;

        this.health = baseHealth;
        this.healthRegen = baseHealthRegen;
        this.mana = baseMana;
        this.manaRegen = baseManaRegen;
        this.attackDamage = baseAttackDamage;
        this.attackSpeed = baseAttackSpeed;
        this.armor = baseArmor;
        this.magicResist = baseMagicResist;

        runes = false;
    }

    /*
        @args:	target - The champion you are attacking.

        Calculates the damage per second you would do to your target.
     */
    public double dps(Champion target) {
        return attackDamage * target.armorReduction() * attackSpeed;
    }

    /*
        Calculates and sets the new stats for this champion after leveling up
     */
    public void levelUp() {
        // If the champion's level is less than 18 then it is a valid level up
        if (level < 18) {
            // Update champion level
            level += 1;
        }

        health = levelUpStat(baseHealth, healthGrowth);
        healthRegen = levelUpStat(baseHealthRegen, healthRegenGrowth);
        mana = levelUpStat(baseMana, manaGrowth);
        manaRegen = levelUpStat(baseManaRegen, manaRegenGrowth);
        attackDamage = levelUpStat(baseAttackDamage, attackDamageGrowth);
        attackSpeed = levelUpStat(baseAttackSpeed, attackSpeedGrowth);
        armor = levelUpStat(baseArmor, armorGrowth);
        magicResist = levelUpStat(baseMagicResist, magicResistGrowth);
    }

    /*
    @args:		b - The base stat you are upgrading
			    g - The growth stat you are upgrading

	@return:	A double containing the new value of the upgraded stat

	A formula used by Riot to calculate what a stat should be after a level up
     */
    public double levelUpStat(double b, double g) {
        return b + ((g * (level - 1)) * (.685 + (.0175 * level)));
    }

    /*
        Calculates how much less damage you would take with the amount of armor you have
     */
    public double armorReduction() {
        return 100 / (armor + 100);
    }

    /*
        Calculates how much less damage you would take with the amount of magice resist you have
     */
    public double magicReduction() {
        return 100 / (magicResist + 100);
    }

    /*
        Prints out all the champions current stats
     */
    public void printChampionStats() {
        System.out.println("Name: " + name);
        System.out.println("Level: " + level);
        System.out.println("Health: " + health);
        System.out.println("Health Regen: " + healthRegen);
        System.out.println("Mana: " + mana);
        System.out.println("Mana Regen: " + manaRegen);
        System.out.println("Attack Damage: " + attackDamage);
        System.out.println("Attack Speed: " + attackSpeed);
        System.out.println("Armor: " + armor);
        System.out.println("Magic Resist: " + magicResist);
    }

    // TODO: THE RUNE METHODS BELOW NEED TO BE MOVED TO THEIR OWN CLASS

    /*
        The stats added if you had a standard adc rune page
     */
    public void addStandardADCRunes() {
        attackDamage += 8.5;
        attackSpeed += .135;
        magicResist += 12.1;
        armor += 9;
        runes = true;
    }

    /*
        The stats added if you had Arrow's adc rune page
     */
    public void addArrowRunes() {
        attackDamage += 5.7;
        attackSpeed += .141;
        magicResist += 12.1;
        armor += 9;
        runes = true;
    }
}
