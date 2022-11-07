package BehavioralPatterns;

public class Group implements Appliance{
    int id;
    int size;

    @Override
    public String accept(Visitor visitor) {
       return visitor.visit(this);
    }

    public Group(int id, int size) {
        this.id = id;
        this.size = size;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                "size=" + size +
                '}';
    }
}
