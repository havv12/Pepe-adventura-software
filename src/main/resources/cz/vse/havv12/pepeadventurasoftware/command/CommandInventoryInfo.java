
package command;

import game.GameWorld;

/**
 * Třída implementuje rozhraní ICommand.
 * Tříde se používá k získání informací o svém inventáři.
 * Drží si odkaz na hru.
 * @author  Václav Havlík
 * @version ZS-2022, 2022-01-08
   */
 
public class CommandInventoryInfo implements ICommand
{
    private GameWorld game;
    
    public CommandInventoryInfo(GameWorld game)
    {
        this.game = game;
    }
    public String getName(){
    return "Inventář";
    }
    
    public String execute(String[] parameters){
      game.getGameWorld().Pepe.getInventory().itemsInInventory();
      System.out.println("V peněžence máš, "+game.getGameWorld().Pepe.getMoney()+"Kč.");
      return "Tohle je vše, co máš v inventáři.";
    }





}
