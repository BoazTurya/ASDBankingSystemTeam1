package miu.edu.cs.cs525.final_project.framework.model;

public interface MinPaymentStartegy  {

    public default  double minPaymentRate(){

        return 0;
    }
}
