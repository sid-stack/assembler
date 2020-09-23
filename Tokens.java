/**
 * Write a description of class Tokens here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
import java.io.*;
public class Tokens
{
    public static void main(String args[])
    {
        List<String> list = new ArrayList<String>();
        String s = "This is Java";
        String d =" ";
        // StringTokenizer str = new StringTokenizer(s,d);
        // while (str.hasMoreTokens()) 
        // {  
        // System.out.println(str.nextToken()); 
        // } 
        List <String> lit = new ArrayList<String>();
        List <String> sym  = new ArrayList<String>();
        try 
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter file name:");
            String filename = sc.nextLine();
            File file = new File(filename);
            Scanner fileReader = new Scanner(file);

            while (fileReader.hasNextLine()) 
            {
                String data = fileReader.nextLine();
                list.add(data);
                if(data.contains("="))
                {
                    lit.add(data);
                }
                else {
                    sym.add(data);
                }
                // list.add(tokens(data,""));
                // String res[] = tokens(data,"");
                // for(String item : res)
                // {
                // list.add(item);
                // if(item.startsWith("="))
                // {
                // lit.add(data);
                // }
                // else {
                // sym.add(item);
                // }
                // }
            }
            // for(String item[] : list)
            // {
            // for(String i: item)
            // if(i.contains("="))
            // {
            // lit.add(i);
            // }
            // else 
            // {
            // sym.add(i);
            // }
            // }

            System.out.println("Symbol Table : ");
            for(String i : sym)
                System.out.println(i);
            System.out.println();
            System.out.println("Literal Table : ");
            for(String i : lit)
                System.out.println(i);
        }

        // String res[] = tokens(s,d);

        // for(String t[]:list)
        // {
        // // if(t.startsWith("="))
        // // {

        // // }
        // System.out.println(t);

        // }

        catch(Exception e)
        {
            e.printStackTrace();
        }
    } 

    static String[] tokens(String arr, String d)
    {
        return arr.split(d);
    }
}
