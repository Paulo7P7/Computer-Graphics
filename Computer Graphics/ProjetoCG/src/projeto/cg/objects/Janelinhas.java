package projeto.cg.objects;

import javax.media.opengl.GL2;

import br.ufal.cg.AutoDrawnableObject;

public class Janelinhas extends AutoDrawnableObject{
	private int startList;

	public Janelinhas(GL2 gl) {
		super(gl);
		desenhaJanela();
	}

	private void desenhaJanela() {
		startList = gl.glGenLists(2);


	gl.glNewList(startList+2, GL2.GL_COMPILE); // JANELAS PEQUENAS
	{
		gl.glBegin(GL2.GL_QUAD_STRIP);
		{
			gl.glTexCoord2f(1, 0);gl.glVertex3f(2.5f, 0, 0); //largura
			gl.glTexCoord2f(1, 1);gl.glVertex3f(2.5f, 0, 0.8f); //largura//  //altura
			gl.glTexCoord2f(0, 0);gl.glVertex3f(0, 0, 0);
			gl.glTexCoord2f(0, 1);gl.glVertex3f(0, 0, 0.8f); //altura
		}
		gl.glEnd();
	}
	gl.glEndList();




}

	@Override
	protected String getTextureExtension() {

		return "jpg";
	}

	@Override
	protected String getTextureImg() {

		return "glassWidowSmall2.jpg";
	}

	@Override
	public void selfDraw(GL2 gl) {
		texture.enable(gl);
		texture.bind(gl);
		
		// JANELAS DA PORTA PRINCIPAL
		gl.glPushMatrix();
		{
			gl.glTranslatef(0.59f, -5.5f, 2.9f); //
			gl.glRotatef(-90, 0f, 0f, 1f);
			gl.glCallList(startList +2);
		}
		gl.glPopMatrix();
		
		gl.glPushMatrix();
		{
			gl.glTranslatef(0.59f, -9.2f, 2.9f); //
			gl.glRotatef(-90, 0f, 0f, 1f);
			gl.glCallList(startList +2);
		}
		gl.glPopMatrix();
		
		gl.glPushMatrix();
		{
			gl.glTranslatef(0.59f, -13.2f, 2.9f); //
			gl.glRotatef(-90, 0f, 0f, 1f);
			gl.glCallList(startList +2);
		}
		gl.glPopMatrix();
		
		gl.glPushMatrix();
		{
			gl.glTranslatef(0.65f, -17.2f, 2.9f); //
			gl.glRotatef(-90, 0f, 0f, 1f);
			gl.glCallList(startList +2);
		}
		gl.glPopMatrix();

		


		
	}
}