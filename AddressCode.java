/**
 * Write a description of class test1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class AddressCode
{
    static Set<Character> opr = new LinkedHashSet<Character>();

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in); 
        String exp=null, t1=null,t2=null,t3=null;
        char op = ' ';
        int c=0;
        System.out.println("Expression: ");
        String s = sc.nextLine();//'*','/','+','-'
        opr.add('*');
        opr.add('/');
        opr.add('+');
        opr.add('-');
        int flag = 111, l=0;
        char t=' ';
        String a,b; 
        for(char i: s.toCharArray())
        { 
            l++;
            //char j = s.charAt(l+1);
            if(i == '=')
            {
                t3 = s.split("=")[0];
                exp = s.split("=")[1];  
                s = exp;
            }

            else if(opr.contains(i))
            {
                op = i; 
                c++;
                if(flag ==111)
                {
                    a = Character.toString(exp.charAt((exp.indexOf(op)-1)));
                    b = Character.toString(exp.charAt((exp.indexOf(op)+1)));
                    if(c==1){
                        t1 = a+""+op+""+b;
                        flag = 0;
                    }
                    continue;
                }

                if(flag == 0 && c==2)
                {
                    flag = 1;   
                    t = op;
                    // a = Character.toString(s.charAt((s.indexOf(op)-1)));
                    b = Character.toString(s.charAt((s.indexOf(op)+1)));                    
                    t2 = "t1"+op+""+s.charAt(s.length()-1);   
                    op = i;
                    //t2 = "t1"+b;                    
                }
                if(c==2 || flag != 0)
                {                
                    //t = op;                    
                    
                }
                if(c==3)
                {
                    a = Character.toString(exp.charAt((exp.indexOf(op)-1)));
                    b = Character.toString(exp.charAt((exp.indexOf(op)+1)));
                    t2 = a+""+op+""+b; 
                    t3 = "t1"+t+"t2";
                }
            }

            // else if(flag == 0)
            // {
            // String a = Character.toString(exp.charAt(exp.indexOf(i))-1);
            // String b = Character.toString(exp.charAt(exp.indexOf(i))+1);
            // t1 = a+op+b;
            // flag = 1;
            // }
            // else if(flag == 1)
            // {
            // String a = Character.toString(s.charAt(s.indexOf(op)-1));
            // String b = Character.toString(s.charAt(s.indexOf(op)+1));
            // t2 = a+op+b;
            // }
            //else continue;
        }
        System.out.println("t1 = "+t1);
        System.out.println("t2 = "+t2);
        System.out.println("t3 = "+t3);
    }
}
