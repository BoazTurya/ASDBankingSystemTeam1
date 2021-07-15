package miu.edu.cs.cs525.final_project.ccard.backend.modal.minPaymentStartegey;

import miu.edu.cs.cs525.final_project.framework.model.MinPaymentStartegy;

public class SilverMinPay implements MinPaymentStartegy {
    private static SilverMinPay instance = new SilverMinPay();

    public static SilverMinPay getInstance() {
        return instance;
    }


    @Override
    public double minPaymentRate(){
        return 0.12;
    }
}
