package br.ufal.cg;

import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;

public abstract class MovableCamera implements GLEventListener {

	//Parametros iniciais
	protected double x_eye = 2;
	protected double y_eye = 0;
	protected double z_eye = 1;

	protected double x_y_angle = 0;
	protected double z_angle = 0;

	protected GLU glu;
	protected double walkFowardSensivity = 0.2;
	protected double walkBackwardSensivity = 0.2;

	public MovableCamera() {
		glu = new GLU();
	}

	protected void setCameraPos() {
		double eye_direction_x = x_eye + Math.sin(Math.toRadians(x_y_angle));
		double eye_direction_y = y_eye + Math.cos(Math.toRadians(x_y_angle));
		double eye_direction_z = z_eye + Math.tan(Math.toRadians(z_angle));

		glu.gluLookAt(x_eye, y_eye, z_eye, eye_direction_x, eye_direction_y,
				eye_direction_z, 0., 0., 1.); // set the

	}

	public void walkForward() {
		double eye_direction_x = x_eye + Math.sin(Math.toRadians(x_y_angle));
		double eye_direction_y = y_eye + Math.cos(Math.toRadians(x_y_angle));
		double eye_direction_z = z_eye + Math.tan(Math.toRadians(z_angle));

		x_eye += walkFowardSensivity * (eye_direction_x - x_eye);
		y_eye += walkFowardSensivity * (eye_direction_y - y_eye);
		z_eye += walkFowardSensivity * (eye_direction_z - z_eye);
	}

	public void walkBackward() {
		double eye_direction_x = x_eye + Math.sin(Math.toRadians(x_y_angle));
		double eye_direction_y = y_eye + Math.cos(Math.toRadians(x_y_angle));
		double eye_direction_z = z_eye + Math.tan(Math.toRadians(z_angle));

		x_eye -= walkBackwardSensivity * (eye_direction_x - x_eye);
		y_eye -= walkBackwardSensivity * (eye_direction_y - y_eye);
		z_eye -= walkBackwardSensivity * (eye_direction_z - z_eye);
	}

	public void walkRight() {
		double eye_direction_x = x_eye
				+ Math.sin(Math.toRadians(x_y_angle + 90));
		double eye_direction_y = y_eye
				+ Math.cos(Math.toRadians(x_y_angle + 90));

		x_eye += walkBackwardSensivity * (eye_direction_x - x_eye);
		y_eye += walkBackwardSensivity * (eye_direction_y - y_eye);

	}

	public void walkFoward(int x_angle, int y_angle, int z_angle) {
		double eye_direction_x = x_eye
				+ Math.sin(Math.toRadians(x_y_angle + x_angle));
		double eye_direction_y = y_eye
				+ Math.cos(Math.toRadians(x_y_angle + y_angle));
		double eye_direction_z = z_eye
				+ Math.tan(Math.toRadians(this.z_angle + z_angle));

		x_eye += walkBackwardSensivity * (eye_direction_x - x_eye);
		y_eye += walkBackwardSensivity * (eye_direction_y - y_eye);
		z_eye += walkBackwardSensivity * (eye_direction_z - z_eye);

	}

	public void walkBackard(int x_angle, int y_angle, int z_angle) {
		double eye_direction_x = x_eye
				+ Math.sin(Math.toRadians(x_y_angle + x_angle));
		double eye_direction_y = y_eye
				+ Math.cos(Math.toRadians(x_y_angle + y_angle));
		double eye_direction_z = z_eye
				+ Math.tan(Math.toRadians(this.z_angle + z_angle));

		x_eye -= walkBackwardSensivity * (eye_direction_x - x_eye);
		y_eye -= walkBackwardSensivity * (eye_direction_y - y_eye);
		z_eye -= walkBackwardSensivity * (eye_direction_z - z_eye);

	}

	public void walkLeft() {
		double eye_direction_x = x_eye
				+ Math.sin(Math.toRadians(x_y_angle - 90));
		double eye_direction_y = y_eye
				+ Math.cos(Math.toRadians(x_y_angle - 90));
		x_eye += walkBackwardSensivity * (eye_direction_x - x_eye);
		y_eye += walkBackwardSensivity * (eye_direction_y - y_eye);

	}

	public void displayChanged(GLAutoDrawable drawable, boolean modeChanged,
			boolean deviceChanged) {
	}

	public void moveCameraX_Y(int x_dist) {

		x_y_angle += x_dist * 0.08;

		if (x_y_angle < -360 || x_y_angle > 360)
			x_y_angle = 0;
	}

	public void moveCameraY(int y_dist) {

		z_angle -= y_dist * 0.08;

		if (z_angle <= -60)
			z_angle = -60;
		else if (z_angle >= 60)
			z_angle = 60;

	}

	public abstract void processKey(char c);

}
