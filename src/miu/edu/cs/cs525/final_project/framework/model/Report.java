package miu.edu.cs.cs525.final_project.framework.model;

import miu.edu.cs.cs525.final_project.framework.dao.AccountDAO;
import miu.edu.cs.cs525.final_project.framework.service.AccountService;

public abstract class Report {
    protected String report;

    public final Report generateReport(Account account, AccountDAO accountDAO) {
        return createReport(account,accountDAO);
    }

    public abstract Report createReport(Account account,AccountDAO accountDAO);

    public void setReport(String report) {
        this.report = report;
    }

    public String getReport() {
        return report;
    }
}
