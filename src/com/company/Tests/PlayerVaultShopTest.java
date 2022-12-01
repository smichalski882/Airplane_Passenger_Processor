package com.company.Tests;
import com.company.Diamond;
import com.company.Player;
import com.company.Shop;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerVaultShopTest {
    Player david = new Player("David");
    Player dan = new Player("Dan");
    Diamond diamond1 = new Diamond();
    Diamond diamond2 = new Diamond();

    @Test
    public void testConvertDiamonds(){
        david.getVault().addDiamond(diamond1);
        david.getVault().addDiamond(diamond2);

        //ASSERT THE DIAMOND LIST IS NOT EMPTY
        assertTrue(!david.getVault().getDiamonds().isEmpty());

        //Assert the diamonds have been transferred into the correct amount of points
        david.getVault().convertDiamondToPoints();
        assertTrue(david.getVault().getPoints() == 2000);

        //Assert that the diamonds are removed after being converted to points
        assertTrue(david.getVault().getDiamonds().isEmpty());
    }

    /**
     * Tests the cart methods, the map creation, add function, subtract function
     */
    @Test
    public void testCart(){
        david.getVault().getShop().addToCart(Shop.Merchandise.AGENT);
        david.getVault().getShop().addToCart(Shop.Merchandise.AUTOMATED_COUNTER);
        david.getVault().getShop().addToCart(Shop.Merchandise.SUPERVISOR);

        //Assert the value of the cart is expected
        assertEquals(2500, david.getVault().getShop().computeCartPrice());

        //Assert the funds are sufficient to buy the cart materials
        david.getVault().addToPoints(3000);
        assertTrue(david.getVault().canAffordCart(david.getVault().getShop()));

        //Assert that the cart is successfully checked out
        assertTrue(david.getVault().checkOutCart(david.getVault().getShop()));

        //Assert that david's points are now 500
        assertTrue(david.getVault().getPoints() == 500);

        //Assert that david has items in the lists added to, not the list not added to
        assertFalse(david.getVault().getAgents().isEmpty());
        assertFalse(david.getVault().getAutomatedLines().isEmpty());
        assertFalse(david.getVault().getSupervisors().isEmpty());
        assertTrue(david.getVault().getInPersonLines().isEmpty());

        //Assert that the cart is now empty
        assertTrue(david.getVault().getShop().getCart().isEmpty());

        david.getVault().getShop().addToCart(Shop.Merchandise.AGENT);
        david.getVault().getShop().addToCart(Shop.Merchandise.AUTOMATED_COUNTER);
        david.getVault().getShop().addToCart(Shop.Merchandise.SUPERVISOR);

        //Assert that david is a student and blew all his money away and can now not afford his merchandise
        assertFalse(david.getVault().checkOutCart(david.getVault().getShop()));
    }
}
