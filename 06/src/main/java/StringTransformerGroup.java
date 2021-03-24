import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class StringTransformerGroup implements StringTransformer{
    List<StringTransformer> transformers;

    StringTransformerGroup(List<StringTransformer> transformers) {
        this.transformers = transformers;
    }

    public void execute(StringDrink drink) {
        for (StringTransformer transformer : transformers)
            transformer.execute(drink);
    }

    public void undo(StringDrink drink) {
        Collections.reverse(transformers);

        for (StringTransformer transformer : transformers)
            transformer.undo(drink);

        Collections.reverse(transformers);
    }
}
