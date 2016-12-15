package ui.administor;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import businesslogic.account.WebDesignerAccountController;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import tools.ResultMessage_Account;
import ui.administor.CustomerController.Customer;
import ui.utils.Dialogs;
import vo.WebAccountVO;
/**
 * 网站营销人员账号管理的委托类
 * @author zjy
 *
 */
public class WebController {
	private static final String titles[]={"用户名","姓名"};
	
	private JFXTreeTableView<Web> webList;
	private TextField filterField;
	private Button reset;
	private Button delete;
	private ObservableList<Web> webs;

	/**
	 * 
	 * @param webList 显示列表的TreeTableView
	 * @param filterField 过滤显示的TextField
	 * @param reset 重置密码按钮
	 * @param delete 删除账号按钮
	 */
	public WebController(JFXTreeTableView<Web> webList,TextField filterField,Button reset,Button delete) {
		this.webList = webList;
		this.filterField=filterField;
		this.reset=reset;
		this.delete=delete;
		initWeb();
	}
	
	
	private void initWeb(){
		webs = FXCollections.observableArrayList();
		//webs.add(new Web("userName","webName"));
		//webs.add(new Web("userName1","webName"));
		//上面是一个例子
		WebDesignerAccountController webDesignerAccountController = WebDesignerAccountController.getInstance();
		List<WebAccountVO> list = webDesignerAccountController.getWebAccount();
		webs.addAll(list.stream().map(account -> new Web(account.name,account.id)).collect(Collectors.toList()));
		
		final TreeItem<Web> root = new RecursiveTreeItem<Web>(webs, RecursiveTreeObject::getChildren);
		webList.setRoot(root);
		
		for(int index=0;index<titles.length;index++){
			setCustomerColumn(index);
		}
		filterField.textProperty().addListener((o,oldVal,newVal)->{
			webList.setPredicate(web -> web.getValue().userName.get().contains(newVal) || 
					web.getValue().webName.get().contains(newVal));
		});
		reset.setOnAction((action)->resetPassword());
		delete.setOnAction((action)->delete());
	}
	private void setCustomerColumn(int index){
		JFXTreeTableColumn<Web, String> colum=new JFXTreeTableColumn<>(titles[index]);
		colum.setPrefWidth(150);
		colum.setCellValueFactory((TreeTableColumn.CellDataFeatures<Web, String> param) ->{
			StringProperty propertys[]={param.getValue().getValue().userName,param.getValue().getValue().webName};
			if(colum.validateValue(param)) return propertys[index];
			else return colum.getComputedValue(param);
		});
		webList.getColumns().add(colum);
	}	
	private void resetPassword() {
		if(webList.getSelectionModel().getSelectedItem()==null){
			return;
		}
		String userName=webList.getSelectionModel().getSelectedItem().getValue().userName.get();
		System.out.println("reset:"+userName);
		
		String id=webList.getSelectionModel().getSelectedItem().getValue().webName.get();
		WebDesignerAccountController webDesignerAccountController = 
				WebDesignerAccountController.getInstance();
		ResultMessage_Account rs = webDesignerAccountController.resetPassword(id, "webweb");
		
		if(rs.equals(ResultMessage_Account.Success)){
			Dialogs.showMessage("耶耶","重置密码成功！≧∇≦");
		}else{
			Dialogs.showMessage("额", "重置失败，也许是网络问题？");
		}
		
		
	}
	private void delete() {
		if(webList.getSelectionModel().getSelectedItem()==null){
			return;
		}
		String userName=webList.getSelectionModel().getSelectedItem().getValue().userName.get();
		System.out.println("delete:"+userName);
		
		String id=webList.getSelectionModel().getSelectedItem().getValue().webName.get();
		WebDesignerAccountController webDesignerAccountController = 
				WebDesignerAccountController.getInstance();
		ResultMessage_Account rs = webDesignerAccountController.deleteAccount(id);
		
		if(rs.equals(ResultMessage_Account.Success)){
			Dialogs.showMessage("", "删除成功");
			webs.remove(webList.getSelectionModel().getSelectedItem().getValue());
		}else{
			Dialogs.showMessage("额", "删除失败，也许是网络问题？");
		}
	}
	
	/**
	 * 要显示的网站营销人员属性
	 * @author zjy
	 *
	 */
	class Web extends RecursiveTreeObject<Web>{		
		StringProperty userName;
		StringProperty webName;
		
		/**
		 * 
		 * @param userName 用户名
		 * @param webName 网站营销人员的名字  没有 暂时先用id 代替
		 */
		public Web(String userID, String username) {
			super();
			this.userName = new SimpleStringProperty(userID) ;
			this.webName = new SimpleStringProperty(username) ;
		}
	}
}
