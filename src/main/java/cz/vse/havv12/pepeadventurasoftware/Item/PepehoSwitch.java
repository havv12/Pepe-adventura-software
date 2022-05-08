
package cz.vse.havv12.pepeadventurasoftware.Item;

import game.HealthBar;
import game.Inventory;

/**
 * Třída představuje pepehoSwitch v adventuře.
 * Drží si odkaz na hru.
 * Má atribut počet her.
 * 
 * @author  Václav Havlík
 * @version ZS-2022, 2022-01-09
 */
public class PepehoSwitch extends Item
{
	private HealthBar hb;
	private Inventory inv;
	private int numberOfGames;
    /**
     * Konsturkotr vytvoří instanci pepehoSwitche a nastaví počet her na 0;
     */
     public PepehoSwitch(String name, String description, boolean pickable, boolean usable, boolean combinable,boolean searchable, HealthBar hb, Inventory inv)
    {
        super(name,description,pickable,usable,combinable,searchable);
        numberOfGames = 0;
        this.hb=hb;
        this.inv=inv;
    }
    /**
     * Metoda odečte 1 z počtu her po každem použití a přidá jednu pozornost, pokud na něm nejsou žádné hry vypíše se string.
     * 
     * @return přidá pozornost, pokud je počet her větší než nula.
     * @return String, pokud na Switchi nejsou žádné hry
     */
    @Override
    public String onUse()
    {
        if (numberOfGames>0){
            numberOfGames--;
            return hb.addHp(1);
        }
        else {
            return "Na switchy nemáš žádné hry, které by tě bavili.";
        }
    }
    
    @Override
    public String onSearch()
    {
        return null;
    }
    /**
     * Metoda zkontroluje, zda jdou předměty spojit.
     * 
     * @param instance itemu
     * @return předměty nelze spojit, pokud nejde spojit
     * @return předměty byly spojeny
     */
    @Override
    public String onCombine(Item item)
    {
        if(!item.isCombinable()){
            return "Předměty "+item.name+" nelze kombinovat.";
        }
        else {
            numberOfGames++;
            inv.removeItem(item);
            return "Předměty Pepeho Switch a "+item.name+" byly spojeny.";
        }
        
    }
}
