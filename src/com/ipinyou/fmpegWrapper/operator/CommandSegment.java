package com.ipinyou.fmpegWrapper.operator;

import java.util.ArrayList;
import java.util.List;

public abstract class CommandSegment {

	protected SegmentType segmentType;
	protected List<FfmpegOperator> operators = new ArrayList<FfmpegOperator>();
	
	
	public String composeOperator(){
		if(this.operators.size() == 0){
			return "";
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(FfmpegOperator operator : operators){
			sb.append(operator.toCommand());
			sb.append(" ");
		}
		
		return sb.toString();
	}
	
	abstract public String toCommand();

	public SegmentType getInputOutput() {
		return segmentType;
	}

	public List<FfmpegOperator> getOperators() {
		return operators;
	}
	
	public void addOperator(FfmpegOperator operator) throws FfmpegWrapperException{
		for(SegmentType type : operator.getForSegs()){
			if(type == this.segmentType){
				this.operators.add(operator);
				return;
			}
		}
		throw new FfmpegWrapperException("segment of type " + this.segmentType + " didn't match operator");
	}
}
