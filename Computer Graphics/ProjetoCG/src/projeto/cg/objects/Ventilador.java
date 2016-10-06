package projeto.cg.objects;

import javax.media.opengl.GL2;

import com.jogamp.opengl.util.gl2.GLUT;

import br.ufal.cg.AutoDrawnableObject;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Ventilador extends AutoDrawnableObject {
    
    private final GLUT glut = new GLUT();
    private float angulo = 0;

    public Ventilador(GL2 gl) {
        super(gl);
        
        new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Ventilador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    angulo++;
                }
            }
            
        }).start();
    }

    @Override
    protected String getTextureExtension() {
        return "jpg";
    }

    @Override
    protected String getTextureImg() {
        return "Ventilador.jpg";
    }

    @Override
    public void selfDraw(GL2 gl) {
        
        gl.glTexParameteri(GL2.GL_TEXTURE_2D, GL2.GL_TEXTURE_WRAP_R, GL2.GL_REPEAT);
        gl.glTexParameteri(GL2.GL_TEXTURE_2D, GL2.GL_TEXTURE_WRAP_S, GL2.GL_REPEAT);
        gl.glTexParameteri(GL2.GL_TEXTURE_2D, GL2.GL_TEXTURE_WRAP_T, GL2.GL_REPEAT);
        
        texture.enable(gl);
        texture.bind(gl);
        
        gl.glColor3f(0.9f, 0.9f, 0.9f);
        
        float[][] verticesL1 = {
            {0f, 0f, 0f},
            {-2f, -0.5f, 0f},
            {-2f, 0.5f, 0f}
        };
        float[][] verticesL2 = {
            {0f, 0f, 0f},
            {0.5f, -2f, 0f},
            {-0.5f, -2f, 0f}
        };
        float[][] verticesL3 = {
            {0f, 0f, 0f},
            {2f, -0.5f, 0f},
            {2f, 0.5f, 0f}
        };
        float[][] verticesL4 = {
            {0f, 0f, 0f},
            {0.5f, 2f, 0f},
            {-0.5f, 2f, 0f}
        };

        gl.glPushMatrix();
            gl.glTranslatef(11f, -18f, 0.2f);
            gl.glScaled(0.3, 0.3, 0.3);
            
            gl.glPushMatrix();
                gl.glTranslatef(0f, 0f, 12.4f);
                glut.glutSolidCylinder(0.25f, 0.1f, 10, 10);
            gl.glPopMatrix();
            
            gl.glPushMatrix();
                gl.glTranslatef(0f, 0f, 10.5f);
                glut.glutSolidCylinder(0.05f, 2f, 10, 10);
            gl.glPopMatrix();
            
            gl.glPushMatrix();
                gl.glTranslatef(0f, 0f, 10.35f);
                glut.glutSolidCylinder(0.35f, 0.2f, 10, 10);
            gl.glPopMatrix();
            
            gl.glPushMatrix();
                gl.glTranslatef(0f, 0f, 10.3f);
                glut.glutSolidCylinder(0.1f, 0.05f, 10, 10);
            gl.glPopMatrix();
            
            gl.glColor3f(1, 1, 1);
            
            gl.glPushMatrix();
                gl.glTranslatef(0f, 0f, 10.325f);
                gl.glRotatef(angulo, 0f, 0f, 1f);
                
                gl.glBegin(GL2.GL_POLYGON);
                for (float[] v : verticesL1) {
//                    gl.glTexCoord2f(v[0]/10f, v[1]/10f);
                    gl.glVertex3f(v[0], v[1], v[2]);
                }
                gl.glEnd();
                gl.glBegin(GL2.GL_POLYGON);
                for (float[] v : verticesL2) {
//                    gl.glTexCoord2f(v[0]/10f, v[1]/10f);
                    gl.glVertex3f(v[0], v[1], v[2]);
                }
                gl.glEnd();
                gl.glBegin(GL2.GL_POLYGON);
                for (float[] v : verticesL3) {
//                    gl.glTexCoord2f(v[0]/10f, v[1]/10f);
                    gl.glVertex3f(v[0], v[1], v[2]);
                }
                gl.glEnd();
                gl.glBegin(GL2.GL_POLYGON);
                for (float[] v : verticesL4) {
//                    gl.glTexCoord2f(v[0]/10f, v[1]/10f);
                    gl.glVertex3f(v[0], v[1], v[2]);
                }
                gl.glEnd();
            gl.glPopMatrix();
        gl.glPopMatrix();
        
    }
    
}
