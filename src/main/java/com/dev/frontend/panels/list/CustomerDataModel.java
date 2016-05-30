package com.dev.frontend.panels.list;

import java.util.List;

import com.dev.frontend.model.Customer;
import com.dev.frontend.services.Services;

public class CustomerDataModel extends ListDataModel
{
	private static final long serialVersionUID = 7526529951747613655L;

	public CustomerDataModel()
	{
		super(new String[] { "Code", "Name", "Phone", "Current Credit" }, 0);
	}

	@Override
	public int getObjectType()
	{
		return Services.TYPE_CUSTOMER;
	}

	@Override
	public String[][] convertRecordsListToTableModel(List<Object> list)
	{
		String[][] sampleData = new String [list.size()][4];
		int customerIndex = 0;
		for (Object object: list) {
			Customer customer = (Customer) object;
			sampleData[customerIndex][0] = customer.getCode()+"";
			sampleData[customerIndex][1] = customer.getName();
			sampleData[customerIndex][2] = customer.getPhone1();
			sampleData[customerIndex][3] = customer.getCurrentCredit()+"";
			customerIndex++;
		}

		return sampleData;
	}
}
