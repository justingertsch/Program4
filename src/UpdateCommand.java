import java.util.Map;

/**
 * Created by Justin on 10/23/2014.
 */
public class UpdateCommand implements Command
{
    private Database db = null;
    private String key = null;
    private String val = null;
    private String prevVal = null;

    public UpdateCommand(Database db, String key, String val)
    {
        this.db = db;
        this.key = key;
        this.val = val;
    }
    public void execute()
    {
        this.prevVal = this.db.get(this.key);
        if(this.prevVal != null)
        {
            this.db.update(this.key,this.val);
        }
    }

    public void undo()
    {
        this.db.update(this.key,this.prevVal);
        System.out.println("Undid UpdateCommand");
        System.out.println(this.db.toString());
    }
}
