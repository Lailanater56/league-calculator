import java.util.ArrayList;
import java.util.Scanner;

public class LeagueCalculator
{
	private ArrayList<Double> naturalTalent;
	private ArrayList<Double> standard;
	private ArrayList<Champion> champs;
	private Scanner input;
	private int levelsToTest;
	private final double NATURAL_TALENT_LIFESTEAL = .045;
	private final double STANDARD_LIFESTEAL = .05;
	private final double RUNIC_ARMOR_BONUS_HEALING = 1.08;
	private static final int EXIT_CALCULATOR = 10;
	
	public LeagueCalculator()
	{
		input = new Scanner(System.in);
		naturalTalent = new ArrayList<Double>();
		standard = new ArrayList<Double>();
		champs = new ArrayList<Champion>();
	}
	
	public void printNaturalTalentLifesteal()
	{
		double damage;
		System.out.println("**********************Natural Talent Lifesteal********************\n");
		for (int i = 0; i < levelsToTest; i++)
		{
			damage = naturalTalent.get(i);
			damage = (damage * NATURAL_TALENT_LIFESTEAL) * RUNIC_ARMOR_BONUS_HEALING;
			System.out.println("Lifesteal for level " + (i + 1) + ": " + damage);
		}
		System.out.println();
	}
	
	public void printStandardLifeSteal()
	{
		double damage;
		System.out.println("**********************Standard Lifesteal**************************\n");
		for (int i = 0; i < levelsToTest; i++)
		{
			damage = standard.get(i);
			damage = damage * STANDARD_LIFESTEAL;
			System.out.println("Lifesteal for level " + (i + 1) + ": " + damage);
		}
		System.out.println();
	}
	
	public void initNaturalTalentDamage()
	{
		for (int i = 0; i < levelsToTest; i++)
		{
			System.out.print("Enter natural talent damage for level " + (i + 1) + ": ");
			naturalTalent.add(input.nextDouble());
			System.out.println();
		}
	}
	
	public void initStandardDamage()
	{
		for (int i = 0; i < levelsToTest; i++)
		{
			System.out.print("Enter standard damage for level " + (i + 1) + ": ");
			standard.add(input.nextDouble());
			System.out.println();
		}
	}
	
	
	// ERROR WON'T PRINT PRECISION. DOESN'T WORK
	public void compareLifesteal()
	{                                                                                                    
		System.out.println("\n**********************Comparing Both Lifesteal**************************\n");
		double naturalTalentLifesteal;
		double standardLifesteal;
		double comparedLifesteal;
		for (int i = 0; i < levelsToTest; i++)
		{
			naturalTalentLifesteal = naturalTalent.get(i);
			standardLifesteal = standard.get(i);
			comparedLifesteal = naturalTalentLifesteal - standardLifesteal;
			if (comparedLifesteal > 0)
			{
				System.out.printf("Natural Talent healed more at level " + (i + 1) + " by %.5f", comparedLifesteal);
			}
			else if (comparedLifesteal < 0)
			{
				System.out.println("Standard healed more at level " + (i + 1) + " by " + Math.abs(comparedLifesteal));
			}
			else
			{
				System.out.println("They both healed the same at level " + (i + 1));
			}
		}
	}
	
	public void printAllChampions()
	{
		if (champs.size() == 0)
			System.out.println("There are currently no champions to print");
		else
		{
			for (int i = 0; i < champs.size(); i++)
			{
				System.out.printf("%d | %s\n", i, champs.get(i).name);
			}
		}
	}
	
		public void printAllChampStats()
	{
		if (champs.size() == 0)
			System.out.println("There are currently no champions to print");
		else
		{
			for (int i = 0; i < champs.size(); i++)
			{
				champs.get(i).printChampionStats();
				System.out.println();
			}
		}
	}
	
	public void printMenu()
	{																			   
		System.out.println("_____________________________________________________");
		System.out.println("|                                                   |");
		System.out.println("|     Welcome to Papa Johnz League Calculator       |");
		System.out.println("|___________________________________________________|");
		System.out.println("|                                                   |");
		System.out.println("|   1.  Compare Lifesteal Between Natural Talent    |");
		System.out.println("|           Build (Korean) and Standard Build       |");
		System.out.println("|   2.  Calculate DPS of One Champion On Another    |");
		System.out.println("|   3.  Add New Champion                            |");
		System.out.println("|   4.  Delete a Champion By Index                  |");
		System.out.println("|   5.  Print List of Current Champions             |");
		System.out.println("|   6.  Add Runes To a Champion By Index            |");
		System.out.println("|   7.  Level Up a Champion By Index                |");
		System.out.println("|   8.  Print Champion Stats By Index               |");
		System.out.println("|   9.  Print All Champions Stats                   |");
		System.out.println("|   10. Exit The Menu                               |");
		System.out.println("|___________________________________________________|");
		System.out.println();
		System.out.print("Please select a menu option: ");
	}
	
	public static void main(String[] args)
	{
		LeagueCalculator test = new LeagueCalculator();
		ChampionCreator cc = new ChampionCreator();
		int choice = 1; //Set to one just to get into the while loop the first time
		
		int champIndex1;
		int champIndex2;
		Champion firstChamp;
		Champion secondChamp;
		String champName;
		
		while(choice != EXIT_CALCULATOR)
		{
			test.printMenu();
			choice = test.input.nextInt();
			System.out.println();
			switch(choice)
			{
				case 1:
					System.out.print("How many levels would you like to test? ");
					test.levelsToTest = test.input.nextInt();
					System.out.println();
					test.initNaturalTalentDamage();
					test.initStandardDamage();
					test.printNaturalTalentLifesteal();
					test.printStandardLifeSteal();
					break;
				
				case 2:
					System.out.print("Enter the index of the champion that is attacking: ");
					champIndex1 = test.input.nextInt();
					firstChamp = test.champs.get(champIndex1);
					System.out.print("Enter the index of the champion that is taking damage: ");
					champIndex2 = test.input.nextInt();
					secondChamp = test.champs.get(champIndex2);
					System.out.printf("\n%s (%d) would have %f DPS against %s (%d)\n", firstChamp.name, champIndex1, firstChamp.dps(secondChamp),
						secondChamp.name, champIndex2);
					break;
						
				case 3:
					System.out.print("Enter the name of a champion: ");
					champName = test.input.next();
					System.out.println();
					firstChamp = cc.findChamp(champName);
					if (firstChamp == null)
						System.out.println("That is not a valid champion.");
					else
					{
						test.champs.add(firstChamp);
					}
					break;
					
				case 4:
					System.out.print("Enter the index of a champion that you would like to delete: ");
					champIndex1 = test.input.nextInt();
					test.champs.remove(champIndex1);
					break;
					
				case 5:
					test.printAllChampions();
					break;
					
				case 6:
					System.out.print("Enter the index of a champion: ");
					champIndex1 = test.input.nextInt();
					System.out.println("Which Runes Would You Like To Add?");
					System.out.println("1.   Standard");
					System.out.println("2.   Arrow");
					champIndex2 = test.input.nextInt(); //Not a champion, but a rune selection number
					if (champIndex2 == 1)
						test.champs.get(champIndex1).addStandardADCRunes();
					else
						test.champs.get(champIndex1).addArrowRunes();
					break;
					
				case 7:
					System.out.print("Enter the index of a champion: ");
					champIndex1 = test.input.nextInt();
					test.champs.get(champIndex1).levelUp();
					break;
					
				case 8:
					System.out.print("Enter the index of a champion: ");
					champIndex1 = test.input.nextInt();
					test.champs.get(champIndex1).printChampionStats();
					break;
					
				case 9:
					test.printAllChampStats();
					break;
					
				case EXIT_CALCULATOR:
					System.out.println("Goodbye.");
					break;
					
				default:
					System.out.println("Sorry, that is an invalid choice. Please try again");
			}
		}
	}
}