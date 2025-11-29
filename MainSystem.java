/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package System_Files;

/**
 *
 * @author pc
 */
import javax.swing.UIManager;

public class MainSystem {

    public static void main(String[] args) {
        
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
           
        }

        
        javax.swing.SwingUtilities.invokeLater(() -> {
            LoadingScreen splash = new LoadingScreen();
            splash.setVisible(true);
        });
    }
}
