package miu.edu.cs.cs525.final_project.ccard.backend.modal.intrestStrategy;

import miu.edu.cs.cs525.final_project.framework.model.IntrestStrategy;

public class GoldStartegy implements IntrestStrategy {

     public GoldStartegy(){
     }

    @Override
    public double intrestRate() {
        return 0.06;
    }
}
