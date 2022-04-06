import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CronExpression  implements Printable{
    Minute minute;
    Hour hour;
    DayOfMonth dayOfMonth;
    Month month;
    DayOfWeek dayOfWeek;

    @Override
    public void print() {
        minute.print();
        hour.print();
        dayOfMonth.print();
        month.print();
        dayOfWeek.print();

    }
}
