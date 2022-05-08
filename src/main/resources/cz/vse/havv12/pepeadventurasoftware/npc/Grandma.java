
package npc;

import game.Player;

/**
 * Třída představuje Pepeho babičku v adventuře.
 * Drží si odkaz na hru.
 *  Dále má atributy {@link #name}, ve kterém je uloženo její jméno a {@link #hasMoney}, ve kterém se ukáldá zda je možné od ní ještě dostat peníze.
 *
 * @author Václav Havlík
 * @version ZS-2022, 2022-01-09
 */
public class Grandma extends Npc
{
    private boolean hasMoney;
    private String name;
    private Player player;
    /**
     * Konstruktor vytvoří instanci babičky a nastaví jí jméno, přidá jí odkaz na instanci třídy game. 
     * Také nastaví, že je možné od babičky dostat peníze.
     */
    public Grandma(String name, Player player)
    {
        super(name);
        hasMoney=true;
        this.name = name;
        this.player = player;
    }
    
    /**
     * Metoda umožňuje hráči mluvit s babi.
     * 
     * @return String kolik ti babi dala peněz, pokud je možné od ní peníze dostat
     * @return String babi už ti nic nedá, pokud není možné od ní dostat peníze
     */
    public String onTalk()
    {
        if(hasMoney){
            System.out.println("Babička se tě ptá, jak ti jde škola, co budeš dělat až dostuduješ, jak se mají rodiče, co pes, jak se má tvoje sestra.... Toto vyptávání tě doslova unudí k smrti.");
            System.out.println(player.getHealthBar().reduceHp(1000));
            
            player.changeMoney(50);
            hasMoney=false;
            return "Babi ti dala 50Kč.";
        }
        else{
            return "Babi už ti nic nedá.";
        }
    }
    /**
     *  Metoda je zde pouze z toho důvodu že třída extenduje postavy.
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

