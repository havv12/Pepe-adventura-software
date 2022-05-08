package cz.vse.havv12.pepeadventurasoftware.Item;

import game.Location;
import game.Player;

/**
 * Abstraktní třída, definuje základní atributy předmětu <i>jméno,popis,jestli jde zvednout,jestli jde použít,jestli jde zkombinovat,jestli jde prohledat<i>.
 * 
 * @author Václav Havlík
 * @version ZS-2022, 2022-01-09
 */
public abstract class Item implements Comparable<Item>
{
    public String name;
    public String description;
    public boolean pickable;
    public boolean usable;
    public boolean combinable;
    public boolean searchable;
    public Location location;
    public Player player;
    /**
     * Při vytváření konkrétních předmětů, si dané předměty přebírají své základní atributy, v tomtt konstruktoru.
     */
    public Item(String name, String description, boolean pickable, boolean usable, boolean combinable,boolean searchable)
    {
        this.name = name;
        this.description = description;
        this.pickable = pickable;
        this.usable = usable;
        this.combinable = combinable;
        this.searchable = searchable;
    }
   /**
     * Metoda slouží k navrácení jména postavy.
     * 
     * @return jméno
     */
    public String getName()
    {
        return name;
    }
    /**
     * Metoda vrací úplný popis předmětu.
     * 
     * return popis
     */
    public String getDescription()
    {
        return description;
    }
    /**
     * Metoda přiřadí předmětu jeho popis;
     * 
     * @param popis
     */
    public void setDescription(String description)
    {
        this.description = description;
    }
    /**
     * Metoda vrací zda jde předmět sebrat.
     * 
     * @return  {@code true}, pokud jde sebrat;  {@code false}, pokud sebrat nejde
     */
    public boolean isPickable()
    {
        return pickable;
    }
    /**
     * Metoda přiřadí předmětu, zda jde sebrat.
     * @param boolean sebratelný
     */
    public void setPickable(boolean pickable)
    {
        this.pickable = pickable;
    }
    /**
     * Metoda vrací, zda jde předmět použít.
     * 
     * @return {@code true}, pokud jde použít; {@code false}, pokud nejde použít
     */    
    public boolean isUsable()
    {
        return usable;
    }
    /**
     * Metoda vrací, zda jde předmět spojit.
     * 
     * @return {@code true}, pokud jde spojit; {@code false}, pokud nejde spojit
     */
    public boolean isCombinable()
    {
        return combinable;
    }
    /**
     * Metoda vrací, zda jde předmět prohledat
     * 
     * @return {@code true}, pokud jde prohledat; {@code false}, pokud nejde prohledat
     */
    public boolean isSearchable()
    {
        return searchable;
    }
    /**
     * Metoda zajišťuje, co se bude dít, při spojení předmětů.
     * 
     * @param instance předmětu
     */
    public abstract String onCombine(Item item);
    /**
     * Metoda zajišťuje, co se bude dít při prohledání předmětů.
     */
    public abstract String onSearch();
    /**
     * Metoda zajišťje, co se bude dít při, použití předmětů.
     */
    public abstract String onUse();
    /**
     * Override equals metody.
     * 
     */
    @Override
    public boolean equals(final Object o)
    {
        if (o == this) {
            return true;
        }

        if (o == null) {
            return false;
        }

        if (o instanceof Item) {
            Item item = (Item) o;

            return name.equals(item.getName());
        }

        return false;
    }
    
    @Override
    public int hashCode()
    {
        return name.hashCode();
    }

    @Override
    public int compareTo(Item item)
    {
        return name.compareTo(item.getName());
    }
}
