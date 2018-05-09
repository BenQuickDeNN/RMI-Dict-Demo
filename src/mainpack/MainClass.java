package mainpack;
/**
 * MainClass for Server
 * @author Qu Bin
 *
 */
public class MainClass {

	public MainClass() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		if(args.length != 4) {
			System.out.println("parameters does not matched!");
		}else {
			switch (args[0]) {
			case "server":
				new DictServer(args[1], Integer.parseInt(args[2]), args[3]);
				break;
			case "client":
				new Client(args[1], Integer.parseInt(args[2]), args[3]);
				break;
			default:
				System.out.println("invalid command!");
				break;
			}
			
		}
	}

}
