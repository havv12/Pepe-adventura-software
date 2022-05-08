
import game.GameWorld;
import ui.TextUI;

/**
 * Spouštěcí třída aplikace.
 *
 * @author Jan Říha
 * @version ZS-2021, 2021-12-13
 */
public class Start
{
    /**
     * Spouštěcí metoda aplikace. Vytvoří instanci hry, uživatelského rozhraní a zahájí hru.
     *
     * @param args parametry aplikace z příkazové řádky, aktuálně se nijak nevyužívají
     */
    public static void main(String[] args)
    {
        GameWorld game = new GameWorld();
        TextUI ui = new TextUI(game);

        ui.play();
    }
}
