public class Device {
    protected String tag;
    protected String objType;
    protected String desrRus;
    protected String desrEng;
    protected String template;
    protected String type = "";

    Device(String tag) {
        this.tag = tag;
    }

    public Device addPropertyDevice(Device device) {
        if (device.tag.contains("MOPS")) {
            device.desrRus = "МОПС-3";
            device.desrEng = "MOPS-3";
            device.objType = "Mops3_PLC";
            device.template = "main";
            return device;
        } else if (device.tag.contains("MUPS")) {
            device.desrRus = "МУПС-3";
            device.desrEng = "MUPS-3";
            device.objType = "Mups3_PLC";
            device.template = "main";
            return device;
        } else if (device.tag.contains("KAU")) {
            device.desrRus = "КАУ2 9030";
            device.desrEng = "KAU 9030";
            device.objType = "KAU2_9030_PLC";
            device.template = "main";
            return device;
        }
        return device;
    }


}
