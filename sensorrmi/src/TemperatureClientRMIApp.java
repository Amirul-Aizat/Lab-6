import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import ftmk.rmi.sensor.TemperatureSensor;

/**
 * This class represent the client-side of RMI application
 * 
 * @author emalianakasmuri
 *
 */
public class TemperatureClientRMIApp {

	public static void main(String[] args) {
		
		
		try {
			
			// Get registry
			Registry rmiRegistry = LocateRegistry.getRegistry();
			
			// Look-up for the remote object
			TemperatureSensor remoteSensorJasin = (TemperatureSensor) rmiRegistry.lookup("SensorJasin");
			
			// Invoke method from the remote object
			int currentTemperature = remoteSensorJasin.getTemperature();
			
			System.out.println("Current temperature in Jasin is " + currentTemperature + " Celcius");
			
		} catch (RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
