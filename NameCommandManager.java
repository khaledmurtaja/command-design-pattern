import java.util.ArrayList;
import java.util.List;

public class NameCommandManager {
    List<Command> list=new ArrayList<Command>();
    int index=0;
    public void AddCommand(Command command){
        list.add(command);
        index=list.size();
    }

    public void undo() {
        if(index>0){
            index--;
            Command command=list.get(index);
            command.UnExecute();
        }

    }

    public void redo() {
        if(index<=list.size()-1) {
            Command command = list.get(index);
            index++;
            command.Execute();
        }
    }
}
