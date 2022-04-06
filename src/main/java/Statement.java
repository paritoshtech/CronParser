import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Statement implements Printable{
    Command command;
    CronExpression cronExpression;


    @Override
    public void print() {
        cronExpression.print();
        command.print();
    }
}
