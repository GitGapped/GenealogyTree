
package com.mycompany.games1;
 
 
 
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
 
 
public class Games1 {
   
    static int gender1,gender2;
    static    Map <String, Person> personList = new HashMap<String,Person>();
       
  
    public static void main(String[] args) {
        try{
        // Open the file.
           // File myfile = new File("C:/Users/Dule/Documents/NetBeansProjects/Games1/persons.csv");
            File myfile = new File("persons.csv");
 
            Scanner inputFile = new Scanner(myfile);
            
        //Empty array list
            personList.clear();
            while(inputFile.hasNext())
            {
 
                String line = inputFile.nextLine();
 
 // Display the line.
               // System.out.println(line);
               
 //split the string into  components which are separated by ,
                String[] arrOfStr = line.split(",");
                
        
        
            if(arrOfStr.length ==2)
            {
                personList.put(arrOfStr[0], new Person(arrOfStr[0],arrOfStr[1]));
            }
            else if(arrOfStr.length ==3)
            {
                if(arrOfStr[1].equals("father"))
                    personList.get(arrOfStr[2]).father=arrOfStr[0];
                else  if(arrOfStr[1].equals("mother"))
                    personList.get(arrOfStr[2]).mother=arrOfStr[0];
                else 
                    personList.get(arrOfStr[2]).spouse=arrOfStr[0];     
            }
        }
        }
        catch(Exception e)
        {
            System.out.println("File no exist");
        }
        //System.out.println("Check the contents of the structure");
        //personList.forEach((n,p)->System.out.println(n+","+p.father+","+p.mother+","+p.spouse));
     //   personList.forEach((n,p)->System.out.println(n+","+p.gender));
                    
        Scanner keyb = new Scanner(System.in);
        String name1, name2;
        int choice;
       System.out.println("This is a menu0");
        System.out.println("If you want close the program 0");
        System.out.println("if you want to see relations press 1");
        
          System.out.println("If you want to see the contents press 2");
     do{
       
            choice =keyb.nextInt();
            
            if(choice!=1 && choice!=2 && choice!=0){
                System.out.println("try again");
            }
           
            if(choice==2){
                 personList.forEach((n,p)->System.out.println(n+","+p.gender));
                 System.out.println("thanks for using out program");
                 System.out.println("would you like to try again");
                 String answer =keyb.next();
                 if(answer.equalsIgnoreCase("yes")){
                      
                System.out.println("if you want to see relations press 1");
         System.out.println("If you want to display the relations press 0");
          System.out.println("If you want to see the contents press 2");
                 }
                 else
                     break;
            }
            
            
             
             if(choice==0){
                 break;
             }
            
             if(choice==1){
                
          
         do
        {
           try{
               
           
            System.out.println("Enter name 1");
            name1 = keyb.next();
            if(name1.equals("STOP"))
                 break;
            System.out.println("Enter name 2");
            name2 = keyb.next();  
            if(name2.equals("STOP"))
                 break;
            
         
            check_gender(name1,name2,true);
                
             if(check_spouse(name1,name2,true))
                    continue;
            if(check_father(name1,name2,true))
                    continue;
            if( check_mother(name1,name2,true))
                continue;
            
            if(check_brother(name1,name2,true))
                continue;
             if(check_cousin(name1,name2,true))
                continue;
             if(check_uncle(name1,name2,true))
                continue;
             if(check_grandpa(name1,name2,true))
                continue;
             if(check_grandma(name1,name2,true))
                continue;
              System.out.println("not related");
           }
           
           catch(Exception e){
                System.out.println("THE GIVEN NAME(S) ARE NOT INCLUDED IN THE FILE");
           }
            
         }while(false);{
                 System.out.println("Press ''yes'' to try again");
                 String answer =keyb.next();
                 if(answer.equalsIgnoreCase("yes" )){
                      
                System.out.println("if you want to see relations press 1");
         System.out.println("If you want to display the relations press 0");
          System.out.println("If you want to see the contents press 2");
                 }
                 else
                     break;
             }
       
     
     }
             
     }
     while(true);
     }

     
       
    
    static boolean check_spouse(String name1, String name2,boolean show)
    {
         if ((personList.get(name2).spouse!=null) && personList.get(name2).spouse.equals(name1))
         {
              if(show)
                    System.out.println(name2+" is spouse of "+name1);
                return true;
         }
         if ((personList.get(name1).spouse!=null) && personList.get(name1).spouse.equals(name2))
         {
              if(show)
                    System.out.println(name1+" is spouse of  "+name2);
                return true;
         }
         return false;
    }
    
    static boolean check_father(String name1, String name2,boolean show)
    {
         if ((personList.get(name2).father!=null) && personList.get(name2).father.equals(name1))
         {
                 if(show)
                if(gender2 == 1)
                   
                    System.out.println("2 is son of 1");
                else
                        if(show)
                    System.out.println("2 is daughter of 1");
                return true;
         }
         if((personList.get(name1).father!=null) && personList.get(name1).father.equals(name2))
             {
               if(show)
                if(gender1 == 1)
                    
                    System.out.println("1 is son of 2");
                else
                        if(show)
                    System.out.println("1 is daughter of 2");
                return true;
            }  
         return false;
    }
    static boolean check_mother(String name1, String name2,boolean show)
    {
         if ((personList.get(name2).mother !=null) && personList.get(name2).mother.equals(name1))
         {
                if(show)
                if(gender2 == 1)
                    
                    System.out.println("2 is son of 1");
                else
                        if(show)
                    System.out.println("2 is daughter of 1");
                return true;
         }
         if((personList.get(name1).mother!=null) && personList.get(name1).mother.equals(name2))
             {
               if(show)
                if(gender1 == 1)
                    System.out.println("1 is son of 2");
                else
                    if(show)
                        
                    System.out.println("1 is daughter of 2");
                return true;
            }  
         return false;
    }
    
    static void check_gender(String name1, String name2, boolean show)
    {
        if (personList.get(name1).gender.equals("man"))
            gender1 = 1;
        else
            gender1 = 2;
        if (personList.get(name2).gender.equals("man"))
            gender2 = 1;
        else
            gender2 = 2;
        
    }
     
    
     static boolean check_brother(String name1, String name2,boolean show)
    {
        if(personList.get(name1)==null)
            return false;
        if(personList.get(name2)==null)
            return false;
         if ((personList.get(name1).father!=null) && (personList.get(name2).father!=null))
         {
             String f1 = personList.get(name1).father;
             String f2 = personList.get(name2).father;
            if(f1.equals(f2))
            {
                if(show)
                    if(gender2 == 1)
                    System.out.println("They are siblings");
                return true;
            }
         }
         else if ((personList.get(name1).mother!=null) && (personList.get(name2).mother!=null))
         {
            String m1 = personList.get(name1).mother;
            String m2 = personList.get(name2).mother;
            if(m1.equals(m2))
            {
                if(show)
                    if(gender1 == 1)
                    System.out.println("They are siblings");
                return true;
            }
         }
         return false;
    }
    
     
    static boolean check_cousin(String name1, String name2,boolean show)
    {
        String f1="";
        String f2="";
        String m1="";
        String m2="";
         if (personList.get(name1).father!=null)
            f1 = personList.get(name1).father;
         if (personList.get(name2).father!=null)
            f2 = personList.get(name2).father;            
         if (personList.get(name1).mother!=null)
            m1 = personList.get(name1).mother;
         if (personList.get(name2).mother!=null)
            m2 = personList.get(name2).mother;          
         int flag = 0;
         if (check_brother(f1,f2,false))
             flag = 1;
         else if (check_brother(m1,m2,false))
             flag = 1;  
         else if (check_brother(f1,m1,false))
             flag = 1; 
         else if (check_brother(f1,m2,false))
             flag = 1;
         else if (check_brother(f2,m1,false))
             flag = 1; 
         else if (check_brother(f2,m2,false))
             flag = 1; 
         if( flag == 1)
         {
             if(show)
              System.out.println("They are cousins");
                return true;
         }
         
         
         
 
         return false;
    }
    
    static boolean check_uncle(String name1, String name2,boolean show)
    {
        String f1="";
        String f2="";
 
         if (personList.get(name1).father!=null)
         {
            f1 = personList.get(name1).father;
            if(check_brother(f1,name2,false))
            {
                if(show)
                    System.out.println(name1 + " is nephew of "+ name2);
                return true;
            }
        }
         if (personList.get(name2).father!=null)
         {
            f1 = personList.get(name2).father;
            if(check_brother(f1,name1,false))
            {
                if(show)
                    System.out.println(name2 + " is nephew of "+ name1);
                return true;
            }
        }
         
         
         
         return false;
    }
    
    static boolean check_grandpa(String name1, String name2,boolean show)
    {
        String f1="";
        String f2="";
 
         if (personList.get(name1).father!=null)
         {
            f1 = personList.get(name1).father;
            if(check_father(f1,name2,false))
            {
                if(show)
                    
                      System.out.println(name2 + " is grandpa of "+ name1);
                 if(show)
                if(gender1 == 1)
                    
                    System.out.println(name1+" is GRANDSON of "+name2);
                else
                        if(show)
                    System.out.println(name1+" is GRANDSON of "+name2);
                 return true;
            }
        }
         if (personList.get(name2).father!=null)
         {
            f1 = personList.get(name2).father;
            if(check_father(f1,name1,false))
            {
                if(show)
                    
                      System.out.println(name1 + " is grandpa of "+ name2);
                if(gender2 == 1)
                   
                    System.out.println(name2+" is grandSON of "+name1);
                else
                        if(show)
                    System.out.println(name2+" is grandDAUGHTER of "+name1);
                
                return true;
            }
        }
         return false;
    }
    static boolean check_grandma(String name1, String name2,boolean show)
    {
        String f1="";
        String f2="";
 
         if (personList.get(name1).father!=null)
         {
            f1 = personList.get(name1).father;
            if(check_mother(f1,name2,false))
            {
                if(show)
                    
                    System.out.println(name2 + " is grandma of "+ name1);
                 if(show)
                if(gender1 == 1)
                    
                    System.out.println(name1+" is GRANDSON of "+name2);
                else
                        if(show)
                    System.out.println(name1+" is GRANDDAUGHTER of "+name2);
                       
                return true;
            }
        }
         if (personList.get(name2).father!=null)
         {
            f1 = personList.get(name2).father;
            if(check_mother(f1,name1,false))
            {
                if(show)
                    
                    System.out.println(name1 + " is grandma of "+ name2);
                if(gender2 == 1)
                   
                    System.out.println(name2+" is grandSON of "+name1);
                else
                        if(show)
                    System.out.println(name2+" is grandDAUGHTER of "+name1);
                
                return true;
            }
        }
         
         return false;
    }
   
    
     
    
    
    /*static boolean check_grandpa(String name1, String name2, boolean show) {
        if (!personList.containsKey(name1) || !personList.containsKey(name2)) {
        System.out.println("One or both persons do not exist in the list.");
        return false;
        }

        String son1 = personList.get(name1).father;
        String son2 = personList.get(name2).father;

        

        if (son1 != null && personList.containsKey(son1) && personList.get(son1).father != null && personList.get(son1).father.equals(name2)) {
            if (show) {
                System.out.println(name2 + " is grandpa of " + name1);
            }
            return true;
        }

        if (son2 != null && personList.containsKey(son2) && personList.get(son2).father != null && personList.get(son2).father.equals(name1)) {
            if (show) {
                System.out.println(name1 + " is grandpa of " + name2);
            }
            return true;
        }

        return false;
    }*/
   
    
}
 
 
 
 
 
class Person{
    String name;
    String gender;
    String father;
    String mother;
    String spouse;
    Person(String name, String gender)
    {
        this.name = name;
        this.gender = gender;
    }
}