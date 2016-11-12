import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class LeetcodeCrawler {
	
	private static final String PATH = "Leetcode.html";
	
	private static final String URL_BASE = "https://leetcode.com";
	
	private static final int SEQ_INDEX = 1;
	private static final int TITLE_INDEX = 2;
	private static final int ACCEPTANCE_INDEX = 4;
	private static final int DIFFICULTY_INDEX = 5;
	
	public static List<Leetcode> generateLeetcode() {
		List<Leetcode> codes = new ArrayList<Leetcode>();
		
		Leetcode title = new Leetcode();
		title.Seq = "Seq";
		title.Title = "Title";
		title.Url = "Url";
		title.Acceptance = "Acceptance";
		title.Difficulty = "Difficulty";
		title.extra = new String[] {
				"Watch 1", "Watch 2", "Watch 3", "Code 1", "Code 2", "Code 3"
		};
		
		codes.add(title);
		
		try {
			codes.addAll(craw());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return codes;
	}
	
	private static List<Leetcode> craw() throws Exception {
		File leetcode = new File(PATH);
		Document doc = Jsoup.parse(leetcode, "UTF-8", "");
		
		Elements elements = doc.getElementsByClass("reactable-data");
		
		List<Leetcode> leetcodes = new ArrayList<Leetcode>();
		
		if (elements != null && elements.size() > 0) {
			Element data = elements.get(0);
			Elements trs = data.getElementsByTag("tr");
			
			if (trs != null && trs.size() > 0) {
				for (Element tr : trs) {
					Elements tds = tr.getElementsByTag("td");
					if (tds != null && tds.size() >= 7) {
						Leetcode code = new Leetcode();
						code.Seq = tds.get(SEQ_INDEX).text();
						Element title = tds.get(TITLE_INDEX);
						code.Title = title.val();
						Elements as = title.getElementsByTag("a");
						if (as != null && as.size() > 0) {
							code.Url = String.format("%s%s", URL_BASE, as.get(0).attr("href"));
						}
						code.Acceptance = tds.get(ACCEPTANCE_INDEX).text();
						code.Difficulty = tds.get(DIFFICULTY_INDEX).text();
						leetcodes.add(code);
					}
				}
			}
		}
		
		return leetcodes;
	}
}
