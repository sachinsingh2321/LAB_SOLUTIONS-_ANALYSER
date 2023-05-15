/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demopro;

/**
 *
 * @author ZAKARIA AHMED
 */
public class info{
   public static String regno = "";
   public static String username = "";
   public static String contact = "";
   
    public static void setinfo(String i , String name , String cont)
    {
        regno=i;
        username = name;
        contact = cont;
    }
    
    public static String getinfo()
    {
        return regno;
    }
     public static String getname()
    {
        return username;
    }
     public static String getcontact()
    {
        return contact;
    }
}
 
