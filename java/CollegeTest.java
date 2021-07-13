

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CollegeTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CollegeTest
{
    private College college1;

    /**
     * Default constructor for test class CollegeTest
     */
    public CollegeTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        college1 = new College(11, 111);
        college1 = new College(10, 100);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testRunCollege()
    {
        college1.runCollege(1);
    }

    @Test
    public void testRunCollege5times()
    {
        college1.runCollege(5);
    }

    @Test
    public void testAllStudentsFinish()
    {
        college1.runCollege(1000);
    }
}





