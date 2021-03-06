package dataservice.datahelper;

import java.util.List;

import po.DiscountPO_web;
import po.DiscountPO_web_district;
import po.DiscountPO_web_level;
import po.DiscountPO_web_period;
import tools.ResultMessage_Discount;
import tools.ResultMessage_DiscountDetail;

public interface DiscountWebDataHelper {
		
		/**
		 * 
		 * @param discountID
		 * @return
		 */
		public DiscountPO_web getDiscountPO(String discountID);
		
		/**
		 * 
		 * @return
		 */
		public  List<DiscountPO_web_district> getDiscountPOWebDistrictList();
		
		/**
		 * 
		 * @return
		 */
		public  List<DiscountPO_web_level> getDiscountPOWebLevelList();
		
		/**
		 * 
		 * @return
		 */
		public  List<DiscountPO_web_period> getDiscountPOWebPeriodList();
		
		/**
		 * 
		 * @return
		 */
		public  List<DiscountPO_web> getALLDiscountPOList();
		
		/**
		 * 
		 * @param discountPO_web
		 * @return
		 */
		public ResultMessage_DiscountDetail addDiscountPO(DiscountPO_web discountPO_web);
		
		/**
		 * 
		 * @param discountPO_web
		 * @return
		 */
		public ResultMessage_Discount modifyDiscountPO(DiscountPO_web discountPO_web);
		
		/**
		 * 
		 * @param discountID
		 * @return
		 */
		public ResultMessage_Discount invalidDisCount(String discountID);
		
		/**
		 * 
		 * @param discountID
		 * @return
		 */
		public ResultMessage_Discount deleteDiscount(String discountID);

	
		
		
		
}
