import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.*;
import java.util.*;
import static org.junit.Assert.assertNotNull;

/**
 *
 * @author E.Marval
 */
public class DevicesLib {

    /**Method to get a list of all the Devices from a Json File**/
    public static List<Device> getAllDevices(String filename){

        List<Device> deviceList = null;
        try{

            File jsonData = new File(DevicesLib.class.getResource(filename).getPath());

            ObjectMapper objectMapper = new ObjectMapper();

             deviceList = objectMapper.readValue(jsonData,
                    TypeFactory.defaultInstance().constructCollectionType(List.class,
                            Device.class));
          }catch(Exception e){
            e.printStackTrace();
        }
        assertNotNull(deviceList);

        return deviceList;
    }
    /**Method to get the Full Name of a Device (BRAND + MODEL) with an space in between**/
    public static String getDeviceFullName(Device device){

        return (device.getBrand() + " " + device.getModel());
    }

    /**Method to get the list of all the Devices filtered by the Full Name provided (BRAND + MODEL) **/
    public static List<Device> getDevicesByFullName(String filename, String fullName){

        List<Device> allDevices = getAllDevices((filename));

        ArrayList<Device> filteredList = new ArrayList<Device>() ;

        for (Device device:allDevices
             ) {
            if(getDeviceFullName(device).equals(fullName)){
                filteredList.add(device);
            }
        }
        return filteredList;
    }

    /**Method to validate a Device based on the criteria required for Story 3**/
    public static boolean validateDevice(Device device){

        try{
            if(device.getModel() != null){
                if(device.getBrand() != null){
                    if(device.getFormFactor() != null){
                        if( (device.getModel().length()<= 50) &&
                                (device.getBrand().length() <= 50)
                                ){
                            if( (device.getFormFactor().equals("CANDYBAR")) ||
                                    (device.getFormFactor().equals("SMARTPHONE")) ||
                                    (device.getFormFactor().equals("PHABLET")) ||
                                    (device.getFormFactor().equals("CLAMSHELL")) ){

                                if(device.getAttributes() != null){
                                    for(DeviceAttributes attributes: device.getAttributes()){
                                        if( (attributes.getName().length()>20) || (attributes.getValue().length()>100)){
                                            return false;
                                        }
                                    }
                                }
                                return true;
                            }
                        }
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    /**Method to get the list with the Unique Devices in the hashmap
     * and print in the console if a Device is Repeated**/
    public static List<Device> getUniqueDeviceValues(HashMap<String,List<Device>> deviceMap){

        ArrayList<Device> filteredList = new ArrayList<Device>();

        if(deviceMap != null){
            for (Map.Entry<String,List<Device>> mapEntry:deviceMap.entrySet()
                    ) {
                if(mapEntry.getValue().size() == 1){
                    filteredList.add(mapEntry.getValue().get(0));
                }
                else{
                    System.err.println("\n**********The following devices are not unique********** \n" + mapEntry.getValue());
                }
            }
        }

        return filteredList;
    }
    /**Method to get a list of all the valid Devices from a Json File following all the criteria from Story 3**/
    public static List<Device> getOnlyValidDevices(String filename){

        List<Device> allDevices = getAllDevices((filename));

        HashMap<String,List<Device>> devicesHashmap = new HashMap<String, List<Device>>();

        List<Device> auxList;

        for (Device device:allDevices
                ) {

            if (validateDevice(device)) {

                if (devicesHashmap.get(getDeviceFullName(device))== null) {

                    auxList = new ArrayList<Device>();

                    auxList.add(device);
                    devicesHashmap.put(getDeviceFullName(device), auxList);
                } else {
                    auxList = devicesHashmap.get(getDeviceFullName(device));
                    auxList.add(device);
                    devicesHashmap.put(getDeviceFullName(device), auxList);
                }
            }
            else{
                System.err.println("\n**********The following device is not valid********** \n" + device.toString());
            }
        }
        
        return getUniqueDeviceValues(devicesHashmap);
    }
    /**Method to get a list of the Devices from the Json File filtered by the Brand provided**/
    public static List<Device> getDeviceByBrand(String filename, String brand){

        List<Device> allDevices = getAllDevices((filename));

        ArrayList<Device> filteredList = new ArrayList<Device>();

        for (Device device:allDevices
                ) {
            if(device.getBrand() != null){
                if(device.getBrand().equals(brand)){
                    filteredList.add(device);
                }
            }
        }
        return filteredList;
    }
    /**Method to get a list of the Devices from the Json File filtered by the Model provided**/
    public static List<Device> getDeviceByModel(String filename, String model){

        List<Device> allDevices = getAllDevices((filename));

        ArrayList<Device> filteredList = new ArrayList<Device>();

        for (Device device:allDevices
                ) {
            if(device.getModel() != null){
                if(device.getModel().equals(model)){
                    filteredList.add(device);
                }
            }
        }
        return filteredList;
    }

    public static void createJsonFileFromDevicesList(List<Device> devicesList, String jsonFileName){


        String fileName = jsonFileName;

        if(fileName == null){
            fileName = "default-json-file-name.json";
        }else{
            if(!fileName.contains(".json")){
                fileName = fileName+".json";
            }
        }


        try {
            String path = System.getProperty("user.dir")+File.separator+"target"+File.separator+"output";
            File jsonFile = new File(path+File.separator +fileName);

            jsonFile.getParentFile().mkdirs();
            if (!jsonFile.exists()) {
                jsonFile.createNewFile();
            }

            FileWriter fw = new FileWriter(jsonFile.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            ObjectMapper objectMapper = new ObjectMapper();
            String arrayToJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(devicesList);
            System.out.println("1. Convert List of Devices objects to JSON :");
            System.out.println(arrayToJson);
            StringWriter sw = new StringWriter();
            sw.write(arrayToJson);
            bw.write(sw.toString());
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args){

        /**Configuration**/
        String jsonFileName = "devices-test.json";
        String fullNameToFilter = "Mockia 5800";
        String deviceBrand = "Mockia";
        String deviceModel = "5800";


        /**Story 1**/
        System.out.println("\n**********Getting all the Devices**********");
        List<Device> allDevicesList = getAllDevices(jsonFileName);
//        System.out.println(allDevicesList);
        createJsonFileFromDevicesList(allDevicesList,"story-1-all-devices");


        /**Story 2**/
        System.out.println("\n**********Getting Devices by Full Name 'Mockia 5800' **********");
        List<Device> devicesListFilteredByFullName = getDevicesByFullName(jsonFileName,fullNameToFilter);
//        System.out.println(devicesListFilteredByFullName);
        createJsonFileFromDevicesList(devicesListFilteredByFullName,"story-2-only-"+fullNameToFilter);

        /**Story 4**/
        System.out.println("\n**********Getting Devices by Model '5800' **********");
        List<Device> devicesListFilteredByModel = getDeviceByModel(jsonFileName,deviceModel);
//        System.out.println(devicesListFilteredByModel);
        createJsonFileFromDevicesList(devicesListFilteredByModel,"story-4-only-"+deviceModel+"-model-devices");

        /**Story 4**/
        System.out.println("\n**********Getting Devices by Brand 'Mockia' **********");
        List<Device> devicesListFilteredByBrand = getDeviceByBrand(jsonFileName,deviceBrand);
//        System.out.println(devicesListFilteredByBrand);
        createJsonFileFromDevicesList(devicesListFilteredByBrand,"story-4-only-"+deviceBrand+"-brand-devices");

        /**Story 3**/
        System.out.println("\n**********Getting Only Valid Devices**********");
        List<Device> devicesListFilteredByValidDevices = getOnlyValidDevices(jsonFileName);
//        System.out.println(devicesListFilteredByValidDevices);
        createJsonFileFromDevicesList(devicesListFilteredByValidDevices,"story-3-only-Valid-devices");

    }
    


}
