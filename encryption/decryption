import java.util.Scanner;

public class C_option {
    public static void main(String []args){
        Scanner x = new Scanner(System.in);

        C_Submenu();
        String option = x.nextLine().toLowerCase();
        switch (option) {
            case "a":
                Flush_console();
                System.out.println("You  elected option a"); 
                String newText1 = encrypt(x);
                System.out.println(newText1);          
                break;
            case "b":
                Flush_console();
                System.out.println("You selected option b"); 
                String newText2 = decrypt(x);
                System.out.println(newText2);                
                break;
            case "c":
                Flush_console();
                System.out.println("You selected option c");    
                C_Submenu();          
                break;
            
        }
        x.close();
        
    }
    private static void C_Submenu(){
        System.out.println("Select an option from the C submenu below: ");
        System.out.println("[a] Encyryption");
        System.out.println("[b] Decryption");
        System.out.println("[c] Return to the main menu");
        
    }

    private static void Flush_console()
    {
        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
    }
    private static String encrypt(Scanner x) {
        System.out.println("Enter an encryption key (Integer between 26 and -26): ");
        int shift = x.nextInt();
        x.nextLine();  
        if (shift > 26 || shift < -26) {
            System.out.println("Error: shift value is outside the valid range, returning to submenu");
            C_Submenu();
            return "";  
        }
        
        System.out.println("Please enter encryption text: ");
        String text = x.nextLine();
        
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
    
            if (Character.isLetter(c)) {
                int new_AscII = c + shift;
                result += (char)((new_AscII)% 128);
            } else {
                result += c;  
            }
        }
        return result;
    }
    


    private static String decrypt(Scanner x) {
        System.out.println("Enter an encryption key (Integer between 26 and -26): ");
        int shift = x.nextInt();
        x.nextLine();  // clear the buffer
        if (shift > 26 || shift < -26) {
            System.out.println("Error: shift value is outside the valid range, returning to submenu");
            C_Submenu();
            return "";  // returning empty string if invalid input
        }
        
        System.out.println("Please enter encryption text: ");
        String text = x.nextLine();
        
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
    
            if (Character.isLetter(c)) {
                int new_AscII = c - shift;
                result += (char)((new_AscII)% 128);
            } else {
                result += c;  
            }
        }
        return result;
    }
    
}
