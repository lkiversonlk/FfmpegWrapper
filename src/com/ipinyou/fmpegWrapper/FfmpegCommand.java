package com.ipinyou.fmpegWrapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.ipinyou.fmpegWrapper.operator.CommandSegment;
import com.ipinyou.fmpegWrapper.operator.FfmpegOperator;
import com.ipinyou.fmpegWrapper.operator.FfmpegWrapperException;
import com.ipinyou.fmpegWrapper.operator.GlobalCommandSegment;
import com.ipinyou.fmpegWrapper.operator.MultipleFilesHandler;
import com.ipinyou.fmpegWrapper.operator.SegmentType;
import com.ipinyou.fmpegWrapper.operator.fmpegOperators.*;

public class FfmpegCommand {
	private String fmpegBinPath; 
	private GlobalCommandSegment globalSeg = new GlobalCommandSegment();
	private MultipleFilesHandler inputSeg = new MultipleFilesHandler(SegmentType.INPUT);
	private MultipleFilesHandler outputSeg = new MultipleFilesHandler(SegmentType.OUTPUT);
	
	public FfmpegCommand(String fmpegBinPath){
		this.fmpegBinPath = fmpegBinPath;
		try {
			this.addGlobalOperator(new OverwriteWithoutAskingOperator());
		} catch (FfmpegWrapperException e) {
			e.printStackTrace();
		}
	}
	
	public FfmpegResult execute() throws IOException, InterruptedException{
		Process proc = Runtime.getRuntime().exec(this.toCommand());
		
		BufferedReader stdinReader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
		BufferedReader stderrReader = new BufferedReader(new InputStreamReader(proc.getErrorStream()));
		
		String s = null;
		FfmpegResult ret = new FfmpegResult();
		
		while((s = stdinReader.readLine()) != null){
			ret.stdout += s + "\n";
		}
		while((s = stderrReader.readLine()) != null){
			ret.stderr += s + "\n";
		}
		
		ret.RetCode = proc.waitFor();
		
		return ret;
	}
	
	public void addGlobalOperator(FfmpegOperator operator) throws FfmpegWrapperException{
		this.globalSeg.addOperator(operator);
	}
	
	public void addInputFileOperator(FfmpegOperator operator) throws FfmpegWrapperException{
		this.inputSeg.addOperator(operator);
	}
	
	public void addOutputFileOperator(FfmpegOperator operator) throws FfmpegWrapperException{
		this.outputSeg.addOperator(operator);
	}
	
	public void addInputFileHandler(CommandSegment fileHandler) throws FfmpegWrapperException{
		this.inputSeg.addFileHandler(fileHandler);
	}
	
	public void addOutputFileHandler(CommandSegment fileHandler) throws FfmpegWrapperException{
		this.outputSeg.addFileHandler(fileHandler);
	}
	
	public String toCommand(){
		StringBuilder sb = new StringBuilder();
		sb.append(fmpegBinPath + " ");
		sb.append(globalSeg.toCommand() + " ");
		sb.append(inputSeg.toCommand() + " ");
		sb.append(outputSeg.toCommand() + " ");
		return sb.toString();
	}
	
	public void setSilentMode(){
		try {
			this.addGlobalOperator(new SilentFfmpegOperator());
		} catch (FfmpegWrapperException e) {
			e.printStackTrace();
		}
	}

	public GlobalCommandSegment getGlobalSeg() {
		return globalSeg;
	}

	public MultipleFilesHandler getInputSeg() {
		return inputSeg;
	}

	public MultipleFilesHandler getOutputSeg() {
		return outputSeg;
	}
	
	
}
