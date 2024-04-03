package edu.rit.croatia.swen383.g1.ws.ui;

import edu.rit.croatia.swen383.g1.ws.WeatherStation;
import edu.rit.croatia.swen383.g1.ws.observer.Observer;

public class StatisticsDisplay implements Observer {

    private final WeatherStation station;

    public StatisticsDisplay(WeatherStation station) {
        this.station = station;
        this.station.attach(this);
    }

    // todo method
    @Override
    public void update() {

    }

}