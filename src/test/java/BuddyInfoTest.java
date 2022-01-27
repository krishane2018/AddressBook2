import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BuddyInfoTest {

    private BuddyInfo buddy;

    @Before
    public void setUp() {
        buddy = new BuddyInfo("Bob", "hello drive", "613-234-3333", 0, new AddressBook());
    }

    @Test
    public void getName() {
        assertEquals(buddy.getName(), "Bob");
    }

    @Test
    public void setName() {
        buddy.setName("Brian");
        assertEquals(buddy.getName(), "Brian");
    }

    @Test
    public void getAddress() {
        assertEquals(buddy.getAddress(), "hello drive");
    }

    @Test
    public void setAddress() {
        buddy.setAddress("bye drive");
        assertEquals(buddy.getAddress(), "bye drive");
    }

    @Test
    public void getPhone() {
        assertEquals(buddy.getPhone(), "613-234-3333");
    }

    @Test
    public void setPhone() {
        buddy.setPhone("613-987-2222");
        assertEquals(buddy.getPhone(), "613-987-2222");
    }

    @Test
    public void testEquals() {
        BuddyInfo buddy2 = new BuddyInfo("Bob", "hello drive", "613-234-3333", 0, new AddressBook());
        assertTrue(buddy.equals(buddy2));
    }
}