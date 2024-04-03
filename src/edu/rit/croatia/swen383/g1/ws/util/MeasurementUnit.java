package edu.rit.croatia.swen383.g1.ws.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Enum for sensor units. The Enum comes with a get method that converts a
 * reading to the appropriate unit.
 *
 * @author Kristina Marasovic <kristina.marasovic@rit.edu>
 */
public enum MeasurementUnit {

    KELVIN(SensorType.TEMPERATURE, 1, 0),
    CELSIUS(SensorType.TEMPERATURE, 1, -27315),
    FAHRENHEIT(SensorType.TEMPERATURE, 1.8, -45967),
    INHG(SensorType.PRESSURE, 1, 0),
    MBAR(SensorType.PRESSURE, 33.8639, 0),
    PCT(SensorType.HUMIDITY, 100, 0);

    private final SensorType type; //conversion factor
    private final double cf1; //conversion factor
    private final double cf2;

    MeasurementUnit(SensorType type, double cf1, double cf2) {
        this.type = type;
        this.cf1 = cf1;
        this.cf2 = cf2;
    }

    public double get(int reading) {
        return (cf1 * reading + cf2) / 100.0;
    }

    public static List<MeasurementUnit> valueOf(SensorType type) {
        List<MeasurementUnit> list = new ArrayList();
        for (MeasurementUnit unit : values()) {
            if (unit.type.equals(type)) {
                list.add(unit);
            }
        }
        return list;
    }
}
