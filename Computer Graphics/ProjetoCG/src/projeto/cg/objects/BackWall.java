package projeto.cg.objects;

import javax.media.opengl.GL2;

import com.jogamp.opengl.util.gl2.GLUT;

import br.ufal.cg.AutoDrawnableObject;

public class BackWall extends AutoDrawnableObject {

	private int startList;
	private GLUT glut = new GLUT();
	private float[] color = new float[] { 1, 0.6f, 1 };

	public BackWall(GL2 gl) {
		super(gl);
		initData();
	}

	private void initData() {
		startList = gl.glGenLists(1);
		
		gl.glNewList(startList, GL2.GL_COMPILE);
		
		gl.glColor3fv(color, 0);
		glut.glutSolidCube(1f);
		
		gl.glEndList();

	}

	@Override
	public void selfDraw(GL2 gl) {

		gl.glPushMatrix();
		gl.glTranslatef(19.2f, -24, 1.7f);
		gl.glScalef(12f, 0.5f, 3.2f);
		gl.glCallList(startList);
		gl.glPopMatrix();
		
		//Parede do lado
		gl.glPushMatrix();
		gl.glColor3f(0f, 1f, 0f);
		gl.glTranslatef(25f, -28.5f, 1.7f);
		gl.glScalef(0.5f, 9f, 3.2f);
//		gl.glRotatef(90, 0f, 0f, 1f);
		gl.glCallList(startList);
		gl.glPopMatrix();
		
		//Parede fundo
		gl.glPushMatrix();
		gl.glTranslatef(19.2f, -33, 1.7f);
		gl.glScalef(12f, 0.5f, 3.2f);
		gl.glCallList(startList);
		gl.glPopMatrix();
		
		//Teto
		gl.glPushMatrix();
		gl.glTranslatef(19.2f, -28.5f, 3.2f);
		gl.glScalef(12f, 9f, 0.5f);
		gl.glCallList(startList);
		gl.glPopMatrix();
		
		gl.glPushMatrix();
		gl.glColor3f(0f, 1f, 0f);
		gl.glTranslatef(-8f, -28.5f, 1.7f);
		gl.glScalef(0.5f, 9f, 3.2f);
//		gl.glRotatef(90, 0f, 0f, 1f);
		gl.glCallList(startList);
		gl.glPopMatrix();
		
		gl.glPushMatrix();
		gl.glTranslatef(-2.2f, -33, 1.7f);
		gl.glScalef(12f, 0.5f, 3.2f);
		gl.glCallList(startList);
		gl.glPopMatrix();
		
		gl.glPushMatrix();
		gl.glTranslatef(-2.2f, -28.5f, 3.2f);
		gl.glScalef(12f, 9f, 0.5f);
		gl.glCallList(startList);
		gl.glPopMatrix();
		
		gl.glPushMatrix();
		gl.glTranslatef(-4.2f, -24, 1.7f);
		gl.glScalef(8f, 0.5f, 3.2f);
		gl.glCallList(startList);
		gl.glPopMatrix();

		
		

	}

}
