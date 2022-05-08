
package cz.vse.havv12.pepeadventurasoftware.Item;





/**
 * Třída představuje Hru_na_Switch v adventuře.
 * 
 * @author Václav Havlík
 * @version ZS-2022, 2022-01-09
 */
public class GameOnSwitch extends Item
{
    /**
     * Konstruktor vytvoří instaci třídy Hra na Switch.
     */
     public GameOnSwitch(String name, String description, boolean pickable, boolean usable, boolean combinable,boolean searchable)
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
        return "Switch bohužel nemůžeš narvat do hry, budeš to muset udělat obráceně";
        }
    }



