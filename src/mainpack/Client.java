package mainpack;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Client {

	int PORT = 4700;
	String Location = "127.0.0.1";
	String Name = "RMIDict";
	DictQuery RMIDict;
	boolean flagConnected = false;
	public Client(String Location, int PORT, String Name) {
		this.Location = Location;
		this.PORT = PORT;
		this.Name = Name;
		init();
		LoopQuery();
	}
	void init() {
		try {
			String ServerName = "rmi://" + Location + ":" + PORT + "/" + Name;
			System.out.println("connecting to " + ServerName);
			RMIDict = (DictQuery) Naming.lookup(ServerName);
			System.out.println("client connected to server");
			flagConnected = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 循环查找
	 */
	void LoopQuery() {
		if(!flagConnected)return;
		Scanner input = new Scanner(System.in);
		boolean isContinue = true;
		while(isContinue) {
			System.out.println("请分别在以下三行中输入源语言、目标语言、要查找的单词");
			String SrcLgg = input.nextLine();
			String TarLgg = input.nextLine();
			String WordInfo = input.nextLine();
			if(WordInfo.equals("_bye")) {
				System.out.println("bye bye");
				isContinue = false;
			}else {
				try {
					String Answser = RMIDict.QueryWord(SrcLgg, TarLgg, WordInfo);// 调用RMI
					System.out.println("源语言:" + SrcLgg + ", 目标语言:" + TarLgg + ", 单词:" + 
						WordInfo + ", 释义:" + Answser + ";");
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
				
				}
			}
		}
		if(input != null)input.close();
	}

}
