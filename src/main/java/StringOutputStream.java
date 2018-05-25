import java.io.OutputStream;
import java.io.Serializable;

public class StringOutputStream extends OutputStream implements Serializable {

    private static final long serialVersionUID = 1L;

    public StringOutputStream() {

    }

    @Override
    public void write(int b)  {
        NbtController.appendConsole(String.valueOf((char)b));
    }

}