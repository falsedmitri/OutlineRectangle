package com.outlinerectangle;

import org.andengine.entity.Entity;
import org.andengine.entity.primitive.Line;
import org.andengine.entity.shape.IAreaShape;
import org.andengine.entity.shape.IShape;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.shader.ShaderProgram;
import org.andengine.opengl.vbo.IVertexBufferObject;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.util.color.Color;

/**
 *    Rectangle formed by using 4 lines attached to this Entity
 */
public class OutlineRectangle extends Entity implements IAreaShape {

	// default color and line thickness
	private Color mLineColor = Color.RED;
	private float mLineThickness = 1.0f;

	// 2 horizontal lines for width of rectangle
	Line mTopLine;
	Line mBottomLine;

	// 2 vertical lines for height of rectangle
	Line mLeftLine;
	Line mRightLine;

	/**
	 * Constructor
	 * 
	 * Default line color and line width
	 * 
	 * @param pX1 upper left corner x
	 * @param pY1 upper left corner y
	 * @param pWidth length of x line
	 * @param pHeight length of y line
	 * @param vertexBufferObjectManager
	 */
	public OutlineRectangle(
			float pX1, 
			float pY1, 
			float pWidth, 
			float pHeight, 
			VertexBufferObjectManager vertexBufferObjectManager) {

		mTopLine = new Line(pX1, pY1, pX1 + pWidth, pY1, mLineThickness, vertexBufferObjectManager);
		mBottomLine = new Line(pX1, pY1 + pHeight, pX1 + pWidth, pY1 + pHeight, mLineThickness, vertexBufferObjectManager);

		mLeftLine = new Line(pX1, pY1, pX1, pY1 + pHeight, mLineThickness, vertexBufferObjectManager);
		mRightLine = new Line(pX1 + pWidth, pY1, pX1 + pWidth, pY1 + pHeight, mLineThickness, vertexBufferObjectManager);

		setColor(mLineColor);

		this.attachChild(mTopLine);
		this.attachChild(mBottomLine);
		this.attachChild(mLeftLine);
		this.attachChild(mRightLine);

	}

	/**
	 * Constructor
	 * 
	 * Default line width
	 * 
	 * @param pX1 upper left corner x
	 * @param pY1 upper left corner y
	 * @param pWidth length of x line
	 * @param pHeight length of y line
	 * @oaran lineColor line color
	 * @param vertexBufferObjectManager
	 */
	public OutlineRectangle(
			float pX1, 
			float pY1, 
			float pWidth, 
			float pHeight,
			Color lineColor,
			VertexBufferObjectManager vertexBufferObjectManager) {

		mTopLine = new Line(pX1, pY1, pX1 + pWidth, pY1, mLineThickness, vertexBufferObjectManager);
		mBottomLine = new Line(pX1, pY1 + pHeight, pX1 + pWidth, pY1 + pHeight, mLineThickness, vertexBufferObjectManager);

		mLeftLine = new Line(pX1, pY1, pX1, pY1 + pHeight, mLineThickness, vertexBufferObjectManager);
		mRightLine = new Line(pX1 + pWidth, pY1, pX1 + pWidth, pY1 + pHeight, mLineThickness, vertexBufferObjectManager);

		mLineColor = lineColor;
		setColor(lineColor);

		this.attachChild(mTopLine);
		this.attachChild(mBottomLine);
		this.attachChild(mLeftLine);
		this.attachChild(mRightLine);

	}

	/**
	 * Constructor
	 * 
	 * @param pX1 upper left corner x
	 * @param pY1 upper left corner y
	 * @param pWidth length of x line
	 * @param pHeight length of y line
	 * @oaran lineColor line color
	 * @param lineThickness
	 * @param vertexBufferObjectManager
	 */
	public OutlineRectangle(
			float pX1, 
			float pY1, 
			float pWidth, 
			float pHeight,
			Color lineColor,
			float lineThickness,
			VertexBufferObjectManager vertexBufferObjectManager) {

		mLineThickness = lineThickness;
		float halfThickness = mLineThickness/2;

		mTopLine = new Line(pX1 - halfThickness, pY1, pX1 + halfThickness + pWidth, pY1, mLineThickness, vertexBufferObjectManager);
		mBottomLine = new Line(pX1- halfThickness, pY1 + pHeight, pX1 + halfThickness + pWidth, pY1 + pHeight, mLineThickness, vertexBufferObjectManager);

		mLeftLine = new Line(pX1, pY1, pX1, pY1 + pHeight, mLineThickness, vertexBufferObjectManager);
		mRightLine = new Line(pX1 + pWidth, pY1, pX1 + pWidth, pY1 + pHeight, mLineThickness, vertexBufferObjectManager);

		mLineColor = lineColor;
		setColor(lineColor);

		this.attachChild(mTopLine);
		this.attachChild(mBottomLine);
		this.attachChild(mLeftLine);
		this.attachChild(mRightLine);

	}

	@Override
	public void setColor(Color color) {
		mTopLine.setColor(color);
		mBottomLine.setColor(color);
		mLeftLine.setColor(color);
		mRightLine.setColor(color);
	}

	// interface

	@Override
	public boolean collidesWith(IShape pOtherShape) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isBlendingEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setBlendingEnabled(boolean pBlendingEnabled) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getBlendFunctionSource() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getBlendFunctionDestination() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setBlendFunctionSource(int pBlendFunctionSource) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setBlendFunctionDestination(int pBlendFunctionDestination) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setBlendFunction(int pBlendFunctionSource,
			int pBlendFunctionDestination) {
		// TODO Auto-generated method stub

	}

	@Override
	public VertexBufferObjectManager getVertexBufferObjectManager() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IVertexBufferObject getVertexBufferObject() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShaderProgram getShaderProgram() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setShaderProgram(ShaderProgram pShaderProgram) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean contains(float pX, float pY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onAreaTouched(TouchEvent pSceneTouchEvent,
			float pTouchAreaLocalX, float pTouchAreaLocalY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public float getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getWidthScaled() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getHeightScaled() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setHeight(float pHeight) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setWidth(float pWidth) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSize(float pWidth, float pHeight) {
		// TODO Auto-generated method stub

	}

}
