
package cz.vse.havv12.pepeadventurasoftware.command;

import game.GameWorld;
import game.Location;
import npc.Npc;

/**
 * Třída implementuje rozhraní ICommand.
 * Třída se používá ke kupování předmětů..
 * Drží si odkaz na hru.
 * @author  Václav Havlík
 * @version ZS-2022, 2022-01-08
   */
public class CommandBuy implements ICommand
{
    private GameWorld game;
    public String getName(){
    return "Kup";
    }
    public CommandBuy(GameWorld game)
    {
        this.game = game;
    }
    
  
     public String execute(String[] parameters)
    {
         if (parameters.length < 1) {
            return "Tomu nerozumím, musíš mi říct, co mám koupit.";
        }
        
        if (parameters.length > 1) {
            return "Tomu nerozumím, neumím koupit víc věcí současně.";
        }
        
        String itemName = parameters[0];
        
        Location currentLocation = game.getGameWorld().getCurrentLocation();
        Npc npc = currentLocation.getNpc("Prodavačka");
        if (!currentLocation.containsNpc("Prodavačka")) {
            return "Prodavačka tady není.";
        }
        if(!npc.sellsItem(itemName)){

           return itemName+" se tu neprodává.";
        }
        return npc.onBuy(itemName);
    }


}
