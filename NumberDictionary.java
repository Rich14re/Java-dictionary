import java.io.File;

public class NumberDictionary extends AbstractDictionary {
    public NumberDictionary(File f) {
        super(f);
    }

    @Override
    boolean checkWord(String word) {
        return word.matches("\\d{5}");
    }
}
