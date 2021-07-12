package miu.edu.cs.cs525.final_project.framework.command;

import miu.edu.cs.cs525.final_project.framework.IntrestStrategy;

public abstract class IntrestTemplate implements Command {

    public abstract  void calculateMonthlyIntrest();

    @Override
    public void execute() {
        calculateMonthlyIntrest();

    }
    @Override
    public void unexecute() {

    }


}
