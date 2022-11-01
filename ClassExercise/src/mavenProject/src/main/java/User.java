
public abstract class User {
    abstract int id();

    abstract String name();

    abstract int password();

    abstract String email();

    static User create(int id, String name, String email, int password) {
        return new AutoValue_User(id, name, email);
    }

    public boolean compare(String firstList[], String secondList[]) {
        return firstList.equals(secondList);
    }
}
