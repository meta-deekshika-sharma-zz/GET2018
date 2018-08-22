package storeFront;

/**
 * @author Deekshika Sharma
 * This pojo have image properties for image table in store front
 */
public class ImagePojo {

	private String url;
	private String text;
	private int productId;
	
	public ImagePojo(String url, String text, int productId) {
		this.url = url;
		this.text = text;
		this.productId = productId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
}
