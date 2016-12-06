package Exception;
/**
 * 客户信用值不足
 * @author zjy
 *
 */
public class CustomerCreditNotEnoughException extends Exception{
	public int credit;

	/**
	 * 
	 */
	private static final long serialVersionUID = 2918895173194321774L;

	/**
	 * 
	 * @param credit 客户当前信用值
	 */
	public CustomerCreditNotEnoughException(int credit) {
		super();
		this.credit = credit;
	}
	
}
