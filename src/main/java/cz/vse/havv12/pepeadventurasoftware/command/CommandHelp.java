package cz.vse.havv12.pepeadventurasoftware.command;

/**
 * Třída implementuje rozhraní ICommand.
 * Tříde slouží k poskytnutí nutné pomoci uživateli, popsání nejnutnějších věcí.
 * Drží si odkaz na hru.
 * @author  Václav Havlík
 * @version ZS-2022, 2022-01-08
   */
public class CommandHelp implements ICommand
{
    public String getName()
    {
        return "napoveda";
    }
    
    public String execute(String[] parameters)
    {
        return "Aby jdi úspěšně dostal Pepeho na maturitu, budeš potřebovat několik věcí:/n nejdříve si musíš promluvit s Mámou, aby jsi dostal peníze./n Poté si musíš promluvit s Babičkou, aby ti dala zbytek peněz potřebných na Lístek./n Pokud ti nevyhází pozornost zkus prohledat nějaké věci.";
    }
}
