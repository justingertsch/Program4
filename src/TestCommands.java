import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Justin on 10/23/2014.
 */
public class TestCommands
{
    private static Map<String,Database> dbs = new HashMap<String,Database>(100);

    public static void main(String[] args)
    {


    }

    public static void createCommands( ArrayList<Command> commandList, ArrayList<String[]> lines, int num)
    {
        for (int i = num; i < lines.size(); i++)
        {
            String[] line = lines.get(num);
            Database db = checkDb(line[1], dbs);
            switch (line[0])
            {
                case "A":
                    commandList.add(new AddCommand(db,line[2],line[3]));
                    break;

                case "U":
                    commandList.add(new UpdateCommand(db,line[2],line[3]));
                    break;

                case "R":
                    commandList.add(new RemoveCommand(db,line[2]));
                    break;

                case "B":
                    ArrayList<Command> macrolist = new ArrayList<Command>();
                    Command macro = new MacroCommand(macrolist);
                    commandList.add(macro);
                    i++;
                    createCommands(macrolist,lines, i);
                    break;

                case "E":
                    return;

            }
        }
    }

    public static Command[] read(String file)
    {
        // read in file
        Scanner in = null;
        try
        {
            in = new Scanner(new File(file));
        }
        catch(IOException ex)
        {
            System.out.println("Error opening file");
            System.exit(1);
        }

        // Get all commands
        ArrayList<String[]> fileLines = new ArrayList<String[]>();
        while(in.hasNextLine())
        {
            String[] line = in.nextLine().trim().split(" +");

            // If value then consolidate if multiple words
            if (line.length <= 4)
            {
                String val = null;
                for (int i = 3; i < line.length; i++)
                {
                    val += line[i] + " ";
                }
                line[3] = val.trim();
            }
            fileLines.add(line);
        }


        // create a command
        ArrayList<Command> commandList = new ArrayList<Command>();
        createCommands(commandList, fileLines, 0);



    }


    public static Database checkDb(String dbid, Map dbs)
    {
        Database curdb;
        if(!dbs.containsKey(dbid))
        {
            curdb = new Database(dbid);
            dbs.put(dbid, curdb);
            return curdb;
        }
        else
            curdb = (Database)dbs.get(dbid);

        return curdb;
    }



}
