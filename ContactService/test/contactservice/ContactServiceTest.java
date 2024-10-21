package contactservice;

import org.junit.jupiter.api.*;

class ContactServiceTest {
	
	private ContactService contactService;
	private Contact c1;
	private Contact c2;
	private Contact c3;
	
	@BeforeEach
	public void setUp() {
		contactService = new ContactService();
		c1 = new Contact("1", "John", "Doe", "1234567890", "123");
		c2 = new Contact("2", "Jane", "Smith", "0987654321", "321");
		c3 = new Contact("1", "Jack", "Davis", "1234543210", "121");
	}

	@Test
	void testAddContact_noContacts() {
		Assertions.assertTrue(contactService.addContact(c1));
		Assertions.assertFalse(contactService.addContact(c1));
	}
	
	@Test
	void testAddContact_withContacts() {
		contactService.addContact(c1);
		Assertions.assertTrue(contactService.addContact(c2));
		
		Assertions.assertFalse(contactService.addContact(c3));
	}
	
	@Test
	void testDeleteContact() {
		contactService.addContact(c1);
		contactService.addContact(c2);
		contactService.deleteContact("1");
		contactService.deleteContact("3");
		
		Assertions.assertEquals(1, contactService.contactList.size());
		Assertions.assertTrue(contactService.contactList.contains(c2));
	}
	
	@Test
	void testChangeFirstName() {
		contactService.addContact(c1);
		contactService.addContact(c2);
		contactService.changeFirstName("1", "Daniel");
		contactService.changeFirstName("2", "Joe");
		
		Assertions.assertEquals("Daniel", contactService.contactList.get(0).getFirstName());
		Assertions.assertEquals("Joe", contactService.contactList.get(1).getFirstName());
	}
	
	@Test
	void testChangeLastName() {
		contactService.addContact(c1);
		contactService.addContact(c2);
		contactService.changeLastName("1", "Daniel");
		contactService.changeLastName("2", "Joe");
		
		Assertions.assertEquals("Daniel", contactService.contactList.get(0).getLastName());
		Assertions.assertEquals("Joe", contactService.contactList.get(1).getLastName());
	}
	
	@Test
	void testChangeNumber() {
		contactService.addContact(c1);
		contactService.addContact(c2);
		contactService.changeNumber("1", "1111111111");
		contactService.changeNumber("2", "2222222222");
		
		Assertions.assertEquals("1111111111", contactService.contactList.get(0).getNumber());
		Assertions.assertEquals("2222222222", contactService.contactList.get(1).getNumber());
	}
	
	@Test
	void testChangeAddress() {
		contactService.addContact(c1);
		contactService.addContact(c2);
		contactService.changeAddress("1", "12345");
		contactService.changeAddress("2", "54321");
		
		Assertions.assertEquals("12345", contactService.contactList.get(0).getAddress());
		Assertions.assertEquals("54321", contactService.contactList.get(1).getAddress());
	}

}
