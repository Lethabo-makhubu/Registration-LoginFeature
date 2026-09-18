/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registrationandloginfeature;


public class Login {
    
                //Attributes
    public String cellphoneNumber;
    public String username;
    public String password;
    
    //Constructor
    public Login(String cellphoneNumber, String username, String password){
        
         this.cellphoneNumber = cellphoneNumber;
         this.username = username;
         this.password = password;
         
    }
         public boolean checkUsername(){ //Check username
             
         return username.contains("_") && username.length() <= 5;
         }
         
         public boolean checkPasswordComplexity()  { //Check password complexity
             return password.length() >=8
                     && password.matches(".*[A-Z].*") 
                     && password.matches(".*[0-9].*")
                     && password.matches(".*[^a-zA-Z0-9].*");              
         }
         //check cellphone number
         public boolean checkcellphoneNumber(){ //Check cellphone number
             return cellphoneNumber.matches("^\\+27[0-9]{9}$");
             
         }
         
         public boolean loginUser(String enteredUsername, String enteredPassword){
             return username.equals(enteredUsername)
                     && password.equals(enteredPassword);
         }
         
         public String returnLoginStatus(boolean loginSuccessful){
             if (loginSuccessful){
                 return "Welcome, it is great to see you.";
             }else{
                 return "Username or password incorrect, please try again.";
             }
         }
}
