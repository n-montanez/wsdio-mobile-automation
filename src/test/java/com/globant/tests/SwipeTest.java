package com.globant.tests;

import com.globant.base.MobileBaseTest;
import com.globant.screens.Navbar;
import com.globant.screens.SwipeScreen;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SwipeTest extends MobileBaseTest {

    private SwipeScreen swipeScreen;

    /**
     * Precondition: the user should be at the Swipe screen
     */
    @BeforeMethod
    public void goToSwipe() {
        Navbar navbar = new Navbar(driver);
        swipeScreen = navbar.goToSwipe();
    }

    /**
     * Checks that swipe reveals new cards and old cards are hidden
     * Indexes shown in lists are those of expected cards to be visible
     */
    @Test(testName = "Swipe cards horizontally")
    public void swipeCardsHorizontally() {
        Assert.assertTrue(swipeScreen.areAllElementsVisible());
        Assert.assertEquals(swipeScreen.getVisibleCards(), List.of(0, 1));
        swipeScreen.swipeCard();
        Assert.assertEquals(swipeScreen.getVisibleCards(), List.of(1, 2));
        swipeScreen.swipeCard();
        Assert.assertEquals(swipeScreen.getVisibleCards(), List.of(2, 3));
        swipeScreen.swipeCard();
        Assert.assertEquals(swipeScreen.getVisibleCards(), List.of(3, 4));
        swipeScreen.swipeCard();
        Assert.assertEquals(swipeScreen.getVisibleCards(), List.of(4, 5));
    }

    /**
     * Swipes vertically to screen bottom and checks the target robot element
     */
    @Test(testName = "Swipe vertically to find robot")
    public void findRobot() {
        Assert.assertTrue(swipeScreen.areAllElementsVisible());
        swipeScreen.swipeDown();
        Assert.assertTrue(swipeScreen.wasRobotFound());
        Assert.assertEquals(swipeScreen.getLabelRobot(), "You found me!!!");
    }
}
