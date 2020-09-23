/**
 * Write a description of class Tokenizer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
import java.io.*;
public class Tokenizer
{
    public static void main(String args[])
    {
        List <String> list = new ArrayList<String>();
        List <String> lit = new ArrayList<String>();
        List <String> sym  = new ArrayList<String>();
        String symbols[] = {"START","LOOP","LTORG","A","B","ADD","MOVEM"};
        String s = "This is Java";
        String d =" ";
        // StringTokenizer str = new StringTokenizer(s,d);
        // while (str.hasMoreTokens()) 
        // {  
        // System.out.println(str.nextToken()); 
        // } 
        try 
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter file name:");
            String filename = sc.nextLine();
            filename = "abc.txt";
            File file = new File(filename);
            Scanner fileReader = new Scanner(file);
            int dc = 0;
            while (fileReader.hasNextLine()) 
            {
                String data = fileReader.nextLine();
                list.add(data);
                if(data.contains("START"))
                {
                    dc = Integer.valueOf(tokens(data," ")[1]);
                                    }
                if(data.contains("="))
                {
                    String l = data.substring(data.indexOf('='));
                    lit.add(l);
                }
                else {
                    for(String l : symbols)
                    {
                        if(data.contains(l))
                            if(!sym.contains(l))
                            {sym.add(l);}
                    }
                }

            }
            System.out.println(dc+"\n");
            System.out.println("List : ");
                print_list(list,dc);
            // for(String a : list)
            // {
                // System.out.println(a);
            // }
            System.out.println();
            System.out.println("Symbol Table : ");
            for(String i : sym)
                System.out.println(i);
            System.out.println();
            System.out.println("Literal Table : ");
            for(String i : lit)
                System.out.println(i);
        }

        catch(Exception e)
        {
            e.printStackTrace();
        }       
    } 

    static String[] tokens(String arr, String d)
    {
        return arr.split(d);
    }

    static void print_list(List <String> list, int dc)
    {
        int flag = 0;
        for(String i : list)
        {
            if(i.contains("START"))
            {
                System.out.println(i);
                dc++;
            }

            else if(i.contains("LTORG"))
            {
                flag = 1;
                System.out.println(i+"\t"+dc);
                dc++;
            }

            else if(i.contains("="))
            {
                if(flag == 1)
                {
                    System.out.println(i+"\t"+dc);
                    dc++;
                }
                else{
                    System.out.println(i);
                }
            }
            else{
                    System.out.println(i+"\t"+dc);
                    dc++;
                }
                
          
        }        
    }
}

