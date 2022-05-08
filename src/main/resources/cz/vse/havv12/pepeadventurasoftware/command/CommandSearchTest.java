/* UTF-8 codepage: Příliš žluťoučký kůň úpěl ďábelské ódy. ÷ × ¤
 * «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package command;



import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import game.GameWorld;
import Item.Ticket;
import game.Location;
/*******************************************************************************
 * Testovací třída {@code CommandSearchTest} slouží ke komplexnímu otestování
 * třídy {@link CommandSearchTest}.
 *
 * @author  author name
 * @version 0.00.0000 — 20yy-mm-dd
 */
public class CommandSearchTest
{
    private GameWorld gameWorld;
    private Ticket ticket;
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
    public void testSearchItem()
    {
    assertEquals("Tomu nerozumím, musíš mi říct, co mám prozkoumat.",gameWorld.processCommand("prozkoumej  "));
    assertEquals("Tomu nerozumím, neumím prozkoumat více věcí současně.",gameWorld.processCommand("prozkoumej jojo switch"));
    assertEquals("Předmět Jojo tady není.",gameWorld.processCommand("prozkoumej Jojo"));
    ticket = new Ticket ("Lístek","Listek na vlak, ten budeš potřebovat, aby ses dostal do Střibra",true,false,false,false);
    gameWorld.getCurrentLocation().addItem(ticket);
    assertEquals("Předmět Lístek nemůžeš prohledat.",gameWorld.processCommand("prozkoumej Lístek"));
    }
}
