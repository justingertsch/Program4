import java.util.ArrayList;

/**
 * Created by Justin on 10/23/2014.
 */
public class MacroCommand implements Command
{
    private ArrayList<Command> commands = null;

    public MacroCommand(ArrayList<Command> commands)
    {
        this.commands = commands;
    }

    public void execute()
    {
        System.out.println("Beginning a Macro");
        for(int i = 0; i < commands.size(); i++)
        {
                commands.get(i).execute();
        }
        System.out.println("Ending a Macro");
    }

    public void undo()
    {
        System.out.println("Begin Undoing Macro");
        for(int i = commands.size() - 1; i >= 0 ; i--)
        {
            commands.get(i).execute();
        }
        System.out.println("End Undoing Macro");
    }

}
