package com.ipinyou.fmpegWrapper.operator.fmpegOperators;

import com.ipinyou.fmpegWrapper.operator.SegmentType;
import com.ipinyou.fmpegWrapper.operator.Selector;

public class ScaleVideoOperator extends FfmpegVideoOperator {

	public ScaleVideoOperator(Selector selector, int width, int height) {
		super("s", selector, width == 0 ? null : width + "x" + height, SegmentType.INPUT, SegmentType.OUTPUT);
	}

}
