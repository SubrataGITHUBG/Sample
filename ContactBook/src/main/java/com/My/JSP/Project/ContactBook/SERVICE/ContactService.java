package com.My.JSP.Project.ContactBook.SERVICE;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.My.JSP.Project.ContactBook.DTO.Contact;
import com.My.JSP.Project.ContactBook.REPOSITORY.ContactRepository;

@Service
public class ContactService {
	
	@Autowired
	ContactRepository repository;
	
	//to save the object into the DB
	public Contact addContact(Contact con)
	{
		return repository.save(con);
	}
	
	
	//to search the contact into the DB
	public Contact searchContact(int id)
	{
		Optional<Contact>opt=repository.findById(id);
		
		if(opt.isPresent())
		{
			return opt.get();
		}
		return null;
	}
	
	
	//to remove the contact from the database
	public int removeContact(int id )
	{
		Contact c=searchContact(id);
		{
			if(c!=null)
			{
				 repository.deleteById(id);
				 return 1;
			}
			return 0;
		}
				
	}
	
	//to get all contact from the DB
	public List<Contact>getallContacts()
	{
		return repository.findAll();
	}
	
	
	//to update the contact into the DB
	public Contact updatecontact(String name,int id)
	{
		Contact c=searchContact(id);
		if(c!=null)
		{
			c.setName(name);
			repository.save(c);
			return c;
		}
		return null;
	}

	
}
