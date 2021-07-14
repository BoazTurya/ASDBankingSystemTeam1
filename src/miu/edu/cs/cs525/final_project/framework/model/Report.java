package miu.edu.cs.cs525.final_project.framework.model;

public abstract class Report {
    protected String report;

    public final Report generateReport(Account account) {
        return createReport(account);
    }

    public abstract Report createReport(Account account);

    public void setReport(String report) {
        this.report = report;
    }

    public String getReport() {
        return report;
    }
}
