package mainpack;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class RemoteDictionary extends UnicastRemoteObject implements DictQuery{

	/**
	 * ���л�
	 */
	private static final long serialVersionUID = -977528995451798479L;
	ArrayList<Word> WordList;
	public RemoteDictionary() throws RemoteException{
		WordList = new ArrayList<Word>();
		addWords();
	}

	@Override
	public String QueryWord(String SrcLgg, String TarLgg, String WordInfo) throws RemoteException {
		return findWord(SrcLgg, TarLgg, WordInfo);
	}
	void addWords() {
		Word w_apple = new Word("ƻ��", "apple", "pommes", "apple", "���");
		Word w_developer = new Word("������", "developer", "d��veloppeur", "entwickler", "�_�k��");
		Word w_distributed = new Word("�ֲ�ʽ��", "distributed", "distribu��", "verteilt", "�ֲ��򤷤�");
		Word w_computer = new Word("�����", "computer", "ordinateur", "computer", "����ԥ�`��");
		
		WordList.add(w_apple);
		WordList.add(w_developer);
		WordList.add(w_distributed);
		WordList.add(w_computer);
	}
	private String findWord(String srcLgg, String tarLgg, String wordInfo) {
		for (Word word : WordList) {
			if(word.getWordMeaning().containsValue(wordInfo)) {
				return word.find(srcLgg, tarLgg, wordInfo);
			}
		}
		return null;
	}
	// ��������
	public class LanguageType{
		public final static String Chinese = "CN"; // Chinese
		public final static String English = "EN"; // English
		public final static String French = "FR"; // French
		public final static String Germany = "GR"; // Germany
		public final static String Japanese = "JAP"; // Japanese
	}
}
