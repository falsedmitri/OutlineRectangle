package com.outlinerectangle;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.scene.Scene;
import org.andengine.extension.physics.box2d.PhysicsConnector;
import org.andengine.extension.physics.box2d.PhysicsFactory;
import org.andengine.extension.physics.box2d.PhysicsWorld;
import org.andengine.ui.activity.SimpleBaseGameActivity;
import org.andengine.util.color.Color;

import android.hardware.SensorManager;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;

/**
 * 
 */
public class OutlineRectangleActivity extends SimpleBaseGameActivity {

	private final int CAMERA_WIDTH = 800; // right edge of screen
	private final int CAMERA_HEIGHT = 480; // bottom of screen

	private PhysicsWorld mPhysicsWorld;
	private FixtureDef fixtureDef;
	private Scene mScene;

	private OutlineRectangle defaultRectangle;
	private OutlineRectangle blueRectangle;
	private OutlineRectangle thickRectangle;
	private OutlineRectangle veryThickRectangle;
	private OutlineRectangle thirty2Rectangle;
	private OutlineRectangle sixty4Rectangle;

	private Body defaultRectangleBody;

	public EngineOptions onCreateEngineOptions() {

		final Camera camera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);

		final EngineOptions engineOptions = new EngineOptions(true, ScreenOrientation.LANDSCAPE_FIXED, new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT), camera);
		return engineOptions;

	}

	@Override
	protected void onCreateResources() {

	}

	@Override
	public Scene onCreateScene() {

		mScene = new Scene();
		this.mPhysicsWorld = new PhysicsWorld(new Vector2(0, SensorManager.GRAVITY_EARTH), false);
		fixtureDef = PhysicsFactory.createFixtureDef(1.0f, 0.0f, 1.0f);
		
		defaultRectangle = new OutlineRectangle(10, 10, 250, 400, this.getVertexBufferObjectManager());

		defaultRectangleBody = PhysicsFactory.createBoxBody(this.mPhysicsWorld, defaultRectangle, BodyType.StaticBody, fixtureDef);
		defaultRectangle.setUserData(defaultRectangleBody);
		this.mPhysicsWorld.registerPhysicsConnector(new PhysicsConnector(defaultRectangle, defaultRectangleBody, true, false));

		mScene.attachChild(defaultRectangle);
		
		blueRectangle = new OutlineRectangle(50, 50, 300, 150, Color.BLUE, this.getVertexBufferObjectManager());
		mScene.attachChild(blueRectangle);

		thickRectangle = new OutlineRectangle(125, 150, 200, 200, Color.GREEN, 10, this.getVertexBufferObjectManager());
		mScene.attachChild(thickRectangle);

		veryThickRectangle = new OutlineRectangle(250, 200, 300, 200, Color.CYAN, 40, this.getVertexBufferObjectManager());
		mScene.attachChild(veryThickRectangle);
		
		thirty2Rectangle = new OutlineRectangle(600, 200, 64, 64, Color.RED, 2, this.getVertexBufferObjectManager());
		mScene.attachChild(thirty2Rectangle);
		
		sixty4Rectangle = new OutlineRectangle(600, 300, 32, 32, Color.RED, 2, this.getVertexBufferObjectManager());
		mScene.attachChild(sixty4Rectangle);
		
		return mScene;

	}

}
