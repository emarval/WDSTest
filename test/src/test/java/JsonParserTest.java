import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author E.Marval
 */
public class JsonParserTest {

    /**Starting
     * getAllDevices Method Test
     * */

    @Test(expected = AssertionError.class)
    public final void testwhenFileDoesNotExistGetAllDevicesThrowsAssertionError(){
        DevicesLib.getAllDevices("devicees.json");
    }

    @Test
    public final void testwhenFileExistsNoExceptionShouldBeThrown(){
        DevicesLib.getAllDevices("devices-test.json");
        Assert.assertTrue(true);
    }

    @Test(expected = AssertionError.class)
    public final void testwhenFilaNameNullInGetAllDevicesAssertionErrorBeThrown(){
        DevicesLib.getAllDevices(null);
        Assert.assertTrue(true);
    }
    /**Finished getAllDevices Test*/

    /**
     * Starting getDeviceFullName Method Test
     * */

    @Test
    public final void testgetDeviceFullName(){
        Device mockDevice = new Device();
        mockDevice.setBrand("mockBrand");
        mockDevice.setModel("mockModel");
        mockDevice.setFormFactor("mockFormFactor");
        mockDevice.setAttributes(null);

        Assert.assertEquals(DevicesLib.getDeviceFullName(mockDevice),mockDevice.getBrand() + " " + mockDevice.getModel());
    }
    /**Finished getDeviceFullName Test*/

    /**
     * Starting validateDevice Method Test
     * */
    @Test
    public final void testvalidateDeviceShouldReturnFalseWhenNoModelAttributeInJson(){
        Device mockDevice = new Device();
        mockDevice.setBrand("mockBrand");
        mockDevice.setFormFactor("SMARTPHONE");
        mockDevice.setAttributes(null);

        Assert.assertFalse(DevicesLib.validateDevice(mockDevice));
    }
    @Test
    public final void testValidateDeviceShouldReturnFalseWhenNoBrandAttributeInJson(){
        Device mockDevice = new Device();
        mockDevice.setModel("mockModel");
        mockDevice.setFormFactor("SMARTPHONE");
        mockDevice.setAttributes(null);

        Assert.assertFalse(DevicesLib.validateDevice(mockDevice));
    }

    @Test
    public final void testValidateDeviceShouldReturnFalseWhenNoFormFactorAttributeInJson(){
        Device mockDevice = new Device();
        mockDevice.setBrand("mockBrand");
        mockDevice.setModel("mockModel");
        mockDevice.setAttributes(null);

        Assert.assertFalse(DevicesLib.validateDevice(mockDevice));
    }

    @Test
    public final void testValidateDeviceShouldReturnFalseWhenFormFactorNotValidString(){
        Device mockDevice = new Device();
        mockDevice.setBrand("mockBrand");
        mockDevice.setModel("mockModel");
        mockDevice.setFormFactor("mockFormFactor");
        mockDevice.setAttributes(null);

        Assert.assertFalse(DevicesLib.validateDevice(mockDevice));
    }

    @Test
    public final void testValidateDeviceShouldReturnFalseWhenModelLengthGreaterThanFifty(){
        Device mockDevice = new Device();
        mockDevice.setBrand("mockBrand");
        mockDevice.setModel("This String For Sure Has MOre Than Fifty Characters");
        mockDevice.setFormFactor("CANDYBAR");
        mockDevice.setAttributes(null);

        Assert.assertFalse(DevicesLib.validateDevice(mockDevice));
    }
    @Test
    public final void testValidateDeviceShouldReturnFalseWhenBrandLengthGreaterThanFifty(){
        Device mockDevice = new Device();
        mockDevice.setModel("mockModel");
        mockDevice.setBrand("This String For Sure Has MOre Than Fifty Characters");
        mockDevice.setFormFactor("CANDYBAR");
        mockDevice.setAttributes(null);

        Assert.assertFalse(DevicesLib.validateDevice(mockDevice));
    }
    @Test
    public final void testValidateDeviceShouldReturnTrueWhenAttributesAreValid(){
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

        Assert.assertTrue(DevicesLib.validateDevice(mockDevice));
    }

    @Test
    public final void testValidateDeviceShouldReturnTrueWhenNameInAttributesGreaterThanTwenty(){
        Device mockDevice = new Device();
        mockDevice.setModel("mockModel");
        mockDevice.setBrand("mockBrand");
        mockDevice.setFormFactor("CANDYBAR");
        List<DeviceAttributes> mockAttributes = new ArrayList<DeviceAttributes>();
        DeviceAttributes mockAttribute = new DeviceAttributes();
        mockAttribute.setName("This Mock Name Has More Than 20 Characters");
        mockAttribute.setValue("mockValue");
        mockAttributes.add(mockAttribute);
        mockDevice.setAttributes(mockAttributes);

        Assert.assertFalse(DevicesLib.validateDevice(mockDevice));
    }

    @Test
    public final void testValidateDeviceShouldReturnTrueWhenValueInAttributesGreaterThanHundred(){
        Device mockDevice = new Device();
        mockDevice.setModel("mockModel");
        mockDevice.setBrand("mockBrand");
        mockDevice.setFormFactor("CANDYBAR");
        List<DeviceAttributes> mockAttributes = new ArrayList<DeviceAttributes>();
        DeviceAttributes mockAttribute = new DeviceAttributes();
        mockAttribute.setName("mockValue");
        mockAttribute.setValue("This Mock Value nees to have more than 100 characterss and I am completely sure tha Has More Than 100 Characters");
        mockAttributes.add(mockAttribute);
        mockDevice.setAttributes(mockAttributes);

        Assert.assertFalse(DevicesLib.validateDevice(mockDevice));
    }
    @Test
    public final void testValidateDeviceShouldReturnTrueWhenValuesAreValid(){
        Device mockDevice = new Device();
        mockDevice.setModel("mockModel");
        mockDevice.setBrand("mockBrand");
        mockDevice.setFormFactor("CANDYBAR");
        mockDevice.setAttributes(null);

        Assert.assertTrue(DevicesLib.validateDevice(mockDevice));
    }
    /**Finished validateDevice Test*/

    /**
     * Starting getUniqueDeviceValues Method Test
     * */
    @Test
    public final void testgetUniqueDeviceValues(){
        Device mockDevice = new Device();
        mockDevice.setModel("mockModel");
        mockDevice.setBrand("mockBrand");
        mockDevice.setFormFactor("CANDYBAR");
        mockDevice.setAttributes(null);

        Device copymockDevice = new Device();
        copymockDevice.setModel("mockModel");
        copymockDevice.setBrand("mockBrand");
        copymockDevice.setFormFactor("CANDYBAR");
        copymockDevice.setAttributes(null);

        Device mockDevice2 = new Device();
        mockDevice2.setModel("mockModel2");
        mockDevice2.setBrand("mockBrand2");
        mockDevice2.setFormFactor("CANDYBAR");
        mockDevice2.setAttributes(null);

        Device mockDevice3 = new Device();
        mockDevice3.setModel("mockModel3");
        mockDevice3.setBrand("mockBrand3");
        mockDevice3.setFormFactor("CANDYBAR");
        mockDevice3.setAttributes(null);

        List<Device> mockDevicesList1 = new ArrayList<Device>();
        List<Device> mockDevicesList2 = new ArrayList<Device>();
        List<Device> mockDevicesList3 = new ArrayList<Device>();

        mockDevicesList1.add(mockDevice);
        mockDevicesList1.add(copymockDevice);

        mockDevicesList2.add(mockDevice2);

        mockDevicesList3.add(mockDevice3);

        HashMap<String, List<Device>> mockHashMap = new HashMap<String, List<Device>>();

        mockHashMap.put("key1",mockDevicesList1);
        mockHashMap.put("key2",mockDevicesList2);
        mockHashMap.put("key3",mockDevicesList3);

        Assert.assertTrue(DevicesLib.getUniqueDeviceValues(mockHashMap).size() == 2);
    }

    @Test
    public final void testgetUniqueDeviceValuesShouldReturnListWithSizeZeroWhenHashMapIsNull(){


        Assert.assertTrue(DevicesLib.getUniqueDeviceValues(null).size() == 0);
    }

    /**Finished getUniqueDeviceValues Test*/

    /**
     * Starting getDeviceByBrand Method Test
     * */
    @Test
    public final void testgetDeviceByBrandShouldReturnListWithSizeZeroWhenBrandIsNull(){


        Assert.assertTrue(DevicesLib.getDeviceByBrand("devices-test.json",null).size() == 0);
    }

    @Test(expected = AssertionError.class)
    public final void testgetDeviceByBrandShouldReturnAssertionErrorWhenFileDoesNotExist(){


        Assert.assertTrue(DevicesLib.getDeviceByBrand("nothing",null).size() == 0);
    }
    /**Finished getDeviceByBrand Test*/

    /**
     * Starting getDeviceByModel Method Test
     * */
    @Test
    public final void testGetDeviceByModelShouldReturnListWithSizeZeroWhenBrandIsNull(){


        Assert.assertTrue(DevicesLib.getDeviceByModel("devices-test.json",null).size() == 0);
    }

    @Test(expected = AssertionError.class)
    public final void testGetDeviceByModelShouldReturnAssertionErrorWhenFileDoesNotExist(){


        Assert.assertTrue(DevicesLib.getDeviceByModel("nothing",null).size() == 0);
    }
    /**Finished getDeviceByModel Test*/




//    @Test(expected = NullPointerException.class)
//    public final void whenFileDoesNotExistGetAllDevicesThrowsNoSuchFileException(){
//        DevicesLib.getAllDevices("devicees.json");
//    }
}
