package storeFront;

/**
 * @author Deekshika Sharma
 * This pojo have Category properties for Category table in store front
 */
public class TopCategory {

	private String parentCategoryName;
    private int childCategories;
    
    public TopCategory(String parentCategoryName, int childCategories) {
        
        this.parentCategoryName = parentCategoryName;
        this.childCategories = childCategories;
    }

    public String getParentCategoryName() {
        return parentCategoryName;
    }
    
    public void setParentCategoryName(String parentCategoryName) {
        this.parentCategoryName = parentCategoryName;
    }
    
    public int getChildCategories() {
        return childCategories;
    }
    
    public void setChildCategories(int childCategories) {
        this.childCategories = childCategories;
    }

    @Override
    public String toString() {
        return "TopCategory [parentCategoryName=" + parentCategoryName
                + ", childCategories=" + childCategories + "]";
    }
}
