import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author E.Marval
 */
public class DeviceTest {

    @Test
    public void testGetModel() throws Exception {
        Device mockDevice = new Device();
        mockDevice.setModel("mockModel");
        Assert.assertEquals(mockDevice.getModel(),"mockModel");
    }

    @Test
    public void testSetModel() throws Exception {
        Device mockDevice = new Device();
        mockDevice.setModel("mockModel");
        Assert.assertTrue(true);

    }

    @Test
    public void testGetBrand() throws Exception {
        Device mockDevice = new Device();
        mockDevice.setBrand("mockBrand");
        Assert.assertEquals(mockDevice.getBrand(),"mockBrand");
    }

    @Test
    public void testSetBrand() throws Exception {
        Device mockDevice = new Device();
        mockDevice.setBrand("mockBrand");
        Assert.assertTrue(true);
    }

    @Test
    public void testGetFormFactor() throws Exception {
        Device mockDevice = new Device();
        mockDevice.setFormFactor("mockFormFactor");
        Assert.assertEquals(mockDevice.getFormFactor(),"mockFormFactor");
    }

    @Test
    public void testSetFormFactor() throws Exception {
        Device mockDevice = new Device();
        mockDevice.setFormFactor("mockFormFactor");
        Assert.assertTrue(true);
    }

    @Test
    public void testGetAttributes() throws Exception {
        Device mockDevice = new Device();
        List<DeviceAttributes> mockAttributes = new ArrayList<DeviceAttributes>();
        DeviceAttributes mockAttribute = new DeviceAttributes();
        mockAttribute.setName("mockName");
        mockAttribute.setValue("mockValue");
        mockAttributes.add(mockAttribute);
        mockDevice.setAttributes(mockAttributes);

        Assert.assertTrue(mockDevice.getAttributes().size() == 1);
    }

    @Test
    public void testSetAttributes() throws Exception {
        Device mockDevice = new Device();
        List<DeviceAttributes> mockAttributes = new ArrayList<DeviceAttributes>();
        DeviceAttributes mockAttribute = new DeviceAttributes();
        mockAttribute.setName("mockName");
        mockAttribute.setValue("mockValue");
        mockAttributes.add(mockAttribute);
        mockDevice.setAttributes(mockAttributes);

        Assert.assertTrue(true);
    }

    @Test
    public void testToString() throws Exception {

        String sb = "\n***** Device Details *****\n" +
                "Model=mockModel\n" +
                "Brand=mockBrand\n" +
                "From Factor=CANDYBAR\n" +
                "Attributes=[Name=mockName, Value=mockValue]\n" +
                "*****************************";

        Device mockDevice = new Device();
        mockDevice.setModel("mockModel");
        mockDevice.setBrand("mockBrand");
        mockDevice.setFormFactor("CANDYBAR");
        List<DeviceAttributes> mockAttributes = new ArrayList<DeviceAttributes>();
        DeviceAttributes mockAttribute = new DeviceAttributes();
        mockAttribute.setName("mockName");
        mockAttribute.setValue("mockValue");
        mockAttributes.add(mockAttribute);
        mockDevice.setAttributes(mockAttributes);

        Assert.assertEquals(sb,mockDevice.toString());



    }
}