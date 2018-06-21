package com.selenium.MavenSelenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadWriteExcel {

	public static void main(String[] args) {
		 FileInputStream fis =null;
		 XSSFWorkbook excel = null;
		 FileOutputStream fos=null;
		try {
		     File f=new File("resources/exceltoread.xlsx");
		
		     fis = new FileInputStream(f);
			 excel=new XSSFWorkbook(fis);
				
			  XSSFSheet sheet=excel.getSheet("selenium");
			 
				String user=sheet.getRow(0).getCell(0).getStringCellValue();
				String pass=sheet.getRow(0).getCell(1).getStringCellValue();
				String log=sheet.getRow(1).getCell(0).getStringCellValue();
				String user1=sheet.getRow(1).getCell(1).getStringCellValue();
				String pass1=sheet.getRow(2).getCell(0).getStringCellValue();
				String log1=sheet.getRow(2).getCell(1).getStringCellValue();
					 
					 
					 System.out.println(user);
					 System.out.println(pass);
					 System.out.println(log);	
					 System.out.println(user1);
					 System.out.println(pass1);
					 System.out.println(log1);
		
		sheet.getRow(1).createCell(2).setCellValue("pass");
		sheet.getRow(2).createCell(2).setCellValue("fail");
				
		 fos=new FileOutputStream(f);
		
				
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			finally {
				
				try {
					excel.write(fos);
					excel.close();
					fis.close();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
				
		
	}

}
