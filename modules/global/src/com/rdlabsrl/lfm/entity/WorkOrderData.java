package com.rdlabsrl.lfm.entity;

import com.haulmont.cuba.core.entity.BaseUuidEntity;
import com.haulmont.cuba.core.entity.Creatable;
import com.haulmont.cuba.core.entity.Updatable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Table(name = "LFM_WORK_ORDER_DATA")
@Entity(name = "lfm_WorkOrderData")
public class WorkOrderData extends BaseUuidEntity implements Creatable, Updatable {
    private static final long serialVersionUID = 1867308731014905873L;

    @Column(name = "CREATE_TS")
    private Date createTs;

    @Column(name = "CREATED_BY", length = 50)
    private String createdBy;

    @Column(name = "UPDATE_TS")
    private Date updateTs;

    @Column(name = "UPDATED_BY", length = 50)
    private String updatedBy;

    @NotNull
    @Column(name = "WORK_ORDER", nullable = false, unique = true, length = 12)
    private String workOrder;

    @NotNull
    @Column(name = "GTIN", nullable = false, length = 14)
    private String gtin;

    @Column(name = "INFO")
    private String info;

    @Column(name = "MATERIALE", length = 50)
    private String materiale;

    @NotNull
    @Column(name = "SER_TYPE", nullable = false)
    private Integer serType;

    public SerType getSerType() {
        return serType == null ? null : SerType.fromId(serType);
    }

    public void setSerType(SerType serType) {
        this.serType = serType == null ? null : serType.getId();
    }

    public String getMateriale() {
        return materiale;
    }

    public void setMateriale(String materiale) {
        this.materiale = materiale;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getGtin() {
        return gtin;
    }

    public void setGtin(String gtin) {
        this.gtin = gtin;
    }

    public String getWorkOrder() {
        return workOrder;
    }

    public void setWorkOrder(String workOrder) {
        this.workOrder = workOrder;
    }

    @Override
    public String getUpdatedBy() {
        return updatedBy;
    }

    @Override
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Override
    public Date getUpdateTs() {
        return updateTs;
    }

    @Override
    public void setUpdateTs(Date updateTs) {
        this.updateTs = updateTs;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreateTs() {
        return createTs;
    }

    public void setCreateTs(Date createTs) {
        this.createTs = createTs;
    }
}