package vehicles;

import java.io.*;
import weather.Coordinates;
import weather.WeatherProvider;
import weather.WeatherTower;
import Aircraft;


public class Balloon extends src.simulation.vehicles.Aircraft implements Flyable {
    
    private WeatherTower weatherTower;

    private balloon(String name, Coordinates coordinates)
    {
        super(name, coordinates);
    }

    public void updateConditions() {
        if (this.weatherTower == null) {
            System.out.println("Error: No feedback from WeatherTower");
            return ;
        }
        HashMap<String, String> weatherUpdate = new HashMap<String, String>();
        weatherUpdate.put("RAIN", "Never mind cats and dogs, it's raining chickens and ducks! What Fowl weather.");
        weatherUpdate.put("SUN", "I tried to find out where the sun went last night... it just dawned on me.");
        weatherUpdate.put("SNOW", "I can't land in this weather! Looks like there's snow way out...");
        weatherUpdate.put("FOG", "If I disappeared into this fog, would I be mist?");

    }
    
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
        System.out.println(newID + "registered to weather tower.");
    }
}