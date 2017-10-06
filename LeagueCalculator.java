/*
	@author: Chris Lail
	@version: 1.0

	This class facilitates the main menu of the calculator and it's helper functions.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class LeagueCalculator
{
	private final double NATURAL_TALENT_LIFESTEAL = .045;
	private final double STANDARD_LIFESTEAL = .05;
	private final double RUNIC_ARMOR_BONUS_HEALING = 1.08;
	private static final int EXIT_CALCULATOR = 10;

	private ArrayList<Double> naturalTalent;
	private ArrayList<Double> standard;
	private ArrayList<Champion> champs;
	private Scanner input;
	private int levelsToTest;
	
	public LeagueCalculator()
	{
		input = new Scanner(System.in);
		naturalTalent = new ArrayList<Double>();
		standard = new ArrayList<Double>();
		champs = new ArrayList<Champion>();
	}

	/*
		Prints out the amount of lifesteal from Level 1 to Level N taking into account
	 	the lifesteal you would have if you took natural talent instead of a standard
	 	adc mastery setup.
	 */
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

	/*
		Prints out the amount of lifesteal from Level 1 to Level N taking into account
	 	the lifesteal you would have if you took a standard adc mastery setup.
	 */
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

	/*
	 	Takes input from the user asking them to plug in the damage done from Level 1 to Level N.
	 */
	public void initNaturalTalentDamage()
	{
		for (int i = 0; i < levelsToTest; i++)
		{
			System.out.print("Enter natural talent damage for level " + (i + 1) + ": ");
			naturalTalent.add(input.nextDouble());
			System.out.println();
		}
	}

	/*
	 	Takes input from the user asking them to plug in the damage done from Level 1 to Level N.
	 */
	public void initStandardDamage()
	{
		for (int i = 0; i < levelsToTest; i++)
		{
			System.out.print("Enter standard damage for level " + (i + 1) + ": ");
			standard.add(input.nextDouble());
			System.out.println();
		}
	}
	
	
	// TODO: ERROR WON'T PRINT PRECISION. DOESN'T WORK PROPERLY
	/*
		Prints out whether the natural talent build had more lifesteal or the standard build had more
		lifesteal. It also prints the difference of lifesteal between the two builds for each level
		the user wanted to test.
	 */
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

	/*
		Prints all the champions currently stored in the champs array.
		If there are no champs then it prints a simple message.
	 */
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

	/*
		Prints all the champion stats from the champions stored in the champs array.
		If there are no champs then it prints a simple message.
	 */
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

	/*
		Prints the menu options for the user.
	 */
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
		LeagueCalculator calc = new LeagueCalculator();
		ChampionCreator cc = new ChampionCreator();
		int choice = 0; //Set to 0 just to get into the while loop the first time
		
		int champIndex1;
		int champIndex2;
		Champion firstChamp;
		Champion secondChamp;
		String champName;
		
		while(choice != EXIT_CALCULATOR)
		{
			calc.printMenu();
			choice = calc.input.nextInt();
			System.out.println();
			switch(choice)
			{
				// Selected: Compare Lifesteal Between Natural Build (Korean) and Standard Build
				case 1:
					System.out.print("How many levels would you like to test? ");
					calc.levelsToTest = calc.input.nextInt();
					System.out.println();
					calc.initNaturalTalentDamage();
					calc.initStandardDamage();
					calc.printNaturalTalentLifesteal();
					calc.printStandardLifeSteal();
					break;

				// Selected: Calculate DPS of One Champion On Another
				case 2:
					System.out.print("Enter the index of the champion that is attacking: ");
					champIndex1 = calc.input.nextInt();
					firstChamp = calc.champs.get(champIndex1);
					System.out.print("Enter the index of the champion that is taking damage: ");
					champIndex2 = calc.input.nextInt();
					secondChamp = calc.champs.get(champIndex2);
					System.out.printf("\n%s (%d) would have %f DPS against %s (%d)\n", firstChamp.name, champIndex1, firstChamp.dps(secondChamp),
						secondChamp.name, champIndex2);
					break;

				// Selected: Add New Champion
				case 3:
					System.out.print("Enter the name of a champion: ");
					champName = calc.input.next();
					System.out.println();
					firstChamp = cc.findChamp(champName);
					if (firstChamp == null)
						System.out.println("That is not a valid champion.");
					else
					{
						calc.champs.add(firstChamp);
					}
					break;

				// Selected: Delete a Champion By Index
				case 4:
					System.out.print("Enter the index of a champion that you would like to delete: ");
					champIndex1 = calc.input.nextInt();
					calc.champs.remove(champIndex1);
					break;

				// Selected: Print List of Current Champions
				case 5:
					calc.printAllChampions();
					break;

				// Selected: Add Runes To a Champion By Index
				case 6:
					System.out.print("Enter the index of a champion: ");
					champIndex1 = calc.input.nextInt();
					System.out.println("Which Runes Would You Like To Add?");
					System.out.println("1.   Standard");
					System.out.println("2.   Arrow");
					champIndex2 = calc.input.nextInt(); //Not a champion, but a rune selection number
					if (champIndex2 == 1)
						calc.champs.get(champIndex1).addStandardADCRunes();
					else
						calc.champs.get(champIndex1).addArrowRunes();
					break;

				// Selected: Level Up a Champion By Index
				case 7:
					System.out.print("Enter the index of a champion: ");
					champIndex1 = calc.input.nextInt();
					calc.champs.get(champIndex1).levelUp();
					break;

				// Selected: Print Champion Stats By Index
				case 8:
					System.out.print("Enter the index of a champion: ");
					champIndex1 = calc.input.nextInt();
					calc.champs.get(champIndex1).printChampionStats();
					break;

				// Selected: Print All Champions Stats
				case 9:
					calc.printAllChampStats();
					break;

				// Selected: Exit The Menu
				case EXIT_CALCULATOR:
					System.out.println("Goodbye.");
					break;

				// Selected: An invalid option for the calculator
				default:
					System.out.println("Sorry, that is an invalid choice. Please try again");
			}
		}
	}
}
