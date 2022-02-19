import com.example.accessingdatajpa.AddressBook;
import com.example.accessingdatajpa.BuddyInfo;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddressBookTest {

    BuddyInfo buddy;
    BuddyInfo buddy2;

    AddressBook addy;

    @Before
    public void setUp() {
        addy = new AddressBook();
        buddy = new BuddyInfo("Bob", "hello drive", "613-234-3333");
        buddy2 = new BuddyInfo("Bill", "bye drive", "613-987-2222");

        addy.addBuddy(buddy);
        addy.addBuddy(buddy2);

    }

    @Test
    public void addBuddy() {
        int initSize = addy.getBuddies().size();
        addy.addBuddy(new BuddyInfo("Brian", "allo drive", "613-182-4221"));
        assertEquals(initSize + 1, addy.getBuddies().size());
    }

    @Test
    public void removeBuddy() {
        int initSize = addy.getBuddies().size();
        addy.removeBuddy(0);
        assertEquals(initSize - 1, addy.getBuddies().size());
    }
}