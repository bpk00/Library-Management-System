package learning.librarymanagementsystem;

public class LibraryManagementSystem {

    public static void main(String[] args) {
        
        // create and display login view
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            } 
        });
    }
}
