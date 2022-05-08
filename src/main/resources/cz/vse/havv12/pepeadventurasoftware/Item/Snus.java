
package Item;


/**
 * Třída představuje snus v adventuře.
 * Drží si odkaz na hru.
 * 
 * @author  Václav Havlík
 * @version ZS-2022, 2022-01-09
 */
public class Snus extends Item{
   /**
    * Konstruktor vytváří instanci snusu.
    */
     public Snus(String name, String description, boolean pickable, boolean usable, boolean combinable,boolean searchable)
    {
        super(name,description,pickable,usable,combinable,searchable);
    }
    /**
     * Metoda zajišťuje, že po použití snusu dojde, k jeho odebrání z inventáře a k jeho aktivaci v healthBaru.
     * 
     * @return String
     */
    @Override
    public String onUse()
    {
        System.out.println(player.getInventory().removeItem(this));
        player.getHealthBar().setSnusActive(true);
        return "Použil jsi snus";
    }
    @Override
    public String onSearch()
    {
        return null;
    }
    @Override
    public String onCombine(Item item)
    {
       return null; 
    }
   
    

}
