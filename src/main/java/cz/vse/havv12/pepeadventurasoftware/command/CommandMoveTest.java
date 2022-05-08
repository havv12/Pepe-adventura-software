/* UTF-8 codepage: Příliš žluťoučký kůň úpěl ďábelské ódy. ÷ × ¤
 * «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.vse.havv12.pepeadventurasoftware.command;



import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import game.GameWorld;
import Item.Ticket;

/*******************************************************************************
 * Testovací třída {@code CommandMoveTest} slouží ke komplexnímu otestování
 * třídy {@link CommandMoveTest}.
 *
 * @author  author name
 * @version 0.00.0000 — 20yy-mm-dd
 */
public class CommandMoveTest
{
    private String[] parameters;
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
        parameters = new String[1];
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
    public void testDeathFromWalking()
    {
       assertEquals("Tomu nerozumím, musíš mi říct, kam mám jít.",gameWorld.processCommand("jdi  "));
       assertEquals("Tomu nerozumím, neumím jít na více míst současně.",gameWorld.processCommand("jdi park louka"));
       assertEquals("Do lokace park se odsud jít nedá.",gameWorld.processCommand("jdi park"));
        
       
       gameWorld.processCommand("jdi Obývák");
       gameWorld.processCommand("jdi Pokoj");
       gameWorld.processCommand("jdi Obývák");
       gameWorld.processCommand("jdi Pokoj");
       gameWorld.processCommand("jdi Obývák");
       assertEquals(true,gameWorld.isGameOver());
       
    }
    @Test
    public void testTicketDeath(){
        gameWorld.processCommand("jdi Obývák");
        gameWorld.processCommand("jdi Cesta_na_vlak");
        gameWorld.processCommand("jdi Vlakové_nádraží_v_Boru");
        gameWorld.processCommand("jdi Vlak");
        assertEquals(true,gameWorld.isGameOver());
        
    }
    @Test
    public void testTicketNotDeath(){
        gameWorld.Pepe.getInventory().add(new Ticket ("Lístek","Listek na vlak, ten budeš potřebovat, aby ses dostal do Střibra",true,false,false,false));
        gameWorld.processCommand("jdi Obývák");
        gameWorld.processCommand("jdi Cesta_na_vlak");
        gameWorld.processCommand("jdi Vlakové_nádraží_v_Boru");
        assertEquals("Revizor ti zkontroloval lístek a pokračuješ v jízdě.", gameWorld.processCommand("jdi Vlak"));
        gameWorld.processCommand("jdi Vlak");
        assertEquals(false,gameWorld.isGameOver());
        gameWorld.processCommand("jdi Vlakové_nádraží_Stříbro");
        assertEquals(true,gameWorld.isVictorious());
        
    }
}
