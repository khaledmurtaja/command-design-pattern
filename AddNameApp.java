import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;


public class AddNameApp extends JFrame{

    NameCommandManager manager;
    public AddNameApp(){
        this.setTitle("Add FirstName  app");
       manager = new NameCommandManager();
        this.setSize(400, 450);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().setBackground(Color.WHITE);
        final ListPanel drawPanel = new ListPanel(manager);
        this.getContentPane().add(drawPanel,BorderLayout.CENTER);
        String[] btns = {"Undo","Redo"};
        ControlPanel cp = new ControlPanel(btns);
        cp.addControlPanelListener(new ControlPanel.ControlPanelListener(){
            @Override
            public void buttonPressed(String btnName) {
                if(btnName.equals("Undo")){
                    manager.undo();

                }else if(btnName.equals("Redo")){
                    manager.redo();
                }
            }

        });
        this.getContentPane().add(cp,BorderLayout.SOUTH);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args){
        new AddNameApp();
    }

}
