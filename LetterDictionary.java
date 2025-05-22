import java.io.File;
import java.util.Dictionary;

public class LetterDictionary extends AbstractDictionary {
    public LetterDictionary(File f) {
        super(f);
    }

    @Override
    boolean checkWord(String word) {
        return word.matches("[a-zA-Z]{4}");
    }
}
