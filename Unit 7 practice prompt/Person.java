public class Person implements Comparable<Person>
{
    private String name;
    
    /**
     * 
     */
    public Person(String name)
    {
        this.name = name;
    }
    
    /**
     * 
     */
    public String getName()
    {
        return this.name;
    }
    
    /**
     * 
     */
    public int compareTo(Person otherPerson)
    {
        return this.getName().toUpperCase().compareTo(otherPerson.getName().toUpperCase());
    }
}