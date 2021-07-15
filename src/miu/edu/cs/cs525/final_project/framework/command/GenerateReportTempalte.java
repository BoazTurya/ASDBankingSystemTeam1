package miu.edu.cs.cs525.final_project.framework.command;

public abstract class GenerateReportTempalte implements Command{

    public abstract void generateDepositReport();
    public abstract void generateWithdrawReport();
    public abstract void getBalancePreviousMonth();
    public abstract void getTotalcharges();
    public abstract void setNewBalance();
    public abstract void getTotalCredit();
    public abstract void TotalDue();




    @Override
    public final void execute() {
        getBalancePreviousMonth();

        if(hasAccountReport()){
            generateDepositReport();
            generateWithdrawReport();

        }

        if (hasBillingReport()){
            getTotalcharges();
            getTotalCredit();
            setNewBalance();
            TotalDue();
        }


    }

    public boolean hasBillingReport(){
        return true;
    }
    public boolean hasAccountReport(){
        return true;
    }




}
