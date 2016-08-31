import java.util.Arrays;
import java.util.List;

/**
 *
 * @author E.Marval
 */
public class Device {

    private String brand;
    private String model;

    private String formFactor;
    private List<DeviceAttributes> attributes;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getFormFactor() {
        return formFactor;
    }

    public void setFormFactor(String formFactor) {
        this.formFactor = formFactor;
    }

    public List<DeviceAttributes> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<DeviceAttributes> attributes) {
        this.attributes = attributes;
    }

    public String toString(){

        return "\n***** Device Details *****\n" +
                "Model=" + ((getModel() != null) ? (getModel()) : "null") + "\n" +
                "Brand=" + ((getBrand() != null) ? (getBrand()) : "null") + "\n" +
                "From Factor=" + ((getFormFactor() != null) ? (getFormFactor()) : "null") + "\n" +
                "Attributes=" + ((getAttributes() != null) ? (Arrays.toString(getAttributes().toArray())) : "null") + "\n" +
                "*****************************";
    }

}
