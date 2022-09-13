package ru.job4j.serialization.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "car")
public class Engine {

    @XmlAttribute
    private int power;

    public Engine(int power) {
        this.power = power;
    }

    public Engine() {
    }

    @Override
    public String toString() {
        return "Engine{" + "power=" + power + '}';
    }
}
