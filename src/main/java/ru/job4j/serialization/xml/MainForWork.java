package ru.job4j.serialization.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class MainForWork {
    public static void main(String[] args) throws Exception {
        Work work = new Work(false, 3, new Task("Выпонить задачу"), "Иванов", "Сидоров");

        JAXBContext context = JAXBContext.newInstance(Work.class);

        Marshaller marshaller = context.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {

            marshaller.marshal(work, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }

        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {

            Work result = (Work) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }

    }
}