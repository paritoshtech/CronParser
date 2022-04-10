import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;

public class KeyValuePair {
    final int KEY_BUFFER=Constants.KEY_BUFFER;
    //    void print() throws IOException;
    default void printlabel(String label){
        System.out.printf("%"+(-1*KEY_BUFFER)+"s",label);

    }
    default void print() throws IOException {
        printlabel(label);
        if (value.equals("*"))
            for (int i = start; i <= end; i++)
                System.out.print(i + " ");
        else if (Pattern.matches("\\d+", value))
            System.out.print(value);

        else if (Pattern.matches("\\d+(,\\d+)+", value)) {
            String[] splitStr = value.split(",");
            System.out.print(Arrays.toString(splitStr));
        } else if (Pattern.matches("\\*/\\d+", value)) {
            String[] splitStr = value.split("/");
            int multiple = Integer.parseInt(splitStr[1]);
            for (int i = 0; i <= end; i = i + multiple)
                System.out.print(i + " ");


        } else if (Pattern.matches("\\d+-\\d+", value)) {
            String[] splitStr = value.split("-");
            start = Integer.parseInt(splitStr[0]);
            end = Integer.parseInt(splitStr[1]);
            for (int i = start; i <= end; i++)
                System.out.print(i + " ");
        } else
            throw new IOException("Wrong Format for  " + label);

        System.out.println("");
    }
}
