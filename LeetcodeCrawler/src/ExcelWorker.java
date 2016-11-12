import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import jxl.Workbook;
import jxl.format.Colour;
import jxl.write.DateFormats;
import jxl.write.DateTime;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableHyperlink;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class ExcelWorker {
	
	private static final int COL_SEQ = 0;
	private static final int COL_TITLE = 1;
	private static final int COL_ACCEPTANCE = 2;
	private static final int COL_DIFFICULTY = 3;
	private static final int COL_EXTRA = 4;
	
	private static WritableCellFormat mSeqFormat;
	private static WritableCellFormat mTitleFormat;
	private static WritableCellFormat mLinkFormat;
	private static WritableCellFormat mAcceptanceFormat;
	private static WritableCellFormat mDifficultyFormat;
	private static WritableCellFormat mExtraFormat;
	
	public static void work(String fileName, List<Leetcode> codes) {
		try {
			createExcel(fileName, codes);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void createExcel(String fileName, List<Leetcode> codes) throws Exception {
		File file = new File(fileName);
		BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(file));
		createExcel(os, codes);
		os.flush();
		os.close();
	}
	
	private static WritableCellFormat getSeqFormat() throws Exception {
		if (mSeqFormat == null) {
			WritableFont font = new WritableFont(WritableFont.TIMES, 14, WritableFont.NO_BOLD);
	        font.setColour(Colour.BLACK);
	        mSeqFormat = new WritableCellFormat(font);
	        mSeqFormat.setAlignment(jxl.format.Alignment.CENTRE);
	        mSeqFormat.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
		}
		return mSeqFormat;
	}
	
	private static WritableCellFormat getTitleFormat() throws Exception {
		if (mTitleFormat == null) {
			WritableFont font = new WritableFont(WritableFont.TIMES, 14, WritableFont.NO_BOLD);
	        font.setColour(Colour.BLACK);
	        mTitleFormat = new WritableCellFormat(font);
	        mTitleFormat.setAlignment(jxl.format.Alignment.CENTRE);
	        mTitleFormat.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
		}
		return mSeqFormat;
	}
	
	private static WritableCellFormat getAcceptanceFormat() throws Exception {
		if (mAcceptanceFormat == null) {
			WritableFont font = new WritableFont(WritableFont.TIMES, 14, WritableFont.NO_BOLD);
	        font.setColour(Colour.BLACK);
	        mAcceptanceFormat = new WritableCellFormat(font);
	        mAcceptanceFormat.setAlignment(jxl.format.Alignment.CENTRE);
	        mAcceptanceFormat.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
		}
		return mAcceptanceFormat;
	}
	
	private static WritableCellFormat getDifficultyFormat() throws Exception {
		if (mDifficultyFormat == null) {
			WritableFont font = new WritableFont(WritableFont.TIMES, 14, WritableFont.NO_BOLD);
	        font.setColour(Colour.BLACK);
	        mDifficultyFormat = new WritableCellFormat(font);
	        mDifficultyFormat.setAlignment(jxl.format.Alignment.CENTRE);
	        mDifficultyFormat.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
		}
		return mDifficultyFormat;
	}
	
	private static WritableCellFormat getExtraFormat() throws Exception {
		if (mDifficultyFormat == null) {
			WritableFont font = new WritableFont(WritableFont.TIMES, 14, WritableFont.NO_BOLD);
	        font.setColour(Colour.BLACK);
	        mDifficultyFormat = new WritableCellFormat(font);
	        mDifficultyFormat.setAlignment(jxl.format.Alignment.CENTRE);
	        mDifficultyFormat.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
		}
		return mDifficultyFormat;
	}
	
	private static WritableCellFormat getLinkFormat() throws Exception {
		
		if (mLinkFormat == null) {
			WritableFont font = new WritableFont(WritableFont.TIMES, 14, WritableFont.NO_BOLD);
	        font.setColour(Colour.BLACK);
	        mLinkFormat = new WritableCellFormat(font);
	        mLinkFormat.setAlignment(jxl.format.Alignment.LEFT);
	        mLinkFormat.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
		}
		return mLinkFormat;
	}
	
	private static void createExcel(OutputStream os, List<Leetcode> codes) throws Exception {
        WritableWorkbook workbook = Workbook.createWorkbook(os);
        WritableSheet sheet = workbook.createSheet("Sheet 1", 0);
        
        int row = 0;
        
        for (Leetcode code : codes) {
        	sheet.setRowView(row, 400);
        	
        	sheet.addCell(new Label(COL_SEQ, row, code.Seq, getSeqFormat()));
        	sheet.setColumnView(COL_SEQ, 8);
        	
        	if (row == 0) {
        		sheet.addCell(new Label(COL_TITLE, row, code.Title, getTitleFormat()));
        	} else {
        		WritableHyperlink link = new WritableHyperlink(COL_TITLE, row, new URL(code.Url));
            	link.setDescription(code.Title);
            	sheet.addHyperlink(link);
        	}
        	sheet.setColumnView(COL_TITLE, 50);
        	
        	sheet.addCell(new Label(COL_ACCEPTANCE, row, code.Acceptance, getAcceptanceFormat()));
        	sheet.setColumnView(COL_ACCEPTANCE, 15);
        	
        	sheet.addCell(new Label(COL_DIFFICULTY, row, code.Difficulty, getDifficultyFormat()));
        	sheet.setColumnView(COL_DIFFICULTY, 15);
        	
        	int col = COL_EXTRA;
        	if (code.extra != null) {
        		for (String text : code.extra) {
        			sheet.addCell(new Label(col, row, text, getExtraFormat()));
                	sheet.setColumnView(col, 15);
                	col++;
        		}
        	}
        	
        	row++;
        }
        
        workbook.write();
        workbook.close();
        os.close();
    }
	
}
