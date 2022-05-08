
package game;

/**
 * Třída představující Pepeho pozornost. 
 * Veškeré informaci týkající se Pepeho pozornosti jsou uloženy zde, pomocí datových atributů.
 * Datový atribut limit, slouží k nastavení maximální hodnoty hráče.
 * 
 * @author Václav Havlík
 * @version ZS-2022, 2022-01-08
 */

public class HealthBar
{
    private int health;
    private int limit;
    private int snusDurability;
    /**
     * Konstruktor, při vytvoření hráče, nastaví maximální množství pozornosti na aktuální množství pozornosti.
     */
    public HealthBar(int health)
    {
        this.health = health;
        limit = health;
    }

    /**
     * Metoda slouží k přidávání pozornosti.
     * 
     * @param množství přidané pozornosti
     * @return množství pozornosti po přidání
     */
    public String addHp(int addHealth)
    {
        if(health+addHealth >= limit){
            health=limit;  
            return "Máš plnou pozornost";
        }
        else
        { 
            health=health+addHealth;
            return "Máš "+health+" jednotek pozornosti.";
        }
    }

    /**
     * Metoda slouží k odebírání pozornosti.
     * 
     * @param množství odebrané pozornosti
     * @return množství pozornosti po odebrání
     */
    public String reduceHp(int reduceHealth)
    {
        if(snusDurability>0){
            snusDurability--;
            if(snusDurability==0){
                System.out.println("Vypršel ti snus.");
            }
            return "Nepřišel jsi o pozornost, protože jsi měl aktivní snus.";
        }
        health = health - reduceHealth;

        return "Máš "+health+" jednotek pozornosti.";
    }

    /**
     * Metoda sloužící ke kontrole toho, zda je předmět Snus aktivní a pokud ano nastaví snusDurability.
     * 
     * @param {@code true} pokud je předmět aktivní;{@code false} pokud není aktivní
     */
    public void setSnusActive(boolean activated)
    {
        if(activated)
        {
            snusDurability = 2;
        }

    }
    
    public int getHp()
    {
        return health;
    }


}
