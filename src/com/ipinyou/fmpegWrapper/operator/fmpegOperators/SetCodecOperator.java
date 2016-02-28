package com.ipinyou.fmpegWrapper.operator.fmpegOperators;

import com.ipinyou.fmpegWrapper.operator.FfmpegOperator;
import com.ipinyou.fmpegWrapper.operator.SegmentType;
import com.ipinyou.fmpegWrapper.operator.Selector;

public class SetCodecOperator extends FfmpegOperator {
	public enum Codec{
		libx264
	}
	
	public SetCodecOperator(Selector selector, Codec codec) {
		super("codec", selector, codec.name(), SegmentType.INPUT, SegmentType.OUTPUT);
	}

}
