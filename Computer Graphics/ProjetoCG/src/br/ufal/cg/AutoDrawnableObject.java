package br.ufal.cg;

import java.io.IOException;
import java.io.InputStream;

import javax.media.opengl.GL2;
import javax.media.opengl.GLProfile;

import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureData;
import com.jogamp.opengl.util.texture.TextureIO;

public abstract class AutoDrawnableObject {

	protected GL2 gl;
	/** The earth texture. */
	protected Texture texture;

	public AutoDrawnableObject(GL2 gl) {
		this.gl = gl;
		loadTextures();
		System.out.println(getTextureImg());
	}

	private void loadTextures() {
		try {
			InputStream stream = AutoDrawnableObject.class.getClassLoader()
					.getResourceAsStream(getTextureImg());
			TextureData data = TextureIO.newTextureData(
					GLProfile.get(GLProfile.GL2), stream, false,
					getTextureExtension());
			texture = TextureIO.newTexture(data);
		} catch (IOException exc) {
			// exc.printStackTrace();
			System.err
					.println("Não foi possivel gerar as texturas para a Classe:"
							+ getTextureImg());
		}

	}

	protected String getTextureExtension() {
		return "jpg";
	}

	protected String getTextureImg() {
		return this.getClass().getSimpleName()+".jpg";
	}

	public abstract void selfDraw(GL2 gl);

}
