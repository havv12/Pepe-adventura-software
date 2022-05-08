
package command;

import game.GameWorld;
import game.Location;

/**
 * Třída implementuje rozhraní ICommand.
 * Tříde se používá k mluvení s postavami.
 * Drží si odkaz na hru.
 * @author  Václav Havlík
 * @version ZS-2022, 2022-01-08
   */
//current location
public class CommandTalk implements ICommand
{
    private GameWorld game;
    
    public CommandTalk(GameWorld game)
    {
    this.game = game;
    }
    
    public String getName(){
    return "Mluv";
    }
     
   public String execute(String[] parameters)
    {
         if (parameters.length < 1) {
            return "Tomu nerozumím, musíš mi říct, s kým mám mluvit.";
        }
        
        if (parameters.length > 1) {
            return "Tomu nerozumím, neumím mluvit s více lidmi současně.";
        }
        
        String npcName = parameters[0];
        Location currentLocation = game.getGameWorld().getCurrentLocation();
        
        if (!currentLocation.containsNpc(npcName)) {
            return "Postava " + npcName + " tady není.";
        }
        
        return currentLocation.talkNpc(npcName);
    }


}
