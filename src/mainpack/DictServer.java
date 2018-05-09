package mainpack;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class DictServer {

	int PORT = 4700;
	String Location = "127.0.0.1";
	String Name = "RMIDict";
	DictQuery RMIDict;
	public DictServer(String Location, int PORT, String Name) {
		this.Location = Location;
		this.PORT = PORT;
		this.Name = Name;
		Init();
	}
	void Init() {
		try {
			RMIDict = new RemoteDictionary();
			LocateRegistry.createRegistry(PORT);
			String ServerName = "rmi://" + Location + ":" + PORT + "/" + Name;
			Naming.bind(ServerName, RMIDict);
			System.out.println("server sucesslly established");
			System.out.println("server binding is " + ServerName);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
