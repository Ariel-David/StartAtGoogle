package CommonMethods.exercies;

import java.util.Objects;

public class Contact implements Comparable<Contact> {
    Name name;
   PhoneNumber phoneNumber;

    public Contact(){
        name = new Name();
        phoneNumber = new PhoneNumber();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;
        Contact contact = (Contact) o;
        return name == contact.name && Objects.equals(phoneNumber, contact.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phoneNumber);
    }

    @Override
    public String toString() {
        return ("Name: " + name + " Phone Number: " + phoneNumber);
    }

    public Contact(Contact contact){
        name = new Name(contact.name);
        phoneNumber = new PhoneNumber(contact.phoneNumber);
    }

    @Override
    public int compareTo(Contact o) {
        if((this.name.equals(o.name)) && (this.phoneNumber.equals(o.phoneNumber))) return 0;
        return -1;
    }
}
