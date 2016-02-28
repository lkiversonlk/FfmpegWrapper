package com.ipinyou.fmpegWrapper.helper;

import java.io.IOException;

import com.ipinyou.fmpegWrapper.FfmpegCommand;
import com.ipinyou.fmpegWrapper.FfmpegResult;
import com.ipinyou.fmpegWrapper.operator.CommandSegment;
import com.ipinyou.fmpegWrapper.operator.SegmentType;
import com.ipinyou.fmpegWrapper.operator.Selector;
import com.ipinyou.fmpegWrapper.operator.SingleFileHandler;
import com.ipinyou.fmpegWrapper.operator.fmpegOperators.*;


public class OneToOneCommandBuilder {
	
	private final int VideoFileId = 0;
	private final int AudioFileId = 1;
	
	private FfmpegCommand command;
	
	public OneToOneCommandBuilder(String ffmpegBinPath){
		command = new FfmpegCommand(ffmpegBinPath);
	}
	
	public void setOutputVideoCodech264(){
		command.addOutputFileOperator(new SetCodecOperator(Selector.AllVideoSelector, SetCodecOperator.Codec.libx264));
	}
	
	public void setWidthHeight(int width, int height){
		command.addOutputFileOperator(new ScaleVideoOperator(Selector.AllVideoSelector, width, height));
	}
	
	public void cutVideo(double start, double end){
		CommandSegment videoFileHandler = command.getInputSeg().getFileHandlers().get(VideoFileId);
		cutStream(videoFileHandler, start, end);
	}
	
	public void cutAudio(double start, double end){
		CommandSegment audioFileHandler = command.getInputSeg().getFileHandlers().get(AudioFileId);
		cutStream(audioFileHandler, start, end);
	}
	
	private void cutStream(CommandSegment fileHandler, double startTime, double endTime){
		fileHandler.addOperator(new SetStartPointOperator(Selector.NoneSelector, startTime));
		fileHandler.addOperator(new SetEndPointOperator(Selector.NoneSelector, endTime));
	}
	
	public void setAudioCodec(SetCodecOperator.Codec codec){
		command.addOutputFileOperator(new SetCodecOperator(Selector.AllAudioSelector, codec));
	}
		
	public void setInputFilePath(String filePath){
		command.addInputFileHandler(new SingleFileHandler(SegmentType.INPUT, filePath));
		command.addInputFileHandler(new SingleFileHandler(SegmentType.INPUT, filePath));
	}
	
	public void setOutputFilePath(String filePath){
		SingleFileHandler outputFile = new SingleFileHandler(SegmentType.OUTPUT, filePath);
		outputFile.addOperator(new MapOperator(VideoFileId, 0));
		outputFile.addOperator(new MapOperator(AudioFileId, 1));
		command.addOutputFileHandler(outputFile);
	}
	
	public void setAspect(int w, int h){
		command.addOutputFileOperator(new SetAspectOperator(Selector.NoneSelector, w, h));
	}
	
	public String generateCommand(){
		return command.toCommand();
	}
	
	public FfmpegResult execute() throws IOException, InterruptedException{
		return command.execute();
	}
	
	public void setVideoBitRate(String bitRate){
		command.addOutputFileOperator(new SetBitRateOperator(Selector.AllVideoSelector, bitRate));
	}
	
	public void setSilentMode(){
		command.setSilentMode();
	}
}
