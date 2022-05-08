
package cz.vse.havv12.pepeadventurasoftware.Item;


/**
 * Třída představuje stůl v adventuře.
 * Drží si odkaz na hru a odkaz na pepehoSwitch.
 * 
 * @author  Václav Havlík
 * @version ZS-2022, 2022-01-08
 */
public class Table extends Item
{

    private PepehoSwitch pepehoSwitch;
    /**
     * Konstruktor vytvoří instanci stolu.
     */
    public Table(String name, String description, boolean pickable, boolean usable, boolean combinable,boolean searchable,PepehoSwitch pepehoSwitch)
    {
        super(name,description,pickable,usable,combinable,searchable);
        this.pepehoSwitch=pepehoSwitch;
    }

    @Override
    public String onUse()
    {
        return null;
    }
    /**
     * 
     */
    @Override
    public String onSearch()
    {
        /**
         * Medota zjistí, zda pepehoSwitch ve stole je, a pokud ano umístí ho do lokace.
         * 
         * @return String našel jsi Switch, pokud je ve stole
         * @return String nic jsi nenašel, pokud není ve stole
         */
        if(pepehoSwitch!=null){
            location.addItem(pepehoSwitch);
            pepehoSwitch=null;
            return "Našel jsi PepehoSwitch, nyní ho můžeš sebrat.";
        }
        else {
            return "Ve stole jsi nic nenašel";
        }
    }
    @Override
    public String onCombine(Item item)
    {
        return null;
    }

}


