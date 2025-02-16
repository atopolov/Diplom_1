package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class IngredientTypeTest {

    @Test
    public void countValues() {
        assertEquals(2, IngredientType.values().length);
    }

    @Test
    public void sauceValueOf() {
        assertEquals(IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
    }

    @Test
    public void fillingValueOf() {
        assertEquals(IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }
}