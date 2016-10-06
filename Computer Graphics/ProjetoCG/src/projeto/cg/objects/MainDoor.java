package projeto.cg.objects;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;

import com.jogamp.common.nio.Buffers;

import br.ufal.cg.AutoDrawnableObject;

public class MainDoor extends AutoDrawnableObject {

	private int rotationAngle = 0;
	private boolean open = false;

	public MainDoor(GL2 gl) {
		super(gl);
		createBuffers();
		bindBuffers(gl);
	}

	float vertices[] = { 0, 0, 3f, 0, 0.21f, 3f, 2.5f, 0.21f, 3f, 2.5f, 0, 3f, // v0-v1-v2-v3
			2.5f, 0, 2.4f, 2.5f, 0.21f, 2.4f, 2.5f, 0.21f, 0, 2.5f, 0, 0f, // v0-v3-v4-v5
			2f, 0.21f, 3f, 0, 0.19f, 3f, 0, 0.21f, 0f, 2f, 0.21f, 0f, // v0-v5-v6-v1
			0, 0, 3f, 0, 0, 0f, 0, 0.21f, 0, 0, 0.21f, 3f, // v1-v6-v7-v2
			0, 0, 3f, 2.5f, 0, 3f, 2.5f, 0, 0, 0, 0, 0, 2.5f, 0, 0, 2.5f, 0.21f, 0, 0, 0.21f, 0, 0, 0, 0 }; // v4-v7-v6-v5
	// normal array
	float normals[] = { 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, // v0-v1-v2-v3
			1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, // v0-v3-v4-v5
			0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, // v0-v5-v6-v1
			-1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, // v1-v6-v7-v2
			0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0 }; // v4-v7-v6-v5

	float textures[] = { 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0,
			0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0 };

	byte indices[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26,
			27 };
	float scale = 1;
	public FloatBuffer vertBuffer;
	public FloatBuffer normalBuffer;
	public FloatBuffer texCoordBuffer;
	public ByteBuffer faceBuffer;
	private int vert_id;
	private int normal_id;
	private int face_id;
	private int texture_id;

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
		gl.glBufferData(GL2.GL_ARRAY_BUFFER, vertBuffer.capacity() * Float.SIZE / 8, vertBuffer, GL2.GL_STATIC_DRAW);

		gl.glBindBuffer(GL2.GL_ARRAY_BUFFER, normal_id);
		gl.glBufferData(GL2.GL_ARRAY_BUFFER, normalBuffer.capacity() * Float.SIZE / 8, normalBuffer,
				GL2.GL_STATIC_DRAW);

		gl.glBindTexture(GL2.GL_TEXTURE_2D, texture_id);
		gl.glBindBuffer(GL2.GL_ARRAY_BUFFER, texture_id);
		gl.glBufferData(GL2.GL_ARRAY_BUFFER, texCoordBuffer.capacity() * Float.SIZE / 8, texCoordBuffer,
				GL2.GL_STATIC_DRAW);

		gl.glBindBuffer(GL2.GL_ELEMENT_ARRAY_BUFFER, face_id);
		gl.glBufferData(GL2.GL_ELEMENT_ARRAY_BUFFER, faceBuffer.capacity(), faceBuffer, GL2.GL_STATIC_DRAW);

	}

	@Override
	public void selfDraw(GL2 gl) {

		texture.enable(gl);
		texture.bind(gl);
	
		gl.glTranslatef(3f, -1.225f, 0.2f);
		gl.glRotatef(-90, 0f, 0f, 1f);

		gl.glPushMatrix();
		gl.glRotatef(rotationAngle, 0f, 0f, 1f);
		drawElements();
		gl.glPopMatrix();

		//gl.glTranslatef(1.75f, 0.15f, 0);
		//gl.glRotatef(180 - rotationAngle, 0f, 0f, 1f);
		//drawElements();

		texture.disable(gl);

	}

	private void drawElements() {

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

		gl.glDrawElements(GL2.GL_QUADS, faceBuffer.capacity(), GL2.GL_UNSIGNED_BYTE, 0);

		gl.glDisableClientState(GL2.GL_VERTEX_ARRAY);
		gl.glDisableClientState(GL2.GL_NORMAL_ARRAY);
		gl.glDisableClientState(GL2.GL_TEXTURE_COORD_ARRAY);

		gl.glBindBuffer(GL2.GL_ARRAY_BUFFER, 0);
		gl.glBindBuffer(GL2.GL_ELEMENT_ARRAY_BUFFER, 0);

	}

	public synchronized void openDoor() {
		if (open)
			return;
		open = true;
		for (int i = 0; i < 90; i++) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			rotationAngle--;
		}

	}

}
