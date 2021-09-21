package ru.job4j.serialization.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.io.StringWriter;
import java.util.Arrays;

@XmlRootElement(name = "work")
@XmlAccessorType(XmlAccessType.FIELD)
public class Work {

    @XmlAttribute
    private boolean done;

    @XmlAttribute
    private int time;
    private Task task;

    private String[] performers;

    public Work() { }

    public Work(boolean done, int time, Task task, String... performers) {
        this.done = done;
        this.time = time;
        this.task = task;
        this.performers = performers;
    }

    @Override
    public String toString() {
        return "Work{"
               + " done=" + done
               + ", time=" + time
               + ", task=" + task
               + ", performers=" + Arrays.toString(performers)
               + '}';
    }



    public static void main(String[] args) throws JAXBException {

        final Work work = new Work(false, 3, new Task("Выполнить задачу"), "Иванов", "Исов");

        JAXBContext context = JAXBContext.newInstance(Work.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(work, writer);
            String result = writer.getBuffer().toString();
            System.out.println(result);
        } catch (Exception e) {

        }
    }

}

