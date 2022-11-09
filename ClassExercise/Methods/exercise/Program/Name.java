package Methods.exercise.Program;

public class Name {
    public String FirstName;
    public String LastName;
    generator g = new generator();

    public Name() {
        FirstName = g.getFirstName();
        LastName = g.getLastName();
    }

    public void printFullName(){
       System.out.println(FirstName + "  " + LastName);
    }
}
