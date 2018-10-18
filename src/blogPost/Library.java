package blogPost;


import java.io.Serializable;  
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

public class Library implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String name, address, phone;
	
	
	/*public Library(int id, String name, String address, String phone){
		
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}*/

	public int getId() {
		return id;
	}

	@XmlElement
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	@XmlElement
	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}
	
	@XmlElement
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	

}
