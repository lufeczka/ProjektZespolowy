package com.uwm.projektz.ob;

import com.uwm.projektz.enums.TicketType;

import javax.persistence.*;
import java.util.List;

/**
 * Created by wojni on 11.03.2016.
 */
@MappedSuperclass
public class TicketOB extends BaseOB{
    TicketType typ;
    String description;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID" , referencedColumnName = "ID")
    UserOB user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRIORITY_ID" , referencedColumnName = "ID")
    PriorityOB priority;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROJECT_ID" , referencedColumnName = "ID")
    ProjectOB project;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "HISTORY_ID" , referencedColumnName = "ID")
    List<HistoryOB> histories;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "ATTACHMENT_ID" , referencedColumnName = "ID")
    List<AttachmentOB> attachments;


    public TicketOB() {
    }

    public TicketOB(TicketType typ, String description, PriorityOB priority, ProjectOB project)
    {
        this.typ = typ;
        this.description = description;
        this.priority = priority;
        this.project = project;
    }

    public TicketType getTyp() {
        return typ;
    }

    public void setTyp(TicketType typ) {
        this.typ = typ;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserOB getUser() {
        return user;
    }

    public void setUser(UserOB user) {
        this.user = user;
    }

    public PriorityOB getPriority() {
        return priority;
    }

    public void setPriority(PriorityOB priority) {
        this.priority = priority;
    }

    public ProjectOB getProject() {
        return project;
    }

    public void setProject(ProjectOB project) {
        this.project = project;
    }

    public List<HistoryOB> getHistories() {
        return histories;
    }

    public void setHistories(List<HistoryOB> histories) {
        this.histories = histories;
    }

    public List<AttachmentOB> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<AttachmentOB> attachments) {
        this.attachments = attachments;
    }
}


