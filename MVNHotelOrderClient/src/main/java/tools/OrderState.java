package tools;

import javafx.scene.paint.Color;

/**
 *  订单的状态，一共四种
 *  @author zjy
 */
public enum OrderState {
	Unexecuted,
	Executed,
	Exception,
	Revoked;

	@Override
	public String toString() {
		if(this.equals(Unexecuted)){
			return "未入住";
		}else if (this.equals(Executed)) {
			return "已入住";
		}else if (this.equals(Exception)) {
			return "异常订单";
		}else if (this.equals(Revoked)) {
			return "已撤销";
		}
		return super.toString();
	}
	
	public Color getColor() {
		Color[] stateColors={Color.GREEN,Color.LIGHTSKYBLUE,Color.RED,Color.DARKGREY};
		return stateColors[this.ordinal()];
	}
}
