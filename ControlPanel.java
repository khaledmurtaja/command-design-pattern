import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ControlPanel extends JPanel{
    private final JButton[] btns;
    private final List<ControlPanelListener> listeners;

    public ControlPanel(String[] btnNames){
        listeners = new ArrayList<ControlPanelListener>();

        btns = new JButton[btnNames.length];
        for(int i=0; i<btnNames.length; i++){
            btns[i] = new JButton(btnNames[i]);
            btns[i].addActionListener(new ActionListener(){

                @Override
                public void actionPerformed(ActionEvent event) {
                    for(ControlPanelListener l: listeners)
                        l.buttonPressed(event.getActionCommand());
                }

            });
            btns[i].setActionCommand(btnNames[i]);
            this.add(btns[i]);
        }
    }

    public interface ControlPanelListener{
        void buttonPressed(String btnName);
    }

    public void addControlPanelListener(ControlPanelListener l){
        if(!listeners.contains(l))
            listeners.add(l);
    }

}


