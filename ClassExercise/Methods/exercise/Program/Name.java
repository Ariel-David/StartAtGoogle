package startAtGoogle.Methods.exercise.Program;

import startAtGoogle.CommonMethods.exercies.Generator;

public class Name {
    public String FirstName;
    public String LastName;
    Generator g = new Generator();

    public Name() {
        FirstName = g.getFirstName();
        LastName = g.getLastName();
    }

    public void printFullName(){
       System.out.println(FirstName + "  " + LastName);
    }
}
