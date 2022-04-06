public class DayOfMonth extends KeyValuePair implements Printable {
    public DayOfMonth(String s) {
        label="day of month";
        value=s;
    }

    @Override
    public void print() {

        printlabel(label);
        System.out.println("Breakup");
    }
}
