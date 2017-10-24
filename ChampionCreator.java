/*
 *  @author: Chris Lail
 *  @version: 1.0
 *
 *  This class handles instantiating all of the champions for use with LeagueCalculator.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ChampionCreator {
    private Map<String, Champion> validChampions = new HashMap<>();

    public ChampionCreator() {
        initializeValidChampions();
    }

    /*
     *  @args:      target - a string that holds a champions name entered by the user.
     *
     *  @return:    The champion that was requested or a null value if it doesn't exist.
     *
     *  If the champion name contained in the target variable is a valid champion then we return that champion back
     *  to the user. If it is not a valid champion name then we return null.
     */
    public Champion findChamp(String target) {
        target = target.toLowerCase();

        if (validChampions.containsKey(target))
            return validChampions.get(target);
        return null;
    }

    /*
     *  Starts the process for creating a valid map of champions from champions.txt.
     */
    private void initializeValidChampions() {
        final String champs = "champions.txt";

        FileReader fr = null;
        BufferedReader bufferedReader = null;
        try {
            fr = new FileReader(champs);
            bufferedReader = new BufferedReader(fr);

            readChampionsTxt(bufferedReader);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null)
                    bufferedReader.close();
                if (fr != null)
                    fr.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }

    /*
     * @args:   br - A BufferedReader used to read through the champions.txt file.
     *
     * Read through the champions.txt file adding champions to the validChampions map.
     */
    private void readChampionsTxt(BufferedReader br) {
        try {
            String currentLine = br.readLine();
            while (currentLine != null) {
                // If the line read contains "---" then we are trying to read a new champion.
                if (currentLine.equals("---")) {
                    // Read an extra time to discard the "---" and get to the next champion.
                    currentLine = br.readLine();
                }

                // Read the name from the file.
                String name = currentLine.replace("Name=", "");

                // Read a new line from the file and convert the number in the string to a double.
                currentLine = br.readLine();
                double baseHealth = Double.valueOf(currentLine.replace("BaseHealth=", ""));

                currentLine = br.readLine();
                double baseHealthRegen = Double.valueOf(currentLine.replace("BaseHealthRegen=", ""));

                currentLine = br.readLine();
                double baseMana = Double.valueOf(currentLine.replace("BaseMana=", ""));

                currentLine = br.readLine();
                double baseManaRegen = Double.valueOf(currentLine.replace("BaseManaRegen=", ""));

                currentLine = br.readLine();
                double baseAttackDamage = Double.valueOf(currentLine.replace("BaseAttackDamage=", ""));

                currentLine = br.readLine();
                double baseAttackSpeed = Double.valueOf(currentLine.replace("BaseAttackSpeed=", ""));

                currentLine = br.readLine();
                double baseArmor = Double.valueOf(currentLine.replace("BaseArmor=", ""));

                currentLine = br.readLine();
                double baseMagicResist = Double.valueOf(currentLine.replace("BaseMagicResist=", ""));

                currentLine = br.readLine();
                double healthGrowth = Double.valueOf(currentLine.replace("HealthGrowth=", ""));

                currentLine = br.readLine();
                double healthRegenGrowth = Double.valueOf(currentLine.replace("HealthRegenGrowth=", ""));

                currentLine = br.readLine();
                double manaGrowth = Double.valueOf(currentLine.replace("ManaGrowth=", ""));

                currentLine = br.readLine();
                double manaRegenGrowth = Double.valueOf(currentLine.replace("ManaRegenGrowth=", ""));

                currentLine = br.readLine();
                double attackDamageGrowth = Double.valueOf(currentLine.replace("AttackDamageGrowth=", ""));

                currentLine = br.readLine();
                double attackSpeedGrowth = Double.valueOf(currentLine.replace("AttackSpeedGrowth=", ""));

                currentLine = br.readLine();
                double armorGrowth = Double.valueOf(currentLine.replace("ArmorGrowth=", ""));

                currentLine = br.readLine();
                double magicResistGrowth = Double.valueOf(currentLine.replace("MagicResistGrowth=", ""));

                Champion champ = new Champion(name, 1, baseHealth, baseHealthRegen,
                        baseMana, baseManaRegen, baseAttackDamage, baseAttackSpeed, baseArmor,
                        baseMagicResist, healthGrowth, healthRegenGrowth, manaGrowth, manaRegenGrowth,
                        attackDamageGrowth, attackSpeedGrowth, armorGrowth, magicResistGrowth);

                // Add the newly created champion to the validChampions map.
                validChampions.put(champ.name.toLowerCase(), champ);

                // Read a new line to restart the loop.
                currentLine = br.readLine();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
