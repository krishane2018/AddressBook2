package com.example.accessingdatajpa;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.event.ListDataListener;

@Entity
public class AddressBook extends DefaultListModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "addressBook")
    private List<BuddyInfo> bis;

    public AddressBook() {
        bis = new ArrayList<>();
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

}
