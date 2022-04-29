import javax.swing.*;
import java.awt.*;

public class FirstNameCommand implements Command {
   String name;
   JTextField textField;
   DefaultListModel model;
   int key;



    public FirstNameCommand(String name,JTextField textField ,DefaultListModel model) {
       this.textField=textField;
        this.name=name;
        this.model=model;


    }

    @Override
    public void Execute() {
        model.addElement(name);
        textField.setText("");
    }

    @Override
    public void UnExecute() {
        model.remove(model.size()-1);
        textField.setText(name);

    }
}
