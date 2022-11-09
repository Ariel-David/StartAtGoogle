package CommonMethods.exercies;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class Name implements Comparable<Name>{
    Prefix prefix;
    public String FirstName;
    public String LastName;
    Generator g = new Generator();

    public Name() {
        FirstName = g.getFirstName();
        LastName = g.getLastName();
        prefix = Prefix.randomPrefix();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Name)) return false;
        Name name = (Name) o;
        return FirstName == name.FirstName && Objects.equals(LastName, name.LastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(FirstName, LastName);
    }

    @Override
    public String toString() {
        return (this.prefix.toString()+"    "+this.FirstName+" "+this.LastName);
    }

    public Name(Name name){
        FirstName = new String(name.FirstName);
        LastName = new String(name.LastName);
    }

    @Override
    public int compareTo(Name o) {
        if((this.FirstName.equals(o.FirstName)) && (this.LastName.equals(LastName))) return 0;
        return -1;
    }
}
