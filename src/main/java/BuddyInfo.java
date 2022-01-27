import javax.persistence.*;

@Entity
public class BuddyInfo {

    private int id;

    private String name;

    private String address;

    private String phone;

    private AddressBook addBook;

    /* Constructor
     */
    public BuddyInfo(String name, String address, String phone, int id, AddressBook addBook) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.addBook = addBook;
        this.id = id;
    }

    public BuddyInfo() {
        this("", "", "", 0, new AddressBook());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne
    public AddressBook getAddBook() {
        return addBook;
    }

    public void setAddBook(AddressBook addBook) {
        this.addBook = addBook;
    }

    public boolean equals(BuddyInfo buddy) {
        if(buddy == null) return false;
        if(buddy == this) return true;
        if(buddy.getClass() != this.getClass()) return false;
        BuddyInfo bud = (BuddyInfo)buddy;
        if(bud.getAddress().equals(this.address) && bud.getName().equals(this.name) && bud.getPhone().equals(this.phone)) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "{ID: " + this.id + "Name: " + this.name + ", Phone: " + this.phone + ", Address: " + this.address + "}";
    }

}