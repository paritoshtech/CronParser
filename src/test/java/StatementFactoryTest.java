import java.io.IOException;
import java.util.Arrays;

public class StatementFactoryTest {

    public static  void main(String[] argv) {
        System.out.println("Starting Parser " + Arrays.toString(argv));

        try {
            Statement statement = StatementFactory.getStatementFromArg("*/15 0 1,15 * 1-5 /home/user");
            statement.print();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
