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
import Item.Snus;
import Item.Jojo;

/*******************************************************************************
 * Testovací třída {@code CommandPickTest} slouží ke komplexnímu otestování
 * třídy {@link CommandPickTest}.
 *
 * @author  author name
 * @version 0.00.0000 — 20yy-mm-dd
 */
public class CommandPickTest
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
    public void testOnePlusOne()
    {
    assertEquals("Tomu nerozumím, musíš mi říct, co mám sebrat.",gameWorld.processCommand("seber  "));
    assertEquals("Tomu nerozumím, neumím sebrat více věcí současně.",gameWorld.processCommand("seber Jojo Switch"));
    assertEquals("Předmět Jojo tady není.",gameWorld.processCommand("seber Jojo"));
    assertEquals("Předmět Stul fakt neuneseš.",gameWorld.processCommand("seber Stul"));
    Ticket ticket= new Ticket ("Lístek","Listek na vlak, ten budeš potřebovat, aby ses dostal do Střibra",true,false,false,false);
    gameWorld.Pepe.getInventory().add(new Ticket ("Lístek","Listek na vlak, ten budeš potřebovat, aby ses dostal do Střibra",true,false,false,false));
    gameWorld.Pepe.getInventory().add(new Ticket ("Lístek","Listek na vlak, ten budeš potřebovat, aby ses dostal do Střibra",true,false,false,false));
    gameWorld.Pepe.getInventory().add(new Ticket ("Lístek","Listek na vlak, ten budeš potřebovat, aby ses dostal do Střibra",true,false,false,false));
    gameWorld.getCurrentLocation().addItem(ticket);
    assertEquals("Předmět Lístek se Ti nevejde do inventáře.",gameWorld.processCommand("seber Lístek"));

    }
}
