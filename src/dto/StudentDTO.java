package dto;

public class StudentDTO {
    private String id;
    private String Name;
    private String Address;
    private String Contact;
    private String dob;
    private String gender;

    public StudentDTO() {
    }

    public StudentDTO(String id, String name, String address, String contact, String dob,String gender) {
        this.id = id;
        Name = name;
        Address = address;
        Contact = contact;
        this.dob = dob;
        this.gender=gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getDate() {
        return dob;
    }

    public void setDate(String date) {
        this.dob = date;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "id='" + id + '\'' +
                ", Name='" + Name + '\'' +
                ", Address='" + Address + '\'' +
                ", Contact='" + Contact + '\'' +
                ", dob='" + dob + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}

