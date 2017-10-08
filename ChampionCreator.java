/*
    @author: Chris Lail
    @version: 1.0

    This class handles instantiating all of the champions for use with LeagueCalculator
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
        @args:  target - a string that holds a champions name entered by the user.
                        If the champion name is valid then we create a new champion
                        from their respective templates.
     */
    public Champion findChamp(String target) {
        target = target.toLowerCase();

        if (validChampions.containsKey(target))
            return validChampions.get(target);
        return null;
    }

    // TODO: Won't parse the strings in champions.txt correctly causes ArrayIndexOutOfBoundsException
    private void initializeValidChampions() {
        final String champs = "champions.txt";

        FileReader fr = null;
        BufferedReader bufferedReader = null;
        try {
            fr = new FileReader(champs);
            bufferedReader = new BufferedReader(fr);

            String currentLine;
            String[] line;

            while ((currentLine = bufferedReader.readLine()) != null) {
                if (currentLine.equals(" "))
                    currentLine = bufferedReader.readLine();
                String name = currentLine;

                line = bufferedReader.readLine().split("=");
                double baseHealth = Double.valueOf(line[1]);

                line = bufferedReader.readLine().split("=");
                double baseHealthRegen = Double.valueOf(line[1]);

                line = bufferedReader.readLine().split("=");
                double baseMana = Double.valueOf(line[1]);

                line = bufferedReader.readLine().split("=");
                double baseManaRegen = Double.valueOf(line[1]);

                line = bufferedReader.readLine().split("=");
                double baseAttackDamage = Double.valueOf(line[1]);

                line = bufferedReader.readLine().split("=");
                double baseAttackSpeed = Double.valueOf(line[1]);

                line = bufferedReader.readLine().split("=");
                double baseArmor = Double.valueOf(line[1]);

                line = bufferedReader.readLine().split("=");
                double baseMagicResist = Double.valueOf(line[1]);

                line = bufferedReader.readLine().split("=");
                double healthGrowth = Double.valueOf(line[1]);

                line = bufferedReader.readLine().split("=");
                double healthRegenGrowth = Double.valueOf(line[1]);

                line = bufferedReader.readLine().split("=");
                double manaGrowth = Double.valueOf(line[1]);

                line = bufferedReader.readLine().split("=");
                double manaRegenGrowth = Double.valueOf(line[1]);

                line = bufferedReader.readLine().split("=");
                double attackDamageGrowth = Double.valueOf(line[1]);

                line = bufferedReader.readLine().split("=");
                double attackSpeedGrowth = Double.valueOf(line[1]);

                line = bufferedReader.readLine().split("=");
                double armorGrowth = Double.valueOf(line[1]);

                line = bufferedReader.readLine().split("=");
                double magicResistGrowth = Double.valueOf(line[1]);

                Champion champ = new Champion(name, 1, baseHealth, baseHealthRegen,
                        baseMana, baseManaRegen, baseAttackDamage, baseAttackSpeed, baseArmor,
                        baseMagicResist, healthGrowth, healthRegenGrowth, manaGrowth, manaRegenGrowth,
                        attackDamageGrowth, attackSpeedGrowth, armorGrowth, magicResistGrowth);

                validChampions.put(name.toLowerCase(), champ);
            }
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
}
