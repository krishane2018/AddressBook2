import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.event.ListDataListener;

@Entity
public class AddressBook extends DefaultListModel {

    @Id
    @GeneratedValue
    private int id;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<BuddyInfo> bis;

    public AddressBook(int id) {
        bis = new ArrayList<>();
        this.id = id;
    }

    public AddressBook() {
        this(0);
    }

    public void clear() {
        bis.clear();
        super.clear();
    }

    public void addBuddy(BuddyInfo bud) {
        if (bud != null) {
            bis.add(bud);
            super.addElement(bud);
        }
    }

    public void removeBuddy(int index) {
        if (index >= 0 && index < super.size()) {
            bis.remove(index);
            super.remove(index);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Collection<BuddyInfo> getBuddies() {
        return bis;
    }

    public void setBuddies(List<BuddyInfo> bis) {
        this.bis = bis;
    }

    public String toString() {
        return bis.toString();
    }

    public void addListener(ListDataListener l) {
        super.addListDataListener(l);
    }

    public static void main(String args[]) {
        AddressBook addy = new AddressBook();

        BuddyInfo buddy = new BuddyInfo("Bob", "hello drive", "613-234-3333", 0);
        BuddyInfo buddy2 = new BuddyInfo("Bill", "bye drive", "613-987-2222", 0);
        BuddyInfo buddy3 = new BuddyInfo("Brian", "allo drive", "613-182-4221", 0);

		addy.addBuddy(buddy);
        addy.addBuddy(buddy2);
        addy.addBuddy(buddy3);
        System.out.println(addy);
    }
}
