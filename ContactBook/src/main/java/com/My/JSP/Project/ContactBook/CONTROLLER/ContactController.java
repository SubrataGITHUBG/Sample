package com.My.JSP.Project.ContactBook.CONTROLLER;

import java.io.IOException;
import java.util.List;
import org.apache.poi.EncryptedDocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import com.My.JSP.Project.ContactBook.DTO.Contact;
import com.My.JSP.Project.ContactBook.EXCEL.ExcelService;
import com.My.JSP.Project.ContactBook.SERVICE.ContactService;

@RestController
@RequestMapping("/Contact")
public class ContactController {
 @Autowired
 ContactService service;
 
 @Autowired
 ExcelService excel;
 
 //add the contact details to DB
 @PostMapping
 public ResponseEntity<Contact>addContact(@RequestBody Contact con)
 {
	 Contact savedContact=service.addContact(con);
	 return ResponseEntity.ok(savedContact);
 }
 
 //API to get all the contacts
 @GetMapping
 public ResponseEntity<List<Contact>> findAllContact()
 {
	 List<Contact>list=service.getallContacts();
	 return ResponseEntity.ok(list);
 }
 
 
 //API to get  the contacts by id
 @GetMapping("/byid")
 public ResponseEntity<Contact> searchbyId(@RequestParam int id)
 {
	 Contact con=service.searchContact(id);
	 if(con!=null)
	 {
		 return ResponseEntity.ok(con);
	 }
	 else
	 {
		 return ResponseEntity.notFound().build();
	 }
 }
 
 //APi to update the contact into database
 @PutMapping
 public ResponseEntity<Contact>updateContact(@RequestParam String name,@RequestParam int id )
 {
	 Contact updatecontact=service.updatecontact(name, id);
	 if(updatecontact!=null)
	 {
		 return ResponseEntity.ok(updatecontact);
	 }
	 return ResponseEntity.notFound().build();
 }
 
 //API to delete the contact in the Database
 @DeleteMapping
 public ResponseEntity<Void> Deletecontact(@RequestParam int id)
 {
	 int a=service.removeContact(id);
	 if(a==1)
	 {
		 return ResponseEntity.ok().build();
		 
	 }
	 else
	 {
		 return ResponseEntity.notFound().build(); 
	 }
 }
 
 //api to upload the file into the DB
 
 @PostMapping("/upload")
 public ResponseEntity<List<Contact>> uploadFile(@RequestParam ("file")MultipartFile file ) throws EncryptedDocumentException, IOException
 {
	 try
	 {
		 List<Contact>list=excel.parseExcelfile(file);
		 for(Contact c : list)
		 {
			 service.addContact(c);
			 
		 }
		 return ResponseEntity.ok(list);
	 }
	 catch(IOException e)
	 {
		 return ResponseEntity.badRequest().build();
	 }
			 
 }
 
 
 
}













