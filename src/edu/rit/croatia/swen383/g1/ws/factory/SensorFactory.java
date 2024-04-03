package edu.rit.croatia.swen383.g1.ws.factory;

import edu.rit.croatia.swen383.g1.ws.sensor.HumiditySensor;
import edu.rit.croatia.swen383.g1.ws.sensor.PressureSensor;
import edu.rit.croatia.swen383.g1.ws.sensor.Sensor;
import edu.rit.croatia.swen383.g1.ws.sensor.TemperatureSensor;
import edu.rit.croatia.swen383.g1.ws.util.SensorType;

public class SensorFactory {

    public SensorFactory() {

    }

    public static Sensor get(SensorType sensorType) { // Ejup and I added the "static" keyword in Discord together, as
                                                      // we were trying to figure out the UIFactory error.
        Sensor sensor;
        switch (sensorType) {
            case TEMPERATURE:
                sensor = new TemperatureSensor();
                break;
            case PRESSURE:
                sensor = new PressureSensor();
                break;
            case HUMIDITY:
                sensor = new HumiditySensor();
                break;
            default:
                throw new IllegalArgumentException("Unsupported sensor type: " + sensorType);
        }
        return sensor;
    }
}