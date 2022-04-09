import lombok.Getter;
import lombok.Setter;

import java.io.IOException;

@Getter
@Setter
public class Statement implements Printable{
    Command command;
    CronExpression cronExpression;


    @Override
    public void print() throws IOException {
        cronExpression.print();
        command.print();
    }
}
