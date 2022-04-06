public class Command  extends KeyValuePair implements Printable  {




    public Command(String s) {
        value=s;
        label="command";

    }

    @Override
    public void print() {
        this.printlabel(this.label);
        System.out.println(this.value);
    }
}
