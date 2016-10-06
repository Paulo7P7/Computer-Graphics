
package projeto.cg;

import java.util.ArrayList;
import java.util.List;
import javax.media.opengl.DebugGL2;
import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.glu.GLU;

import com.jogamp.opengl.util.gl2.GLUT;

import br.ufal.cg.AutoDrawnableObject;
import br.ufal.cg.MovableCamera;
import projeto.cg.objects.BWall;
import projeto.cg.objects.Bancada;
import projeto.cg.objects.Biro;
import projeto.cg.objects.Cadeiras;
//import projeto.cg.objects.Cube;
import projeto.cg.objects.D2Wall;
import projeto.cg.objects.DWall;
import projeto.cg.objects.F2Wall;
import projeto.cg.objects.FrontWall;
import projeto.cg.objects.Ground;
import projeto.cg.objects.GroundInside1;
import projeto.cg.objects.Janelas;
import projeto.cg.objects.Janelinhas;
//import projeto.cg.objects.Janelas;
import projeto.cg.objects.L1Wall;
import projeto.cg.objects.L3Wall;
import projeto.cg.objects.Lousa;
import projeto.cg.objects.MainDoor;
//import projeto.cg.objects.Monitor;
//import projeto.cg.objects.Lampadas;
import projeto.cg.objects.Roof;
import projeto.cg.objects.Ventilador;

public class ProjetoRenderer extends MovableCamera {

	private float[] ambientLight = { .5f, .5f, .5f, 1f };
	private float[] diffuseLight = { .2f, .2f, .2f, 1f };

	private float[] lightPos = { 10f, -10f, 8f, 1f };

	private MainDoor door;

	private List<AutoDrawnableObject> objects;
	@SuppressWarnings("unused")
	private GLUT glut = new GLUT();

	public ProjetoRenderer() {
	}

	@Override
	public void display(GLAutoDrawable drawable) {

		GL2 gl = drawable.getGL().getGL2();

		gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
		gl.glMatrixMode(GL2.GL_MODELVIEW);
		gl.glLoadIdentity();
		setCameraPos();

		gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_POSITION, lightPos, 0);

		gl.glScalef(1f, 1f, 1.2f);
		for (AutoDrawnableObject obj : objects) {
			gl.glPushMatrix();
			obj.selfDraw(gl);
			gl.glPopMatrix();
		}

		gl.glTranslatef(lightPos[0], lightPos[1], lightPos[2]);
		gl.glColor3f(1f, 1f, 1f);
		//glut.glutSolidSphere(0.2f, 30, 30);

		gl.glFlush();

	}

	@Override
	public void dispose(GLAutoDrawable arg0) {

	}

	@Override
	public void init(GLAutoDrawable drawable) {
		GL2 gl = drawable.getGL().getGL2();

		objects = new ArrayList<AutoDrawnableObject>();
		objects.add(new Ground(gl));
		objects.add(new GroundInside1(gl));

		// Paredes

		objects.add(new L1Wall(gl)); //Quadro
		objects.add(new L3Wall(gl)); //Janelas
		objects.add(new FrontWall(gl)); //parede da porta
		objects.add(new BWall(gl));
		objects.add(new DWall(gl));
		objects.add(new D2Wall(gl));
		objects.add(new F2Wall(gl));
		objects.add(new Roof(gl));
		
		//Objetos

		objects.add(door = new MainDoor(gl));
		objects.add(new Lousa(gl));
		objects.add(new Biro(gl));
		objects.add(new Cadeiras(gl));
		objects.add(new Janelas(gl));
		objects.add(new Janelinhas(gl));
		objects.add(new Bancada(gl));
		objects.add(new Ventilador(gl));
		//objects.add(new Lampadas(gl));
		//objects.add(new Monitor(gl));
		//objects.add(new Cube(gl));
		
		

		System.out.println("init");
		drawable.setGL(new DebugGL2(drawable.getGL().getGL2()));

		System.err.println("INIT GL IS: " + gl.getClass().getName());

		initLight(gl);

		// Enable VSync
		gl.setSwapInterval(1);
		gl.glEnable(GL.GL_DEPTH_TEST);
		// Setup the drawing area and shading mode
		gl.glClearColor(.2f, .2f, .5f, 0);
		gl.glShadeModel(GL2.GL_SMOOTH); // try setting this to GL_FLAT and see
										// what happens.
		//gl.glEnable(GL2.GL_CULL_FACE); //?

	}

	private void initLight(GL2 gl) {
		//
		gl.glEnable(GL2.GL_LIGHTING);
		// gl.glLightModelfv(GL2.GL_LIGHT_MODEL_AMBIENT,ambientLight,0);

		gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_AMBIENT, ambientLight, 0);
		gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_DIFFUSE, diffuseLight, 0);
		//gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_SPECULAR, specularLight, 0);
		gl.glEnable(GL2.GL_LIGHT0);


		gl.glEnable(GL2.GL_COLOR_MATERIAL);

	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
		GL2 gl = drawable.getGL().getGL2();

		GLU glu = new GLU();

		if (height <= 0) { // avoid a divide by zero error!
			height = 1;
		}
		final float h = (float) width / (float) height;
		gl.glViewport(0, 0, width, height);
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();
		glu.gluPerspective(45.0f, h, 1.0, 200.0);
		gl.glMatrixMode(GL2.GL_MODELVIEW);
		gl.glLoadIdentity();

	}

	@Override
	public void processKey(final char c) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				if (c == 'o') {
					door.openDoor();
				}

			}
		}).start();

	}

}
