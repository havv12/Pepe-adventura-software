
package npc;
import java.util.*;

import Item.GameOnSwitch;
import Item.Snus;
import Item.Ticket;
import game.Player;


/**
 * Třída představuje porodavačku v adventuře.
 * Drží si odkaz na hru.
 * Vytváří mapu předmětů, s názvem předmětu jako klíčem a cenou předmětů jako hodnotou. 
 *
 * @author  Václav Havlík
 * @version ZS-2022, 2022-01-08
 */
public class ShopKeeper extends Npc
{    
    private Player pepe;
    @SuppressWarnings("serial")
    Map<String,Integer> itemsInShop = new HashMap<String,Integer>()
        {
            {
                put("Snus", 20);
                put("Lístek", 120);
                put("Hra_na_Switch",5);
            }
        };
    /**
     * Konstruktor vytváří instanci prodavačky a dává jí odkaz na hru.
     */
    public ShopKeeper(String name, Player pepe)
    {
        super(name);
        this.pepe = pepe;
    }
    /**
     * Metoda určuje co se stane, pokud budeš mluvit s prodavačkou.
     * 
     * @return String
     */
    public String onTalk()
    {
        return "Prodavačka ti může prodat spoustu věcí, ale pro tebe jsou důležité pouze Hra_na_Switch za 5Kč, Lístek za 120Kč a Snus za 20Kč";
    }
    /**
     * Metoda vrací, zda je předmět, který chceme koupit na prodej.
     * 
     * @param instance přemětu
     * @return instance předmětu
     */
    public boolean sellsItem(String item)
    {
        return itemsInShop.containsKey(item);
    }
    /**
     * Metoda zajišťuje obchod s prodavačkou a vytváří předměty, které si kupujeme.
     * 
     * @param instance předmětu
     * @return předmět,který sis koupil a cenu, kterou jsi za něj zaplatil.
     */
    public String onBuy(String itemName)
    {
        if(pepe.getMoney()<(itemsInShop.get(itemName)))
        {
            return "Na "+itemName+" nemáš peníze";
        }
        switch (itemName)
        {
            case "Hra_na_Switch":
            if(pepe.getInventory().add (new GameOnSwitch ("Hra_na_Switch","Tuto hru můžeš dát do switche a pak si jí zahrát.",true,false,true,false)))
            {
                 pepe.changeMoney(-itemsInShop.get(itemName)); 
                 return "Koupil sis "+itemName+" a přidal sis ho do inventáře, stálo tě to "+ itemsInShop.get(itemName) +" Kč.";
            }
            break;
               
            case "Snus":
            if(pepe.getInventory().add(new Snus ("Snus", "Snus, neboli žvýkací tabák, můžeš ho žvýkat po cestě, při dalších dvou změnách lokace nepřicházíš o pozornost.",true,true,false,false)))
            {
                pepe.changeMoney(-itemsInShop.get(itemName)); 
                return "Koupil sis "+itemName+" a přidal sis ho do inventáře, stálo tě to "+ itemsInShop.get(itemName) +" Kč.";
            }
            break;   
            case "Lístek":
            if(pepe.getInventory().add(new Ticket ("Lístek","Listek na vlak, ten budeš potřebovat, aby ses dostal do Střibra",true,false,false,false)))
            {
                pepe.changeMoney(-itemsInShop.get(itemName));
                return "Koupil sis "+itemName+" a přidal sis ho do inventáře, stálo tě to "+ itemsInShop.get(itemName) +" Kč.";
            }
            break;
        }
        return itemName+" se ti nevejde do inventáře.";
    }

}
