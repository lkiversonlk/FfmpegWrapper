package com.ipinyou.fmpegWrapper.operator;

public class GlobalCommandSegment extends CommandSegment{
	
	public GlobalCommandSegment(){
		this.segmentType = SegmentType.GLOBAL;
	}

	@Override
	public String toCommand() {
		return this.composeOperator();
	}
}
