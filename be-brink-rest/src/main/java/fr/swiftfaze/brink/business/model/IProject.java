package fr.swiftfaze.brink.business.model;

public interface IProject {
    long getCompanyId();

    void setCompanyId(long companyId);

    String getCaseNumber();

    void setCaseNumber(String caseNumber);

    String getTitle();

    void setTitle(String title);

    String getDescription();

    void setDescription(String description);

    String getPrefix();

    void setPrefix(String prefix);
}
