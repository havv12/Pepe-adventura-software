
package cz.vse.havv12.pepeadventurasoftware.Item;





/**
 * Třída představuje lístek v adventuře.
 * 
 * @author  Václav Havlík
 * @version ZS-2022, 2022-01-09
 */
public class Ticket extends Item
{   
    /**
     * Konstruktor vytvoří instanci lístku.
     */
    
     public Ticket(String name, String description, boolean pickable, boolean usable, boolean combinable,boolean searchable)
    {
        super(name,description,pickable,usable,combinable,searchable);
        
       
    }
    
    @Override
    public String onUse()
    {
        return null;
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
