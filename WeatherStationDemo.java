public class WeatherStationDemo{
public static void main(String args[]){
WeatherStation weatherStation = new WeatherStation();
WeatherDisplay weatherDisplay = new WeatherDisplay();
weatherStation.addObserver(weatherDisplay);
weatherStation.setMeasurements(80, 65, 30.4f);
weatherStation.setMeasurements(82, 70, 29.2f);

}
}
