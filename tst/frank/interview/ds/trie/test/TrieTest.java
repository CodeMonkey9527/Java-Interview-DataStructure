package frank.interview.ds.trie.test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import frank.interview.ds.trie.Trie;

public class TrieTest {

	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testPut() {
		Trie<String> trie = new Trie<String>();
		trie.put("Frank", "110-119-1234");
		trie.put("Frankie", "110-119-1234");
		trie.put("Franky", "110-119-1234");
		trie.printPreOrder();
	}

	@Test
	public void testGet() {
		Trie<String> trie = new Trie<String>();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader("C:\\Users\\shenshi\\Documents\\dict.txt"));
			String line = null;
			while((line = reader.readLine()) != null) {
				String key = line.trim();
				if(key.matches("[a-z|A-Z]+")) {
//					System.out.println(key);
					trie.put(key, key);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		System.out.println(trie.get("introduction"));
		System.out.println(trie.get("Washington"));
		System.out.println(trie.get("good"));
		System.out.println(trie.get("beautiful"));
		System.out.println(trie.get("state"));
		
		List<String> words = trie.list("consi");
		System.out.println(words);
	}

	@Test
	public void testPrintPreOrder() {
	}

}
