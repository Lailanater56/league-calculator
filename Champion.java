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
					    double armor, double magicResist)
	{
        this.name = name;
        level = 1;
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
	
	public double dps(Champion target)
	{
		return attackDamage * target.armorReduction() * attackSpeed;
	}
	
	public abstract void levelUp();
	
	public double levelUpStat(double b, double g, int n)
	{
		return b + ((g * (n - 1)) * (.685 + (.0175 * n)));
	}
	
	public double armorReduction()
	{
		return 100 / (armor + 100); 
	}
	
	public double magicReduction()
	{
		return 100 / (magicResist + 100);
	}
	
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

    public void addStandardADCRunes()
    {
        attackDamage += 8.5;
        attackSpeed += .135;
        magicResist += 12.1;
        armor += 9;
        runes = true;
    }
    
    public void addArrowRunes()
    {
        attackDamage += 5.7;
        attackSpeed += .141;
        magicResist += 12.1;
        armor += 9;
        runes = true;
    }
}
