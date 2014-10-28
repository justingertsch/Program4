import java.util.Map;

/**
 * Created by Justin on 10/23/2014.
 */
public class AddCommand implements Command
{
    private Database db = null;
    private String key = null;
    private String val = null;

    public AddCommand(Database db, String key, String val)
    {
        this.db = db;
        this.key = key;
        this.val = val;
    }

    public void execute()
    {

    }

    public void undo()
    {

    }

}
