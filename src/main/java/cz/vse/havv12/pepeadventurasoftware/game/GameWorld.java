package cz.vse.havv12.pepeadventurasoftware.game;

import java.util.HashSet;
import java.util.Set;

import Item.Bush;
import Item.Item;
import Item.Jojo;
import Item.PepehoSwitch;
import Item.Table;
import command.CommandBuy;
import command.CommandCombine;
import command.CommandHelp;
import command.CommandInventoryInfo;
import command.CommandLookAround;
import command.CommandMove;
import command.CommandPick;
import command.CommandSearch;
import command.CommandTalk;
import command.CommandTerminate;
import command.CommandUse;
import command.ICommand;
import npc.Grandma;
import npc.Mum;
import npc.ShopKeeper;

/**
 * Třída představující mapu lokací herního světa. V datovém atributu
 * {@link #currentLocation} uchovává odkaz na aktuální lokaci, ve které
 * se hráč právě nachází. Z aktuální lokace je možné se prostřednictvím
 * jejích sousedů dostat ke všem přístupným lokacím ve hře.
 * <p>
 * Veškeré informace o stavu hry <i>(mapa prostorů, popis lokací, Pepe)</i> jsou uložené zde v podobě datových atributů.
 *
 * @author Jan Říha, Václav Havlík
 * @version ZS-2022, 2022-01-09
 */
public class GameWorld
{
    private Location currentLocation;
    public Player Pepe;
    private boolean gameOver;

    private Set<ICommand> commands;
    
    /**
     * Konstruktor třídy, vytvoří jednotlivé lokace, propojí je pomocí východů, vloží do nich předměty, postavy a hráče vloží na startovací lokaci.
     */
    public GameWorld()
    {
        Pepe = new Player();
        
        Location pepeRoom = new Location("Pokoj", "Toto je Pepeho pokoj,ve kterém spí,hraje hry a dělá beaty.");
        Location livingRoom = new Location("Obývák", "Toto je obývák, zde můžeš potkat Pepeho mámu.");
        Location routeToTrain = new Location("Cesta_na_vlak", "Toto je cesta na vlak, není ničím exrta zajímavá, ale čaká tu na tebe babička.");
        Location shop = new Location("Trafika", "Vešel jsi do trafiky, můžeš zde nakoupit spoustu užitečných předmětů a lístek na vlak.");
        Location park = new Location ("Park", "Tohle je park, příroda tě moc nezajímá, ale pokud se porozhlédneš můžeš najít něco užitečného.");
        Location trainStationBor = new Location ("Vlakové_nádraží_v_Boru" , "Super došel jsi na vlakáč, můžeš nastoupit do vlaku, ale pozor, abys měl lístek.");
        Location train = new Location ("Vlak", "Konečně jsi ve vlaku, teď stačí jenom počkat než dojede do Stříbra.");
        Location trainStationStribro = new Location ("Vlakové_nádraží_Stříbro" , "Toto je nádraží ve Stříbře, odtud už bude hračka dostat se na maturitu");
        pepeRoom.addExit(livingRoom);
        livingRoom.addExit(pepeRoom);
        

        routeToTrain.addExit(livingRoom);
        livingRoom.addExit(routeToTrain);
        routeToTrain.addExit(shop);
        shop.addExit(routeToTrain);
        routeToTrain.addExit(trainStationBor);
        trainStationBor.addExit(routeToTrain);
        
        park.addExit(livingRoom);
        livingRoom.addExit(park);
        park.addExit(shop);
        shop.addExit(park);
        shop.addExit(routeToTrain);
        
        
        trainStationBor.addExit(train);
        train.addExit(trainStationStribro);
        
        Jojo jojo = new Jojo("Jojo", "Docela kvalitní jojo, na chvilku zabaví, pokud ho použiješ dá ti 2 jednotky pozornosti.",true,true,false,false);
        Bush bush = new Bush("Keř", "Zelený keř, možná v něm něco najdeš.", false,false,false,true,jojo);
        PepehoSwitch pepehoSwitch = new PepehoSwitch ("PepehoSwitch", "Switch, můžeš na něm hrát hry, ale každá tě bude bavit pouze jednou. Pokaždé když si zahraješ hru dostaneš 1 jednotku pozornosti.",true,true,true,false, Pepe.getHealthBar(), Pepe.getInventory());
        Table table = new Table ("Stul","Velký stůl se šuplíky, možná když ho prohlídneš pořádně, něco najdeš.",false,false,false,true,pepehoSwitch);
        
        Mum mum = new Mum ("Máma", Pepe);
        ShopKeeper shopKeeper = new ShopKeeper ("Prodavačka", Pepe);
        Grandma grandma = new Grandma ("Babička", Pepe);
        
        park.addItem(bush);
        pepeRoom.addItem(table);
        
        
        livingRoom.addNpc(mum);
        shop.addNpc(shopKeeper);
        routeToTrain.addNpc(grandma);
        
                        
        currentLocation = pepeRoom;
        
        commands = new HashSet<>();

        commands.add(new CommandTerminate(this));
        commands.add(new CommandHelp());
        commands.add(new CommandMove(this));
        commands.add(new CommandLookAround(this));
        commands.add(new CommandPick(this));
        commands.add(new CommandInventoryInfo(this));
        commands.add(new CommandUse(this));
        commands.add(new CommandSearch(this));
        commands.add(new CommandCombine(this));
        commands.add(new CommandTalk(this));
        commands.add(new CommandBuy(this));
    }
    
    public void addLocationsToWorld() {
        
    }

    /**
     * Metoda vrací odkaz na aktuální lokaci, ve které se hráč právě nachází.
     *
     * @return aktuální lokace
     */
    public Location getCurrentLocation(){
        return currentLocation;
    }
    /**
     * Metoda nastaví aktuální lokaci. Používá ji příkaz {@link CommandMove}
     * při přechodu mezi lokacemi.
     *
     * @param currentLocation lokace, která bude nastavena jako aktuální
     */
    public void setCurrentLocation(Location currentLocation)
    {
        this.currentLocation = currentLocation;
    }

    /**
     * Metoda vrací informaci, zda hráč vyhrál <i>(zda se dostal na cílovou lokaci ve hře Vlakové_nádraží_Střibro)</i>.
     *
     * @return {@code true}, pokud hráč vyhrál; jinak {@code false}
     */
    public boolean isVictorious()
    {
        return currentLocation.getName().equals("Vlakové_nádraží_Stříbro");
    }
    /**
     * Metoda vrací informaci, zda hra již skončila <i>(je jedno, jestli
     * výhrou, prohrou nebo příkazem 'konec')</i>.
     *
     * @return {@code true}, pokud hra již skončila; jinak {@code false}
     */
    public boolean isGameOver()
    {
        return gameOver;
    }

    /**
     * Metoda nastaví příznak indikující, zda hra skončila. Metodu
     * využívá třída {@link CommandTerminate}, mohou ji ale použít
     * i další implementace rozhraní {@link ICommand}.
     *
     * @param gameOver příznak indikující, zda hra již skončila
     */
    public void setGameOver(boolean gameOver)
    {
        this.gameOver = gameOver;
    }

    /**
     * Metoda vrací odkaz na mapu prostorů herního světa.
     *
     * @return mapa prostorů herního světa
     */
    public GameWorld getGameWorld()
    {
        return this;
    }
    /**
     * Metoda zpracuje herní příkaz <i>(jeden řádek textu zadaný na konzoli)</i>.
     * Řetězec uvedený jako parametr se rozdělí na slova. První slovo je považováno
     * za název příkazu, další slova za jeho parametry.
     * <p>
     * Metoda nejprve ověří, zda první slovo odpovídá hernímu příkazu <i>(např.
     * 'napoveda', 'konec', 'jdi' apod.)</i>. Pokud ano, spustí obsluhu tohoto
     * příkazu a zbývající slova předá jako parametry.
     *
     * @param line text, který hráč zadal na konzoli jako příkaz pro hru
     * @return výsledek zpracování <i>(informace pro hráče, které se vypíšou na konzoli)</i>
     */
    public String processCommand(String line)
    {
        String[] parts = line.split("[ \t]+");

        String commandName = parts[0];
        String[] commandParameters = new String[parts.length - 1];

        for (int i = 0; i < commandParameters.length; i++) {
            commandParameters[i] = parts[i + 1];
        }

        for (ICommand cmd : commands) {
            if (cmd.getName().equalsIgnoreCase(commandName)) {
                String commandResult = cmd.execute(commandParameters);
                
                if (isVictorious()) {
                    gameOver = true;
                }

                return commandResult;
            }
        }

        return "Tomu nerozumím, příkaz '" + commandName + "' neznám.";
    }

    /**
     * Metoda vrací úvodní text pro hráče, který se vypíše na konzoli ihned po
     * zahájení hry.
     *
     * @return úvodní text
     */
    public String getPrologue()
    {
        return "Vítejte!\n"
                + "Toto je příběh o chlapci jménem Pepe. Tvůj úkol je dostat Pepeho na maturitu a hlídat si při tom jeho pozornost. Pokud Pepemu vyprší pozornost, zapomene, že má jít na maturitu.\n"
                + "Nevíte-li, jak pokračovat, zadejte příkaz 'nápověda'.";
    }
    
    /**
     * Metoda vrací závěrečný text pro hráče, který se vypíše na konzoli po ukončení
     * hry. Metoda se zavolá pro všechna možná ukončení hry <i>(hráč vyhrál, hráč
     * prohrál, hráč ukončil hru příkazem 'konec')</i>. Tyto stavy je vhodné
     * v metodě rozlišit.
     *
     * @return závěrečný text
     */
    public String getEpilogue()
    {
        String epilogue = "Díky, že sis zahrál(a).";

        if (isVictorious()) {
            epilogue = "Vyhrál(a) jsi,odtud už se Pepe musí dostat na maturitu sám.\n\n" + epilogue;
        }

        return epilogue;
    }
}
