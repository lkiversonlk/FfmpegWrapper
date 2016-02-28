package com.ipinyou.fmpegWrapper.operator;

public class SingleFileHandler extends CommandSegment {

	private String filePath;
	
	public SingleFileHandler(SegmentType inputOutput, String filePath){
		this.segmentType = inputOutput;
		this.filePath = filePath;
	}
	
	@Override
	public String toCommand() {
		return this.composeOperator() + " " + (this.segmentType == SegmentType.INPUT? "-i ":"") + this.filePath;
	}

}
