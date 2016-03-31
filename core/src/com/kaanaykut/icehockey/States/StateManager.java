package com.kaanaykut.icehockey.States;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

/**
 * Created by kaan on 15.03.2016.
 */
public class StateManager extends State{

    private Stack<State> states;

    public StateManager(StateManager sm) {
        super(sm);

        states = new Stack<State>();
    }

    @Override
    public void render(SpriteBatch sb) {
        states.peek().render(sb);
        states.peek().handleInput();
    }

    @Override
    public void update(float delta) {
        states.peek().update(delta);
    }

    @Override
    public void handleInput() {

    }

    public void pushState(State state){

        states.push(state);
    }

    public void popState(State state){

        states.pop();
    }
}
