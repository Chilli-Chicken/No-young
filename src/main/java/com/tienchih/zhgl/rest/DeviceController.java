package com.tienchih.zhgl.rest;

import com.alibaba.fastjson.JSONObject;
import com.tienchih.zhgl.config.SystemSettings;
import com.tienchih.zhgl.entity.AlarmFolwRecord;
import com.tienchih.zhgl.service.AlarmFolwService;
import com.tienchih.zhgl.util.DateUtil;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.*;

@Controller
public class DeviceController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SystemSettings systemSettings;

    @Autowired
    private AlarmFolwService alarmFolwService;

    @RequestMapping(value = "/device/clear", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject deviceClear(HttpServletRequest request, String acu, String key, String value) {
        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("userName");
        String s = "0";
        List<String> epCodeList = new ArrayList<String>();
        List<String> epValue = new ArrayList<String>();
        epCodeList.add(key);
        epValue.add(value);
        logger.info(acu +"---->"+ key + "=" + value);
        if (epCodeList != null && !epCodeList.isEmpty())
            s = ctrlNormValue(acu, epCodeList, epValue);
        JSONObject result = new JSONObject();
        if("1".equals(s)) {
            saveCtrl(acu, key, value, userName);
            result.put("success", "true");
        } else
            result.put("success", "false");
        return result;
    }

    @RequestMapping(value = "/device/ctrl", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject deviceCtrl(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("userName");
        String acu = request.getParameter("acu");
        String s = "0";
        List<String> epCodeList = new ArrayList<String>();
        List<String> epValue = new ArrayList<String>();
        Enumeration enu = request.getParameterNames();
        while (enu.hasMoreElements()) {
            String paraName = (String) enu.nextElement();
            String value = request.getParameter(paraName);
            if(!"".equals(value) && !"acu".equals(paraName)) {
                epCodeList.add(paraName);
                epValue.add(value);
            }
        }
        for (int i = 0; i < epCodeList.size(); i++)
            logger.info(acu +"---->"+ epCodeList.get(i) + "=" + epValue.get(i));
        if (epCodeList != null && !epCodeList.isEmpty())
            s = ctrlNormValue(acu, epCodeList, epValue);
        JSONObject result = new JSONObject();
        if("1".equals(s)) {
           for(int i = 0; i < epCodeList.size(); i++)
           {
               saveCtrl(acu, epCodeList.get(i), epValue.get(i), userName);
           }
            result.put("success", "true");
        }
        else
            result.put("success", "false");
        return result;
    }

    @RequestMapping(value = "/device/{acu}", method = RequestMethod.GET)
    public String deviceInfo(@PathVariable(value = "acu") String acu, Model model) {

        Map<String, String> normMap = getNormValue(acu);

//        Map<String, String> normMap = new HashMap<String, String>();
//
//        normMap.put("VD812", "38");
//        normMap.put("VD816", "35");
//        normMap.put("VD820", "40");
//        normMap.put("VD824", "80");
//        normMap.put("VD828", "60");
//        normMap.put("VD832", "90");
//        normMap.put("VD836", "20.5");
//        normMap.put("VD840", "20");
//        normMap.put("VD844", "15");
//        normMap.put("VD848", "5");
//        normMap.put("VD852", "5");
//        normMap.put("VD856", "3.3");
//
//        normMap.put("VD652", "0.1");
//        normMap.put("VD656", "0.18");
//        normMap.put("VD660", "0.3");
//        normMap.put("VD664", "0");
//        normMap.put("VD668", "0");
//        normMap.put("VD672", "0");
//        normMap.put("VD676", "0");
//        normMap.put("VD680", "0");
//        normMap.put("VD684", "0");
//        normMap.put("VD688", "0");
//        normMap.put("VD692", "0");
//        normMap.put("VD696", "0");
//        normMap.put("VD700", "0");
//        normMap.put("VD704", "0");
//        normMap.put("VD708", "0");

        model.addAttribute("normMap", normMap);

        model.addAttribute("acuCode", "ACU" + acu);
        model.addAttribute("acuNum", acu);
        return "deviceAcu" + acu;
    }

    private String ctrlNormValue(String acu, List<String> epCodeList, List<String> epValue) {
        try {
            String url = systemSettings.getUrl();
            PostMethod postMethod = new PostMethod(url);
            String soapRequestData = buildEquipmentsData("ACU" + acu, epCodeList, epValue);
            if(soapRequestData.isEmpty()) {
                return null;
            }
            byte[] bytes = soapRequestData.getBytes("utf-8");

            InputStream inputStream = new ByteArrayInputStream(bytes, 0, bytes.length);
            RequestEntity requestEntity = new InputStreamRequestEntity(
                    inputStream,
                    bytes.length,
                    "application/soap+xml; charset=utf-8"
            );
            postMethod.setRequestEntity(requestEntity);
            HttpClient httpClient = new HttpClient();
            int statusCode = httpClient.executeMethod(postMethod);
            String soapResponseData = postMethod.getResponseBodyAsString();
            if (statusCode == 200){
                Document doc = DocumentHelper.parseText(soapResponseData);//reader.read(s);
                Element root = doc.getRootElement();
                root.addNamespace("SOAP-ENV", "http://schemas.xmlsoap.org/soap/envelope/");
                Element e0 = root.element("Body");
                Element e1 = e0.element("EquipmentsResponse");
                Element datas = e1.element("return");
                return datas.getText();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "0";
    }

    private Map<String, String> getNormValue(String acu) {
        try {
            String url = systemSettings.getUrl();
            PostMethod postMethod = new PostMethod(url);
            String soapRequestData = buildRequestEquipmentData("ACU" + acu);
            if(soapRequestData.isEmpty()) {
                return null;
            }
            byte[] bytes = soapRequestData.getBytes("utf-8");

            InputStream inputStream = new ByteArrayInputStream(bytes, 0, bytes.length);
            RequestEntity requestEntity = new InputStreamRequestEntity(
                    inputStream,
                    bytes.length,
                    "application/soap+xml; charset=utf-8"
            );
            postMethod.setRequestEntity(requestEntity);
            HttpClient httpClient = new HttpClient();
            int statusCode = httpClient.executeMethod(postMethod);
            String soapResponseData = postMethod.getResponseBodyAsString();
            if (statusCode == 200){
                Map<String, String> normMap = parseXmlDataHead("ACU" + acu, soapResponseData);
                return normMap;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private String buildEquipmentsData(String acu, List<String> epCodeList, List<String> epValue) {
        StringBuffer sb = new StringBuffer();
        sb.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:web=\"http://webservice.util.opc.zkzh.com/\">");
        sb.append("<soapenv:Header/>");
        sb.append("<soapenv:Body>");
        sb.append("<web:Equipments>");
        sb.append("<data>");
        sb.append("<? xml version=\"1.0\" encoding=\"UTF-8\"?>");
        sb.append("<EQUIP>");
        sb.append("<EQUIPCODE>");
        sb.append(acu);
        sb.append("</EQUIPCODE>");
        for (int i = 0; i < epCodeList.size(); i++) {
            sb.append("<EQUIPPARAMS>");
            sb.append("<EQUIPPARAM>");
            sb.append("<EPCODE>");
            sb.append(epCodeList.get(i));
            sb.append("</EPCODE>");
            sb.append("<VALUE>");
            sb.append(epValue.get(i));
            sb.append("</VALUE>");
            sb.append("</EQUIPPARAM>");
            sb.append("</EQUIPPARAMS>");
        }

        sb.append("</EQUIP>");
        sb.append("</data>");
        sb.append("</web:Equipments>");
        sb.append("</soapenv:Body>");
        sb.append("</soapenv:Envelope>");
        return sb.toString();
    }

    private String buildRequestEquipmentData(String acu) {
        StringBuffer sb = new StringBuffer();
        sb.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:web=\"http://webservice.util.opc.zkzh.com/\">");
        sb.append("<soapenv:Header/>");
        sb.append("<soapenv:Body>");
        sb.append("<web:RequestEquipmentParam>");
        sb.append("<data>");
        sb.append("<? xml version=\"1.0\" encoding=\"UTF-8\"?>");
        sb.append("<EQUIP>");
        sb.append("<EQUIPCODE>");
        sb.append(acu);
        sb.append("</EQUIPCODE>");
        sb.append("</EQUIP>");
        sb.append("</data>");
        sb.append("</web:RequestEquipmentParam>");
        sb.append("</soapenv:Body>");
        sb.append("</soapenv:Envelope>");
        return sb.toString();
    }

    private Map<String, String> parseXmlDataHead(String acu_code, String response_data) throws DocumentException {
        Map<String, String> result = new HashMap<String, String>();
        if (response_data == null || "".equals(response_data)) {
            logger.info("parse xml head  = null");
            return null;
        }
        Document doc = DocumentHelper.parseText(response_data);//reader.read(s);
        Element root = doc.getRootElement();
        root.addNamespace("SOAP-ENV", "http://schemas.xmlsoap.org/soap/envelope/");
        Element e0 = root.element("Body");
        Element e1 = e0.element("RequestEquipmentParamResponse");
        Element datas = e1.element("return");
        String body = datas.getText();
        if (body == null || "".equals(body)) {
            logger.info("parse xml body  = null");
            return null;
        }
        Document bodyDoc = DocumentHelper.parseText(body);
        Element EQUIP = bodyDoc.getRootElement();
        Element EQUIPPARAMS = EQUIP.element("EQUIPPARAMS");
        List<Element> EQUIPPARAM = EQUIPPARAMS.elements("EQUIPPARAM");
        if (EQUIPPARAM.size() == 0) {
            return null;
        }

        for (Element element : EQUIPPARAM) {
            String EPCODE = element.element("EPCODE").getText();
            String VALUE = element.element("VALUE").getText();
            String ACUCODE = acu_code;
            result.put(EPCODE, VALUE);
        }
        return result;
    }

    private void saveCtrl(String acu,String key,String value, String user)
    {

        if(acu.length()<4||!acu.substring(0,3).equals("ACU"))
        {

            acu ="ACU"+acu;
        }
        String time = DateUtil.getTime();
        AlarmFolwRecord record = new AlarmFolwRecord();
        record.setAcu(acu);
        record.setPointKey(key);
        record.setValue(value);
        record.setOperator(user);
        record.setCreateDate(time);
        alarmFolwService.save(record);
    }

}