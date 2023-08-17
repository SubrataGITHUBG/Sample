package com.My.JSP.Project.ContactBook.EXCEL;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.My.JSP.Project.ContactBook.DTO.Contact;

@Service
public class ExcelService 
{
	//by Multipart file we will store the uploded file by client
	public List<Contact> parseExcelfile(MultipartFile file) throws EncryptedDocumentException, IOException
	{
		List<Contact> Contacts=new ArrayList<Contact>();
		Workbook book=WorkbookFactory.create(file.getInputStream());    //creating the workbook and into workbook storinh the file 
		Sheet sheet =book.getSheetAt(0);                                //creating the sheet interface to get the data 
		Iterator<Row> rowIterator=sheet.iterator();                     //itteration along the row by row itterator 
		while(rowIterator.hasNext())
		{
			Row row=rowIterator.next();
			String name=row.getCell(0).getStringCellValue();
			String number=row.getCell(1).getStringCellValue();
			Contact con=new Contact();
			con.setName(name);
			con.setPhone(number);
			Contacts.add(con);
		}
		return Contacts;
	}

}
