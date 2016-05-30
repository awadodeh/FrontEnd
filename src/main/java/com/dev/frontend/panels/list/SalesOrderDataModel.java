package com.dev.frontend.panels.list;

import java.util.List;

import com.dev.frontend.model.SalesOrder;
import com.dev.frontend.services.Services;


public class SalesOrderDataModel extends ListDataModel
{
	private static final long serialVersionUID = 7526529951747614655L;

	public SalesOrderDataModel() 
	{
		super(new String[]{"Order Number","Customer","Total Price"}, 0);
	}

	@Override
	public int getObjectType() {
		return Services.TYPE_SALESORDER;
	}

	@Override
	public String[][] convertRecordsListToTableModel(List<Object> list) 
	{
		String[][] sampleData = new String [list.size()][3];
		int salesOrderIndex = 0;
		for (Object object: list) {
			SalesOrder salesOrder = (SalesOrder) object;
			sampleData[salesOrderIndex][0] = salesOrder.getOrderNumber()+"";
			sampleData[salesOrderIndex][1] = salesOrder.getCustomer().getName();
			sampleData[salesOrderIndex][2] = salesOrder.getTotalPrice()+"";
			salesOrderIndex++;
		}

		return sampleData;
	}
}
