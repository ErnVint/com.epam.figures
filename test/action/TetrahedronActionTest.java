package action;

import entity.Point;
import entity.Tetrahedron;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TetrahedronActionTest {
    static TetrahedronAction tetrahedronAction = new TetrahedronAction();

    @Parameters({"tetrahedron", "expected"})
    @Test(description = "Volume calculation test", dataProvider = "dataForCalculation")
    public void testCalculateVolume(Tetrahedron tetrahedron, double expected) {
        double volume = tetrahedronAction.calculateVolume(tetrahedron);
        Assert.assertEquals(volume, expected);
    }

    @DataProvider
    public Object[][] dataForCalculation() {
            return new Object[][]{
                    {new Tetrahedron(new Point(0, 0, 0), new Point(1, 0, 0), new Point(0.5, Math.sqrt(3)/2, 0), new Point(0.5, Math.sqrt(3)/6, Math.sqrt(6)/3)), 0.11785113019775793},
                    {new Tetrahedron(new Point(1, 1, 1), new Point(-1, -1, 1), new Point(-1, 1, -1), new Point(1, -1, -1)), 2.6666666666666674},
                    {new Tetrahedron(new Point(1, 0, 1), new Point(-1, -2, 1), new Point(-1, 0, -1), new Point(1, -2, -1)), 2.6666666666666674}

            };
    }

    @Parameters({"tetrahedron", "expected"})
    @Test(description = "Square calculation test", dataProvider = "dataForSquareCalculation")
    public void testCalculateSquare(Tetrahedron tetrahedron, double expected) {
        double volume = tetrahedronAction.calculateSquare(tetrahedron);
        Assert.assertEquals(volume, expected);
    }

    @DataProvider
    public Object[][] dataForSquareCalculation() {
        return new Object[][]{
                {new Tetrahedron(new Point(0, 0, 0), new Point(1, 0, 0), new Point(0.5, Math.sqrt(3)/2, 0), new Point(0.5, Math.sqrt(3)/6, Math.sqrt(6)/3)), 1.7320508075688772},
                {new Tetrahedron(new Point(1, 1, 1), new Point(-1, -1, 1), new Point(-1, 1, -1), new Point(1, -1, -1)), 13.856406460551021},
                {new Tetrahedron(new Point(1, 0, 1), new Point(-1, -2, 1), new Point(-1, 0, -1), new Point(1, -2, -1)), 13.856406460551021}
        };
    }
    @Parameters({"tetrahedron"})
    @Test(description = "is Tetrahedron", dataProvider = "dataIsTetrahedron")
    public void testIsTetrahedron(Tetrahedron tetrahedron) {
        boolean volume = tetrahedronAction.isTetrahedron(tetrahedron);
        Assert.assertTrue(volume);
    }

    @DataProvider
    public Object[][] dataIsTetrahedron() {
        return new Object[][]{
                {new Tetrahedron(new Point(0, 0, 0), new Point(1, 0, 0), new Point(0.5, Math.sqrt(3)/2, 0), new Point(0.5, Math.sqrt(3)/6, Math.sqrt(6)/3))},
                {new Tetrahedron(new Point(1, 1, 1), new Point(-1, -1, 1), new Point(-1, 1, -1), new Point(1, -1, -1))},
                {new Tetrahedron(new Point(1, 0, 1), new Point(-1, -2, 1), new Point(-1, 0, -1), new Point(1, -2, -1))}

        };
    }

    @Test
    public void testCalculateDistanceViaHypot() {
    }

}