package com.talleresicesi.controltaller2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Observable;
import java.util.Observer;

import mensaje.Mensaje;

public class Control extends AppCompatActivity implements Observer, View.OnClickListener {

    Button up;
    Button down;
    Button left;
    Button right;
    Button help;
    Button restart;
    Button shot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);
        Comunicacion.getInstance().addObserver(this);

        up= (Button) findViewById(R.id.up);
        down= (Button) findViewById(R.id.down);
        left= (Button) findViewById(R.id.left);
        right= (Button) findViewById(R.id.right);
        help= (Button) findViewById(R.id.help);
        restart= (Button) findViewById(R.id.restart);
        shot= (Button) findViewById(R.id.shot);

        up.setOnClickListener(this);
        down.setOnClickListener(this);
        left.setOnClickListener(this);
        right.setOnClickListener(this);
        help.setOnClickListener(this);
        restart.setOnClickListener(this);
        shot.setOnClickListener(this);

    }


    @Override
    public void update(Observable observable, Object o) {

    }

    @Override
    public void onClick(View view) {

        Mensaje ms;

        switch (view.getId()){

            case R.id.up:
                Comunicacion.getInstance().sendMessage(ms =new Mensaje("up"), Comunicacion.MULTI_GROUP_ADDRESS, Comunicacion.DEFAULT_PORT );
                break;
            case R.id.down:
                Comunicacion.getInstance().sendMessage(ms =new Mensaje("down"), Comunicacion.MULTI_GROUP_ADDRESS, Comunicacion.DEFAULT_PORT );
                break;
            case R.id.left:
                Comunicacion.getInstance().sendMessage(ms =new Mensaje("left"), Comunicacion.MULTI_GROUP_ADDRESS, Comunicacion.DEFAULT_PORT );
                break;
            case R.id.right:
                Comunicacion.getInstance().sendMessage(ms =new Mensaje("right"), Comunicacion.MULTI_GROUP_ADDRESS, Comunicacion.DEFAULT_PORT );
                break;
            case R.id.help:
                Comunicacion.getInstance().sendMessage(ms =new Mensaje("help"), Comunicacion.MULTI_GROUP_ADDRESS, Comunicacion.DEFAULT_PORT );
                break;
            case R.id.restart:
                Comunicacion.getInstance().sendMessage(ms =new Mensaje("restart"), Comunicacion.MULTI_GROUP_ADDRESS, Comunicacion.DEFAULT_PORT );
                break;
            case R.id. shot:
                Comunicacion.getInstance().sendMessage(ms =new Mensaje("shoot"), Comunicacion.MULTI_GROUP_ADDRESS, Comunicacion.DEFAULT_PORT );
                break;
        }
    }
}
