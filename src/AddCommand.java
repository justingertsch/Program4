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
        if(this.db.get(this.key) == null)
        {
            this.db.add(this.key,this.val);
        }
    }

    public void undo()
    {
        this.db.remove(this.key);
        System.out.println("Undid AddCommand");
        System.out.println(this.db.toString());
    }

}
