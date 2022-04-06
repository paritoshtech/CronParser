public class Minute extends KeyValuePair implements Printable {
    Minute(String s)
    {
        label="minute";
        value=s;

    }
    public void print()
    {
        printlabel(label);
        System.out.println("Breakup");
    }
}
