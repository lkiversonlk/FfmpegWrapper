package com.ipinyou.fmpegWrapper.operator.fmpegOperators;

import com.ipinyou.fmpegWrapper.operator.FfmpegOperator;
import com.ipinyou.fmpegWrapper.operator.SegmentType;
import com.ipinyou.fmpegWrapper.operator.Selector;

public class SilentFfmpegOperator extends FfmpegOperator {

	public SilentFfmpegOperator() {
		super("loglevel", Selector.NoneSelector, "quiet", SegmentType.GLOBAL);
	}
}
