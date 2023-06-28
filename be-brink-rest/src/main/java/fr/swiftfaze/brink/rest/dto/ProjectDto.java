package fr.swiftfaze.brink.rest.dto;

import fr.swiftfaze.brink.business.model.IProject;

import java.time.LocalDateTime;

public class ProjectDto implements IProject {

    private long id;
    private long companyId;
    private String caseNumber;
    private Long owner;
    private String title;
    private String prefix;
    private String description;
    private LocalDateTime creationDate;
    private LocalDateTime updatedDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public Long getOwner() {
        return owner;
    }

    public void setOwner(Long owner) {
        this.owner = owner;
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
    public String getPrefix() {
        return prefix;
    }

    @Override
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }
}
