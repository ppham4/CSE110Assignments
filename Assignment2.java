import java.util.Scanner;

public class Assignment2
{
   public static void main (String[] args)
   {
       Scanner scan = new Scanner(System.in);
       System.out.println("Please input a word or phrase:");
       String phrase = scan.nextLine();
       System.out.println("Please input the string you would like to search for:");
       String search = scan.nextLine();
       System.out.println("Would you like to include spaces in your search?\nType 1 for YES or 0 for NO");
       // 4 scenarios: Y/Y, N/N, Y/N, N/Y || 0/0, 1/1, 0/1, 1/0 
       String space = scan.nextLine();
       int Space = Integer.parseInt(space);
       System.out.println("Would you like to consider uppercase and lowercase as different?\nType 1 for YES or 0 for NO");
       String ulCase = scan.nextLine();
       int Case = Integer.parseInt(ulCase);
       boolean begin = phrase.startsWith(search);
       boolean end = phrase.endsWith(search);
       if(Space == 1)
       {
           System.out.println("Including spaces in search...");
       }
       else
       // Don't need else if(Space == 0) because the only two possible inputs are 1 & 0, so if they don't type 1 it will assume they will type 0
       {
           phrase = phrase.replace(" ", "");
           search = search.replace(" ", "");    
           System.out.println("Excluding spaces in search...");
       }
       if(Case == 1)
       {
           System.out.println("Considering uppercase and lowercase as different...");
       }
       else
       {
           phrase = phrase.toUpperCase();
           search = search.toUpperCase();
           System.out.println("Not considering case in search...");
       }
       if(search.equals(phrase))
       {
           System.out.println("Your search was equal to the entire input.");
       }
       else if(phrase.contains(search))
       {
           int firstIndex = phrase.indexOf(search);
           int length = search.length();
           int temp = phrase.length();
           int temp1 = temp - 1;
           int end1 = (firstIndex + length) - 1;
           if(begin || firstIndex == 0)
           // With boolean operators, you can use begin for begin == true or !begin for begin == false to save space 
           {
                System.out.println("Your search was found at the start of the input.");
           }
           else if(end || temp1 == end1)
           {
                System.out.println("Your search was found at the end of the input.");
           }
           else if(!begin && !end)
           {
                System.out.println("Your search was found beginning at index " + firstIndex + " and ending at index " + end1 + ".");
           }
       }
       else
       {
           System.out.println("Your search was not found. Please try again.");
       }
    }
}