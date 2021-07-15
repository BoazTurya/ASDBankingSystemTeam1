package miu.edu.cs.cs525.final_project.ccard.backend.modal.minPaymentStartegey;

import miu.edu.cs.cs525.final_project.framework.model.MinPaymentStartegy;

public class GoldMinPay implements MinPaymentStartegy {

    public GoldMinPay(){

    }


    @Override
    public double minPaymentRate(){
        return 0.1;
    }
}
