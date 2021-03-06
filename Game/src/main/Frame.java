package main;
import graphics.Texture;

public class Frame {

	private Texture frame;
	private int duration;

	public Frame(Texture frame, int duration) {
		this.frame = frame;
		this.duration = duration;
	}

	public Texture getFrame() {
		return frame;
	}

	public void setFrame(Texture frame) {
		this.frame = frame;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

}