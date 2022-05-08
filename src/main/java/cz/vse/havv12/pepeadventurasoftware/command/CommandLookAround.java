package cz.vse.havv12.pepeadventurasoftware.command;

import game.GameWorld;

/**
 * Třída implementuje rozhraní ICommand.
 * Tříde se používá k rozhlédnutí, čímž hráč získá veškeré informace o lokaci, be které se nachází.
 * Drží si odkaz na hru.
 * @author  Václav Havlík
 * @version ZS-2022, 2022-01-08
   */
public class CommandLookAround implements ICommand
{
    private GameWorld game;
    
    public CommandLookAround(GameWorld game)
    {
        this.game = game;
    }
    
    public String getName()
    {
        return "rozhledni_se";
    }
    
    public String execute(String[] parameters)
    {
        return game.getGameWorld().getCurrentLocation().getFullDescription();
    }
}
