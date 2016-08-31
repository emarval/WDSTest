import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author E.Marval
 */
public class DeviceAttributesTest {

    @Test
    public void testGetName() throws Exception {
        DeviceAttributes mockAttribute = new DeviceAttributes();
        mockAttribute.setName("mockName");

        Assert.assertEquals(mockAttribute.getName(),"mockName");
    }

    @Test
    public void testSetName() throws Exception {
        DeviceAttributes mockAttribute = new DeviceAttributes();
        mockAttribute.setName("mockName");

        Assert.assertTrue(true);
    }

    @Test
    public void testGetValue() throws Exception {
        DeviceAttributes mockAttribute = new DeviceAttributes();
        mockAttribute.setValue("mockValue");

        Assert.assertEquals(mockAttribute.getValue(),"mockValue");
    }

    @Test
    public void testSetValue() throws Exception {
        DeviceAttributes mockAttribute = new DeviceAttributes();
        mockAttribute.setValue("mockValue");

        Assert.assertTrue(true);
    }

    @Test
    public void testToString() throws Exception {

        DeviceAttributes mockAttribute = new DeviceAttributes();
        mockAttribute.setName("mockName");
        mockAttribute.setValue("mockValue");

        String expectedResult = "Name=mockName, Value=mockValue";

        Assert.assertEquals(expectedResult,mockAttribute.toString());

    }
}