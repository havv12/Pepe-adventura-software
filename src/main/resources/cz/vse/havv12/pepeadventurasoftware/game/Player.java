
package game;
/**
 * Třída představuje postavu hráče, tedy Pepeho. 
 * Drži si odkaz na Pepeho pozornost a inventář. 
 * Dále je zde uložena proměná peníze.
 * 
 * @author Václav Havlík
 * @version ZS-2022, 2022-01-09
 */
public class Player
{
    private HealthBar healthBar;
    private Inventory inventory;
    private int money;
    /**
     * Konstruktor, při vytvoření hráče vytvoří inventář,měřič pozornosti a nastaví jejich parametry. 
     * Také nastaví proměnou peníze na 0.
     */
    public Player()
    {
        inventory = new Inventory(3);
        healthBar = new HealthBar(5);
        money = 0;
    }
    /**
     * Metoda vrací instaci třídy healthBar.
     * 
     * @return healthBar
     */
    public HealthBar getHealthBar()
    {
        return healthBar;
    }
    /**
     * Metoda vrací instaci třídy inventory.
     * 
     * @return inventory
     */
    public Inventory getInventory(){
        return inventory;
    }
    /**
     * Metoda zajišťuje změnu počtu peněz jak do plusu tak do mínusu.
     * 
     * @param částka o kterou se změní počet peněz i se znaménkem
     */
    public void changeMoney(int cash)
    {
        money +=cash;
    }
    /**
     * Metoda vrací aktuální počet peněz.
     * 
     * @return počet peněz
     */
    public int getMoney()
    {
        return money;
    }
}
    
