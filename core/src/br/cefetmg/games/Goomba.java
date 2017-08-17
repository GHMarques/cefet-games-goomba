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
 * @author gustavo
 */
public class Goomba extends ApplicationAdapter{
    //private Sprite sprGoomba;
    private float[] fltPosition = new float[2];
    private float fltMaxWidth, fltWidth = 21;
    private float fltMaxHeight, fltHeight = 24;
    
    private TextureRegion[][] quadrosDaAnimacao;
    private Animation[] andar = new Animation[5];
    private float tempoDaAnimacao;
    private int intMovimentoAtual = 2;
    /**
     * Contrutor da classe Goomba
     * Conforme o enunciado da pratica, seta a posicao inicial em (30,10)
     * @param texGoomba textura do Goomba
     */
    public Goomba(Texture texGoomba){
        quadrosDaAnimacao = TextureRegion.split(texGoomba, (int)fltWidth, (int)fltHeight);
        fltPosition[0] = 30; //Coordenada x inicial
        fltPosition[1] = 10; //Coordenada y inicial
        //Andar para baixo
        andar[0] = new Animation(0.1f,
                quadrosDaAnimacao[0][0],
                quadrosDaAnimacao[0][1],
                quadrosDaAnimacao[0][2],
                quadrosDaAnimacao[0][3],
                quadrosDaAnimacao[0][4]);
        andar[0].setPlayMode(PlayMode.LOOP_PINGPONG);
        //Andar para direita
        andar[1] = new Animation(0.1f,
                quadrosDaAnimacao[1][0],
                quadrosDaAnimacao[1][1],
                quadrosDaAnimacao[1][2],
                quadrosDaAnimacao[1][3],
                quadrosDaAnimacao[1][4]);
        andar[1].setPlayMode(PlayMode.LOOP_PINGPONG);
        //Andar para cima
        andar[2] = new Animation(0.1f,
                quadrosDaAnimacao[2][0],
                quadrosDaAnimacao[2][1],
                quadrosDaAnimacao[2][2],
                quadrosDaAnimacao[2][3],
                quadrosDaAnimacao[2][4]);
        andar[2].setPlayMode(PlayMode.LOOP_PINGPONG);
        //Andar para esquerda
        andar[3] = new Animation(0.1f,
                quadrosDaAnimacao[3][0],
                quadrosDaAnimacao[3][1],
                quadrosDaAnimacao[3][2],
                quadrosDaAnimacao[3][3],
                quadrosDaAnimacao[3][4]);
        andar[3].setPlayMode(PlayMode.LOOP_PINGPONG);
        //Andar para esquerda
        andar[4] = new Animation(0.1f,
                quadrosDaAnimacao[0][2]);
        andar[4].setPlayMode(PlayMode.LOOP_PINGPONG);
        
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
        batch.draw((TextureRegion) andar[intMovimentoAtual].getKeyFrame(tempoDaAnimacao), fltPosition[0], fltPosition[1]);
    }
    
    /**
     * Metodo update responsavel pelo Goomba
     * @param delta o tempo que passou desde o último "quadro".
     */
    public void update(float delta) {
        //tempoDaAnimacao
        tempoDaAnimacao += Gdx.graphics.getDeltaTime();
        //Para a animacao quando nenhuma tecla e' pressionada
        intMovimentoAtual = 4;
        //Movimento vertical para cima do Goomba
        if(Gdx.input.isKeyPressed(Input.Keys.UP) || Gdx.input.isKeyPressed(Input.Keys.W)){
            intMovimentoAtual = 2;
            if(fltPosition[1] < (fltMaxHeight - fltHeight))
                fltPosition[1]++;
        }
        //Movimento vertical para baixo do Goomba
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN) || Gdx.input.isKeyPressed(Input.Keys.S)){
            intMovimentoAtual = 0;
            if(fltPosition[1] > 0)
                fltPosition[1]--;
        }
        //Movimento horizontal para direita do Goomba
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.isKeyPressed(Input.Keys.D)){
            intMovimentoAtual = 1;
            if(fltPosition[0] < (fltMaxWidth - fltWidth))
                fltPosition[0]++;
        }
        //Movimento vertical para baixo do Goomba
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.isKeyPressed(Input.Keys.A)){
            intMovimentoAtual = 3;
            if(fltPosition[0] > 0)
                fltPosition[0]--;
        }
            
    }
}
