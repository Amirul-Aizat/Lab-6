import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import ftmk.rmi.sensor.TemperatureSensor;

public class TemperatureClientRMIApp2 {

	public static void main(String[] args) {
		
					
					
			try {
					// Get registry
					Registry rmiRegistry = LocateRegistry.getRegistry();
						
					// Look-up for the remote object
					TemperatureSensor remoteSensorAyerKeroh = (TemperatureSensor) rmiRegistry.lookup("SensorAyerKeroh");
						
					// Invoke method from the remote object
					int currentTemperature = remoteSensorAyerKeroh.getTemperature();
						
					System.out.println("Current temperature in Ayer Keroh is " + currentTemperature + " Celcius");
			
					// Invoke method from remote object to show temperature for specific day
					String day = "Sunday";
					int temperature = remoteSensorAyerKeroh.getTemperatureByDay(day);
					
					System.out.println("Current temperature on " + day +" in Ayer Keroh is " +  temperature + " Celcius");
					
					// Print average temperature
					float averageTemperature = remoteSensorAyerKeroh.getAverageTemperature();
					System.out.println("Average temperature in Ayer Keroh is " +  String.format("%.1f", averageTemperature) + " Celcius");
					
					
					
				} catch (RemoteException | NotBoundException e) {
						
						e.printStackTrace();
				}
					
					
		
	}

}