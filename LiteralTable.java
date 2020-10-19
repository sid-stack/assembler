/**
 * Literal Table generation of a Two-pass-Assembler.
 * @author Github: Sid-Stack
 * @version 2.1
 */
import java.io.*;
import java.util.*;
class LiteralTable
{
    static List <Integer> opcount = new ArrayList<>();
    static void optable(int count, int print)
    {

        if (count>0)
        {
            opcount.add(count);
        }

        else if(count == 0 && print == 1)                    // Printing the Optable
        {   
            System.out.println("\nOPTABLE:"); 
            for(int item : opcount)
            {
                System.out.println("#"+item);
            }
        }
    }

    static void Literal_Table(String fn)
    {
        List<String> lit = new ArrayList<>();
        List<Integer> address = new ArrayList<>();
        int start = 0;
        int lc = 0;
        try{
            File file = new File(fn);
            Scanner fh = new Scanner(file);        
            int c = 0;
            while(fh.hasNextLine())
            {
                String data = fh.nextLine();
                // start = Integer.valueOf(data.substring(data.indexOf("START ")));
                if(data.contains("START"))
                {
                    start = Integer.valueOf(data.split(" ")[1]);
                    lc = start;
                    break;
                }            
            }

            while(fh.hasNextLine())
            {            
                String line = fh.nextLine();
                if(line.contains("=")) 
                {
                    c++;
                    lit.add(line.substring(line.indexOf("=")));
                    lc++;
                }
                else if(line.contains("LTORG")){
                    int temp = lc;
                    optable(c, 0);
                    for(int i = 0; i<c; i++)
                    {    
                        address.add(temp);
                        temp++;
                    }
                    lc++; 
                    c = 0;                
                }
                else if(line.contains("END")){
                    int temp = lc;
                    for(int i = 0; i<c; i++)
                    {    
                        address.add(temp);
                        temp++;
                    }
                    lc++;  
                    optable(c, 0);
                    c = 0;
                    break;                
                }
                else{ lc++; }            
            }       
                System.out.println("\nLITERAL TABLE");
            for(int i = 0; i<address.size(); i++)
            {             
                System.out.println(lit.get(i) +" "+ address.get(i));
            }
            //System.out.println(lit.size()==address.size());
        }
        catch(Exception e)
        {  e.printStackTrace(); }
    } 

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("File:");
        String file = sc.nextLine();
        Literal_Table(file);  
        optable(0, 1);
    }
}