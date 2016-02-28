package com.ipinyou.fmpegWrapper.operator;

public class FfmpegOperator {
	
	private SegmentType[] forSegs;
	private String flag;
	private Selector selector;
	private String parameter;
	
	public FfmpegOperator(String flag, Selector selector, String parameter, SegmentType... forSegs){
		this.flag = flag;
		this.selector = selector;
		this.parameter = parameter;
		this.forSegs = forSegs;
	}
	
	public String toCommand(){
		StringBuilder sb = new StringBuilder();
		
		sb.append("-" + flag);
		
		if(this.selector != null){
			sb.append(":" + selector.toCommand());
		}
		
		if(this.parameter != null){
			sb.append(" " + parameter);
		}
		
		return sb.toString();
	}

	public SegmentType[] getForSegs() {
		return forSegs;
	}
	
	
}
