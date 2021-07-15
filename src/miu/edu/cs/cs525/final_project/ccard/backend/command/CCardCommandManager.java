package miu.edu.cs.cs525.final_project.ccard.backend.command;

import miu.edu.cs.cs525.final_project.framework.command.Command;
import miu.edu.cs.cs525.final_project.framework.command.CommandManager;

import java.util.ArrayList;
import java.util.List;

public class CCardCommandManager implements CommandManager {

    private List<Command> history;
    public CCardCommandManager() {
        this.history=new ArrayList<>();
    }
    public void addCommandToHistory(Command command) {
        this.history.add(command);
    }

    @Override
    public void setCommand(Command command) {

        command.execute();
        addCommandToHistory(command);
}
}
