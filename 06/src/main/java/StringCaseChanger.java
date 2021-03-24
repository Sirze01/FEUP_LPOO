public class StringCaseChanger implements StringTransformer{
    @Override
    public void execute(StringDrink drink) {
        StringBuilder newText = new StringBuilder(drink.getText());
        for(int i = 0; i < newText.length(); i++){
            if(Character.isLetter(newText.charAt(i))){
                if(Character.isLowerCase(newText.charAt(i)))
                    newText.setCharAt(i, Character.toUpperCase(newText.charAt(i)));

                else
                    newText.setCharAt(i, Character.toLowerCase(newText.charAt(i)));
            }
        }
        drink.setText(newText.toString());
    }

    @Override
    public void undo(StringDrink drink) {
        execute(drink);
    }
}
