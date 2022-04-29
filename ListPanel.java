import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class ListPanel extends JPanel{

    DefaultListModel model = new DefaultListModel();
    NameCommandManager manager;


    public ListPanel(NameCommandManager nameCommandManager){
        JList list = new JList(model);
        JScrollPane listScrollPane = new JScrollPane(list);
        listScrollPane.setPreferredSize(new Dimension(120,380));
        ListPanel.this.add(listScrollPane);
        JTextField textField=new JTextField();
        textField.setPreferredSize(new Dimension(90,30));
        JButton AddBtn=new JButton("Add");
        AddBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name=textField.getText();
                Command command=new FirstNameCommand(name,textField,model);
                command.Execute();
                manager.AddCommand(command);
            }
        });
        ListPanel.this.add(textField);
        ListPanel.this.add(AddBtn);
        this.manager= nameCommandManager;

    }


}
