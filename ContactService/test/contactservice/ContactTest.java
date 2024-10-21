package contactservice;


import org.junit.jupiter.api.*;

import org.junit.jupiter.api.Test;

class ContactTest {
	
	private Contact contact;
	
	@BeforeEach
	public void setUp() {
		contact = new Contact("123", "John", "Doe", "1234567890", "123 Maple Street");
	}
	
	@Test
	public void testNewContact_id() {
		Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact = new Contact ("12345678901", "Jane", "Smith", "1234567890", "123");
		});
		Assertions.assertEquals("Invalid ID", exception.getMessage());
		
		exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact = new Contact (null, "Jane", "Smith", "1234567890", "123");
		});
		Assertions.assertEquals("Invalid ID", exception.getMessage());
	}
		
	@Test
	public void testNewContact_firstName() {
		Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact = new Contact ("321", "12345678901", "Smith", "1234567890", "123");
		});
		Assertions.assertEquals("Invalid First Name", exception.getMessage());
			
		exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact = new Contact ("321", null, "Smith", "1234567890", "123");
		});
		Assertions.assertEquals("Invalid First Name", exception.getMessage());
		}
	
	@Test
	public void testNewContact_lastName() {
		Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact = new Contact ("321", "Jane", "12345678901", "1234567890", "123");
		});
		Assertions.assertEquals("Invalid Last Name", exception.getMessage());
		
		exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact = new Contact ("321", "Jane", null, "1234567890", "123");
		});
		Assertions.assertEquals("Invalid Last Name", exception.getMessage());
	}
	
	@Test
	public void testNewContact_number() {
		Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact = new Contact ("321", "Jane", "Smith", "12345678901", "123");
		});
		Assertions.assertEquals("Invalid Number", exception.getMessage());
		
		exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact = new Contact ("321", "Jane", "Smith", null, "123");
		});
		Assertions.assertEquals("Invalid Number", exception.getMessage());
		
		exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact = new Contact ("321", "Jane", "Smith", "123456789", "123");
		});
		Assertions.assertEquals("Invalid Number", exception.getMessage());
	}
	
	@Test
	public void testNewContact_address() {
		Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact = new Contact ("321", "Jane", "Smith", "1234567890", "1234567890123456789012345678901");
		});
		Assertions.assertEquals("Invalid Address", exception.getMessage());
		
		exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact = new Contact ("321", "Jane", "Smith", "1234567890", null);
		});
		Assertions.assertEquals("Invalid Address", exception.getMessage());
	}
	
	@Test
	public void testGetId() {
		Assertions.assertEquals("123", contact.getId());
	}
	@Test
	public void testGetFirstName() {
		Assertions.assertEquals("John", contact.getFirstName());
	}
	@Test
	public void testGetLastName() {
		Assertions.assertEquals("Doe", contact.getLastName());
	}
	@Test
	public void testGetNumber() {
		Assertions.assertEquals("1234567890", contact.getNumber());
	}
	@Test
	public void testGetAddress() {
		Assertions.assertEquals("123 Maple Street", contact.getAddress());
	}
	
	@Test
	public void testSetFirstName() {
		Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setFirstName("12345678901");
		});
		Assertions.assertEquals("Invalid First Name", exception.getMessage());
	}
	
	@Test
	public void testSetLastName() {
		Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setLastName("12345678901");
		});
		Assertions.assertEquals("Invalid Last Name", exception.getMessage());
	}
	
	@Test
	public void testSetNumber() {
		Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setNumber("12345678901");
		});
		Assertions.assertEquals("Invalid Number", exception.getMessage());
	}
	
	@Test
	public void testSetAddress() {
		Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setAddress("1234567890123456789012345678901");
		});
		Assertions.assertEquals("Invalid Address", exception.getMessage());
	}

}
