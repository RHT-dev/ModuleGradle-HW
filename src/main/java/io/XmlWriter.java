package io;

import model.Root;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;

public class XmlWriter {
    public static void writeToXml(Root root) throws Exception {
        File dir = new File("xmlReqs");
        if (!dir.exists()) dir.mkdirs();
        String fileName = "req_" + System.currentTimeMillis() + ".xml";
        File file = new File(dir, fileName);
        JAXBContext context = JAXBContext.newInstance(Root.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(root, file);
    }
}
