package br.ufal.cg;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class UserMouseEventListener extends MouseAdapter {

	private MovableCamera renderer;
	private Point lastPos;

	public UserMouseEventListener(MovableCamera renderer) {
		this.renderer = renderer;
	}

	public void mousePressed(MouseEvent e) {
		lastPos = e.getPoint().getLocation();
	}

	@Override
	public synchronized void mouseDragged(MouseEvent e) {
		if (lastPos == null) {
			lastPos = e.getPoint().getLocation();
			return;
		}
		Point currentPoint = e.getPoint();

		int x_dist = currentPoint.x - lastPos.x;
		int y_dist = currentPoint.y - lastPos.y;
		renderer.moveCameraX_Y(x_dist);
		// mouse invertido
		renderer.moveCameraY(y_dist);

		lastPos = currentPoint.getLocation();
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		if (e.getWheelRotation() < 0)
			renderer.walkForward();
		else
			renderer.walkBackward();
	}
}
