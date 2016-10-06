package projeto.cg.objects;

import javax.media.opengl.GL2;

import br.ufal.cg.AutoDrawnableObject;

public class Bancada extends AutoDrawnableObject {

	 // private int displayIndex = 3;

	    public Bancada(GL2 gl) {
	        super(gl);
	    }

	    private void desenhaBanco(GL2 gl) {

	        float[][] verticesPe = {
	            {0f, 0f, 0f},
	            {0f, 0f, 2f},
	            {0f, -2.5f, 2f},
	            {0f, -2.5f, 0f}
	        };
	        float[][] verticesSustento = {
	            {0f, 0f, 0f},
	            {0f, 0f, 2.5f},
	            {0f, -2.5f, 2.5f},
	            {0f, -2.75f, 0f}
	        };
	        float[][] verticesCostas = {
	                {-8f, 0f, 0f},
	                {-8f, 0f, 2f},
	                {0f, 0f, 2f},
	                {0f, 0f, 0f}
	            };
	    
	        float[][] verticesAssento = {
	            {-8f, 0f, 2f},
	            {-8f, -2.5f, 2f},
	            {0f, -2.5f, 2f},
	            {0f, 0f, 2f}
	        };

	        gl.glBegin(GL2.GL_POLYGON);
	        for (float[] v : verticesPe) {
	            gl.glTexCoord3f(v[0], v[1], v[2]);
	            gl.glVertex3f(v[0], v[1], v[2]);
	        }
	        gl.glEnd();
	        gl.glBegin(GL2.GL_POLYGON);
	        for (float[] v : verticesPe) {
	            gl.glTexCoord3f(v[0], v[1], v[2]);
	            gl.glVertex3f(v[0]-4, v[1], v[2]);
	        }

	        gl.glEnd();
	        
	        gl.glBegin(GL2.GL_POLYGON);
	        for (float[] v : verticesPe) {
	            gl.glTexCoord3f(v[0], v[1], v[2]);
	            gl.glVertex3f(v[0]-8, v[1], v[2]);
	        }

	        gl.glEnd();
	        
	        
	        
	        gl.glBegin(GL2.GL_POLYGON);
	        for (float[] v : verticesSustento) {
	            gl.glTexCoord3f(v[0], v[1], v[2]);
	            gl.glVertex3f(v[0], v[1], v[2]);
	        }
	        gl.glEnd();
	        gl.glBegin(GL2.GL_POLYGON);
	        for (float[] v : verticesSustento) {
	            gl.glTexCoord3f(v[0], v[1], v[2]);
	            gl.glVertex3f(v[0]-4, v[1], v[2]);
	        }
	        gl.glEnd();
	        
	        gl.glBegin(GL2.GL_POLYGON);
	        for (float[] v : verticesSustento) {
	            gl.glTexCoord3f(v[0], v[1], v[2]);
	            gl.glVertex3f(v[0]-8, v[1], v[2]);
	        }
	        gl.glEnd();
	        
	        
	        
	        
	        
	        gl.glBegin(GL2.GL_POLYGON);
	        for (float[] v : verticesCostas) {
	            gl.glTexCoord3f(v[0], v[1], v[2]);
	            gl.glVertex3f(v[0], v[1], v[2]);
	        }
	        gl.glEnd();
	    
	        gl.glBegin(GL2.GL_POLYGON);
	        for (float[] v : verticesAssento) {
	            gl.glTexCoord3f(v[0], v[1], v[2]);
	            gl.glVertex3f(v[0], v[1], v[2]);
	        }
	        gl.glEnd();

	    }

	    @Override
	    protected String getTextureExtension() {
	        return "jpg";
	    }

	    @Override
	    protected String getTextureImg() {
	        return "Banco.jpg";
	    }

	    @Override
	    public void selfDraw(GL2 gl) {
	        
	        gl.glTexParameteri(GL2.GL_TEXTURE_2D, GL2.GL_TEXTURE_WRAP_R, GL2.GL_REPEAT);
	        gl.glTexParameteri(GL2.GL_TEXTURE_2D, GL2.GL_TEXTURE_WRAP_S, GL2.GL_REPEAT);
	        gl.glTexParameteri(GL2.GL_TEXTURE_2D, GL2.GL_TEXTURE_WRAP_T, GL2.GL_REPEAT);
	        
	        texture.enable(gl);
	        texture.bind(gl);
	      
	        
	        gl.glPushMatrix();
	            gl.glTranslatef(8f, -17.5f, 0f);
	            
	            for (int i=0; i<4; i++) {
	                desenhaBanco(gl);
	                gl.glTranslatef(0f, 4f, 0f);
	                
	            }
	        gl.glPopMatrix();
	        
	        gl.glPushMatrix();
	            gl.glTranslatef(19.85f, -17.5f, 0f);
	       
	            for (int i=0; i<4; i++) {
	                desenhaBanco(gl);
	                gl.glTranslatef(0f, 4f, 0f);
	            }
	        gl.glPopMatrix();
	        
	     
	        
	       
	        
	    }
}
