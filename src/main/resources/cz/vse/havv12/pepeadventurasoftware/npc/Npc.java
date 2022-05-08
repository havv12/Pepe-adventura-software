
package npc;



/**
 * Abstraktní třída, definuje základní atributy, každé postavy <i>jméno<i>.
 * 
 */
public abstract class Npc
{
    public String name;
     
  
    /**
     * Konstruktor vytváří instanci třídy postavy a přiřazuje jí jméno.
     */
    public Npc(String name)
    {
       this.name = name;
    }
    /**
     * Metoda vrací jméno postavy.
     * 
     * @return jméno
     */
    public String getName()
    {
        return name;
    }

    /**
     * Metoda zjišťuje zda daná postava pordává daný předmět.
     */
    abstract public boolean sellsItem(String item);
    /**
     * Metoda umožňuje hráči mluvit s postavou.
     */
    abstract public String onTalk();
    /**
     * Metoda umož�?uje hráči koupit předmět.
     */
    abstract public String onBuy(String item);
}
