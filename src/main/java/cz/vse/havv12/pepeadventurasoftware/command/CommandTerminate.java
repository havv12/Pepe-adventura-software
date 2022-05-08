package cz.vse.havv12.pepeadventurasoftware.command;

import game.GameWorld;

/**
 * Třída implementuje rozhraní ICommand.
 * Tříde se používá k ukončení hry.
 * Drží si odkaz na hru.
 * @author  Václav Havlík
 * @version ZS-2022, 2022-01-07
   */
public class CommandTerminate implements ICommand
{
    private GameWorld game;
    
    public CommandTerminate(GameWorld game)
    {
        this.game = game;
    }
    
    public String getName()
    {
        return "konec";
    }
    
    public String execute(String[] parameters)
    {
        game.setGameOver(true);
        
        return "Hra byla ukončena příkazem KONEC.";
    }
}
