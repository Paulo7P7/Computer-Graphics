package projeto.cg.objects;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;

import com.jogamp.common.nio.Buffers;

import br.ufal.cg.AutoDrawnableObject;

public class Roof extends AutoDrawnableObject {

	// cube
	// ///////////////////////////////////////////////////////////////////////
	// v6-----  v5
	// /|       /|
	// v1------v0|
	// | |     | |
	// | |v7---|-|v4
	// |/      |/
	// v2------v3

	// vertex coords array
	float vertices[] = { 0, 0, 0.2f, 0, -24f, 0.2f, 22f, -24f, 0.2f, 22f, 0, 0.2f, // v0-v1-v2-v3
			22f, 0, 0.2f, 22f, -24f, 0.2f, 22f, -24f, 0, 22f, 0, 0f, // v0-v3-v4-v5
			22f, -24f, 0.2f, 0, -24f, 0.2f, 0, -24f, 0f, 22f, -24f, 0f, // v0-v5-v6-v1
			0, 0, 0.2f, 0, 0, 0f, 0, -24f, 0, 0, -24f, 0.2f, // v1-v6-v7-v2
			0, 0, 0.2f, 22f, 0, 0.2f, 22f, 0, 0, 0, 0, 0}; // v4-v7-v6-v5
	
	float textures[] = { 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0,
			1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0,
			0, 0, 1, 1, 0, 1, 1, 0 };
	
	// normal array
	float normals[] = { 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, // v0-v1-v2-v3
			1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, // v0-v3-v4-v5
			0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, // v0-v5-v6-v1
			-1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, // v1-v6-v7-v2
			0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0}; // v4-v7-v6-v5

	byte indices[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15,
			16, 17, 18, 19, 20, 21, 22, 23 };
	float scale = 1;
	public FloatBuffer vertBuffer;
	public FloatBuffer normalBuffer;
	public ByteBuffer faceBuffer;
	public FloatBuffer texCoordBuffer;
	private int vert_id;
	private int normal_id;
	private int face_id;
	private int texture_id;

	public Roof(GL2 gl) {
		super(gl);
		createBuffers();
		bindBuffers(gl);
	}


	// This is needed because we are using JOGL
	public void createBuffers() {
		// note length of vertices, normals, and colors should all be the same!
		try {
			vertBuffer = Buffers.newDirectFloatBuffer(vertices);
			normalBuffer = Buffers.newDirectFloatBuffer(vertices);
			texCoordBuffer = Buffers.newDirectFloatBuffer(textures);
			faceBuffer = Buffers.newDirectByteBuffer(indices);

			vertBuffer.put(vertices);
			normalBuffer.put(normals);
			texCoordBuffer.put(textures);
			faceBuffer.put(indices);

			vertBuffer.rewind();
			normalBuffer.rewind();
			texCoordBuffer.rewind();
			faceBuffer.rewind();
		} catch (Exception e) {
			System.out.println("Error creating buffers \n" + e);
		}

	}

	private void bindBuffers(GL gl) {
		int[] temp = new int[4];
		gl.glGenBuffers(4, temp, 0);
		vert_id = temp[0];
		normal_id = temp[1];
		texture_id = temp[2];
		face_id = temp[3];

		gl.glBindBuffer(GL2.GL_ARRAY_BUFFER, vert_id);
		gl.glBufferData(GL2.GL_ARRAY_BUFFER, vertBuffer.capacity() * Float.SIZE
				/ 8, vertBuffer, GL2.GL_STATIC_DRAW);

		gl.glBindBuffer(GL2.GL_ARRAY_BUFFER, normal_id);
		gl.glBufferData(GL2.GL_ARRAY_BUFFER, normalBuffer.capacity()
				* Float.SIZE / 8, normalBuffer, GL2.GL_STATIC_DRAW);
		
		gl.glBindTexture(GL2.GL_TEXTURE_2D, texture_id);
		gl.glBindBuffer(GL2.GL_ARRAY_BUFFER, texture_id);
		gl.glBufferData(GL2.GL_ARRAY_BUFFER, texCoordBuffer.capacity()
				* Float.SIZE / 8, texCoordBuffer, GL2.GL_STATIC_DRAW);

		gl.glBindBuffer(GL2.GL_ELEMENT_ARRAY_BUFFER, face_id);
		gl.glBufferData(GL2.GL_ELEMENT_ARRAY_BUFFER, faceBuffer.capacity(),
				faceBuffer, GL2.GL_STATIC_DRAW);

	}

	@Override
	public void selfDraw(GL2 gl) {

		texture.enable(gl);
		texture.bind(gl);
		gl.glTranslatef(-1f, 0f, 4f);
		//gl.glColor3f(0.6f, 0.6f, 0.6f);
		gl.glBindBuffer(GL2.GL_ARRAY_BUFFER, vert_id);
		gl.glEnableClientState(GL2.GL_VERTEX_ARRAY);
		gl.glVertexPointer(3, GL2.GL_FLOAT, 0, 0);

		gl.glBindBuffer(GL2.GL_ARRAY_BUFFER, normal_id);
		gl.glEnableClientState(GL2.GL_NORMAL_ARRAY);
		gl.glNormalPointer(GL2.GL_FLOAT, 0, 0);
		
		gl.glBindBuffer(GL2.GL_ARRAY_BUFFER, texture_id);
		gl.glEnableClientState(GL2.GL_TEXTURE_COORD_ARRAY);
		gl.glEnable(GL2.GL_TEXTURE_2D);
		gl.glTexCoordPointer(2, GL2.GL_FLOAT, 0, 0);


		gl.glBindBuffer(GL2.GL_ELEMENT_ARRAY_BUFFER, face_id);

		gl.glDrawElements(GL2.GL_QUADS, faceBuffer.capacity(),
				GL2.GL_UNSIGNED_BYTE, 0);

		gl.glDisableClientState(GL2.GL_VERTEX_ARRAY);
		gl.glDisableClientState(GL2.GL_NORMAL_ARRAY);

		gl.glBindBuffer(GL2.GL_ARRAY_BUFFER, 0);
		gl.glBindBuffer(GL2.GL_ELEMENT_ARRAY_BUFFER, 0);
		
		texture.disable(gl);
	}
}
