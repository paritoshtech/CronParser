public class Month extends KeyValuePair implements Printable {
    public Month(String s) {
        label="month";
        value=s;
    }

    @Override
    public void print() {
        printlabel(label);
        System.out.println("Breakup");
    }
}
