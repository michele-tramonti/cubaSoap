package com.rdlabsrl.lfm.web.screens.workorderdata;

import com.haulmont.cuba.gui.screen.*;
import com.rdlabsrl.lfm.entity.WorkOrderData;

@UiController("lfm_WorkOrderData.edit")
@UiDescriptor("work-order-data-edit.xml")
@EditedEntityContainer("workOrderDataDc")
@LoadDataBeforeShow
public class WorkOrderDataEdit extends StandardEditor<WorkOrderData> {
}