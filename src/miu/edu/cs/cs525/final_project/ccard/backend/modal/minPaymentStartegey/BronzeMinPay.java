package miu.edu.cs.cs525.final_project.ccard.backend.modal.minPaymentStartegey;

import miu.edu.cs.cs525.final_project.framework.model.MinPaymentStartegy;

public class BronzeMinPay implements MinPaymentStartegy {

    private static  BronzeMinPay instance = new  BronzeMinPay();

    public static  BronzeMinPay getInstance() {
        return instance;
    }


    @Override
    public double minPaymentRate(){
        return 0.14;
    }
}
