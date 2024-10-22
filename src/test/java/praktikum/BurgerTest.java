package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static praktikum.constants.Delta.DELTA;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredientFiling, ingredientSauce;


    @Before
    public void setUp() {

        when(bun.getName()).thenReturn("Simple bun");
        when(bun.getPrice()).thenReturn(2.25f);

        when(ingredientFiling.getPrice()).thenReturn(0.55f);
        when(ingredientFiling.getName()).thenReturn("cutlet");
        when(ingredientFiling.getType()).thenReturn(IngredientType.FILLING);


        when(ingredientSauce.getPrice()).thenReturn(0.45f);
        when(ingredientSauce.getName()).thenReturn("smetana");
        when(ingredientSauce.getType()).thenReturn(IngredientType.SAUCE);

        burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredientFiling);
        burger.addIngredient(ingredientSauce);
    }

    @Test
    public void setBuns() {
        assertSame(bun, burger.bun);
    }

    @Test
    public void addIngredient() {
        int expectedSize = 2;
        assertEquals(expectedSize, burger.ingredients.size());
    }

    @Test
    public void removeIngredient() {
        burger.removeIngredient(1);
        int expectedSize = 1;
        assertEquals(expectedSize, burger.ingredients.size());
    }

    @Test
    public void moveIngredient() {
        burger.moveIngredient(0, 1);
        int expectedIndex = 1;
        assertEquals(expectedIndex, burger.ingredients.indexOf(ingredientFiling));
    }

    @Test
    public void verifyBurgerCompositionPrice() {
        burger.getPrice();
        verify(bun).getPrice();
        verify(ingredientSauce).getPrice();
        verify(ingredientFiling).getPrice();
    }

    @Test
    public void getCorrectBurgerPrice() {
        float expectedBurgerPrice = (bun.getPrice() * 2) + ingredientSauce.getPrice() + ingredientFiling.getPrice();
        assertEquals(expectedBurgerPrice, burger.getPrice(), DELTA);
    }

    @Test
    public void getBurgerReceipt() {
        String burgerReceipt = burger.getReceipt();
        String expectedBurgerReceipt = "(==== Simple bun ====)\r\n= filling cutlet =\r\n= sauce smetana =\r\n(==== Simple bun ====)\r\n\r\nPrice: 5,500000\r\n";
        assertEquals(expectedBurgerReceipt, burgerReceipt);
    }
}