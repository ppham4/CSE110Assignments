import java.util.Arrays;

// 1.
public class MyString
{
    // 2. 
    private int length;
    private char[] array; 

    // 3.
    public MyString()
    {
        length = 0;
        array = new char[length]; 
    }

    // 4.
    public MyString(String parameter)
    {
        length = parameter.length();
        array = parameter.toCharArray(); 
    }

    // 5. 
    public boolean equals1(String parameter)
    { 
        if(parameter.length() == array.length)
        {
            for(int i = 0; i < array.length; i++)
            {
                boolean temp = true; 
                for(int j = 0; j < parameter.length(); j++)
                {
                    if(array[j] != parameter.charAt(j))
                    {
                        temp = false;
                    }
                }
                if(temp == true)
                {
                    return true;
                }
            }
        }
        return false;
    }

    // 6.
    public int indexOf(char parameter)
    {
        for(int i = 0; i < array.length; i++)
        {
            if(array[i] == parameter)
            {
                return i; 
            }
        }
        return -1; 
    }

    // 7.
    public int indexOf1(String parameter)
    {
        for(int i = 0; i < array.length; i++)
        {
            if(array[i] == parameter.charAt(0) && array.length > parameter.length())
            {
                boolean temp = true; 
                for(int j = 0; j < parameter.length(); j++)
                {
                    if(array[i+j] != parameter.charAt(j))
                    {
                        temp = false;
                    }                 
                }
                if(temp == true)
                {
                    return i;
                }
            }
        }
        return -1; 
    }

    // 8.
    public boolean startsWith1(String parameter)
    {
        if(indexOf1(parameter) == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    // 9.
    public boolean endsWith1(String parameter)
    {
        if(indexOf1(parameter) == (array.length - parameter.length()))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    // 10. 
    public boolean contains1(String parameter)
    {
        if(indexOf1(parameter) != -1) 
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    // 11. 
    public String toString()
    {
        String stringVersion = "";
        for(int i = 0; i < array.length; i++)
        {
            stringVersion += array[i]; 
        }
        return stringVersion; 
    }
}
