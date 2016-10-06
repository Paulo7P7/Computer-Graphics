package projeto.cg.objects;

import javax.media.opengl.GL2;

import br.ufal.cg.AutoDrawnableObject;

public class Ground extends AutoDrawnableObject {

	private int displayIndex = 1;

	public Ground(GL2 gl) {
		super(gl);
		
		compileGround(gl);
	}

	private void compileGround(GL2 gl) {
		gl.glNewList(displayIndex, GL2.GL_COMPILE);
		
		texture.enable(gl);
		texture.bind(gl);
		
		
		gl.glBegin(GL2.GL_QUADS);		
//		gl.glColor3f(0.3f, 0.7f, 0.3f);
		
		gl.glNormal3f(0f, 0f, 1f);
		
		gl.glTexCoord2f(0f, 0f);
		gl.glVertex3f(-10, 10, 0);
		
		gl.glTexCoord2f(0f, 1f);
		gl.glVertex3f(-10, -50, 0);
		
		gl.glTexCoord2f(1f, 0f);
		gl.glVertex3f(40, -50, 0);
		
		gl.glTexCoord2f(1f, 1f);
		gl.glVertex3f(40, 10, 0);
		
		gl.glEnd();
		
		gl.glEndList();
	}

	@Override
	public void selfDraw(GL2 gl) {
//		gl.glRotated(45, 1f, 1f, 0);
		gl.glCallList(displayIndex);
//		texture.disable(gl);
	}

}
