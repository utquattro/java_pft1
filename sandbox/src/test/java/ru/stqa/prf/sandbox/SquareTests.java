package ru.stqa.prf.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SquareTests {

    @Test
    public void testArea(){
        Square s = new Square(5);
        Assert.assertEquals(s.area(),25);
    }

    @Test
    public void testStorona(){
        Square m = new Square(5);
        Assert.assertNotNull(m.l);
    }
}
