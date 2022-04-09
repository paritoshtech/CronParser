import java.io.IOException;
import java.util.Arrays;

public class StatementFactoryTest {

    public static  void main(String[] argv) {
        System.out.println("Starting Parser " + Arrays.toString(argv));

        try {
            Statement statement = StatementFactory.getStatementFromArg("1,12,14 0 1,15 * 1-15 /home/user");
            statement.print();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
