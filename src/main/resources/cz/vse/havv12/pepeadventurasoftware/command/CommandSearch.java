
package command;

import Item.Item;
import game.GameWorld;
import game.Location;

/**
 * Třída implementuje rozhraní ICommand.
 * Tříde se používá k prohledání předmětu.
 * Drží si odkaz na hru.
 * @author  Václav Havlík
 * @version ZS-2022, 2022-01-08
   */

public class CommandSearch implements ICommand
{
    private GameWorld game;
    
    public CommandSearch(GameWorld game)
    {
        this.game=game;
    }
    
    public String getName(){
    return "prozkoumej";
    }
    
    public String execute(String[] parameters)
    {
        if (parameters.length < 1) {
            return "Tomu nerozumím, musíš mi říct, co mám prozkoumat.";
        }
        
        if (parameters.length > 1) {
            return "Tomu nerozumím, neumím prozkoumat více věcí současně.";
        }
        
        String itemName = parameters[0];
        Location currentLocation = game.getGameWorld().getCurrentLocation();
        
        if(!currentLocation.containsItem(itemName)) {
            return "Předmět " + itemName + " tady není.";
        }
        
        Item item = currentLocation.getItem(itemName);
        
         if (!item.isSearchable()) {
            return "Předmět " + itemName + " nemůžeš prohledat.";
        }
        return item.onSearch();
    }



}
