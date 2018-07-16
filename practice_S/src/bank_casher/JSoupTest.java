package bank_casher;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JSoupTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "http://news.naver.com/";
		String css = "strong";
		
		try {
			Document doc = Jsoup.connect(url).get();
			Elements body = doc.select(css);
			for(int i=0; i<20; i++) {
				Element e = body.get(i);
				System.out.println(e.text());
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		

	}

}


