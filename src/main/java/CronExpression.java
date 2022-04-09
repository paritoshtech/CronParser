import lombok.Getter;
import lombok.Setter;

import java.io.IOException;

@Getter
@Setter
public class CronExpression  implements Printable{
    Minute minute;
    Hour hour;
    DayOfMonth dayOfMonth;
    Month month;
    DayOfWeek dayOfWeek;

    @Override
    public void print() throws IOException {
        minute.print();
        hour.print();
        dayOfMonth.print();
        month.print();
        dayOfWeek.print();

    }
}
