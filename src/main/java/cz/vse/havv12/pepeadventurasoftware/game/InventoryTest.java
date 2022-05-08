
package cz.vse.havv12.pepeadventurasoftware.game;



import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import Item.Jojo;

/*******************************************************************************
 * Testovací třída {@code InventoryTest} slouží ke komplexnímu otestování
 * třídy {@link InventoryTest}.
 *
 * @author  author name
 * @version 0.00.0000 — 20yy-mm-dd
 */
public class InventoryTest
{
    private Inventory inventory;
    /***************************************************************************
     * Inicializace předcházející spuštění každého testu a připravující tzv.
     * přípravek (fixture), což je sada objektů, s nimiž budou testy pracovat.
     */
    @BeforeEach
    public void setUp()
    {
        inventory = new Inventory(3);
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
    public void testRemoveItem(){
        Jojo jojo = new Jojo("Jojo", "Docela kvalitní jojo, na chvilku zabaví, pokud ho použiješ dá ti 2 jednotky pozornosti.",true,true,false,false);
        assertEquals(jojo.name+" není v inventáři.",inventory.removeItem (jojo) );
        inventory.add(jojo);
         assertEquals("Odebral jsi "+jojo.name+".",inventory.removeItem (jojo) );
         
    }
    
}
