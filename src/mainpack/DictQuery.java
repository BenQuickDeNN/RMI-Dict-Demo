package mainpack;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * ��ѯ��RMI�ӿ�
 * @author Qu Bin
 *
 */
public interface DictQuery extends Remote{
	/**
	 * ͨ��Դ���ԡ�Ŀ�����ԡ������ڴӲ�������
	 * @param SrcLgg Դ����
	 * @param TarLgg Ŀ������
	 * @param WordInfo ��������
	 * @return Ŀ�����Եĵ�������
	 * @throws RemoteException
	 */
	public String QueryWord(String SrcLgg, String TarLgg, String WordInfo) throws RemoteException;
}
