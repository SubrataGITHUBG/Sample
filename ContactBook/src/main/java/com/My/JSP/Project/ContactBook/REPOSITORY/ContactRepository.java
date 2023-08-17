package com.My.JSP.Project.ContactBook.REPOSITORY;

import org.springframework.data.jpa.repository.JpaRepository;
import com.My.JSP.Project.ContactBook.DTO.Contact;

public interface ContactRepository extends JpaRepository<Contact,Integer> {

	
}
