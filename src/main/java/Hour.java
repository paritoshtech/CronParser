public class Hour extends KeyValuePair implements Printable {
    public Hour(String s) {
        label="hour";
        value=s;

    }

    @Override
    public void print() {
        printlabel(label);
        System.out.println("Breakup");
    }
}
