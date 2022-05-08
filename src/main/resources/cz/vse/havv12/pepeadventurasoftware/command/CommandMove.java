package command;

import Item.Item;
import game.GameWorld;
import game.Location;

/**
 * Třída implementující příkaz pro pohyb mezi herními lokacemi.
 *
 * @author Jan Říha
 * @version ZS-2021, 2021-12-13
 */
public class CommandMove implements ICommand
{
	private GameWorld game;
    /**
     * Konstruktor třídy.
     *
     * @param game hra, ve které se bude příkaz používat
     */
    public CommandMove(GameWorld game)
    {
    	this.game = game;
    }

    /**
     * Metoda vrací název příkazu tj.&nbsp; slovo <b>jdi</b>.
     *
     * @return název příkazu
     */
    public String getName()
    {
        return "jdi";
    }

    /**
     * Metoda se pokusí přesunout hráče do jiné lokace. Nejprve zkontroluje počet
     * parametrů. Pokud nebyl zadán žádný parametr <i>(tj. neznáme cíl cesty)</i>,
     * nebo bylo zadáno dva a více parametrů <i>(tj. hráč chce jít na více míst
     * současně)</i>, vrátí chybové hlášení. Pokud byl zadán právě jeden parametr,
     * zkontroluje, zda s aktuální lokací sousedí lokace s daným názvem <i>(tj.
     * zda z aktuální lokace lze jít do požadovaného cíle)</i>. Pokud ne, vrátí
     * chybové hlášení. Pokud všechny kontroly proběhnou v pořádku, provede přesun
     * hráče do cílové lokace a vrátí její popis.
     * Metoda kontroluje, zda má hráč lístek, když vejde do vlaku a pokuď ne tak prohraje.
     *
     * @param parameters parametry příkazu <i>(očekává se pole s jedním prvkem)</i>
     * @return informace pro hráče, které hra vypíše na konzoli
     */
    public String execute(String[] parameters)
    {
        if (parameters.length < 1 ) {
            return "Tomu nerozumím, musíš mi říct, kam mám jít.";
        }

        if (parameters.length > 1) {
            return "Tomu nerozumím, neumím jít na více míst současně.";
        }

        String exitName = parameters[0];
        Location currentLocation = game.getGameWorld().getCurrentLocation();
        
        if (!currentLocation.hasExit(exitName)) {
            return "Do lokace " + exitName + " se odsud jít nedá.";
        }

        Location exit = currentLocation.getExit(exitName);
        game.getGameWorld().setCurrentLocation(exit);
        System.out.println(game.getGameWorld().Pepe.getHealthBar().reduceHp(1));
        if (game.getGameWorld().Pepe.getHealthBar().getHp()<=0){
            game.setGameOver(true);
            return "Došla ti pozornost, Pepeho již maturita nezajímá, má lepší věci na práci.";
        }
        if(game.getGameWorld().getCurrentLocation().getName().equals("Vlak")){
            
            Item inv[]=game.getGameWorld().Pepe.getInventory().getInv();
            for(int i=0;i<inv.length;i++){
                if(inv[i]!=null){
                    if(inv[i].name.equals( "Lístek")){ 
                        System.out.println(exit.getFullDescription());
                        return "Revizor ti zkontroloval lístek a pokračuješ v jízdě.";
                    }
                }
            }
            game.setGameOver(true);
            return "Revizor tě vyhodil z vlaku, protože si neměl lístek. Maturitu určitě nestihneš.";
        }
       
        
        
        return exit.getFullDescription();
    }
}
