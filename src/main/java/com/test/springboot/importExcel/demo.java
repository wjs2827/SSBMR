package com.test.springboot.importExcel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

public class demo extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	static JPanel p;
	static JTextField jf;
	
	public static void main(String[] args) {
		ExcelExamWrite excel = new ExcelExamWrite();
		String filePath = "D://WXWork//po";
		excel.createExcel(filePath);
	}
	
	public static class ExcelExamWrite {
		// 新建一个Excel文件，里面添加5行5列的内容，另外添加一个合并2行5列的大单元格以及一个合并2行1列的5个合并单元格。
		public void createExcel(String filePath) {
			File file = new File(filePath);// 创建excel文件对象
			if (!file.exists() && !file.isDirectory() && file.mkdirs()) {
				 System.out.println("本地文件目录创建成功 filePath:"+filePath+"");
			}
			String fileName=filePath.concat("/po20190829.xls");
			File file2 = new File(fileName);
            try {
				if (!file2.exists() && file2.createNewFile()) {
					System.out.println("本地文件创建成功 filePath:"+file2+"");
				}
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			FileOutputStream fOut = null;
			try {
				// 创建一个新的HSSFWorkbook对象
				HSSFWorkbook workbook = new HSSFWorkbook();
				//设置标题背景以及字体
				HSSFCellStyle style = workbook.createCellStyle();     
				style.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);     
				style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);     
				HSSFFont font = workbook.createFont();     
				font.setColor(HSSFColor.BLACK.index);  
				style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中  
				font.setFontName("黑体");
				style.setFont(font);     
				// 创建一个Excel的工作表，可以指定工作表的名字
				HSSFSheet sheet = workbook.createSheet("po20190829");
				List<PoBean> poBeanList=new ArrayList<>();
				poBeanList.add(new PoBean());
				poBeanList.add(new PoBean());
				//设置单元格表头 start
				HSSFRow row = sheet.createRow(0);
				HSSFCell cell0 = row.createCell(0);
				cell0.setCellValue("po_supplierCode");
				cell0.setCellStyle(style);
				HSSFCell cell1 = row.createCell(1);
				row.createCell(1).setCellValue("po_markup");
				cell1.setCellStyle(style);
				HSSFCell cell2 = row.createCell(2);
				row.createCell(2).setCellValue("po_fob");
				cell2.setCellStyle(style);
				HSSFCell cell3 = row.createCell(3);
				row.createCell(3).setCellValue("po_qty");
				cell3.setCellStyle(style);
				//设置单元格表头 end
				for (int rowContent=0; rowContent <poBeanList.size(); rowContent++) {
					int rowCount=rowContent+1;
					row = sheet.createRow(rowCount);
				    // 在当前行的colNum位置创建单元格
					row.createCell(0).setCellValue(poBeanList.get(rowContent).getSupplierCode());
					row.createCell(1).setCellValue(poBeanList.get(rowContent).getMarkUp());
					row.createCell(2).setCellValue(String.valueOf(poBeanList.get(rowContent).getFob()));
					row.createCell(3).setCellValue(poBeanList.get(rowContent).getQty());
				}
				// 新建一输出文件流
				fOut = new FileOutputStream(file2);
				// 将创建的内容写到指定的Excel文件中
				workbook.write(fOut);
				fOut.flush();
				fOut.close();// 操作结束，关闭文件
				System.out.println("Excel文件创建成功！\nExcel文件的存放路径为："
						+ file.getAbsolutePath());
			} catch (Exception e) {
				System.out.println("Excel文件" + file.getAbsolutePath()
						+ "创建失败\n其原因为：" + e);
			} finally {
				if (fOut != null) {
					try {
						fOut.close();
					} catch (IOException e1) {
					}
				}
			}
		}
	}
}
