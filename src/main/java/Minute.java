import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Minute extends KeyValuePair implements Printable {

    Minute(String s)
    {
        label="minute";
        value=s;
        String []  delimiters= new String[]{"*","/","-",","};


    }
    public void print()
    {
        printlabel(label);
        if(value.equals("*"))
        {
//            Print 1 to 60 with space;
            for(int i =1; i <=60;i++)
                System.out.print(i+" ");

    }
        else
        {

            Matcher rangeMatcher =Pattern.compile("\\.-\\.").matcher(value);
            if(rangeMatcher.find())
            {

            }

        }

    }
}
