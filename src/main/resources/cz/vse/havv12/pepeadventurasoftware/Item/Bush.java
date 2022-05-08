
package Item;


/**
 * Třída představuje keř v adventuře.
 * Drží si odkaz na hru a jojo.
 * 
 * @author Václav Havlík
 * @version ZS-2022, 2022-01-07
 */
public class Bush extends Item
{    
    private Jojo jojo;
    /**
     * Konstruktor vytvoří instanci keře.
     */
    public Bush(String name, String description, boolean pickable, boolean usable, boolean combinable,boolean searchable,Jojo jojo)
    {
        super(name,description,pickable,usable,combinable,searchable);
        this.jojo=jojo;
    }
    
    @Override
    public String onUse()
    {
        return null;
    }
    /**
     * Metoda odebere, jojo z keře a dá ho do aktuální lokace.
     * 
     * @return String našel jsi jojo, pokud je jojo v keři
     * @return String nic jsi nenašel, pokud není v keři
     */
    @Override
    public String onSearch()
    {

        if(jojo!=null){
            location.addItem(jojo);
            jojo=null;
            return "Našel jsi Jojo, nyní ho můžeš sebrat.";
        }
        else {
            return "V keři jsi nic nenašel";
        }
    }
    @Override
    public String onCombine(Item item)
    {
        return null;        
    }

}
