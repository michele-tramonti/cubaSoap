package com.rdlabsrl.lfm.web.screens.workorderdata;

import com.haulmont.cuba.gui.screen.*;
import com.rdlabsrl.lfm.entity.WorkOrderData;

@UiController("lfm_WorkOrderData.browse")
@UiDescriptor("work-order-data-browse.xml")
@LookupComponent("workOrderDatasTable")
@LoadDataBeforeShow
public class WorkOrderDataBrowse extends StandardLookup<WorkOrderData> {
}