
package cz.vse.havv12.pepeadventurasoftware.command;

import Item.Item;
import game.GameWorld;

/**
 * Třída implementuje rozhraní ICommand.
 * Tříde se používá k spojení dvou předmětů.
 * Drží si odkaz na hru.
 * @author  Václav Havlík
 * @version ZS-2022, 2022-01-08
   */
public class CommandCombine implements ICommand
{
    private GameWorld game;
    
    
    public CommandCombine(GameWorld game)
    {
        this.game=game;
    }

    public String getName(){
        return "spoj";
    }

    public String execute(String[] parameters)
    {
        if (parameters.length < 2) {
            return "Tomu nerozumím, nemohu spojit méně než dva předměty.";
        }

        if (parameters.length > 2) {
            return "Tomu nerozumím, nemohu spojit více než dva předměty najdenou.";
        }

        
        Item inv[]=game.getGameWorld().Pepe.getInventory().getInv();
        for(int i=0;i<inv.length;i++){
            for(int j=0;j<inv.length; j++) {
                if(inv[i]!=null&&inv[i].isCombinable()&&inv[i].name.equals(parameters[0])){
                    if(inv[j]!=null&&inv[j].isCombinable()&&inv[j].name.equals(parameters[1])) {
                        
                        return inv[i].onCombine(inv[j]);
                    }
                }

            }
        }
        return "Předměty nelze zkombinovat.";
    }
}




