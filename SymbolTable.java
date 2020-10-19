/**
 * SymbolTable
 * @author Sid
 * @version 1.0
 */

import java.util.*;
import java.util.regex.Pattern;
import java.io.*;
class SymbolTable
{
    public static void main(String args[])
    {
        
        String test = "This is Java";
        String d = " ";
        List<Integer> addr = new ArrayList<>();
        // StringTokenizer str = new StringTokenizer(s,d);
        // while (str.hasMoreTokens()) 
        // {  
        // System.out.println(str.nextToken()); 
        HashMap<Integer, String> list = new HashMap<>();
        HashMap<String, Integer> s = new HashMap<>();
        HashMap<String, Integer> sym = new HashMap<>();
        int dc = 0, ad =0;
        String keyword[] = {};
        try 
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter file name:");
            String filename = sc.nextLine();
            File file = new File(filename);
            Scanner fileReader = new Scanner(file);
            int count = 1;   
            int a = 0;
            while (fileReader.hasNextLine()) 
            {
                String data = fileReader.nextLine();
                String w = tokens(data," ")[0];
                list.put(count, data);
                count++;
                
                if(data.contains("START"))
                {
                    dc = Integer.valueOf(tokens(data," ")[1]);
                    ad = Integer.valueOf(tokens(data," ")[1]);
                    a = Integer.valueOf(tokens(data," ")[1]);
                    addr.add(ad); // Store all instances of address counter
                    //LiteralTable(filename, addr, Integer.valueOf(tokens(data," ")[1]) );
                }
                else if(w.equals("MOVER") || w.equals("MOVEM") || w.equals("BC"))
                {
                    ad++;
                    addr.add(ad);
                }
                else if(w.equals("ORIGIN"))
                {
                    String l[] = tokens(data," ");
                    String exp = l[1];
                    String label = exp.substring(0,'+');
                    String inc_by = exp.substring('+');
                    ad = s.get(label) + Integer.parseInt(inc_by); 
                    addr.add(ad);
                }
                else if(data.startsWith("ADD"))
                {
                    String str = tokens(data," ")[1];
                    ad++;
                    addr.add(ad);
                    if(str.contains(","))
                    {
                        if(str.endsWith(","))
                            str = str.substring(0, str.indexOf(","));
                        else
                            str = str.substring(str.indexOf(","), str.length());

                    }

                    if(data.contains("REG")){}
                    else
                    {
                        s.put(str, dc);
                        s.put(tokens(data," ")[2], dc);
                    }
                }

                else if(data.startsWith("LOAD"))
                {
                    sym.put(tokens(data," ")[0], ad);
                    ad++;
                    addr.add(ad);

                }

                else if(data.contains("DC") || data.contains("DS"))
                {
                    sym.put(tokens(data," ")[0], ad);
                    ad++;
                    addr.add(ad);
                    if(!(s.keySet().contains(tokens(data," ")[0])))
                        s.put(tokens(data," ")[0], dc);
                }

                else if(data.contains("LTORG") || data.contains("END"))
                {
                    ad++;
                    addr.add(ad);
                }

                else {
                    // ad++;
                    // addr.add(ad);

                    // for(String item: keyword)
                    // {
                        // String t[] = tokens(data," ");

                        // if(t.equals(item))
                        // {                           
                            // sym.put(item,ad);
                            // ad++;
                        // }
                    // }
                }
            }
            System.out.println("Address Instances");
            for(int i : addr)
                System.out.println(i);
            System.out.println("Code : ");
            for(int i : list.keySet())
            {  
                if(list.get(i).contains("START"))
                {System.out.println(i+" "+ list.get(i));}

                else
                {
                    System.out.println(i +" "+list.get(i) +" " + a);
                    a++;
                }
            }
            int c = 0;
            System.out.println("\n\nSymbol Table : ");
            for(String i : sym.keySet())
            {   
                c++;
                System.out.println(c+" "+ i +"  "+ sym.get(i));
            }

            System.out.println();
            

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
    // static void print_table(HashMap<String, Integer> hm)
    // {
    // Formatter f = new Formatter();          
    // f.format("%15s %15s %15s\n", "Index", "Symbol", "address");
    // int c = 0;
    // for(String i : hm.keySet())
    // {
    // c++;
    // f.format("%14.2s %14.2s %15.2s\n", c,i,hm.get(i));
    // }
    // }
}
