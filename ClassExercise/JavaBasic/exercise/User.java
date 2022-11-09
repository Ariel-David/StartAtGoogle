package JavaBasic.exercise;

public class User {
    public String Name;
    public int id;
    public Boolean IsActivated;

    public User() {
        this.Name = Name;
        this.id = id;
        this.IsActivated = true;
    }

    public User(String name, int id, Boolean isActivated) {
        Name = name;
        this.id = id;
        IsActivated = isActivated;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setActivated(Boolean activated) {
        IsActivated = activated;
    }

    public String getName() {
        return Name;
    }

    public int getId() {
        return id;
    }

    public Boolean getActivated() {
        return IsActivated;
    }
}
