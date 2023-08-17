package com.My.JSP.Project.ContactBook.DTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
	@Entity
	@Data
	public class Contact
	{
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int id;
		private String Name;
		private String phone;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return Name;
		}
		public void setName(String name) {
			Name = name;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		
		
}
