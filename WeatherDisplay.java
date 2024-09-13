import java.util.Observable;
import java.util.Observer;

public class WeatherDisplay implements Observer{
private float temperature;
private float humidity;
private float pressure;

@Override
public void update(Observable o, Object arg){
if(o instanceof WeatherStation){
WeatherStation ws = (WeatherStation) o;
temperature = ws.getTemperature();
humidity = ws.getHumidity();
pressure = ws.getPressure();
display();
}
}
private void display(){
System.out.printf("Current weather: %.1fF,%.1f%%humidity,%.1fhPa%n",temperature, humidity, pressure);

}
}
