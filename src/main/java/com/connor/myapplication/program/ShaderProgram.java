package com.connor.myapplication.program;

import android.content.Context;

import static android.opengl.GLES20.glUseProgram;

/**
 * Created by meitu on 2016/7/5.
 */
public class ShaderProgram {
    protected static final String U_TEXTURE_UNIT = "u_TextureUnit";
    protected static final String A_POSITION = "a_Position";
    protected static final String A_TEXTURE_COORDINATES = "a_TextureCoordinates";

    protected final int program;

    protected ShaderProgram(Context context, int vertexShaderResourceId,
                            int fragmentShaderResourceId) {
        program = ShaderHelper.buildProgram(
                TextResourceReader.readTextFileFromResource(
                        context, vertexShaderResourceId),
                TextResourceReader.readTextFileFromResource(
                        context, fragmentShaderResourceId));
    }

    public void useProgram() {
        glUseProgram(program);
    }

    public void setUniforms(int textureid){};

    public void setUniforms(int textureId, int pointId){};

    public int getPositionAttributeLocation(){return 0;}

    public int getTextureCoordinatesAttributeLocation(){return 0;}

    public int getPointTextureCoordinatesAttributeLocation(){return  0;}
}
