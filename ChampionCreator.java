/*
    @author: Chris Lail
    @version: 1.0

    This class handles instantiating all of the champions for use with LeagueCalculator
 */

public class ChampionCreator {
    private String[] validChampionNames;

    public ChampionCreator() {
        validChampionNames = new String[]{"lucian, vayne"};
    }

    /*
        @args:  target - a string that holds a champions name entered by the user.
                        If the champion name is valid then we create a new champion
                        from their respective templates.
     */
    public Champion findChamp(String target) {
        String name = target.toLowerCase();
        switch (name) {
            case "lucian":
                return new Lucian();
            case "vayne":
                return new Vayne();
            default:
                return null;
        }
    }
}
