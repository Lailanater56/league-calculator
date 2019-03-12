/*
 *	@author: Chris Lail
 *	@version: 1.0
 *
 *	This class facilitates the main menu of the calculator and it's helper functions.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class LeagueCalculator {
    private static final int EXIT_CALCULATOR = 10;
    private final double NATURAL_TALENT_LIFESTEAL = .045;
    private final double STANDARD_LIFESTEAL = .05;
    private final double RUNIC_ARMOR_BONUS_HEALING = 1.08;
    private ArrayList<Double> naturalTalent;
    private ArrayList<Double> standard;
    private ArrayList<Champion> champs;
    private Scanner input;
    private int levelsToTest;

    public LeagueCalculator() {
        input = new Scanner(System.in);
        naturalTalent = new ArrayList<Double>();
        standard = new ArrayList<Double>();
        champs = new ArrayList<Champion>();
    }

    public static void main(String[] args) {
        LeagueCalculator calc = new LeagueCalculator();
        ChampionCreator cc = new ChampionCreator();
        int choice = 0; //Set to 0 just to get into the while loop the first time.

        int champIndex1;
        int champIndex2;
        Champion firstChamp;
        Champion secondChamp;
        String champName;

        while (choice != EXIT_CALCULATOR) {
            calc.printMenu();
            choice = calc.input.nextInt();
            System.out.println();
            switch (choice) {
                // Selected: Compare Lifesteal Between Natural Build (Korean) and Standard Build.
                case 1:
                    System.out.print("How many levels would you like to test? ");
                    calc.levelsToTest = calc.input.nextInt();
                    System.out.println();
                    calc.initNaturalTalentDamage();
                    calc.initStandardDamage();
                    calc.printNaturalTalentLifesteal();
                    calc.printStandardLifeSteal();
                    break;

                // Selected: Calculate DPS of One Champion On Another.
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

                // Selected: Add New Champion.
                case 3:
                    System.out.print("Enter the name of a champion: ");
                    champName = calc.input.next();
                    System.out.println();
                    firstChamp = cc.findChamp(champName);
                    if (firstChamp == null)
                        System.out.println("That is not a valid champion.");
                    else {
                        calc.champs.add(firstChamp);
                    }
                    break;

                // Selected: Delete a Champion By Index.
                case 4:
                    System.out.print("Enter the index of a champion that you would like to delete: ");
                    champIndex1 = calc.input.nextInt();
                    calc.champs.remove(champIndex1);
                    break;

                // Selected: Print List of Current Champions.
                case 5:
                    calc.printAllChampions();
                    break;

                // Selected: Add Runes To a Champion By Index.
                case 6:
                    System.out.print("Enter the index of a champion: ");
                    champIndex1 = calc.input.nextInt();
                    System.out.println("Which Runes Would You Like To Add?");
                    System.out.println("1.   Standard");
                    System.out.println("2.   Arrow");
                    champIndex2 = calc.input.nextInt(); //Not a champion, but a rune selection number.
                    if (champIndex2 == 1)
                        calc.champs.get(champIndex1).addStandardADCRunes();
                    else
                        calc.champs.get(champIndex1).addArrowRunes();
                    break;

                // Selected: Level Up a Champion By Index.
                case 7:
                    System.out.print("Enter the index of a champion: ");
                    champIndex1 = calc.input.nextInt();
                    calc.champs.get(champIndex1).levelUp();
                    break;

                // Selected: Print Champion Stats By Index.
                case 8:
                    System.out.print("Enter the index of a champion: ");
                    champIndex1 = calc.input.nextInt();
                    calc.champs.get(champIndex1).printChampionStats();
                    break;

                // Selected: Print All Champions Stats.
                case 9:
                    calc.printAllChampStats();
                    break;

                // Selected: Exit The Menu.
                case EXIT_CALCULATOR:
                    System.out.println("Goodbye.");
                    break;

                // Selected: An invalid option for the calculator.
                default:
                    System.out.println("Sorry, that is an invalid choice. Please try again");
            }
        }
    }
}