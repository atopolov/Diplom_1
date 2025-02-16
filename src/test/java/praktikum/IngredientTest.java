package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;
import static praktikum.constants.Delta.DELTA;

@RunWith(Parameterized.class)
public class IngredientTest {

    private Ingredient ingredient;

    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {IngredientType.FILLING, "onion", 102f},
                {IngredientType.SAUCE, "oil", 50f}
        };
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void getPrice() {
        float actualPrice = ingredient.getPrice();
        assertEquals(price, actualPrice, DELTA);
    }

    @Test
    public void getName() {
        String actualName = ingredient.getName();
        assertEquals(name, actualName);
    }

    @Test
    public void getType() {
        IngredientType actualType = ingredient.getType();
        assertEquals(type, actualType);
    }
}