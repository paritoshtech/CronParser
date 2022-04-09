import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Minute extends KeyValuePair implements Printable {

    int start;
    int end;
    Minute(String s)
    {
        label="minute";
        value=s;
        start=1;
        end=60;
        String []  delimiters= new String[]{"*","/","-",","};



    }
    public void print() throws IOException {
        printlabel(label);
        if(value.equals("*"))
                for(int i =start; i <=end;i++)
                    System.out.print(i+" ");
        else if(Pattern.matches("\\d+", value))
            System.out.print(value);

        else if(Pattern.matches("\\d+(,\\d+)+", value))
        {
            String [] splitStr =  value.split(",");
            System.out.print(Arrays.toString(splitStr));
        }
        else if(Pattern.matches("\\*/\\d+", value))
        {
            String [] splitStr =  value.split("/");
            int multiple=Integer.parseInt(splitStr[1]);
            for(int i =0 ; i<=end;i=i+multiple)
                System.out.print(i+" ");





        }
        else if(Pattern.matches("\\d+-\\d+", value))
        {
            String [] splitStr =  value.split("-");
            start=Integer.parseInt(splitStr[0]);
            end=Integer.parseInt(splitStr[1]);
            for(int i =start; i <=end;i++)
                System.out.print(i+" ");
        }
        else
            throw new IOException("Wrong Format for  "+label );

        System.out.println("");

    }
}
