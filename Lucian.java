public class Lucian extends Champion
{
    private static final String NAME = "Lucian";
    private static final double BASE_HEALTH = 554.4;
    private static final double BASE_HEALTH_REGEN = 6.19;
    private static final double BASE_MANA = 348.88;
    private static final double BASE_MANA_REGEN = 8.175;
    private static final double BASE_ATTACK_DAMAGE = 57.46;
    private static final double BASE_ATTACK_SPEED = 0.638;
    private static final double BASE_ARMOR = 24.04;
    private static final double BASE_MAGIC_RESIST = 30;
	
	protected final double HEALTH_GROWTH = 80;
	protected final double HEALTH_REGEN_GROWTH = .65;
	protected final double MANA_GROWTH = 38;
	protected final double MANA_REGEN_GROWTH = .7;
	protected final double ATTACK_DAMAGE_GROWTH = 2.41;
	protected final double ATTACK_SPEED_GROWTH = .033;
	protected final double ARMOR_GROWTH = 3;
	protected final double MAGIC_RESIST_GROWTH = 0;
    
    public Lucian()
    {
        super(NAME, BASE_HEALTH, BASE_HEALTH_REGEN, BASE_MANA, BASE_MANA_REGEN,
                BASE_ATTACK_DAMAGE, BASE_ATTACK_SPEED, BASE_ARMOR, 
                BASE_MAGIC_RESIST);
    }
	
	public void levelUp()
	{
		level = 1;
		health = levelUpStat(BASE_HEALTH, HEALTH_GROWTH, level);
		healthRegen = levelUpStat(BASE_HEALTH_REGEN, HEALTH_REGEN_GROWTH, level);
		mana = levelUpStat(BASE_MANA, MANA_GROWTH, level);
		manaRegen = levelUpStat(BASE_MANA_REGEN, MANA_REGEN_GROWTH, level);
		attackDamage = levelUpStat(BASE_ATTACK_DAMAGE, ATTACK_DAMAGE_GROWTH, level);
		attackSpeed = levelUpStat(BASE_ATTACK_SPEED, ATTACK_SPEED_GROWTH, level);
		armor = levelUpStat(BASE_ARMOR, ARMOR_GROWTH, level);
		magicResist = levelUpStat(BASE_MAGIC_RESIST, MAGIC_RESIST_GROWTH, level);
	}
}
