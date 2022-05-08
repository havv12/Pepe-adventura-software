/* UTF-8 codepage: Příliš žluťoučký kůň úpěl ďábelské ódy. ÷ × ¤
 * «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package game;



import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*******************************************************************************
 * Testovací třída {@code LocationTest} slouží ke komplexnímu otestování
 * třídy {@link LocationTest}.
 *
 * @author  author name
 * @version 0.00.0000 — 20yy-mm-dd
 */
public class LocationTest
{
 
    /***************************************************************************
     * Inicializace předcházející spuštění každého testu a připravující tzv.
     * přípravek (fixture), což je sada objektů, s nimiž budou testy pracovat.
     */
    @BeforeEach
    public void setUp()
    {
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
        Location pepeRoom = new Location("Pokoj", "Toto je Pepeho pokoj,ve kterém spí,hraje hry a dělá beaty.");
        assertEquals (pepeRoom.hasExit("Obývák"),false);
        Location livingRoom = new Location("Obývák", "Toto je obývák, zde můžeš potkat Pepeho mámu.");
        pepeRoom.addExit(livingRoom);
        assertEquals (pepeRoom.hasExit("Obývák"),true);
        
    }
}
