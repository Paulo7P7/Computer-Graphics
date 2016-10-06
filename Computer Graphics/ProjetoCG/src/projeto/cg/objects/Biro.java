package projeto.cg.objects;

import javax.media.opengl.GL2;

import br.ufal.cg.AutoDrawnableObject;

public class Biro extends AutoDrawnableObject {
	private int startList;

	public Biro(GL2 gl) {
		super(gl);
		desenhaBiro();
	}

	private void desenhaBiro() {
		startList = gl.glGenLists(5);

		gl.glNewList(startList, GL2.GL_COMPILE); // base inferior/superior
		{
			gl.glBegin(GL2.GL_QUAD_STRIP);
			{
				gl.glTexCoord2f(0, 0);
				gl.glVertex3f(0, 0, 0);
				gl.glTexCoord2f(1, 0);
				gl.glVertex3f(9, 0, 0);
				gl.glTexCoord2f(0, 1);
				gl.glVertex3f(0, 5, 0);
				gl.glTexCoord2f(1, 1);
				gl.glVertex3f(9, 5, 0);
			}
			gl.glEnd();
		}
		gl.glEndList();

		gl.glNewList(startList + 1, GL2.GL_COMPILE); // bases laterais
		{
			gl.glBegin(GL2.GL_QUAD_STRIP);
			{
				gl.glTexCoord2f(0, 0);
				gl.glVertex3f(0, 0, 0);
				gl.glTexCoord2f(1, 0);
				gl.glVertex3f(0, 5, 0);
				gl.glTexCoord2f(0, 1);
				gl.glVertex3f(0, 0, 0.5f);
				gl.glTexCoord2f(1, 1);
				gl.glVertex3f(0, 5, 0.5f);
			}
			gl.glEnd();
		}
		gl.glEndList();

		gl.glNewList(startList + 2, GL2.GL_COMPILE); // base frontal/traseiro
		{
			gl.glBegin(GL2.GL_QUAD_STRIP);
			{
				gl.glTexCoord2f(0, 0);
				gl.glVertex3f(0, 0, 0);
				gl.glTexCoord2f(1, 0);
				gl.glVertex3f(9, 0, 0);
				gl.glTexCoord2f(0, 1);
				gl.glVertex3f(0, 0, 0.5f);
				gl.glTexCoord2f(1, 1);
				gl.glVertex3f(9, 0, 0.5f);
			}
			gl.glEnd();
		}
		gl.glEndList();

		gl.glNewList(startList + 3, GL2.GL_COMPILE); // pés
		{
			gl.glBegin(GL2.GL_QUAD_STRIP); // base inferior pé
			{
				gl.glTexCoord2f(0, 0);
				gl.glVertex3f(0, 0, 0);
				gl.glTexCoord2f(1, 0);
				gl.glVertex3f(0.5f, 0, 0);
				gl.glTexCoord2f(0, 1);
				gl.glVertex3f(0, 0.5f, 0);
				gl.glTexCoord2f(1, 1);
				gl.glVertex3f(0.5f, 0.5f, 0f);
			}
			gl.glEnd();

			gl.glBegin(GL2.GL_QUAD_STRIP); // base superior pé
			{
				gl.glTexCoord2f(0, 0);
				gl.glVertex3f(0, 0, 3);
				gl.glTexCoord2f(1, 0);
				gl.glVertex3f(0.5f, 0, 3);
				gl.glTexCoord2f(0, 1);
				gl.glVertex3f(0, 0.5f, 3);
				gl.glTexCoord2f(1, 1);
				gl.glVertex3f(0.5f, 0.5f, 3);
			}
			gl.glEnd();

			gl.glBegin(GL2.GL_QUAD_STRIP); // base esquerda pé
			{
				gl.glTexCoord2f(0, 0);
				gl.glVertex3f(0, 0, 0);
				gl.glTexCoord2f(1, 0);
				gl.glVertex3f(0, 0.5f, 0);
				gl.glTexCoord2f(0, 1);
				gl.glVertex3f(0, 0, 3);
				gl.glTexCoord2f(1, 1);
				gl.glVertex3f(0, 0.5f, 3);
			}
			gl.glEnd();

			gl.glBegin(GL2.GL_QUAD_STRIP); // base direita pé
			{
				gl.glTexCoord2f(0, 0);
				gl.glVertex3f(0.5f, 0, 0);
				gl.glTexCoord2f(1, 0);
				gl.glVertex3f(0.5f, 0.5f, 0);
				gl.glTexCoord2f(0, 1);
				gl.glVertex3f(0.5f, 0, 3);
				gl.glTexCoord2f(1, 1);
				gl.glVertex3f(0.5f, 0.5f, 3);
			}
			gl.glEnd();

			gl.glBegin(GL2.GL_QUAD_STRIP); // base frontal pé
			{
				gl.glTexCoord2f(0, 0);
				gl.glVertex3f(0, 0, 0);
				gl.glTexCoord2f(1, 0);
				gl.glVertex3f(0.5f, 0, 0);
				gl.glTexCoord2f(0, 1);
				gl.glVertex3f(0, 0, 3);
				gl.glTexCoord2f(1, 1);
				gl.glVertex3f(0.5f, 0, 3);
			}
			gl.glEnd();

			gl.glBegin(GL2.GL_QUAD_STRIP); // base traseira pé
			{
				gl.glTexCoord2f(0, 0);
				gl.glVertex3f(0, 0.5f, 0);
				gl.glTexCoord2f(1, 0);
				gl.glVertex3f(0.5f, 0.5f, 0);
				gl.glTexCoord2f(0, 1);
				gl.glVertex3f(0, 0.5f, 3);
				gl.glTexCoord2f(1, 1);
				gl.glVertex3f(0.5f, 0.5f, 3);
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

		return "madeira.jpg";
	}

	@Override
	public void selfDraw(GL2 gl) {
		texture.enable(gl);
		texture.bind(gl);
		gl.glPushMatrix();
		
		gl.glScaled(0.4f, 0.4f, 0.4f);
		{

			gl.glPushMatrix();

			{

				gl.glTranslatef(40f, -8f, 3.1f); // MInferior
				gl.glCallList(startList);
			}
			gl.glPopMatrix();

			gl.glPushMatrix();
			{
				gl.glTranslatef(40f, -8f, 3.6f); // MSuperior
				gl.glCallList(startList);
			}
			gl.glPopMatrix();

			gl.glPushMatrix();
			{
				gl.glTranslatef(45f, -8f, 3.1f); // MLateral555
				gl.glCallList(startList + 1);
			}
			gl.glPopMatrix();

			gl.glPushMatrix();
			{
				gl.glTranslatef(40f, -8f, 3.1f); // MM22
				gl.glCallList(startList + 1);
			}
			gl.glPopMatrix();

			gl.glPushMatrix();
			{
				gl.glTranslatef(40f, -8f, 3.1f); // MTraz

				gl.glCallList(startList + 2);
			}
			gl.glPopMatrix();

			gl.glPushMatrix();
			{
				gl.glTranslatef(40f, -8f, 3.1f); // MFrente

				gl.glCallList(startList + 2);
			}
			gl.glPopMatrix();

			gl.glPushMatrix(); // pé esquerdo inferior
			{
				gl.glTranslatef(41f, -8f, 0.1f);
				gl.glCallList(startList + 3);
			}
			gl.glPopMatrix();

			gl.glPushMatrix(); // pé esquerdo superior
			{
				gl.glTranslatef(41f, -4f, 0.1f);
				gl.glCallList(startList + 3);
			}
			gl.glPopMatrix();

			gl.glPushMatrix(); // pé direito inferior
			{
				gl.glTranslatef(48f, -8, 0.1f);
				gl.glCallList(startList + 3);
			}
			gl.glPopMatrix();

			gl.glPushMatrix(); // pé direito superior
			{
				gl.glTranslatef(48f, -4f, 0.1f);
				gl.glCallList(startList + 3);
			}
			gl.glPopMatrix();

		}
		
		

		gl.glPopMatrix();

	}
}
