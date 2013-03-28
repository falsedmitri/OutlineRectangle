package com.outlinerectangle;

import org.andengine.entity.Entity;
import org.andengine.entity.sprite.Sprite;

public class RectangleDecay {

	private int COUNTDOWN_START = 5;

	Entity entity;
	int time;

	/**
	 * constructor 
	 * 
	 * @param sprite
	 */
	public RectangleDecay(Entity entity) {
		this.entity = entity;
		time = COUNTDOWN_START;
	}

	/**
	 * decrement count
	 * if count < 0 then don't display sprite
	 */
	public boolean decrement() {
		boolean removeFromList = false;

		time--;
		if (time > 0) { // fade sprite a bit

			// fade
			float alpha = entity.getAlpha();
			alpha -= 0.2;
			entity.setAlpha(alpha);

			// shrink
			float scaleX = entity.getScaleX() * 0.8f;
			float scaleY = entity.getScaleY() * 0.8f;;
			entity.setScaleX(scaleX);
			entity.setScaleY(scaleY);

			// move sprite 1 to the left
			entity.setX(entity.getX()-1);

		}
		else { // time's up 
			entity.setVisible(false);
			removeFromList = true;
		}
		return removeFromList;

	}

	public Entity getEntity() {
		return entity;
	}

	public void removeEntity() {
		entity.setVisible(false);
		entity = null;
	}
}
