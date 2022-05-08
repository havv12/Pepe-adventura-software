
package game;

import Item.Item;

/**
 * Třída sloužící k uchovávání předmětů v poli.
 * Zároveň? je zde uložen počet držených předmětů.
 * 
 * @author Václav Havlík
 * @version ZS-2022, 2022-01-09
 */

public class Inventory

{   
    private Item inv[];
    private int numberOfItems;
    /**
     * Konstruktor vytváří pole inv, do kterého se budou ukládat předměty.
     * Nastavuje počet předmětů na 0.
     */
    public Inventory(int size){
     inv = new Item [size];
     numberOfItems = 0;
    
    }
    /**
     * Metoda sloužíci pro přidání předmětu.
     * 
     * @return {@code true} pokud byl přidán předmět; {@code false} pokud předmět přidán nebyl;
     * @param instance předmětu
     */
    public boolean add(Item item){
        for(int i = 0; i < inv.length;i++){
            if(inv[i] == null) {
                inv[i] = item;
                numberOfItems++;
                return true;
            }
        }
        return false;
    }
    
    /**
     * Metoda vypisuje počet předmětů inventáři a jejich jména.
     * 
     */
    public void itemsInInventory(){
        System.out.println("Počet předmětů v inventáři: "+numberOfItems+".");        
        for(int i= 0;i < 3;i++){
        if (inv[i]!=null)
        System.out.println(inv[i].getName());
        }
        
    }
    /**
     * Metoda slouží k odebrání předmětu v inventáři;
     * 
     * 
     * @param isntance předmětu
     * @return metoda vypíše název předmětu, pokud byl předmět odebrán
     * @return pokud předmět není v inventáři vypíše se, že předmět není v inventáři
     */
    public String removeItem(Item item){
     for(int i=0;i<inv.length;i++){
        if(inv[i]!=null&&item.equals(inv[i])){
            inv[i]=null;
            numberOfItems--;
            return("Odebral jsi "+item.name+".");
            }
        }return item.name+" není v inventáři.";
    }
    /**
     * Metoda vrací instanci inventáře.
     * 
     * @return instance inventáře
     */
    public Inventory getInventory(){
    return this;
    }
    /**
     * Metoda vrací pole inventáře.
     * 
     * return pole inventáře
     */
    public Item[] getInv(){
    return inv;
    }
    



}
