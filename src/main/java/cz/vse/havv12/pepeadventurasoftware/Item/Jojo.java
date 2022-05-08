
package cz.vse.havv12.pepeadventurasoftware.Item;


/**
 * Třída představuje Jojo v adventuře.
 * Drží si odkaz na hru.
 * 
 * @author  Václav Havlík
 * @version ZS-2022, 2022-01-09
 */
public class Jojo extends Item 
{
    
    /**
     * Konstrukto vytvoří instanci Joja.
     */
    public Jojo(String name, String description, boolean pickable, boolean usable, boolean combinable,boolean searchable)
    {
        super(name,description,pickable,usable,combinable,searchable);
        
    }
    
    /**
     * Metoda odstraní Jojo z inventáře, a přidá pozornost.
     * 
     * @return addHp
     */
    @Override
    public String onUse()
    {
        System.out.println(player.getInventory().removeItem(this));
        return player.getHealthBar().addHp(3);
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
