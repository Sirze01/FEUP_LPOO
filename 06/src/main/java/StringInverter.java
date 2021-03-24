public class StringInverter implements StringTransformer{
    @Override
    public void execute(StringDrink drink) {
        StringBuilder newText = new StringBuilder(drink.getText());
        drink.setText(newText.reverse().toString());
    }

    @Override
    public void undo(StringDrink drink) {
        execute(drink);
    }
}
