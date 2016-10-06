package projeto.cg;

import java.awt.Dimension;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.swing.JFrame;
import com.jogamp.opengl.util.Animator;
import br.ufal.cg.UserKeyBoardListener;
import br.ufal.cg.UserMouseEventListener;


/*
 * Projeto criado com CG Framework: 
 * https://github.com/Andreymcz/CGFramework
 * 
 */

public class Main extends JFrame {


	private static final long serialVersionUID = 1L;

	public static void main(String args[]) {

		GLCanvas canvas;
		
		GLProfile profile = GLProfile.get(GLProfile.GL2);
		GLCapabilities capabilites = new GLCapabilities(profile);
		capabilites.setDoubleBuffered(true);
		System.out.println(capabilites.getHardwareAccelerated());
		
		canvas = new GLCanvas(capabilites);
		Animator animator = new Animator(canvas);

		JFrame frame = new JFrame( "Modelagem" );
        frame.getContentPane().add( canvas);
		
		ProjetoRenderer r;
		canvas.addGLEventListener(r = new ProjetoRenderer());
		UserKeyBoardListener listener = new UserKeyBoardListener(r);
		UserMouseEventListener mouseListener = new UserMouseEventListener(r);

		canvas.addKeyListener(listener);
		canvas.addMouseListener(mouseListener);
		canvas.addMouseMotionListener(mouseListener);
		canvas.addMouseWheelListener(mouseListener);
		
		frame.getContentPane().add(canvas);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setSize(new Dimension(500, 400));
		frame.setVisible(true);

		canvas.requestFocus();
		animator.start();

	}



}
