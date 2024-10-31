import java.io.*;
import java.util.*;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Excel {
    public static Translit translit = new Translit();
    private String path;

    Excel(String path) {
        this.path = path;
    }

    public Iterator<Sheet> getSheetsByFile() throws Exception {
        FileInputStream fis = new FileInputStream(new File(path));
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        Iterator<Sheet> sheetIterator = workbook.sheetIterator();
        return sheetIterator;
    }

    public Map<Device, ArrayList<Sensor>> getDeviceBySheets(Iterator<Sheet> sheetIterator, Map<Device, ArrayList<Sensor>> devices) throws Exception {
        while (sheetIterator.hasNext()) {
            Sheet sheet = sheetIterator.next();
            if (sheet.getSheetName().contains("DEVICE.")) {
                Device device = new Device(sheet.getSheetName().replace("DEVICE.", ""));
                device.addPropertyDevice(device);
                ArrayList<Sensor> sensors = new ArrayList<>();
                for (Row row : sheet) {
                    if (row.getRowNum() == 0) {
                        continue;
                    }
                    Sensor sensor;
                    String tagSensor = translit.replaceRusOnEng(row.getCell(0).toString().replace("-", "_"));
                    if (device.tag.contains("KAU")) {
                        sensor = new Sensor(tagSensor, row.getCell(1).toString(), row.getCell(2).toString());
                    } else {
                        sensor = new Sensor(row.getCell(0).toString().replace("-", "_"), row.getCell(1).toString(), "");
                    }
                    sensors.add(sensor.definedType(device, sensor));
                }
                if (!devices.containsKey(sheet.getSheetName().replace("DEVICE.", ""))) {
                    devices.put(device, sensors);
                } else {
                    System.out.println("Название листа " + sheet.getSheetName() + " уже раннее был добавлен");
                }
            }
        }
        return devices;
    }

}






