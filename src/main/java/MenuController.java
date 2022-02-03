import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class MenuController implements ActionListener {

    private AddressBook model;
    private static int count = 0;

    public MenuController(AddressBook model) {
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = e.getActionCommand();
        if (name.equals("Create New Address Book")) {
            model.clear();
        }
        else if (name.equals("Remove Buddy")) {
            model.removeBuddy(0);
        }
        else if (name.equals("Add Buddy")) {
            final JDialog dialog = new JDialog();
            dialog.setAlwaysOnTop(true);
            String input = JOptionPane.showInputDialog(dialog, "Enter info, space separated.");
            String[] inputArr = input.split(" ");

            model.addBuddy(new BuddyInfo(inputArr[0], inputArr[1], inputArr[2], count++));
        }
    }

}