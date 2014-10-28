import java.util.HashMap;
import java.util.Map;

/**
 * Created by Justin on 10/27/2014.
 */
public class Database
{
    private Map data = null;
    private String id = null;

    public Database(String id)
    {
        this.id = id;
        this.data = new HashMap<String,String>(100);
    }

    public String getID()
    {
        return this.id;
    }

    public void add(String key, String val)
    {
        this.data.put(key,val);
    }

    public String get(String key)
    {
        return (String)this.data.get(key);
    }

    public void update(String key, String val)
    {
        this.data.put(key,val);
    }

    public void remove(String key)
    {
        this.data.remove(key);
    }

    public void backup()
    {
        System.out.println(this.data.toString());
    }

}
