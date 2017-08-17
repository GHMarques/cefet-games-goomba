/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.games;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 *
 * @author gusta
 */
public class Goomba extends ApplicationAdapter{
    //private Sprite sprGoomba;
    private float[] fltPosition = new float[2];
    private float fltMaxWidth, fltWidth = 21;
    private float fltMaxHeight, fltHeight = 24;
    
    private TextureRegion[][] quadrosDaAnimacao;
    private Animation andarParaFrente;
    private float tempoDaAnimacao;
    
    /**
     * Contrutor da classe Goomba
     * Conforme o enunciado da pratica, seta a posicao inicial em (30,10)
     * @param texGoomba textura do Goomba
     */
    public Goomba(Texture texGoomba){
        quadrosDaAnimacao = TextureRegion.split(texGoomba, (int)fltWidth, (int)fltHeight);
        fltPosition[0] = 30; //Coordenada x inicial
        fltPosition[1] = 10; //Coordenada y inicial
        
        andarParaFrente = new Animation(0.1f,
                quadrosDaAnimacao[0][0],
                quadrosDaAnimacao[0][1],
                quadrosDaAnimacao[0][2],
                quadrosDaAnimacao[0][3],
                quadrosDaAnimacao[0][4]);
        andarParaFrente.setPlayMode(PlayMode.LOOP_PINGPONG);
        tempoDaAnimacao = 0;
    }
    
    //Getter e Setter
    public float[] getFltPosition() {
        return fltPosition;
    }

    public void setFltPosition(float[] fltPosition) {
        this.fltPosition = fltPosition;
    }

    public float getFltMaxWidth() {
        return fltMaxWidth;
    }

    public void setFltMaxWidth(float fltMaxWidth) {
        this.fltMaxWidth = fltMaxWidth;
    }

    public float getFltMaxHeight() {
        return fltMaxHeight;
    }

    public void setFltMaxHeight(float fltMaxHeight) {
        this.fltMaxHeight = fltMaxHeight;
    }
    
    /**
     * Metodo responsavel por desenhar o Goomba
     */
    public void render(SpriteBatch batch) {
        batch.draw((TextureRegion) andarParaFrente.getKeyFrame(tempoDaAnimacao), fltPosition[0], fltPosition[1]);
    }
    
    /**
     * Metodo update responsavel pelo Goomba
     * @param delta o tempo que passou desde o último "quadro".
     */
    public void update(float delta) {
        //tempoDaAnimacao
        tempoDaAnimacao += Gdx.graphics.getDeltaTime();
        //Movimento vertical para cima do Goomba
        if(Gdx.input.isKeyPressed(Input.Keys.UP) || Gdx.input.isKeyPressed(Input.Keys.W)){
            if(fltPosition[1] < (fltMaxHeight - fltHeight))
                fltPosition[1]++;
        }
        //Movimento vertical para baixo do Goomba
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN) || Gdx.input.isKeyPressed(Input.Keys.S)){
            if(fltPosition[1] > 0)
                fltPosition[1]--;
        }
        //Movimento horizontal para direita do Goomba
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.isKeyPressed(Input.Keys.D)){
            if(fltPosition[0] < (fltMaxWidth - fltWidth))
                fltPosition[0]++;
        }
        //Movimento vertical para baixo do Goomba
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.isKeyPressed(Input.Keys.A)){
            if(fltPosition[0] > 0)
                fltPosition[0]--;
        }
    }
}
