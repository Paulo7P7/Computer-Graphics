package projeto.cg.objects;

import javax.media.opengl.GL2;

import br.ufal.cg.AutoDrawnableObject;

public class Cadeiras extends AutoDrawnableObject {
	private int startList;

	public Cadeiras(GL2 gl) {
		super(gl);
		desenhaCadeira();
	}

	private void desenhaCadeira() {
		startList = gl.glGenLists(5);

		gl.glNewList(startList, GL2.GL_COMPILE);
		{ // pes e bracos
			gl.glBegin(GL2.GL_QUAD_STRIP);
			{
				gl.glColor3f(0, 0, 0); // as cadeiras sao pretas
				gl.glVertex3f(0, 0, 0);
				gl.glVertex3f(0.02f, 0, 0);
				gl.glVertex3f(0, 0.1f, 0.5f);
				gl.glVertex3f(0.02f, 0.1f, 0.5f);
				gl.glVertex3f(0, 0.3f, 0.5f);
				gl.glVertex3f(0.02f, 0.3f, 0.5f);
				gl.glVertex3f(0, 0.4f, 0);
				gl.glVertex3f(0.02f, 0.4f, 0);
				gl.glVertex3f(0, 0.38f, 0);
				gl.glVertex3f(0.02f, 0.38f, 0);
				gl.glVertex3f(0, 0.3f, 0.48f);
				gl.glVertex3f(0.02f, 0.3f, 0.48f);
				gl.glVertex3f(0, 0.1f, 0.48f);
				gl.glVertex3f(0.02f, 0.1f, 0.48f);
				gl.glVertex3f(0, 0.02f, 0);
				gl.glVertex3f(0.02f, 0.02f, 0);
				gl.glVertex3f(0, 0, 0);
				gl.glVertex3f(0.02f, 0, 0);

			}
			gl.glEnd();

			gl.glBegin(GL2.GL_QUAD_STRIP);
			{
				gl.glVertex3f(0.02f, 0, 0);
				gl.glVertex3f(0.02f, 0.02f, 0);
				gl.glVertex3f(0.02f, 0.1f, 0.5f);
				gl.glVertex3f(0.02f, 0.1f, 0.48f);
				gl.glVertex3f(0.02f, 0.3f, 0.5f);
				gl.glVertex3f(0.02f, 0.3f, 0.48f);
				gl.glVertex3f(0.02f, 0.4f, 0);
				gl.glVertex3f(0.02f, 0.38f, 0);
				gl.glVertex3f(0, 0.38f, 0);
				gl.glVertex3f(0, 0.4f, 0);
				gl.glVertex3f(0, 0.3f, 0.48f);
				gl.glVertex3f(0, 0.3f, 0.5f);
				gl.glVertex3f(0, 0.1f, 0.48f);
				gl.glVertex3f(0, 0.1f, 0.5f);
				gl.glVertex3f(0, 0.02f, 0);
			}
			gl.glEnd();

		}
		gl.glEndList();

		gl.glNewList(startList + 1, GL2.GL_COMPILE);
		{// acento e encosto
			gl.glBegin(GL2.GL_POLYGON);
			{
				gl.glVertex3f(0.02f, 0.06f, 0.36f);
				gl.glVertex3f(0.02f, 0.36f, 0.36f);
				gl.glVertex3f(0.38f, 0.36f, 0.36f);
				gl.glVertex3f(0.38f, 0.06f, 0.36f);
			}
			gl.glEnd();

			gl.glBegin(GL2.GL_POLYGON);
			{
				gl.glVertex3f(0.02f, 0.06f, 0.34f);
				gl.glVertex3f(0.02f, 0.36f, 0.34f);
				gl.glVertex3f(0.38f, 0.36f, 0.34f);
				gl.glVertex3f(0.38f, 0.06f, 0.34f);
			}
			gl.glEnd();

			gl.glBegin(GL2.GL_QUAD_STRIP);
			{
				gl.glVertex3f(0.02f, 0.06f, 0.36f);
				gl.glVertex3f(0.02f, 0.06f, 0.34f);
				gl.glVertex3f(0.02f, 0.36f, 0.36f);
				gl.glVertex3f(0.02f, 0.36f, 0.34f);
				gl.glVertex3f(0.38f, 0.36f, 0.36f);
				gl.glVertex3f(0.38f, 0.36f, 0.34f);
				gl.glVertex3f(0.38f, 0.06f, 0.36f);
				gl.glVertex3f(0.38f, 0.06f, 0.34f);
			}
			gl.glEnd();

			gl.glBegin(GL2.GL_POLYGON);
			{// encosto
				gl.glVertex3f(0.02f, 0.36f, 0.46f);
				gl.glVertex3f(0.02f, 0.36f, 0.66f);
				gl.glVertex3f(0.38f, 0.36f, 0.66f);
				gl.glVertex3f(0.38f, 0.36f, 0.46f);
			}
			gl.glEnd();
		}
		gl.glEndList();

		gl.glNewList(startList + 2, GL2.GL_COMPILE);// barras encosto
		{
			gl.glBegin(GL2.GL_QUAD_STRIP);
			{
				gl.glVertex3f(0.02f, 0.38f, 0.34f);
				gl.glVertex3f(0.02f, 0.36f, 0.34f);
				gl.glVertex3f(0.12f, 0.38f, 0.56f);
				gl.glVertex3f(0.12f, 0.36f, 0.56f);
				gl.glVertex3f(0.26f, 0.38f, 0.56f);
				gl.glVertex3f(0.26f, 0.36f, 0.56f);
				gl.glVertex3f(0.38f, 0.38f, 0.34f);
				gl.glVertex3f(0.38f, 0.36f, 0.34f);
				gl.glVertex3f(0.36f, 0.38f, 0.34f);
				gl.glVertex3f(0.36f, 0.36f, 0.34f);
				gl.glVertex3f(0.26f, 0.38f, 0.54f);
				gl.glVertex3f(0.26f, 0.36f, 0.54f);
				gl.glVertex3f(0.12f, 0.38f, 0.54f);
				gl.glVertex3f(0.12f, 0.36f, 0.54f);
				gl.glVertex3f(0.04f, 0.38f, 0.34f);
				gl.glVertex3f(0.04f, 0.36f, 0.34f);

			}
			gl.glEnd();
			gl.glBegin(GL2.GL_QUAD_STRIP);
			{
				gl.glVertex3f(0.02f, 0.38f, 0.34f);
				gl.glVertex3f(0.04f, 0.38f, 0.34f);
				gl.glVertex3f(0.12f, 0.38f, 0.56f);
				gl.glVertex3f(0.12f, 0.38f, 0.54f);
				gl.glVertex3f(0.26f, 0.38f, 0.56f);
				gl.glVertex3f(0.26f, 0.38f, 0.54f);
				gl.glVertex3f(0.38f, 0.38f, 0.34f);
				gl.glVertex3f(0.36f, 0.38f, 0.34f);
			}
			gl.glEnd();
		}
		gl.glEndList();

		gl.glNewList(startList + 3, GL2.GL_COMPILE);
		{
			gl.glBegin(GL2.GL_QUAD_STRIP);
			{
				gl.glTexCoord2f(0, 1);
				gl.glVertex3f(0, 0, 1);
				gl.glTexCoord2f(0, 0);
				gl.glVertex3f(0, 0, 0);

				gl.glVertex3f(2, 0, 1);
				gl.glVertex3f(2, 0, 0);

				gl.glVertex3f(2, 0.7f, 1);
				gl.glVertex3f(2, 0.7f, 0);

				gl.glTexCoord2f(1, 0);
				gl.glVertex3f(0, 0.7f, 1);
				gl.glTexCoord2f(1, 1);
				gl.glVertex3f(0, 0.7f, 0);

				gl.glVertex3f(0, 0, 1);
				gl.glVertex3f(0, 0, 0);
			}
			gl.glEnd();

			gl.glBegin(GL2.GL_POLYGON);
			{
				gl.glTexCoord2f(0, 0);
				gl.glVertex3f(0, 0, 1);
				gl.glTexCoord2f(1, 0);
				gl.glVertex3f(2, 0, 1);
				gl.glTexCoord2f(0, 1);
				gl.glVertex3f(2, 0.7f, 1);
				gl.glTexCoord2f(1, 1);
				gl.glVertex3f(0, 0.7f, 1);
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

		{
			gl.glTranslatef(19f, -8f, 0);
			gl.glRotatef(180, 0f, 0f, 1f);
			for (int k = 0; k < 1; ++k) {
				gl.glPushMatrix();
				{
					gl.glPushMatrix();
					{
						for (int i = 0; i < 2; ++i) {

							gl.glPushMatrix();
							{

								gl.glScaled(2f, 2f, 2f);
								gl.glCallList(startList);// pes direito
								gl.glCallList(startList + 1);// acento e
																// encosto
								gl.glCallList(startList + 2);// barras
																// encosto
								gl.glTranslatef(0.38f, 0, 0);
								gl.glCallList(startList);// pes esquerdo
							}

							gl.glPopMatrix();
							gl.glTranslatef(5f, 0, 0);
						}
					}
					gl.glPopMatrix();
					gl.glTranslatef(0, -1, 0);
				}
				gl.glPopMatrix();
				gl.glTranslatef(4.5f, 0, 0);
			}
		}
		gl.glPopMatrix();
		
		
		gl.glPushMatrix();

		{
			gl.glTranslatef(19f, -12f, 0);
			gl.glRotatef(180, 0f, 0f, 1f);
			for (int k = 0; k < 1; ++k) {
				gl.glPushMatrix();
				{
					gl.glPushMatrix();
					{
						for (int i = 0; i < 2; ++i) {

							gl.glPushMatrix();
							{

								gl.glScaled(2f, 2f, 2f);
								gl.glCallList(startList);// pes direito
								gl.glCallList(startList + 1);// acento e
																// encosto
								gl.glCallList(startList + 2);// barras
																// encosto
								gl.glTranslatef(0.38f, 0, 0);
								gl.glCallList(startList);// pes esquerdo
							}

							gl.glPopMatrix();
							gl.glTranslatef(5f, 0, 0);
						}
					}
					gl.glPopMatrix();
					gl.glTranslatef(0, -1, 0);
				}
				gl.glPopMatrix();
				gl.glTranslatef(4.5f, 0, 0);
			}
		}
		gl.glPopMatrix();
		
		gl.glPushMatrix();

		{
			gl.glTranslatef(19f, -16f, 0);
			gl.glRotatef(180, 0f, 0f, 1f);
			for (int k = 0; k < 1; ++k) {
				gl.glPushMatrix();
				{
					gl.glPushMatrix();
					{
						for (int i = 0; i < 2; ++i) {

							gl.glPushMatrix();
							{

								gl.glScaled(2f, 2f, 2f);
								gl.glCallList(startList);// pes direito
								gl.glCallList(startList + 1);// acento e
																// encosto
								gl.glCallList(startList + 2);// barras
																// encosto
								gl.glTranslatef(0.38f, 0, 0);
								gl.glCallList(startList);// pes esquerdo
							}

							gl.glPopMatrix();
							gl.glTranslatef(5f, 0, 0);
						}
					}
					gl.glPopMatrix();
					gl.glTranslatef(0, -1, 0);
				}
				gl.glPopMatrix();
				gl.glTranslatef(4.5f, 0, 0);
			}
		}
		gl.glPopMatrix();
		
		
		///outrolado
		
		gl.glPushMatrix();

		{
			gl.glTranslatef(8f, -8f, 0);
			gl.glRotatef(180, 0f, 0f, 1f);
			for (int k = 0; k < 1; ++k) {
				gl.glPushMatrix();
				{
					gl.glPushMatrix();
					{
						for (int i = 0; i < 2; ++i) {

							gl.glPushMatrix();
							{

								gl.glScaled(2f, 2f, 2f);
								gl.glCallList(startList);// pes direito
								gl.glCallList(startList + 1);// acento e
																// encosto
								gl.glCallList(startList + 2);// barras
																// encosto
								gl.glTranslatef(0.38f, 0, 0);
								gl.glCallList(startList);// pes esquerdo
							}

							gl.glPopMatrix();
							gl.glTranslatef(5f, 0, 0);
						}
					}
					gl.glPopMatrix();
					gl.glTranslatef(0, -1, 0);
				}
				gl.glPopMatrix();
				gl.glTranslatef(4.5f, 0, 0);
			}
		}
		gl.glPopMatrix();
		
		
		gl.glPushMatrix();

		{
			gl.glTranslatef(8f, -12f, 0);
			gl.glRotatef(180, 0f, 0f, 1f);
			for (int k = 0; k < 1; ++k) {
				gl.glPushMatrix();
				{
					gl.glPushMatrix();
					{
						for (int i = 0; i < 2; ++i) {

							gl.glPushMatrix();
							{

								gl.glScaled(2f, 2f, 2f);
								gl.glCallList(startList);// pes direito
								gl.glCallList(startList + 1);// acento e
																// encosto
								gl.glCallList(startList + 2);// barras
																// encosto
								gl.glTranslatef(0.38f, 0, 0);
								gl.glCallList(startList);// pes esquerdo
							}

							gl.glPopMatrix();
							gl.glTranslatef(5f, 0, 0);
						}
					}
					gl.glPopMatrix();
					gl.glTranslatef(0, -1, 0);
				}
				gl.glPopMatrix();
				gl.glTranslatef(4.5f, 0, 0);
			}
		}
		gl.glPopMatrix();
		
		gl.glPushMatrix();

		{
			gl.glTranslatef(8f, -16f, 0);
			gl.glRotatef(180, 0f, 0f, 1f);
			for (int k = 0; k < 1; ++k) {
				gl.glPushMatrix();
				{
					gl.glPushMatrix();
					{
						for (int i = 0; i < 2; ++i) {

							gl.glPushMatrix();
							{

								gl.glScaled(2f, 2f, 2f);
								gl.glCallList(startList);// pes direito
								gl.glCallList(startList + 1);// acento e
																// encosto
								gl.glCallList(startList + 2);// barras
																// encosto
								gl.glTranslatef(0.38f, 0, 0);
								gl.glCallList(startList);// pes esquerdo
							}

							gl.glPopMatrix();
							gl.glTranslatef(5f, 0, 0);
						}
					}
					gl.glPopMatrix();
					gl.glTranslatef(0, -1, 0);
				}
				gl.glPopMatrix();
				gl.glTranslatef(4.5f, 0, 0);
			}
		}
		gl.glPopMatrix();

		gl.glColor3f(1, 1, 1);

	}
}