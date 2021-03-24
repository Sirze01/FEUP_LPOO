public class StringReplacer implements StringTransformer{
    char toReplace;
    char replacement;

    StringReplacer(char toReplace, char replacement){
        this.toReplace = toReplace;
        this.replacement = replacement;
    }

    @Override
    public void execute(StringDrink drink) {
        drink.setText(drink.getText().replace(toReplace, replacement));
    }

    @Override
    public void undo(StringDrink drink) {
        drink.setText(drink.getText().replace(replacement, toReplace));
    }
}
