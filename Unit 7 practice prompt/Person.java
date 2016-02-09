public class Person implements Comparable
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
    public int compareTo(Object other)
    {
        if (this.getClass() == other.getClass())
        {
            Person otherPerson = (Person)other;
            
            return this.getName().toUpperCase().compareTo(otherPerson.getName().toUpperCase());
        }
        return -1;
    }
}