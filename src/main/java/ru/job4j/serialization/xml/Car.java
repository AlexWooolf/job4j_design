package ru.job4j.serialization.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.io.StringWriter;
import java.util.Arrays;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class Car {

    @XmlAttribute
    private boolean cool;
    private int seats;
    private String model;
    private Engine engine;
    private String[] tuning;

    @Override
    public String toString() {
        return "Car{" + "cool=" + cool + ", seats=" + seats + ", model='" + model + '\'' + ", engine=" + engine + ", tuning=" + Arrays.toString(tuning) + '}';
    }

    public Car(boolean cool, int seats, String model, Engine engine, String[] tuning) {
        this.cool = cool;
        this.seats = seats;
        this.model = model;
        this.engine = engine;
        this.tuning = tuning;
    }
}
