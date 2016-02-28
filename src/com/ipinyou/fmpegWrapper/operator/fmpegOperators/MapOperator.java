package com.ipinyou.fmpegWrapper.operator.fmpegOperators;

import com.ipinyou.fmpegWrapper.operator.FfmpegOperator;
import com.ipinyou.fmpegWrapper.operator.SegmentType;
import com.ipinyou.fmpegWrapper.operator.Selector;

public class MapOperator extends FfmpegOperator {

	public MapOperator(int fileId, int streamId) {
		super("map", Selector.NoneSelector, fileId+":"+streamId, SegmentType.OUTPUT);
	}

}
