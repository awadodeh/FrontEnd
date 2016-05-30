package com.dev.frontend.panels.list;

import java.util.List;

import com.dev.frontend.model.Product;
import com.dev.frontend.services.Services;


public class ProductDataModel extends ListDataModel
{
	private static final long serialVersionUID = 7526529951747614655L;

	public ProductDataModel() 
	{
		super(new String[]{"Code","Description","Price","Quantity"}, 0);
	}

	@Override
	public int getObjectType() {
		return Services.TYPE_PRODUCT;
	}

	@Override
	public String[][] convertRecordsListToTableModel(List<Object> list) 
	{
		String[][] sampleData = new String [list.size()][4];
		int productIndex = 0;
		for (Object object: list) {
			Product product = (Product) object;
			sampleData[productIndex][0] = product.getCode()+"";
			sampleData[productIndex][1] = product.getDescription();
			sampleData[productIndex][2] = product.getPrice()+"";
			sampleData[productIndex][3] = product.getQuantity()+"";
			productIndex++;
		}

		return sampleData;
	}
}
