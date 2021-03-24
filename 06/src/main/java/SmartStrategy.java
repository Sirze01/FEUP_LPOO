import java.util.ArrayList;

public class SmartStrategy implements OrderingStrategy {
    private boolean isHappyHour;
    private StringDrink drinkToPrepare;
    private StringRecipe recipeToPrepare;

    SmartStrategy(){
        this.isHappyHour = false;
    }

    @Override
    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar) {
        this.drinkToPrepare = drink;
        this.recipeToPrepare = recipe;
        if(bar.isHappyHour()){
            bar.order(drink, recipe);
        }
    }

    @Override
    public void happyHourStarted(StringBar bar) {
        bar.order(this.drinkToPrepare, this.recipeToPrepare);
    }

    @Override
    public void happyHourEnded(Bar bar) {
    }
}
