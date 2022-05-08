
package npc;

import game.Player;

/**
 * Třída představuje Pepeho mámu v adventuře.
 * Drži si odkaz na hru. 
 * Dále má atributy {@link #name}, ve kterém je uloženo její jméno a {@link #hasMoney}, ve kterém se ukáldá zda je možné od ní ještě dostat peníze.
 *
 * @author  Václav Havlík
 * @version ZS-2022, 2022-01-08
 */
public class Mum extends Npc
{
    private boolean hasMoney;
    private String name;
    private Player pepe;
    /**
     * Konstruktor vytvoří instanci mámy a nastaví jí jméno, přidá jí odkaz na instanci třídy game. 
     * Také nastaví, že je možné od mámy dostat peníze.
     */
    public Mum(String name, Player pepe)
    {
        super(name);
        hasMoney=true;
        this.name = name;
        this.pepe = pepe;
    }
    
    /**
     * Metoda umožňuje hráči mluvit s mámou.
     * 
     * @return "Máma ti dala 100Kč", pokud je možné od ní peníze dostat
     * @return "Máma už ti nic nedá.", pokud není možné od ní dostat peníze
     */
    public String onTalk()
    {
        if(hasMoney){
            pepe.changeMoney(100);
            hasMoney=false;
            return "Máma ti dala 100Kč.";
        }
        else{
            return "Máma už ti nic nedá.";
        }
    }
    /**
     * Metoda je zde pouze z toho důvodu že třída extenduje postavy.
     */
    public String onBuy(String item)
    {
        return null;
    }
    /**
     * Metoda slouží k navrácení jména postavy.
     * 
     * @return jméno
     */
    @Override
    public String getName()
    {
        return name;
    }
    /**
     * Metoda udává zda postava prodává předmět.
     * 
     * @param instance předmětu
     * @return {@code false}, pokud ho neprodává; {@code true}, pokud se prodává
     */
    public boolean sellsItem(String item)
    {
        return false;
    }

}
