package projeto.cg.objects;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUtessellator;
import javax.media.opengl.glu.GLUtessellatorCallback;

import br.ufal.cg.AutoDrawnableObject;
import br.ufal.cg.GeometryUtils;

public class D2Wall extends AutoDrawnableObject {

	private int startList;
	private float[] color = new float[] { 1, 1, 1 };
	private GLU glu;

	private double wall_Height = 4;
	private double wall_Width = 3.5;

	public D2Wall(GL2 gl) {
		super(gl);
		initData();
	}

	private void initData() {
		glu = new GLU();
		/*
		 * jogl specific addition for tessellation
		 */
		TessellCallBack tessCallback = new TessellCallBack(gl, glu);

		double rect[][] = new double[][] { // [4][3] in C; reverse here
				{ 0, 0, 0.0 }, { wall_Width, 0, 0.0 }, { wall_Width, 0.0, wall_Height }, { 0, 0.0, wall_Height } };
		double[] normal = GeometryUtils.calculateNormal(rect[0], rect[1], rect[2]);

		startList = gl.glGenLists(4);

		GLUtessellator tobj = GLU.gluNewTess();

		GLU.gluTessCallback(tobj, GLU.GLU_TESS_VERTEX, tessCallback);// glVertex3dv);
		GLU.gluTessCallback(tobj, GLU.GLU_TESS_BEGIN, tessCallback);// beginCallback);
		GLU.gluTessCallback(tobj, GLU.GLU_TESS_END, tessCallback);// endCallback);
		GLU.gluTessCallback(tobj, GLU.GLU_TESS_ERROR, tessCallback);// errorCallback);

		// lado_dentro
		gl.glNewList(startList, GL2.GL_COMPILE);
		// GLU.gluTessNormal(tobj, normal[0], normal[1], normal[2]);
		GLU.gluTessBeginPolygon(tobj, null);
		GLU.gluTessBeginContour(tobj);
		for (int i = 0; i < rect.length; i++) {
			GLU.gluTessVertex(tobj, rect[i], 0,
					new double[] { rect[i][0], rect[i][1], rect[i][2], normal[0], normal[1], normal[2] });
		}
		GLU.gluTessEndContour(tobj);
		GLU.gluTessBeginContour(tobj);
		//
		// // Todas as 5 aberturas.

		GLU.gluTessEndContour(tobj);
		GLU.gluTessBeginContour(tobj);

		GLU.gluTessEndContour(tobj);
		GLU.gluTessBeginContour(tobj);

		GLU.gluTessEndContour(tobj);
		GLU.gluTessBeginContour(tobj);

		GLU.gluTessEndContour(tobj);
		GLU.gluTessEndPolygon(tobj);
		gl.glEndList();

		double[] normal2 = GeometryUtils.calculateNormal(rect[2], rect[1], rect[0]);

		// Lado_fora
		gl.glNewList(startList + 1, GL2.GL_COMPILE);
		GLU.gluTessNormal(tobj, normal2[0], normal2[1], normal2[2]);
		GLU.gluTessBeginPolygon(tobj, null);
		GLU.gluTessBeginContour(tobj);
		for (int i = rect.length - 1; i >= 0; i--) {
			GLU.gluTessVertex(tobj, rect[i], 0,
					new double[] { rect[i][0], rect[i][1], rect[i][2], normal2[0], normal2[1], normal2[2] });
		}
		GLU.gluTessEndContour(tobj);
		GLU.gluTessBeginContour(tobj);

		GLU.gluTessEndContour(tobj);
		GLU.gluTessBeginContour(tobj);

		GLU.gluTessEndContour(tobj);
		GLU.gluTessBeginContour(tobj);

		GLU.gluTessEndContour(tobj);
		GLU.gluTessBeginContour(tobj);

		GLU.gluTessEndContour(tobj);
		GLU.gluTessEndPolygon(tobj);
		gl.glEndList();

		gl.glNewList(startList + 2, GL2.GL_COMPILE);

		gl.glEndList();

		GLU.gluDeleteTess(tobj);

	}

	@Override
	public void selfDraw(GL2 gl) {

		texture.enable(gl);
		texture.bind(gl);
		gl.glCallList(startList + 3);
		gl.glTranslatef(0f, -5f, 0f);
	

		gl.glColor3fv(color, 0);
		gl.glCallList(startList);

		gl.glTranslatef(0f, -0.5f, 0f);
		gl.glCallList(startList + 1);

		gl.glCallList(startList + 2);

	
	}

	private double[] calculateTexturePoint(double[] vertice) {
		double d_x = vertice[0] / wall_Width;
		double d_z = vertice[2] / wall_Height;

		return new double[] { d_x, d_z };
	}

	class TessellCallBack implements GLUtessellatorCallback {
		private GL2 gl;
		private GLU glu;

		public TessellCallBack(GL2 gl, GLU glu) {
			this.gl = gl;
			this.glu = glu;
		}

		public void begin(int type) {
			gl.glBegin(type);
		}

		public void end() {
			gl.glEnd();
		}

		public void vertex(Object vertexData) {
			double[] pointer;
			if (vertexData instanceof double[]) {
				pointer = (double[]) vertexData;
				gl.glTexCoord2dv(calculateTexturePoint(pointer), 0);
				gl.glVertex3dv(pointer, 0);
				if (pointer.length == 6) {
					gl.glNormal3dv(pointer, 3);
				}
			}
		}

		public void vertexData(Object vertexData, Object polygonData) {
		}

		public void combine(double[] coords, Object[] data, //
				float[] weight, Object[] outData) {
			for (Double object : coords) {
				System.out.println(object);
			}
			System.exit(0);
		}

		public void combineData(double[] coords, Object[] data, //
				float[] weight, Object[] outData, Object polygonData) {
			System.exit(0);
		}

		public void error(int errnum) {
			String estring;

			estring = glu.gluErrorString(errnum);
			System.err.println("Tessellation Error: " + estring);
			System.exit(0);
		}

		public void beginData(int type, Object polygonData) {
		}

		public void endData(Object polygonData) {
		}

		public void edgeFlag(boolean boundaryEdge) {
		}

		public void edgeFlagData(boolean boundaryEdge, Object polygonData) {
		}

		public void errorData(int errnum, Object polygonData) {
		}
	}

}
