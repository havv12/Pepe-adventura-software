package cz.vse.havv12.pepeadventurasoftware.command;

import Item.Item;
import game.GameWorld;
import game.Inventory;
import game.Location;

/**
 * Třída implementuje rozhraní ICommand.
 * Tříde se používá k sbíraní předmětů v adventuře.
 * Drží si odkaz na hru.
 * @author  Václav Havlík
 * @version ZS-2022, 2022-01-08
   */
public class CommandPick implements ICommand
{
    private GameWorld game;
    
    public CommandPick(GameWorld game)
    {
        this.game = game;
    }
    
    public String getName()
    {
        return "seber";
    }
    
    public String execute(String[] parameters)
    {
        if (parameters.length < 1) {
            return "Tomu nerozumím, musíš mi říct, co mám sebrat.";
        }
        
        if (parameters.length > 1) {
            return "Tomu nerozumím, neumím sebrat více věcí současně.";
        }
        
        String itemName = parameters[0];
        Location currentLocation = game.getGameWorld().getCurrentLocation();
        
        if (!currentLocation.containsItem(itemName)) {
            return "Předmět " + itemName + " tady není.";
        }
        
        Item item = currentLocation.getItem(itemName);
        
        if (!item.isPickable()) {
            return "Předmět " + itemName + " fakt neuneseš.";
        }
        
        
        Inventory inventory = game.getGameWorld().Pepe.getInventory();
        if (!inventory.add(item)) {
            return "Předmět " + itemName + " se Ti nevejde do inventáře.";
        }
        
        
        currentLocation.removeItem(itemName);
        
        return "Sebral(a) jsi předmět '" + itemName + "' a uložil(a) ho do inventáře.";
    }
}
