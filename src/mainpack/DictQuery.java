package mainpack;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 查询用RMI接口
 * @author Qu Bin
 *
 */
public interface DictQuery extends Remote{
	/**
	 * 通过源语言、目标语言、单词内从查找释义
	 * @param SrcLgg 源语言
	 * @param TarLgg 目标语言
	 * @param WordInfo 单词内容
	 * @return 目标语言的单词内容
	 * @throws RemoteException
	 */
	public String QueryWord(String SrcLgg, String TarLgg, String WordInfo) throws RemoteException;
}
