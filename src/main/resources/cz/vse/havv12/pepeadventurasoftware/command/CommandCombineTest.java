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

/*******************************************************************************
 * Testovací třída {@code CommandCombineTest} slouží ke komplexnímu otestování
 * třídy {@link CommandCombineTest}.
 *
 * @author  author name
 * @version 0.00.0000 — 20yy-mm-dd
 */
public class CommandCombineTest
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
    assertEquals("Tomu nerozumím, nemohu spojit méně než dva předměty.",gameWorld.processCommand("spoj  "));
    assertEquals("Tomu nerozumím, nemohu spojit méně než dva předměty.",gameWorld.processCommand("spoj Jojo "));
    assertEquals("Tomu nerozumím, nemohu spojit více než dva předměty najdenou.",gameWorld.processCommand("spoj Jojo Switch Snus"));
    Ticket ticket= new Ticket ("Lístek","Listek na vlak, ten budeš potřebovat, aby ses dostal do Střibra",true,false,false,false);
    gameWorld.Pepe.getInventory().add(new Ticket ("Lístek","Listek na vlak, ten budeš potřebovat, aby ses dostal do Střibra",true,false,false,false));
    Snus snus = new Snus ("Snus", "Snus, neboli žvýkací tabák, můžeš ho žvýkat po cestě, při dalších dvou změnách lokace nepřicházíš o pozornost.",true,true,false,false);
    gameWorld.Pepe.getInventory().add(new Snus ("Snus", "Snus, neboli žvýkací tabák, můžeš ho žvýkat po cestě, při dalších dvou změnách lokace nepřicházíš o pozornost.",true,true,false,false));
    assertEquals("Předměty nelze zkombinovat.",gameWorld.processCommand("spoj Snus Lístek "));
    
    }
}
