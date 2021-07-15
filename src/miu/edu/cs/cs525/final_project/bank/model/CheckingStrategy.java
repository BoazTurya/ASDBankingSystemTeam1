package miu.edu.cs.cs525.final_project.bank.model;

import miu.edu.cs.cs525.final_project.framework.model.IntrestStrategy;

public class CheckingStrategy implements IntrestStrategy {

    @Override
    public double intrestRate() {
        return 0.478;
    }
}
