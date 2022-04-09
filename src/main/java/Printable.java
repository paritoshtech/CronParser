import java.io.IOException;

public interface Printable {
    final int KEY_BUFFER=Constants.KEY_BUFFER;
    void print() throws IOException;
    default void printlabel(String label){
        System.out.printf("%"+(-1*KEY_BUFFER)+"s",label);

    }

}
