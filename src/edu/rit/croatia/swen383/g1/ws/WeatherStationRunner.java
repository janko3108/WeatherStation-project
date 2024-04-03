package edu.rit.croatia.swen383.g1.ws;

import java.util.EnumMap;
import java.util.Scanner;

import edu.rit.croatia.swen383.g1.ws.factory.UIFactory;
import edu.rit.croatia.swen383.g1.ws.sensor.Sensor;
import edu.rit.croatia.swen383.g1.ws.util.SensorType;
import edu.rit.croatia.swen383.g1.ws.util.UIType;

public class WeatherStationRunner {
    public final static EnumMap<SensorType, Sensor> sensorMap = new EnumMap<>(SensorType.class);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(
                "Please specify which GUI you would like to launch the application with (t for TextUI or s for SwingUI): ");
        String choice = scanner.nextLine().trim().toLowerCase();
        WeatherStation ws = new WeatherStation(sensorMap);

        UIFactory.setStation(ws);

        switch (choice) {
            case "t":
                UIFactory.get(UIType.TEXTUI);
                break;
            case "s":
                UIFactory.get(UIType.SWINGUI);
                break;
            default:
                UIFactory.get(UIType.SWINGUI);
                break;
        }

        Thread thread = new Thread(ws);
        thread.start();
        scanner.close();
    }
}
