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
        buddy = new BuddyInfo("Bob", "hello drive", "613-234-3333", 0);
        buddy2 = new BuddyInfo("Bill", "bye drive", "613-987-2222", 1);

        addy.addBuddy(buddy);
        addy.addBuddy(buddy2);

    }

    @Test
    public void addBuddy() {
        int initSize = addy.getBuddies().size();
        addy.addBuddy(new BuddyInfo("Brian", "allo drive", "613-182-4221", 2));
        assertEquals(initSize + 1, addy.getBuddies().size());
    }

    @Test
    public void removeBuddy() {
        int initSize = addy.getBuddies().size();
        addy.removeBuddy(buddy);
        assertEquals(initSize - 1, addy.getBuddies().size());
    }
}