package edu.rit.croatia.swen383.g1.ws.factory;

import edu.rit.croatia.swen383.g1.ws.WeatherStation;
import edu.rit.croatia.swen383.g1.ws.observer.Observer;
import edu.rit.croatia.swen383.g1.ws.ui.StatisticsDisplay;
import edu.rit.croatia.swen383.g1.ws.ui.SwingUI;
import edu.rit.croatia.swen383.g1.ws.ui.TextUI;
import edu.rit.croatia.swen383.g1.ws.util.UIType;

public class UIFactory {
    static UIType _type;
    static private WeatherStation station;

    public static void setStation(WeatherStation ws) {
        station = ws;
    }

    public static Observer get(UIType type) {
        _type = type;
        switch (type) {
            case SWINGUI:
                return new SwingUI(station);
            case STATISTICSDISPLAY:
                return new StatisticsDisplay(station);
            case TEXTUI:
                return new TextUI(station);
            default:
                return null;
        }
    }
}
