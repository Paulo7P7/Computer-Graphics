package projeto.cg.objects;

import javax.media.opengl.GL2;

import br.ufal.cg.AutoDrawnableObject;


public class Monitor extends AutoDrawnableObject {

	private int startList;

	public Monitor(GL2 gl) {
		super(gl);
		desenhaPorta();
	}

	private void desenhaPorta() {
		startList = gl.glGenLists(5);

		gl.glNewList(startList, GL2.GL_COMPILE);
		{

			gl.glBegin(GL2.GL_POLYGON); // TV
			{
				gl.glTexCoord2f(0f, 0f);gl.glVertex3f(0, 0, 0);
				gl.glTexCoord2f(0f, 1f);gl.glVertex3f(0, 0, 0.6f);
				gl.glTexCoord2f(1f, 1f);gl.glVertex3f(0, 1.25f,0.6f);
				gl.glTexCoord2f(1f, 0f);gl.glVertex3f(0, 1.25f, 0);
			}
			gl.glEnd();
		}
		gl.glEndList();

	}

	@Override
	protected String getTextureExtension() {
		return "png";
	}

	@Override
	protected String getTextureImg() {
		return "tv.png";
	}

	@Override
	public void selfDraw(GL2 gl) {
		texture.enable(gl);
		texture.bind(gl);
				
		gl.glPushMatrix();
		{
			gl.glTranslatef(6, -6, 2f);
			gl.glRotatef(90, 0f, 0f, 1f);
			gl.glCallList(startList);
		}
		gl.glPopMatrix();
	}
}
