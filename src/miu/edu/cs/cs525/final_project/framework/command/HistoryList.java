package miu.edu.cs.cs525.final_project.framework.command;

import java.util.ArrayList;
import java.util.Collection;

//As Invoker
public class HistoryList {
    private Collection<Command> commands= new ArrayList();
    private Collection<Command> undolist = new ArrayList();

    public void setCommand(Command command){
        command.execute();
        commands.add(command);
    }









}
