public class DayOfWeek extends KeyValuePair implements Printable {
    public DayOfWeek(String s) {
        value=s;
        label="day of week";
    }

    @Override
    public void print() {
        printlabel(label);
        System.out.println("Breakup");
    }
}
