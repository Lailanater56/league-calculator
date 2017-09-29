public class ChampionCreator
{
    private String[] validChampionNames;

    public ChampionCreator()
    {
        validChampionNames = new String[] {"lucian, vayne"};
    }

    public Champion findChamp(String target)
    {
        String name = target.toLowerCase();
        switch(name)
        {
            case "lucian":
                return new Lucian();
            case "vayne":
                return new Vayne();
            default:
                return null;
        }
    }
}
