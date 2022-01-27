import org.junit.Before;
import org.junit.Test;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class PersistenceTest {

    BuddyInfo buddy;
    BuddyInfo buddy2;
    AddressBook addy;


    @Before
    public void setUp() {
        addy = new AddressBook();
        buddy = new BuddyInfo("Bob", "hello drive", "613-234-3333", 0, addy);
        buddy2 = new BuddyInfo("Bill", "bye drive", "613-987-2222", 1, addy);
    }

    @Test
    public void persistenceTest() {



        ArrayList<BuddyInfo> buddies = new ArrayList<BuddyInfo>();
        buddies.add(buddy);
        buddies.add(buddy2);

        addy.addBuddy(buddy);
        addy.addBuddy(buddy2);

        // Connecting to the database through EntityManagerFactory
        // connection details loaded from persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test");

        EntityManager em = emf.createEntityManager();

        // Creating a new transaction
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        em.persist(addy);

        // Persisting the product entity objects
        em.persist(buddy);
        em.persist(buddy2);

        tx.commit();

        // Querying the contents of the database using JPQL query
        Query q = em.createQuery("SELECT bi FROM BuddyInfo bi");

        Query q2 = em.createQuery("SELECT a FROM AddressBook a");


        @SuppressWarnings("unchecked")
        List<BuddyInfo> results = q.getResultList();

        List<AddressBook> results2 = q2.getResultList();


        System.out.println("List of BuddyInfos\n----------------");

        for (BuddyInfo bi : results) {

            System.out.println(bi.getName() + " (id=" + bi.getId() + ")");
        }

        for (AddressBook ab : results2) {

            System.out.println(ab.getBuddies() + " (id=" + ab.getId() + ")");
        }

        // Closing connection
        em.close();

        emf.close();

        assertTrue(buddies.containsAll(results) && buddies.size() == results.size());
    }
}