package storeFront;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * @author Deekshika Sharma
 * This class will have positive and negative test cases for JDBC Queries
 */
public class JDBCTest {

	/**
	 * This test case is related to select order from store front
	 */
	@Test
	public void selectOrderTest() {
		
		List<OrderPojo> resultOrderList = JDBCQuery.selectOrders(1);
		assertNotNull(resultOrderList);
	}
	
	/**
	 * This test case is related to insert images in batch to store front
	 */
	@Test
	public void insertImageBatchTest() {
		
		List<ImagePojo> imageList = new ArrayList<ImagePojo>();
		
		imageList.add(new ImagePojo("uuf.dyffh.bxud/otcb", "Mobile image 1", 1));
		imageList.add(new ImagePojo("www.ufbfeufeu/8fhf55bfj", "Mobile image 2", 2));
		imageList.add(new ImagePojo("https:/fhhdeueiifb46ehg??fueu", "Mobile image 3", 3));
		imageList.add(new ImagePojo("https:/tebceio426ch", "Mobile image 4", 2));
		imageList.add(new ImagePojo("https:/eyeneuuefggsyd", "Mobile image 5", 1));
		
		assertTrue(JDBCQuery.insertImageBatch(imageList));
	}
	
	/**
	 * This test case is related to update product table in store front
	 */
	@Test
	public void updateProductTest() {
		
		assertEquals(2, JDBCQuery.updateProducts());
	}

	/**
	 * This test case is related to count child categories of top category from store front
	 */
	@Test
	public void countChildCategoryTest() {
		
		JDBCQuery j = new JDBCQuery();
		List<TopCategory> topCategoryList = j.getTopCategoryWithChildrenCount();
		for(TopCategory topCategory: topCategoryList)
			System.out.println(topCategory.getParentCategoryName() + " " + topCategory.getChildCategories());
	}
}
