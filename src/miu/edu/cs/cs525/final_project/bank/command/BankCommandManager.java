package miu.edu.cs.cs525.final_project.bank.command;

import miu.edu.cs.cs525.final_project.framework.command.Command;
import miu.edu.cs.cs525.final_project.framework.command.CommandManager;

public class BankCommandManager implements CommandManager {

    @Override
    public void setCommand(Command command) {
        command.execute();

    }
}
