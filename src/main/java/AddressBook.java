import java.util.ArrayList;

public class AddressBook  {

    private ArrayList<BuddyInfo> bis;

    public AddressBook() {
        bis = new ArrayList<BuddyInfo>();
    }

    public void addBuddy(BuddyInfo bud) {
        if (bud != null) {
            bis.add(bud);
        }
    }

    public void removeBuddy(int index) {
        if (index >= 0 && index < bis.size()) {
            bis.remove(index);
        }
    }

    public ArrayList<BuddyInfo> getBuddies() {
        return bis;
    }

    public String toString() {
        return bis.toString();
    }

    public static void main(String args[]) {
		BuddyInfo buddy = new BuddyInfo("Bob", "hello drive", "613-234-3333");
        BuddyInfo buddy2 = new BuddyInfo("Bill", "bye drive", "613-987-2222");
        BuddyInfo buddy3 = new BuddyInfo("Brian", "allo drive", "613-182-4221");

        AddressBook addy = new AddressBook();
		addy.addBuddy(buddy);
        addy.addBuddy(buddy2);
        addy.addBuddy(buddy3);
        System.out.println(addy);
    }
}
