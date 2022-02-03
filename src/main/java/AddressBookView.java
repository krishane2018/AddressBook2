import javax.swing.JFrame;
import javax.swing.JList;

import java.awt.BorderLayout;


import javax.swing.*;

public class AddressBookView extends JFrame{
    private AddressBook addy;
    private JList<BuddyInfo> buddies;
    private JMenuBar menuBar;
    private JMenu addressBook, buddyInfo;
    private JMenuItem createBook, addBuddy, delBuddy;

    public AddressBookView(AddressBook addy, MenuController mC) {
        this.addy = addy;
        this.buddies = new JList<BuddyInfo>(addy);

        this.menuBar = new JMenuBar();
        this.addressBook = new JMenu("Address Book");
        this.buddyInfo = new JMenu("Buddy Info");
        this.createBook = new JMenuItem("Create New Address Book");
        this.addBuddy = new JMenuItem("Add Buddy");
        this.delBuddy = new JMenuItem("Remove Buddy");

        addBuddy.addActionListener(mC);
        createBook.addActionListener(mC);
        delBuddy.addActionListener(mC);

        addressBook.add(createBook);
        buddyInfo.add(addBuddy);
        buddyInfo.add(delBuddy);
        menuBar.add(addressBook);
        menuBar.add(buddyInfo);
        BorderLayout b = new BorderLayout();
        JPanel p = new JPanel();
        p.add(buddies, BorderLayout.CENTER);
        this.add(p);
        this.setJMenuBar(menuBar);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400,400);
        this.setVisible(true);
    }


    public static void main (String[] args) {
        AddressBook addy = new AddressBook();
        MenuController mC = new MenuController(addy);
        AddressBookView aBV = new AddressBookView(addy, mC);
    }
}
