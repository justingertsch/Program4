import java.util.Map;
/**
 * Created by Justin on 10/23/2014.
 */
public class RemoveCommand implements Command
{

    private Database db = null;
    private String key = null;
    private String prevVal = null;

    public RemoveCommand(Database db, String key)
    {
        this.db = db;
        this.key = key;
    }

    public void execute()
    {
        this.prevVal = this.db.get(key);
        if(this.prevVal != null)
        {
            this.db.remove(this.key);
        }
    }

    public void undo()
    {
        this.db.add(this.key,this.prevVal);
        System.out.println("Undid RemoveCommand");
        System.out.println(this.db.toString());
    }
}
