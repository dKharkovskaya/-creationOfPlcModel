import java.util.ArrayList;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.List;

public class Manager {
    private Map<Device, ArrayList<Sensor>> devices = new LinkedHashMap<>();
    private Excel excel;

    Manager(String path) {
        this.excel = new Excel(path);
    }

    public Map<Device, ArrayList<Sensor>> getDevice() throws Exception {
        return excel.getDeviceBySheets(excel.getSheetsByFile(), devices);

    }


}
