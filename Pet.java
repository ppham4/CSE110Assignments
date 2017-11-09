
// This class is used by Assignment5
public class Pet
{
    // Instance variables
    private String name;
    private int age;
    private boolean adopted;

    // Default Constructor
    public Pet()
    {
        name = "";
        age = 0;
        adopted = false;
    }
    
    // Regular Constructor
    public Pet(String petName, int curAge)
    {
        name = petName;
        age = curAge;
        adopted = false;
    }

    // Gets and Sets
    public String getName()
    {
        return name;
    }
    
    // This isn't used, but it is good to have it anyway
    public void setName(String petName)
    {
        name = petName;
    }
    
    public int getAge()
    {
        return age;
    }
    
    public void ageUp()
    {
        age++;
    }
    
    public boolean isAdopted()
    {
        return adopted;
    }
    
    public void adopt() // ^_^
    {
        adopted = true;
    }
}