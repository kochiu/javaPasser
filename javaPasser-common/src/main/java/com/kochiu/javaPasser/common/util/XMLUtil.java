package com.kochiu.javaPasser.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;

import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayOutputStream;

/**
 * Created by IntelliJ IDEA.
 * User: gaochao
 * Date: 2016/5/9.
 * Time: 17:41.
 */
public class XMLUtil {


    public static String getXmlString(Document doc) {
        TransformerFactory tf = TransformerFactory.newInstance();
        try {
            Transformer t = tf.newTransformer();
            t.setOutputProperty(OutputKeys.ENCODING, "UTF-8");//解决中文问题，试过用GBK不行
            t.setOutputProperty(OutputKeys.METHOD, "html");
            t.setOutputProperty(OutputKeys.VERSION, "4.0");
            t.setOutputProperty(OutputKeys.INDENT, "no");
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            t.transform(new DOMSource(doc), new StreamResult(bos));
            return bos.toString();
        } catch (Exception e) {
            log.error("parse document to xml String error:", e);
        }
        return "";
    }

    public static String requestToXmlString(HttpServletRequest request) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(request.getInputStream());
            return getXmlString(doc);
        } catch (Exception e) {
            log.error("XMLUtil requestToXmlString error:", e);
            return null;
        }
    }

    private static final Logger log = LoggerFactory.getLogger(XMLUtil.class);
}
