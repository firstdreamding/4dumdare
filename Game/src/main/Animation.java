package main;
import java.util.ArrayList;
import java.util.List;

import graphics.Texture;

public class Animation {

	private int frameCount, frameDelay, currentFrame, animationDirection, totalFrames;

	private boolean stopped, loop;

	private List<Frame> frames = new ArrayList<Frame>();

	public Animation(Texture frames[], int frameDelay) {
		this.frameDelay = frameDelay;
		this.stopped = true;

		for (int i = 0; i < frames.length; i++) {
			addFrame(frames[i], frameDelay);
		}

		this.frameCount = 0;
		this.frameDelay = frameDelay;
		this.currentFrame = 0;
		this.animationDirection = 1;
		this.totalFrames = this.frames.size();

	}

	public void start() {
		if (!stopped) {
			return;
		}

		if (frames.size() == 0) {
			return;
		}
		stopped = false;
	}

	public void reset() {
		this.stopped = true;
		this.frameCount = 0;
		this.currentFrame = 0;
	}

	public void restart() {
		if (frames.size() == 0) {
			return;
		}

		stopped = false;
		currentFrame = 0;
	}

	public void stop() {
		if (frames.size() == 0) {
			return;
		}

		stopped = true;
	}

	private void addFrame(Texture texture, int duration) {
		if (duration <= 0) {
			System.err.println("Invalid duration: " + duration);
			throw new RuntimeException("Invalid duration: " + duration);
		}

		frames.add(new Frame(texture, duration));
		currentFrame = 0;
	}

	public Texture getSprite() {
		return frames.get(currentFrame).getFrame();
	}

    public void update() {
        if (!stopped) {
            frameCount++;

            if (frameCount > frameDelay) {
                frameCount = 0;
                currentFrame += animationDirection;

                if (currentFrame > totalFrames - 1) {
                    currentFrame = 0;
                }
                else if (currentFrame < 0) {
                    currentFrame = totalFrames - 1;
                }
            }
        }

    }

}