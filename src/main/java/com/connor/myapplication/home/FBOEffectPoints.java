package com.connor.myapplication.home;

import com.connor.myapplication.data.PointBean;
import com.connor.myapplication.data.VertexArray;
import com.connor.myapplication.program.MosaicTextureShaderProgram;
import com.connor.myapplication.program.ShaderProgram;
import com.connor.myapplication.util.PictureUtil;

import static android.opengl.GLES20.GL_TRIANGLE_FAN;
import static android.opengl.GLES20.glDrawArrays;
import static com.connor.myapplication.data.Constant.BYTES_PER_FLOAT;

/**
 * Created by meitu on 2016/8/3.
 */
public class FBOEffectPoints extends Mesh {
    private static final int POSITION_COMPONENT_COUNT = 2;
    private static final int TEXTURE_COORDINATES_COMPONENT_COUNT = 2;
    private static final int STRIDE = (POSITION_COMPONENT_COUNT
            + TEXTURE_COORDINATES_COMPONENT_COUNT * 2) * BYTES_PER_FLOAT;

    private float[] vertices;
    private final VertexArray vertexArray;

    public FBOEffectPoints(PointBean pb) {
        vertices = PictureUtil.calculateOppositeEffectArea(pb);
        vertexArray = new VertexArray(vertices);
    }

    public void bindData(ShaderProgram textureProgram) {
        vertexArray.setVertexAttribPointer(
                0,
                textureProgram.getPositionAttributeLocation(),
                POSITION_COMPONENT_COUNT,
                STRIDE);

        vertexArray.setVertexAttribPointer(
                POSITION_COMPONENT_COUNT,
                textureProgram.getTextureCoordinatesAttributeLocation(),
                TEXTURE_COORDINATES_COMPONENT_COUNT,
                STRIDE);

        vertexArray.setVertexAttribPointer(
                POSITION_COMPONENT_COUNT + TEXTURE_COORDINATES_COMPONENT_COUNT,
                textureProgram.getPointTextureCoordinatesAttributeLocation(),
                TEXTURE_COORDINATES_COMPONENT_COUNT,
                STRIDE);
    }

    public void draw() {
        glDrawArrays(GL_TRIANGLE_FAN, 0, 6);
    }
}
