# WDSTest
WDS Remote Code Challenge Solution

To run the Solution to the challenge you need to run the main method in the DevicesLib class, this will read from the Resources folder and is going to process the Json file.

In the Solution we have all of the Stories solved (with the correct label attached to them).

The main method is going to run the following methods:

* getAllDevices: This method will return a list with all the Devices Objects from the Json File

* devicesListFilteredByFullName: This method will return a list with the Devices Objects filtered by Full Name (Brand + Model) from the Json File

* getDeviceByModel = This method will return a list with the Devices Objects filtered by  Model from the Json File

* getDeviceByBrand = This method will return a list with the Devices Objects filtered by Brand from the Json File

* getOnlyValidDevices = This method will return a list with the Valid Devices Objects from the Json File

Side Note:

To check that the methods are working correctly we have a method called createJsonFileFromDevicesList which will generate a Json File from a List of Devices Objects, in the case of the example, after we run each one of the Stories we are printing in the console the result as well as creating a json file from the resulting List of Devices.

The Json Files generated are saved in target/output, the name of the files correspond to the configuration selected.
In the example with the following configuration:

        jsonFileName = "devices-test.json";
        fullNameToFilter = "Mockia 5800";
        deviceBrand = "Mockia";
        deviceModel = "5800";
        
  The name of the files are the following:
  
  Story 1: "story-1-all-devices.json"
  Story 2: "story-2-only-Mockia 5800.json"
  Story 3: "story-3-only-Valid-devices.json"
  Story 4: "story-4-only-5800-Model-devices.json"
  Story 4: "story-4-only-Mockia-brand-devices.json"
  

