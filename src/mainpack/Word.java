package mainpack;

import java.util.HashMap;

// µ•¥ ¿‡
public class Word {

	private HashMap<String, String> WordMeaning;
	public Word() {
		WordMeaning = new HashMap<String, String>();
	}
	public Word(String cn, String en, String fr, String gr, String jap) {
		WordMeaning = new HashMap<String, String>();
		WordMeaning.put(RemoteDictionary.LanguageType.Chinese, cn);
		WordMeaning.put(RemoteDictionary.LanguageType.English, en);
		WordMeaning.put(RemoteDictionary.LanguageType.French, fr);
		WordMeaning.put(RemoteDictionary.LanguageType.Germany, gr);
		WordMeaning.put(RemoteDictionary.LanguageType.Japanese, jap);
	}
	public void putWord(String lgg, String meaning) {
		if(WordMeaning.containsKey(lgg)) {
			WordMeaning.remove(lgg);
		}
		WordMeaning.put(lgg, meaning);
	}
	public HashMap<String, String> getWordMeaning(){
		return WordMeaning;
	}
	public String find(String SrcLgg, String DestLgg, String WordInfo) {
		if(!WordMeaning.containsKey(SrcLgg))return null;
		if(!WordMeaning.containsKey(DestLgg))return null;
		if(!WordMeaning.containsValue(WordInfo))return null;
		return WordMeaning.get(DestLgg);
	}

}
