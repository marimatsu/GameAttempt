public class Commands 
{
    String name;
    String description;
    Runnable action;

    public Commands(String name, String description, Runnable action)
    {
        this.name = name;
        this.description = description;
        this.action = action;
    }

    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return description;
    }
    public void execute()
    {
        action.run();
    }
}
