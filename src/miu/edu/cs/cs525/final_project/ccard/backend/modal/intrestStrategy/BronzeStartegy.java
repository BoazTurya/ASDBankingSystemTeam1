package miu.edu.cs.cs525.final_project.ccard.backend.modal.intrestStrategy;

import miu.edu.cs.cs525.final_project.framework.model.IntrestStrategy;

public class BronzeStartegy implements IntrestStrategy {

    private static BronzeStartegy instance = new BronzeStartegy();

    public static BronzeStartegy getInstance(){
        return instance;
    }
    @Override
    public double intrestRate() {
        return 0.1;
    }
}
