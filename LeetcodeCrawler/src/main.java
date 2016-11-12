import java.util.List;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Leetcode> codes = LeetcodeCrawler.generateLeetcode();
		
		for (Leetcode code : codes) {
			System.out.println(String.format("%s\t%s\t%s\t%s\t%s", 
					code.Seq, code.Title, code.Url, code.Acceptance, code.Difficulty));
		}
		
		ExcelWorker.work("Leetcode.xls", codes);
	}
}
