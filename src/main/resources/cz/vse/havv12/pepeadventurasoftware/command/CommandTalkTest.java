/* UTF-8 codepage: Příliš žluťoučký kůň úpěl ďábelské ódy. ÷ × ¤
 * «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package command;



import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import game.GameWorld;

/*******************************************************************************
 * Testovací třída {@code CommandTalkTest} slouží ke komplexnímu otestování
 * třídy {@link CommandTalkTest}.
 *
 * @author  author name
 * @version 0.00.0000 — 20yy-mm-dd
 */
public class CommandTalkTest
{
    private GameWorld gameWorld;
    
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
    public void testTalkNpc()
    {
    assertEquals("Tomu nerozumím, musíš mi říct, s kým mám mluvit.",gameWorld.processCommand("mluv  "));
    assertEquals("Tomu nerozumím, neumím mluvit s více lidmi současně.",gameWorld.processCommand("mluv Máma Babi"));
    assertEquals("Postava Máma tady není.",gameWorld.processCommand("mluv Máma"));
    }
}
