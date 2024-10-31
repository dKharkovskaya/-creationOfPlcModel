public class Sensor extends Device {
    protected String loop;
    protected String address;

    Sensor(String tag, String loop, String address) {
        super(tag);
        this.loop = loop;
        this.address = address;
    }

    public Sensor definedType(Device device, Sensor sensor) {
        if (sensor.tag.contains("BIA")) {
            return addNotifierProp(device, sensor);
        } else if (sensor.tag.contains("IZ") || sensor.tag.contains("BR")) {
            return addIzProp(sensor);
        } else if (sensor.tag.contains("BTH") || sensor.tag.contains("BTK")) {
            return addSpotDetectorProp(sensor);
        } else if (sensor.tag.contains("BTM")) {
            //return createManualCallPointTag(device, sensor);
        } else if (sensor.tag.contains("AM")) {
            //return createAddressLoopTag(device, sensor);
        } else if (sensor.tag.contains("RCM")) {
            //return createRcmTag(device, sensor);
        } else if (sensor.tag.contains("RM") || sensor.tag.contains("PM")) {
            //return createRelayModuleTag(device, sensor);
        } else if (sensor.tag.contains("SC")) {
            //return createMptTag(device, sensor);
        }
        return sensor;
    }

    public Sensor addNotifierProp(Device device, Sensor sensor) {
        if (device.tag.contains("MUPS")) {
            sensor.objType = "Notifier_0_PLC";
        } else {
            sensor.objType = "Notifier_1_PLC";
        }
        if (sensor.tag.contains("BIALS")) {
            sensor.desrRus = "Оповещатель свето-звуковой";
            sensor.desrEng = "Ligth-sound notifier";
            sensor.template = "main";
            sensor.type = "Свето-звуковой";
            return sensor;
        } else if (sensor.tag.contains("BIAL")) {
            sensor.desrRus = "Оповещатель световой";
            sensor.desrEng = "Ligth notifier";
            sensor.template = "main";
            sensor.type = "Световой";
            return sensor;
        } else if (sensor.tag.contains("BIAS")) {
            sensor.desrRus = "Оповещатель звуковой";
            sensor.desrEng = "Sound notifier";
            sensor.template = "main";
            sensor.type = "Звуковой";
            return sensor;
        }
        System.out.println("Тег не найден в перечне вариантов");
        return sensor;
    }

    public Sensor addIzProp(Sensor sensor) {
        sensor.desrRus = "Изолятор шлейфа";
        sensor.desrEng = "Izolation loop";
        sensor.template = "main";
        sensor.type = "";
        sensor.objType = "IZ_0_PLC";
        return sensor;
    }

    public Sensor addSpotDetectorProp(Sensor sensor) {
        sensor.desrRus = "Извещатель";
        sensor.desrEng = "SpotDetector";
        /* Переделать шаблон */
        sensor.template = "main_warn";
        sensor.type = "";
        sensor.objType = "SpotDetector_1_PLC";
        return sensor;
    }

}
