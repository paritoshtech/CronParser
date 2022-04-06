import java.io.IOException;
import java.util.Arrays;

public class CronParser {
    public static  void main(String[] argv)
    {
        System.out.println("Starting Parser "+ Arrays.toString(argv));


        try {
            System.out.println("Creating the statement object ");

            Statement statement = StatementFactory.getStatementFromArg(argv[0]);
            System.out.println("Created the statement");
            statement.print();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
