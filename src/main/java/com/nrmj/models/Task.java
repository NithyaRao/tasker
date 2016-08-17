package com.nrmj.models;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tasks")
public class Task {
    private int id;
    private String name;
    private String category;
    private Date due;
    private Boolean isComplete;
    private Date createdAt;
    private Date updatedAt;

    public Task() {
        this.isComplete = false;
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Temporal(TemporalType.DATE)
    public Date getDue() {
        return due;
    }

    public void setDue(Date due) {
        this.due = due;
    }

    @Column(name = "is_complete", columnDefinition = "BIT", length = 1)
    public Boolean getComplete() {
        return isComplete;
    }

    public void setComplete(Boolean complete) {
        isComplete = complete;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", insertable = true, updatable = false)
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @PreUpdate
    protected void updateTime() {
        this.updatedAt = new Date();
    }


}
