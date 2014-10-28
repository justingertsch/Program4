import java.util.Map;
/**
 * Created by Justin on 10/23/2014.
 */
public class RemoveCommand implements Command
{

    private Database db = null;
    private String key = null;

    public RemoveCommand(Database db, String key)
    {
        this.db = db;
        this.key = key;
    }

    public void execute()
    {

    }

    public void undo()
    {

    }
}
