/*
	@author: Chris Lail
	@version: 1.0

	This class holds all the stats of a champion and functions used to manipulate them
	with masteries, runes, levels, and other stats.
 */
public abstract class Champion
{
    protected String name;
    protected int level;
    protected double health;
    protected double healthRegen;
    protected double mana;
    protected double manaRegen;
    protected double attackDamage;
    protected double attackSpeed;
    protected double armor;
    protected double magicResist;
    protected boolean runes;
    public Champion(String name, double health,double healthRegen,double mana,
		    double manaRegen,double attackDamage, double attackSpeed,
		    double armor, double magicResist, int level)
    {
        this.name = name;
        this.level = level;
        this.health = health;
        this. healthRegen = healthRegen;
        this.mana = mana;
        this.manaRegen = manaRegen;
        this.attackDamage = attackDamage;
        this.attackSpeed = attackSpeed;
        this.armor = armor;
        this.magicResist = magicResist;
        runes = false;
    }

    /*
        @args:	target - The champion you are attacking.

        Calculates the damage per second you would do to your target.
     */
    public double dps(Champion target)
    {
		return attackDamage * target.armorReduction() * attackSpeed;
    }

    // An abstract levelUp method
    public abstract void levelUp();
    
    /*
	@args:		b - The base stat you are upgrading
			g - The growth stat you are upgrading
			n - The level of the champion

	@return:	A double containing the new value of the upgraded stat

	A formula used by Riot to calculate what a stat should be after a level up
     */
    public double levelUpStat(double b, double g, int n)
    {
        return b + ((g * (n - 1)) * (.685 + (.0175 * n)));
    }
    
    /*
        Calculates how much less damage you would take with the amount of armor you have
     */
    public double armorReduction()
    {
        return 100 / (armor + 100); 
    }

    /*
        Calculates how much less damage you would take with the amount of magice resist you have
     */
    public double magicReduction()
    {
        return 100 / (magicResist + 100);
    }

    /*
        Prints out all the champions current stats
     */
    public void printChampionStats()
    {
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
    public void addStandardADCRunes()
    {
        attackDamage += 8.5;
        attackSpeed += .135;
        magicResist += 12.1;
        armor += 9;
        runes = true;
    }

    /*
    	The stats added if you had Arrow's adc rune page
     */
    public void addArrowRunes()
    {
        attackDamage += 5.7;
        attackSpeed += .141;
        magicResist += 12.1;
        armor += 9;
        runes = true;
    }
}
