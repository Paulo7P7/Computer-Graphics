package projeto.cg.objects;

import javax.media.opengl.GL2;

import br.ufal.cg.AutoDrawnableObject;

public class Janelas extends AutoDrawnableObject {
		private int startList;

		public Janelas(GL2 gl) {
			super(gl);
			desenhaJanela();
		}

		private void desenhaJanela() {
			startList = gl.glGenLists(2);


		gl.glNewList(startList+2, GL2.GL_COMPILE); // JANELAS PEQUENAS
		{
			gl.glBegin(GL2.GL_QUAD_STRIP);
			{
				gl.glTexCoord2f(1, 0);gl.glVertex3f(5, 0, 0); //largura
				gl.glTexCoord2f(1, 1);gl.glVertex3f(5, 0, 2); //largura//  //altura
				gl.glTexCoord2f(0, 0);gl.glVertex3f(0, 0, 0);
				gl.glTexCoord2f(0, 1);gl.glVertex3f(0, 0, 2); //altura
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

			return "glassWidowSmall.jpg";
		}

		@Override
		public void selfDraw(GL2 gl) {
			texture.enable(gl);
			texture.bind(gl);
			
			// JANELAS DA PORTA PRINCIPAL
			gl.glPushMatrix();
			{
				gl.glTranslatef(19.95f, -1.99f, 1.5f); //
				gl.glRotatef(-90, 0f, 0f, 1f);
				gl.glCallList(startList +2);
			}
			gl.glPopMatrix();
			
			gl.glPushMatrix();
			{
				gl.glTranslatef(19.95f, -7.99f, 1.5f); //
				gl.glRotatef(-90, 0f, 0f, 1f);
				gl.glCallList(startList +2);
			}
			gl.glPopMatrix();
			
			gl.glPushMatrix();
			{
				gl.glTranslatef(19.95f, -13.8f, 1.5f); //
				gl.glRotatef(-90, 0f, 0f, 1f);
				gl.glCallList(startList +2);
			}
			gl.glPopMatrix();

			


			
		}
	}