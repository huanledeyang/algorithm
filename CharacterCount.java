import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class CharacterCount {
	
	public LinkedHashMap<String,Integer> lhs = new LinkedHashMap<String, Integer>();
	
	
	public void getCharacterCount(String str){
		String[] split = str.split("\\.\\s*|\\s+|,\\s*^[\u4e00-\u9fa5]{0,128}$");
		for(int i=0; i<split.length; i++) {
			if(!lhs.containsKey(split[i])){
				lhs.put(split[i], 1);
			}else{
				lhs.put(split[i], lhs.get(split[i])+1);
			}
		}
	}
	
	public void getFile(String filePath){
		try {
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			String str = null;
			try {
				while((str = br.readLine()) != null) {
					getCharacterCount(str);
				}
			} catch (IOException e) {
				// TODO Auto-generated catcdh block
				e.printStackTrace();
			}finally{
				if(br != null){
					try {
						br.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	
	public void print(){
		Iterator<Entry<String, Integer>> iterator = lhs.entrySet().iterator();
		Entry<String, Integer> entry;
		while(iterator.hasNext()) {
			entry = iterator.next();
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}
	
	public static void main(String args[]){
		CharacterCount cc = new CharacterCount();
		cc.getFile("D:/test.txt");
		cc.print();
	}
}
