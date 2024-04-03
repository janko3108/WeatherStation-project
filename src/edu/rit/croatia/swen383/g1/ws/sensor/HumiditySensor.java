package edu.rit.croatia.swen383.g1.ws.sensor;

import edu.rit.marasovic.swen383.thirdparty.sensor.HumidityReader;

public class HumiditySensor implements Sensor {
    private HumidityReader humidityReader;

    public HumiditySensor() {
        this.humidityReader = new HumidityReader();
    }

    @Override
    public int read() {
        if (humidityReader == null) {
            throw new IllegalStateException("Library not initalized.");
        }
        return humidityReader.get();
    }

}