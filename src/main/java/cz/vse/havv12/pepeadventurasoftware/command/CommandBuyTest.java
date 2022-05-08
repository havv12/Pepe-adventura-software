/* UTF-8 codepage: Příliš žluťoučký kůň úpěl ďábelské ódy. ÷ × ¤
 * «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.vse.havv12.pepeadventurasoftware.command;



import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import game.GameWorld;
import npc.ShopKeeper;
import Item.Snus;
import game.Player;


/*******************************************************************************
 * Testovací třída {@code CommandBuyTest} slouží ke komplexnímu otestování
 * třídy {@link CommandBuyTest}.
 *
 * @author  author name
 * @version 0.00.0000 — 20yy-mm-dd
 */
public class CommandBuyTest
{
    private GameWorld gameWorld;
    private Player Pepe;
    private ShopKeeper shopKeeper;
    
    /***************************************************************************
     * Inicializace předcházející spuštění každého testu a připravující tzv.
     * přípravek (fixture), což je sada objektů, s nimiž budou testy pracovat.
     */
    @BeforeEach
    public void setUp()
    {
        gameWorld = new GameWorld();
            
    }

    /***************************************************************************
     * Úklid po testu - tato metoda se spustí po vykonání každého testu.
     */
    @AfterEach
    public void tearDown()
    {
    }

    /***************************************************************************
     * Test, který kontroluje požadovanou funkcionalitu.
     */
    @Test
    public void testOnePlusOne()
    {
    assertEquals("Tomu nerozumím, musíš mi říct, co mám koupit.",gameWorld.processCommand("kup  "));
    assertEquals("Tomu nerozumím, neumím koupit víc věcí současně.",gameWorld.processCommand("kup jojo switch"));
    assertEquals("Prodavačka tady není.",gameWorld.processCommand("kup Jojo"));
    shopKeeper = new ShopKeeper ("Prodavačka", gameWorld.Pepe);
    gameWorld.getCurrentLocation().addNpc(shopKeeper);
    assertEquals("Jojo se tu neprodává.",gameWorld.processCommand("kup Jojo"));
    assertEquals("Na Snus nemáš peníze",gameWorld.processCommand("kup Snus"));
    
    }
}
