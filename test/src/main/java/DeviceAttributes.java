/**
 *
 * @author E.Marval
 */
public class DeviceAttributes {

    private String name;
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String toString(){
        return "Name=" + ((getName() != null)?(getName()):"null") + ", Value="+((getValue() != null)?(getValue()):"null");
    }
}
