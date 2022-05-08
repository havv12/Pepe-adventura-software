
package cz.vse.havv12.pepeadventurasoftware.command;

import Item.Item;
import game.GameWorld;

/**
 * Třída implementuje rozhraní ICommand.
 * Tříde se používá k používání předmětů v adventuře.
 * Drží si odkaz na hru.
 * @author  Václav Havlík
 * @version ZS-2022, 2022-01-08
   */
//Inventář
public class CommandUse implements ICommand
{
    private GameWorld game;
    /**
     * Konstruktor vytvoří instanci třídy CommandUse.
     */
     
    public CommandUse(GameWorld game)
    {

        this.game = game;
    }
    
    public String getName(){
        return "použij";
    }
    
    public String execute(String[] parameters){
        if (parameters.length < 1) {
            return "Tomu nerozumím, musíš mi říct, co mám použít.";
        }
        
        if (parameters.length > 1) {
            return "Tomu nerozumím, neumím použít více věcí současně.";
        }
        Item inv[]=game.getGameWorld().Pepe.getInventory().getInv();
        for(int i=0;i<inv.length;i++){
            if(inv[i]!=null){
                if(inv[i].name.equals( parameters[0])){ 
                    if(inv[i].isUsable()){
                    	inv[i].player=game.Pepe;
                        return inv[i].onUse();
                    } 
                    else {return "Předmět "+inv[i].name+" nejde použít."; }
                }
            }
        }return "Předmět "+parameters[0]+" není v inventáři.";
    }

}
