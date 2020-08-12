import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


@SuppressWarnings("ALL")
public class pointTest {


    /** Fixture initialization (common initialization
     *  for all tests). **/
    @Before public void setUp() {
    }


    /** A test that always fails. **/
    @Test public void test1() {
        Assert.assertEquals("Default test added by jGRASP. Delete "
                + "this test once you have added your own.", 1, 1);
    }
}
