package fr.swiftfaze.brink.business.model;

public class ProjectRegistry implements IProject {

    private long companyId;
    private String caseNumber;
    private String title;
    private String prefix;
    private String description;

    @Override
    public long getCompanyId() {
        return companyId;
    }

    @Override
    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    @Override
    public String getCaseNumber() {
        return caseNumber;
    }

    @Override
    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getPrefix() {
        return prefix;
    }

    @Override
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}
