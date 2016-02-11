import java.util.Scanner;

public class TestPerson
{   
    /**
     * 
     */
    public static void main(String[] args)
    {
        Person[] people = new Person[10];
        Scanner in = new Scanner(System.in);
        
        for (int i = 0; i < 10; i++)
        {
            System.out.println("\nEnter the name of person number "+i+": ");
            people[i] = new Person(in.next());
        }
        
        //Sort the people based on name
        for (int i = 0; i < 10; i++)
        {
            for (int r = 0; r < 10; r++)
            {
                int compared = people[i].compareTo(people[r]);
                if (compared < 0)
                {
                    Person temp = people[r];
                    people[r] = people[i];
                    people[i] = temp;
                }
            }
        }
        
        String firstName = people[0].getName();
        String lastName = people[people.length-1].getName();
        
        //Print first and last name
        System.out.println("\nFirst name: "+firstName+"\nLast Name: "+lastName);
    }
}