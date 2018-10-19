package com.tienchih.zhgl.util;

//import java.util.HashMap;
//import java.util.Map;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Const {
    private static Const instance = null;
    public static Const getInstance(){
        if(instance == null){
            instance = new Const();
        }
        return instance;
    }

    public static final String SYS_PROP_TYPE_USER = "USER_ID_NAME";
    public static final String SYS_PROP_TYPE_AP_MAC_CODE = "AP_MAC_CODE";

    public static final String DEVICE_INVOK_CTRL = "ctrl";
    public static final String DEVICE_INVOK_INFO = "info";

    public static final String DEVICE_LINE_CTRL = "ctrl";
    public static final String DEVICE_LINE_AUTO = "auto";

    public static final String DEVICE_CTRL_OPEN = "open";
    public static final String DEVICE_CTRL_CLOSE = "close";

    public static final String DEVICE_TYPE_IT = "IT";//红外对射
    public static final String DEVICE_TYPE_VD = "VD";//摄像机
    public static final String DEVICE_TYPE_FD = "FD";//排风机
    public static final String DEVICE_TYPE_RT = "RT";//通讯
    public static final String DEVICE_TYPE_AP = "AP";//APS
    public static final String DEVICE_TYPE_EP = "EP";//EPS
    public static final String DEVICE_TYPE_ACU = "ACU";//ACU
    public static final String DEVICE_TYPE_AIR = "AIR";//有害气体检测仪
    public static final String DEVICE_TYPE_AT = "AT";//温湿度检测仪
    public static final String DEVICE_TYPE_ZM = "ZM";//照明
    public static final String DEVICE_TYPE_PD = "PD";//排水

    public static final String DEVICE_NORM_SIGNAL_INFO_FILE_PATH = "device_norm_signal_info.json";
    public static final String DEVICE_NORM_SIGNAL_CTRL_FILE_PATH = "device_norm_signal_ctrl.json";
    public static final String DEVICE_FD_AUTO_FILE_PATH = "device_fd_auto.json";

    public static final String DEVICE_CTRL_LINE_AUTO = "auto";
    public static final String DEVICE_CTRL_LINE_STATUS = "ctrl_status";
    public static final String DEVICE_CTRL_LINE_F_STATUS = "f_ctrl_status";
    public static final String DEVICE_CTRL_LINE_S_STATUS = "s_ctrl_status";

    public static final String ACU_1 = "ACU1";//acu1
    public static final String ACU_2 = "ACU2";//acu2
    public static final String ACU_3 = "ACU3";//acu3
    public static final String ACU_4 = "ACU4";//acu4
    public static final String ACU_5 = "ACU5";//acu5
    public static final String ACU_6 = "ACU6";//acu6
    public static final String ACU_7 = "ACU7";//acu7
    public static final String ACU_8 = "ACU8";//acu8
    public static final String ACU_9 = "ACU9";//acu9
    public static final String ACU_10 = "ACU10";//acu10
    public static final String ACU_11 = "ACU11";//acu11
    public static final String ACU_12 = "ACU12";//acu12
    public static final String ACU_13 = "ACU13";//acu13

    public static final Map<String, String> ACU1_NORM = new HashMap();
    public static final Map<String, String> ACU2_NORM = new HashMap();
    public static final Map<String, String> ACU3_NORM = new HashMap();
    public static final Map<String, String> ACU4_NORM = new HashMap();
    public static final Map<String, String> ACU5_NORM = new HashMap();
    public static final Map<String, String> ACU6_NORM = new HashMap();
    public static final Map<String, String> ACU7_NORM = new HashMap();
    public static final Map<String, String> ACU8_NORM = new HashMap();
    public static final Map<String, String> ACU9_NORM = new HashMap();
    public static final Map<String, String> ACU10_NORM = new HashMap();
    public static final Map<String, String> ACU11_NORM = new HashMap();
    public static final Map<String, String> ACU12_NORM = new HashMap();
    public static final Map<String, String> ACU13_NORM = new HashMap();

    public static final Map<String, Date> Login_Auth = new HashMap<>();
//    private Map<String, String> ApMap = new HashMap<>();
//
//    public String getApByMac(String mac){
//        if(ApMap.isEmpty() || ApMap.size() <= 0){
//            createApMap();
//        }
//        String mac2 = mac.toUpperCase();
//        if(ApMap.containsKey(mac2)){
//            return ApMap.get(mac2);
//        }
//        return "";
//    }
//
//    public String getApByIndex(int index){
//        if(ApMap.isEmpty() || ApMap.size() <= 0){
//            createApMap();
//        }
//        String re = "";
//        int i = 0;
//        for(Map.Entry<String, String> entry : ApMap.entrySet()){
//            if(i == index){
//                re = entry.getValue();
//                break;
//            }
//            i++;
//            continue;
//        }
//        return re;
//    }
//
//    private void createApMap(){
//        ApMap.put("C240722EC82D","01AP1-A1");
//        ApMap.put("FFE28F0FF82E","01AP2-A1");
//        ApMap.put("FA885529FDCC","01AP3-A1");
//        ApMap.put("E9890FF46416","01AP4-A1");
//        ApMap.put("FC210B4B407C","01AP5-A1");
//        ApMap.put("E33D62526223","01AP6-A1");
//        ApMap.put("D9797BC02615","02-AP7-A2_AP02");
//        ApMap.put("C46AA5779729","02-AP8-A2");
//        ApMap.put("C2901F88F4BC","02-AP9-A2");
//        ApMap.put("E04D19C7D07E","02-AP10-A2");
//        ApMap.put("E7C829CA1932","03-AP11-A2");
//        ApMap.put("E7E04D70213B","03-AP12-A2");
//        ApMap.put("E8D1E83FECD4","03-AP13-A3");
//        ApMap.put("E5BC648FA2D9","03-AP14-A3");
//        ApMap.put("EE1DC44A35C2","03-AP15-A3");
//        ApMap.put("E7037351FB16","04-AP16-A3");
//        ApMap.put("CBB0D44874BA","04-AP17-A3");
//        ApMap.put("C8B727BE7D70","04-AP18-A4");
//        ApMap.put("DF9CA7AF8681","04-AP19-A4");
//        ApMap.put("DBEE17AB476F","04-AP20-A4_AP04");
//        ApMap.put("DFC9D16B82DC","05-AP21-A4");
//        ApMap.put("F1311EADB74C","05-AP22-A4");
//        ApMap.put("F79B11C28674","05-AP23-A4");
//        ApMap.put("EB776D05AD3C","05-AP24-A5");
//        ApMap.put("F29EF553F857","05-AP25-A5");
//        ApMap.put("DF97AD8FE6DF","06-AP26-A5");
//        ApMap.put("D49851E0B369","06-AP27-A5");
//        ApMap.put("F2E6181A7B6E","06-AP28-B1");
//        ApMap.put("CF8F9124BA4E","06-AP29-B1");
//        ApMap.put("F6BBA1289532","06-AP30-B1");
//        ApMap.put("EAF358D4FD5D","07-AP31-B1");
//        ApMap.put("EEB622BF46D9","07-AP32-B2");
//        ApMap.put("CECBCC515007","07-AP33-B2");
//        ApMap.put("D6721BEC163D","07-AP34-B2");
//        ApMap.put("CEDBB2E95319","07-AP35-B2");
//        ApMap.put("E681C1A6016B","07-AP36-B2");
//        ApMap.put("DCD8BFDBC9FB","08-AP37-B3_AP05");
//        ApMap.put("F86A069079BA","08-AP38-B3");
//        ApMap.put("D873206978E8","08-AP39-B3");
//        ApMap.put("EA35A3DD719A","08-AP40-B3");
//        ApMap.put("D3A0BE8AC03D","08-AP41-B3");
//        ApMap.put("DB816CF4B614","08-AP42-B3");
//        ApMap.put("F780A5953ACC","08-AP43-B4");
//        ApMap.put("D98D1CFD0DF8","09-AP44-B4_AP06");
//        ApMap.put("CFB5C71588F8","09-AP45-B4");
//        ApMap.put("D47456F59977","09-AP46-B4");
//        ApMap.put("F5EC64044752","09-AP47-B4");
//        ApMap.put("C610D2E4C2C3","09-AP48-B4");
//        ApMap.put("DCC0DABF7D1F","09-AP49-B5");
//        ApMap.put("F175B9CA8DD8","10-AP50-B5_AP07");
//        ApMap.put("C7544568552C","10-AP51-B5");
//        ApMap.put("DE0848BC8FE4","10-AP52-B5");
//        ApMap.put("EB710B784C92","10-AP53-B5");
//        ApMap.put("C9BBC9BA3B47","10-AP54-B6");
//        ApMap.put("C65CBDCEAFE0","10-AP55-B6");
//        ApMap.put("D012C54722FB","11-AP56-B6");
//        ApMap.put("C622EBF5B84D","11-AP57-B6");
//        ApMap.put("EDD283E5413E","11-AP58-B7");
//        ApMap.put("D0C9752615B6","11-AP59-B7");
//        ApMap.put("D52560243CC1","11-AP60-B7");
//        ApMap.put("DF319E422725","12-AP61-B7_AP08");
//        ApMap.put("E35827B2EC8F","12-AP62-B7");
//        ApMap.put("EBCCAB4DC79F","12-AP63-B7");
//        ApMap.put("E83EF8573C22","12-AP64-B8");
//        ApMap.put("DE9A521AFDA5","12-AP65-B8");
//        ApMap.put("E9811BF5CB8E","12-AP66-B8");
//        ApMap.put("DA836DB5B0CC","13-AP67-B8_AP09");
//        ApMap.put("CE8019387D76","13-AP68-B8");
//        ApMap.put("D411C489F1FB","13-AP69-B8");
//        ApMap.put("D37F55545144","13-AP70-B9");
//        ApMap.put("DFE11675133A","13-AP71-B9");
//        ApMap.put("C567CA2B8EBF","14-AP72-B9_AP10");
//        ApMap.put("D9B59583CEFD","14-AP73-B9");
//        ApMap.put("FC95C395B115","14-AP74-C1");
//        ApMap.put("E04F5B556AC0","14-AP75-C1");
//        ApMap.put("F5BBA3EA08DA","14-AP76-C1");
//        ApMap.put("C267B403A027","14-AP77-C1");
//        ApMap.put("F7EAE06D585C","14-AP78-C2");
//        ApMap.put("EC0BD24D065E","15-AP79-C2");
//        ApMap.put("F35131D65686","15-AP80-C2");
//        ApMap.put("C774A29F058D","15-AP81-C2");
//        ApMap.put("E53405D8588E","16-AP82-C2_AP11");
//        ApMap.put("DDC3F8D3CE10","16-AP83-C3");
//        ApMap.put("CFF30CBD859A","16-AP84-C3");
//        ApMap.put("C8BC9C4E5D05","16-AP85-C3");
//        ApMap.put("DD627ECB261D","16-AP86-C3");
//        ApMap.put("CF1A302A625E","16-AP87-C4");
//        ApMap.put("D20619D2E593","16-AP88-C4");
//        ApMap.put("C97B790C568E","17-AP89-C4_AP12");
//        ApMap.put("E6F8CDCA1574","17-AP90-C4");
//        ApMap.put("FCF18D598C11","17-AP91-C4");
//        ApMap.put("CF7188E85179","17-AP92-C4");
//        ApMap.put("C78360360CBB","17-AP93-C5");
//        ApMap.put("DE1E1EBAC512","18-AP94-C5");
//        ApMap.put("F7E12EA12139","18-AP95-C5");
//        ApMap.put("EF57112CE1EC","18-AP96-C5");
//        ApMap.put("F95EA6774E93","19-AP97-C5_AP13");
//        ApMap.put("FA0FA963203B","19-AP98-C5");
//        ApMap.put("E04AA53E1523","19-AP99-C6");
//        ApMap.put("FF43EA1C868A","19-AP100-C6");
//        ApMap.put("DE2E543F536A","19-AP101-C6");
//        ApMap.put("FB8ABC6B523F","19-AP102-C6");
//        ApMap.put("FD21AFC72E40","19-AP103-C7");
//        ApMap.put("CD2E41ADC7A8","20-AP104-C7");
//        ApMap.put("DDB876A51DA9","20-AP105-C7");
//        ApMap.put("EAF51003EA90","20-AP106-C7");
//        ApMap.put("D68CFC011C2B","20-AP107-C8");
//        ApMap.put("E7E04A6CB0B4","21-AP108-C8_AP14");
//        ApMap.put("D7363C30DBBB","21-AP109-C8");
//        ApMap.put("F28E1523D6A5","21-AP110-C8");
//        ApMap.put("FB15A74CD30D","21-AP111-C8");
//        ApMap.put("E48D52DDA718","21-AP112-C9");
//        ApMap.put("D60108D61E72","21-AP113-C9");
//        ApMap.put("ED05A8AB074B","22-AP114-C9");
//        ApMap.put("D02F2DE93C78","22-AP115-C9");
//        ApMap.put("DAE2FD577FF8","22-AP116-C9");
//        ApMap.put("E95535F3ED34","22-AP117-D1");
//        ApMap.put("F36E8B60BCA2","22-AP118-D1");
//        ApMap.put("CF21E0D4D538","22-AP119-D1");
//        ApMap.put("F0208D021161","22-AP120-D1");
//        ApMap.put("E46C4A02BD62","23-AP121-D1_AP15");
//        ApMap.put("D3EFA6F1EAFA","23-AP122-D1");
//        ApMap.put("F19186A55042","23-AP123-D2");
//        ApMap.put("E09323AE6A21","23-AP124-D2");
//        ApMap.put("F2A0AC9E084C","23-AP125-D2");
//        ApMap.put("DEA67BC763CE","24-AP126-D2_AP16");
//        ApMap.put("C2F2978E561E","24-AP127-D2");
//        ApMap.put("EB5EF4E9BAFD","24-AP128-D2");
//        ApMap.put("FB8E449E9E5A","24-AP129-D3");
//        ApMap.put("C6DAF309F369","24-AP130-D3");
//        ApMap.put("FE396EBC1D7E","24-AP131-D3");
//        ApMap.put("D8A40FAAB707","25-AP132-D3");
//        ApMap.put("E6589B6139C0","25-AP133-D3");
//        ApMap.put("DE158EFC7F17","25-AP134-D4");
//        ApMap.put("C662D75D61FE","25-AP135-D4");
//        ApMap.put("EC65962D23EB","26-AP136-D4_AP17");
//        ApMap.put("F737F2903733","26-AP137-D4");
//        ApMap.put("C9DBAF83C434","26-AP138-D4");
//        ApMap.put("CD08743DF2B0","26-AP139-D5");
//        ApMap.put("E3FC6E387B72","26-AP140-D5");
//        ApMap.put("E4DA6342605D","26-AP141-D5");
//        ApMap.put("C762AAA60EE4","27-AP142-D5_AP18");
//        ApMap.put("D8ED9E39DA13","27-AP143-D5");
//        ApMap.put("E242CBF6CF60","27-AP144-D5");
//        ApMap.put("E25D4762BC09","27-AP145-D6");
//        ApMap.put("CE23986A7D54","27-AP146-D6");
//        ApMap.put("F0AB43CE9B98","28-AP147-D6_AP19");
//        ApMap.put("EAAD7E827FEE","28-AP148-D6");
//        ApMap.put("D7140711E078","28-AP149-D6");
//        ApMap.put("F4C107EFFBC4","28-AP150-D6");
//        ApMap.put("E1BFC4B9B12D","28-AP151-D7");
//        ApMap.put("E8EFD0856717","28-AP152-D7");
//        ApMap.put("EF296962F1FC","28-AP153-D7");
//        ApMap.put("F515133F3EFC","28-AP154-D7");
//        ApMap.put("CC5C431CD01B","29-AP155-D7_AP20");
//        ApMap.put("F95DD7A1D81C","29-AP156-D7");
//        ApMap.put("C5843E5F742C","29-AP157-D8");
//        ApMap.put("E2492DBBC43A","29-AP158-D8");
//        ApMap.put("CE99779E445A","29-AP159-D8");
//        ApMap.put("E509DFE24303","29-AP160-D8");
//        ApMap.put("FD3C100F0546","30-AP161-D8_AP21");
//        ApMap.put("D6E4B0390F9D","30-AP162-D9");
//        ApMap.put("FDAD479AD829","30-AP163-D9");
//        ApMap.put("CBD5039A04B5","30-AP164-D9");
//        ApMap.put("C80608E067D7","30-AP165-D9");
//        ApMap.put("D375F4A0D59C","30-AP166-D10");
//        ApMap.put("C6AA8E3BCD6C","31-AP167-D10_AP22");
//        ApMap.put("E772AE341FF1","31-AP168-D10");
//        ApMap.put("CE6BAEFD6B34","31-AP169-D10");
//
//    }
}
