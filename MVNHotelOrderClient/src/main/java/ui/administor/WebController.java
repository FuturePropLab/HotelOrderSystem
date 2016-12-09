package ui.administor;

import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
/**
 * 网站营销人员账号管理的委托类
 * @author zjy
 *
 */
public class WebController {
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
		webs.add(new Web("userName","webName"));
		webs.add(new Web("userName1","webName"));
		//上面时一个例子
		//TODO:调用blservice添加酒店账号信息
		final TreeItem<Web> root = new RecursiveTreeItem<Web>(webs, RecursiveTreeObject::getChildren);
		webList.setRoot(root);
		
		for(int index=0;index<2;index++){
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
		String titles[]={"用户名","姓名"};
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
		//TODO:调用blservice重置密码
	}
	private void delete() {
		if(webList.getSelectionModel().getSelectedItem()==null){
			return;
		}
		String userName=webList.getSelectionModel().getSelectedItem().getValue().userName.get();
		System.out.println("delete:"+userName);
		//TODO:调用blservice删除账号
		
		
		webs.remove(webList.getSelectionModel().getSelectedItem().getValue());
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
		 * @param webName 网站营销人员的名字
		 */
		public Web(String userName, String webName) {
			super();
			this.userName = new SimpleStringProperty(userName) ;
			this.webName = new SimpleStringProperty(webName) ;
		}
	}
}
