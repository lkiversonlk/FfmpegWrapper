package com.ipinyou.fmpegWrapper.operator;

public class Selector {
	public enum AudioVideo{
		AUDIO,
		VIDEO,
		ALL
	}
	
	public static final Selector NoneSelector = null;
	public static final Selector AllVideoSelector = new Selector(AudioVideo.VIDEO);
	public static final Selector AllAudioSelector = new Selector(AudioVideo.AUDIO);

	private boolean specifiedStream = false;
	private int streamNo;
	private AudioVideo type;
	
	public Selector(Selector.AudioVideo type){
		this.type = type;
	}
	
	public Selector(Selector.AudioVideo type, int streamNo){
		this.type = type;
		this.specifiedStream = true;
		this.streamNo = streamNo;
	}
	
	public String toCommand(){
		StringBuilder sb = new StringBuilder();
		if(this.type == AudioVideo.AUDIO){
			sb.append("a");
		}
		
		if(this.type == AudioVideo.VIDEO){
			sb.append("v");
		}
		
		if(this.specifiedStream){
			sb.append(":" + this.streamNo);
		}
		
		return sb.toString();
	}

	public AudioVideo getType() {
		return type;
	}
	
	
}
