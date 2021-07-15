package miu.edu.cs.cs525.final_project.ccard.backend.modal.intrestStrategy;

import miu.edu.cs.cs525.final_project.framework.model.IntrestStrategy;

public class SilverStrategy implements IntrestStrategy {

    private static SilverStrategy instance = new  SilverStrategy();

    public static  SilverStrategy getInstance(){
        return instance;
    }


    @Override
    public double intrestRate() {
        return 0.08;
    }

}
