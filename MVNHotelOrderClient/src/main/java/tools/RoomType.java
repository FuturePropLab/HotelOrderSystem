package tools;

/**
 *  房间的类型
 *  @author zjy
 */
public enum RoomType {
	Single,
	Double,
	Standard,
	Suites,
	EluxeSuite;
	
	public String tosave(){
		if(this.equals(Single)){
			return "Single";
		}else if(this.equals(Double)){
			return "Double";
		}else if(this.equals(Standard)){
			return "Standard";
		}else if(this.equals(Suites)){
			return "Suites";
		}else if(this.equals(EluxeSuite)){
			return "EluxeSuite";
		}else return null;
	}

	@Override
	public String toString() {
		if(this.equals(Single)){
			return "单人间";
		}else if(this.equals(Double)){
			return "双人间";
		}else if(this.equals(Standard)){
			return "标准间";
		}else if(this.equals(Suites)){
			return "豪华套房";
		}else if(this.equals(EluxeSuite)){
			return "总统套房";
		}
		return super.toString();
	}
}
