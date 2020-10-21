/**
 * Phase of an Assembler - Intermediate Code Generation
 * @author Sid
 * @version 1.0
 */
import java.io.*;
import java.util.*;
public class IntermediateCode
{
    static Map <String, String> mnemonic = new LinkedHashMap<>(); // hashMap to store mnemonic as key
    //and their opcodes as values

    static String mnemonicCheck(Set<String> set)
    {
        for(String x : set)
        {
            if(mnemonic.containsKey(x)) 
            {
                // System.out.println();
                return mnemonic.get(x);
            }
        }        
        return null;
    }

    static void mnemonic(String addr)
    {
        mnemonic.put("START","(AD,01)"+ "(C," +addr+ ")");
        mnemonic.put("END","(AD, 02)");
        mnemonic.put("LTORG","(AD, 03)");
        mnemonic.put("MOVER","(IS, 01)");
        mnemonic.put("ADD","(IS, 02)");
        mnemonic.put("MOVEM","(IS, 03)");       
        mnemonic.put("DC","(DL, 01)");
        mnemonic.put("DS","(DL, 02)");
        mnemonic.put("AREG","(RG,1)");
        mnemonic.put("BREG","(RG,2)");
        mnemonic.put("CREG","(RG,3)");
    }

    public static void main(String args[])
    {       
        Scanner sc = new Scanner(System.in);
        System.out.println("File:");
        String fname = sc.nextLine();
        try 
        {
            File file = new File(fname);
            Scanner filereader = new Scanner(file);           
            Set<String> code = new LinkedHashSet<>(); // Use of HashSet to deal with Duplicates
            String addr = " ";

            while(filereader.hasNextLine()) // Line by Line iteration through the file
            {
                // StringTokenizer str = new StringTokenizer(filereader.nextLine());
                String data = filereader.nextLine();
                if(data.startsWith("START"))
                {
                    addr = data.split(" ")[1];
                    mnemonic(addr);
                }               
            } 

            Scanner filereader1 = new Scanner(file); 
            while(filereader1.hasNextLine())
            {                
                String data = filereader1.nextLine();
                for(String i: mnemonic.keySet())
                {
                    if(data.contains(i))
                    {
                        System.out.println(data+" "+mnemonic.get(i));
                    }

                }

            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
