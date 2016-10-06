package br.ufal.cg;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class UserKeyBoardListener implements KeyListener {

	private MovableCamera renderer;
	final private List<Character> pressedChars;

	private boolean run = true;

	public UserKeyBoardListener(MovableCamera renderer) {
		this.renderer = renderer;
		pressedChars = new ArrayList<>();

		Thread listener = new Thread(new Runnable() {

			@Override
			public void run() {
				while (run) {
					try {
						Thread.sleep(30);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						// e.printStackTrace();
					}
					if (pressedChars.size() > 0)
						processPressedKeys();
				}
			}
		});
		listener.start();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (!pressedChars.contains(e.getKeyChar()))
			pressedChars.add(e.getKeyChar());

	}

	private void processPressedKeys() {
		if (pressedChars.contains('w') && pressedChars.contains('d'))
			renderer.walkFoward(45, 45, 0);
		else if (pressedChars.contains('w') && pressedChars.contains('a'))
			renderer.walkFoward(-45, -45, 0);
		else if (pressedChars.contains('s') && pressedChars.contains('d'))
			renderer.walkBackard(-45, -45, 0);
		else if (pressedChars.contains('s') && pressedChars.contains('a'))
			renderer.walkBackard(+45, +45, 0);
		else if (pressedChars.contains('w'))
			renderer.walkForward();
		else if (pressedChars.contains('s'))
			renderer.walkBackward();
		else if (pressedChars.contains('d'))
			renderer.walkRight();
		else if (pressedChars.contains('a'))
			renderer.walkLeft();
		else if (pressedChars.contains('o'))
			renderer.processKey('o');
		// for (Character pressKey : pressedChars) {
		// if (pressKey == 'w')
		// renderer.walkForward();
		// if (pressKey == 's')
		// renderer.walkBackward();
		// if (pressKey == 'd')
		// renderer.walkRight();
		// if (pressKey == 'a')
		// renderer.walkLeft();
		// }
	}

	@Override
	public void keyReleased(KeyEvent e) {
		pressedChars.remove(new Character(e.getKeyChar()));
		// processPressedKeys();
	}

	@Override
	protected void finalize() throws Throwable {
		run = false;
		super.finalize();
	}

}
