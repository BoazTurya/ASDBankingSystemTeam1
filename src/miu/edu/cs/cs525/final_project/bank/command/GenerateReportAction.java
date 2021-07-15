package miu.edu.cs.cs525.final_project.bank.command;

import miu.edu.cs.cs525.final_project.framework.command.GenerateReportTempalte;

public class GenerateReportAction extends GenerateReportTempalte {


    @Override
    public void generateDepositReport() {

    }

    @Override
    public void generateWithdrawReport() {

    }

    @Override
    public void getBalancePreviousMonth() {

    }

    @Override
    public void getTotalcharges() {

    }

    @Override
    public void setNewBalance() {

    }

    @Override
    public void getTotalCredit() {

    }

    @Override
    public void TotalDue() {

    }

    public boolean hasBillingReport(){
        return false;
    }
    public boolean hasAccountReport(){
        return true;
    }
}
